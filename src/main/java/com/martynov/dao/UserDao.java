package com.martynov.dao;

import com.martynov.entity.User;
import org.hibernate.SessionFactory;


import java.util.List;

public class UserDao {

    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    //TODO create
    public void addNewExpenses(User user) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO delete
    public void deleteExpenses(int id) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            User idToDelete = session.get(User.class, id);
            if (idToDelete != null) {
                session.remove(idToDelete);
            }
            transaction.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO read
    public User readExpenses(int id) {
        try (var session = sessionFactory.openSession()) {

            User readUserExpenses = session.get(User.class, id);

            System.out.println(readUserExpenses.getUserChoice());

            return readUserExpenses;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO update
    public User updateExpensesAmount(int id, double newAmount) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            User updateUser = session.get(User.class, id);
            updateUser.setAmount(newAmount);

            transaction.commit();
            System.out.println(updateUser);
            return updateUser;
        }
    }

    //TODO findAll
    public List<User> findALl() {
        try(var session = sessionFactory.openSession()) {
            return session.createQuery("SELECT u FROM User u", User.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO getSumAmount use NamedQuery
    public double getSumAmount() {
        try(var session = sessionFactory.openSession()) {
            var result = session.createNamedQuery("User.totalSum", Double.class).getSingleResult();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //TODO operationCount
    public int countOperation() {
        try(var session = sessionFactory.openSession()) {
            var result = session.createQuery("SELECT count(u.amount) FROM User u", Long.class).getSingleResult();
            System.out.println(result);
            return result != null ? result.intValue() : 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}