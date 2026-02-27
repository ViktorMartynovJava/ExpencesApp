package com.martynov.dao;

import com.martynov.entity.Category;
import com.martynov.entity.MoneyValue;
import com.martynov.entity.User;
import com.martynov.entity.UserChoice;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserDaoTest {

    private static SessionFactory sessionFactory;
    private UserDao userDao;

    @BeforeAll
    static void init() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @BeforeEach
    public void setUp() {
        userDao = new UserDao(sessionFactory);
    }

    @Test
     void addNewExpenses() {
        User user = User.builder().userChoice(UserChoice.TOGETHER)
                .category(Category.EAT)
                .moneyValue(MoneyValue.VND)
                .amount(500.0)
                .createdAt(LocalDate.now()).build();
        userDao.addNewExpenses(user);
        User saveUser = userDao.readExpenses(user.getId());
        assertNotNull(saveUser);
        assertEquals(500.0,saveUser.getAmount());
    }

    @Test
    void deleteExpenses() {
    }

    @Test
    void readExpenses() {
    }

    @Test
    void updateExpensesAmount() {
    }

    @Test
    void findALl() {
    }

    @Test
    void getSumAmount() {
    }
}