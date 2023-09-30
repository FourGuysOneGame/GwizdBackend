package com.example.MyPlannerApp.config;

import com.example.MyPlannerApp.models.*;
import com.example.MyPlannerApp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            WeekRepository weekRepository,
            UserDetailsEntityRepository userDetailsEntityRepository,
            UserRepository userRepository,
            TaskRepository taskRepository,
            UserWeekRepository userWeekRepository) {
        return args -> {
            List<Week> weeksEntities = new ArrayList<>();

            UUID week1Id = UUID.randomUUID();
            UUID week2Id = UUID.randomUUID();
            UUID week3Id = UUID.randomUUID();
            UUID week4Id = UUID.randomUUID();
            UUID userDetails1Id = UUID.randomUUID();
            UUID userDetails2Id = UUID.randomUUID();
            UUID user1Id = UUID.randomUUID();
            UUID user2Id = UUID.randomUUID();
            weeksEntities.add(new Week(
                    week2Id,
                    LocalDate.of(2023, Month.AUGUST, 21),
                    LocalDate.of(2023, Month.AUGUST, 27)
            ));
            weeksEntities.add(new Week(
                    week3Id,
                    LocalDate.of(2023, Month.AUGUST, 28),
                    LocalDate.of(2023, Month.SEPTEMBER, 3)
            ));
            weeksEntities.add(new Week(
                    week4Id,
                    LocalDate.of(2023, Month.SEPTEMBER, 4),
                    LocalDate.of(2023, Month.SEPTEMBER, 10)
            ));
            weeksEntities.add(new Week(
                    week1Id,
                    LocalDate.of(2023, Month.SEPTEMBER, 11),
                    LocalDate.of(2023, Month.SEPTEMBER, 17)
            ));
            List<UserDetailsEntity> userDetailsEntities = new ArrayList<>();
            userDetailsEntities.add(new UserDetailsEntity(
                    userDetails1Id,
                    "John",
                    "Snow"
            ));
            userDetailsEntities.add(new UserDetailsEntity(
                    userDetails2Id,
                    "Kuba",
                    "Cudak"
            ));
            List<User> usersEntities = new ArrayList<>();
            usersEntities.add(new User(
                    user1Id,
                    "jsnow@wp.pl",
                    "$2a$10$bhiGBBGBax8Y2Z/Psp86Ue4cVKULgmbYkegPKrm/l/109bwOk/nW2",
                    userDetails1Id
            ));
            usersEntities.add(new User(
                    user2Id,
                    "kubcud@op.pl",
                    "$2a$10$bhiGBBGBax8Y2Z/Psp86Ue4cVKULgmbYkegPKrm/l/109bwOk/nW2",
                    userDetails2Id
            ));
            List<Task> tasksEntities = new ArrayList<>();
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "swimming",
                    "Sport",
                    LocalDate.of(2023, Month.AUGUST, 30),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "Meet with Anna",
                    "Meetings",
                    LocalDate.of(2023, Month.AUGUST, 28),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "Clean Bedroom",
                    "Chores",
                    LocalDate.of(2023, Month.SEPTEMBER, 4),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "Go cycling",
                    "Sport",
                    LocalDate.of(2023, Month.SEPTEMBER, 5),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "wash dishes",
                    "Chores",
                    LocalDate.of(2023, Month.SEPTEMBER, 5),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "do WdPai",
                    "Work",
                    LocalDate.of(2023, Month.SEPTEMBER, 7),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "do WdPai",
                    "Work",
                    LocalDate.of(2023, Month.SEPTEMBER, 8),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "kill dragon",
                    "Chores",
                    LocalDate.of(2023, Month.AUGUST, 31),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week1Id,
                    "meet with Thomas",
                    "Relations",
                    LocalDate.of(2023, Month.AUGUST, 26),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week4Id,
                    "wash dishes",
                    "Chores",
                    LocalDate.of(2023, Month.AUGUST, 28),
                    false
            ));
            tasksEntities.add(new Task(
                    user1Id,
                    week2Id,
                    "do laundry",
                    "Chores",
                    LocalDate.of(2023, Month.AUGUST, 29),
                    false
            ));
            tasksEntities.add(new Task(
                    user2Id,
                    week1Id,
                    "hejka",
                    "Work",
                    LocalDate.of(2023, Month.SEPTEMBER, 4),
                    false
            ));
            tasksEntities.add(new Task(
                    user2Id,
                    week1Id,
                    "naklejka",
                    "Work",
                    LocalDate.of(2023, Month.SEPTEMBER, 6),
                    false
            ));

            List<UsersWeeks> usersWeeksEntities = new ArrayList<>();
            usersWeeksEntities.add(new UsersWeeks(
                    user1Id,
                    week1Id
            ));
            usersWeeksEntities.add(new UsersWeeks(
                    user1Id,
                    week2Id
            ));
            usersWeeksEntities.add(new UsersWeeks(
                    user1Id,
                    week3Id
            ));
            usersWeeksEntities.add(new UsersWeeks(
                    user1Id,
                    week4Id
            ));
            usersWeeksEntities.add(new UsersWeeks(
                    user2Id,
                    week1Id
            ));
            usersWeeksEntities.add(new UsersWeeks(
                    user2Id,
                    week2Id
            ));

            weekRepository.saveAll(weeksEntities);
            userDetailsEntityRepository.saveAll(userDetailsEntities);
            userRepository.saveAll(usersEntities);
            taskRepository.saveAll(tasksEntities);
            userWeekRepository.saveAll(usersWeeksEntities);
        };
    }
}
