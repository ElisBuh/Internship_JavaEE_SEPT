package ru.javawebinar.topjava.service.DataJpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.MealServiceTest;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.JPA;

@ActiveProfiles(DATAJPA)
public class DataJpaMealServiceTest extends MealServiceTest {
}
