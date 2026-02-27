package com.martynov;

import com.martynov.dao.UserDao;
import com.martynov.entity.Category;
import com.martynov.entity.MoneyValue;
import com.martynov.entity.User;

import com.martynov.entity.UserChoice;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class Runner {

    public static void main(String[] args) {


        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            UserDao userDao = new UserDao(sessionFactory);
            /*userDao.getSumAmount();
            userDao.addNewExpenses(User.builder().userChoice(UserChoice.TOGETHER)
                    .category(Category.ENTERTAINMENT)
                    .moneyValue(MoneyValue.VND)
                    .amount(294000.0)
                    .createdAt(LocalDate.now()*//*.minusDays(1)*//*).build());*/
            /*userDao.deleteExpenses(11);*/
            /*userDao.countOperation();*/
            userDao.findALl();

        }

    }
}
