package ru.javawebinar.topjava.service.DataJpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserServiceTest;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.JPA;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends UserServiceTest {
}
