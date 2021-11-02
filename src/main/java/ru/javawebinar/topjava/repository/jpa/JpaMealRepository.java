package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Meal save(Meal meal, int userId) {
        meal.setUser(entityManager.getReference(User.class, userId));
        if (meal.isNew()) {
            entityManager.persist(meal);
            return meal;
        } else if (get(meal.id(), userId) == null) {
            return null;
        }
        return entityManager.merge(meal);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        try {
        return entityManager.createNamedQuery(Meal.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
        }catch (NoResultException e){
            throw new NotFoundException("not id");
        }
    }

    @Override
    public Meal get(int id, int userId) {
        try {
        return entityManager.createNamedQuery(Meal.GET, Meal.class)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .getSingleResult();
        }catch (NoResultException e){
            throw new NotFoundException("not id");
        }
    }

    @Override
    public List<Meal> getAll(int userId) {
        return entityManager.createNamedQuery(Meal.ALL_SORTED, Meal.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return entityManager.createNamedQuery(Meal.BETWEEN, Meal.class)
                .setParameter("dateStart", startDateTime)
                .setParameter("dateEnd", endDateTime)
                .setParameter("userId", userId)
                .getResultList();
    }
}