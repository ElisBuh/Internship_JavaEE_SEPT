package ru.javawebinar.topjava.service.JPA;


import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.MealServiceTest;

import static ru.javawebinar.topjava.Profiles.*;

@ActiveProfiles(JPA)
public class JpaMealServiceTest extends MealServiceTest {
}
