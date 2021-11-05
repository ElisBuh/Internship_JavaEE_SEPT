package ru.javawebinar.topjava.service.JDBC;


import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserServiceTest;

import static ru.javawebinar.topjava.Profiles.JDBC;
import static ru.javawebinar.topjava.Profiles.JPA;

@ActiveProfiles(JDBC)
public class JdbcUserServiceTest extends UserServiceTest {
}
