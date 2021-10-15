package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Controller
public class MealRestController {
    private MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal create(Meal meal, Integer userId) {
        return service.create(meal, userId);
    }

    public void delete(int id, Integer userId) {
        service.delete(id, userId);
    }

    public Meal get(int id, Integer userId) {
        return service.get(id, userId);
    }

    public List<Meal> getAll(Integer userId) {
        return service.getAll(userId);
    }

    public void update(Meal meal, Integer userId) {
        service.update(meal, userId);
    }
}