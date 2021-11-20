package com.fillswim.hibernate.One_to_Many;

import com.fillswim.hibernate.One_to_Many.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO {

    // Обновление Сохранение или обновление данных
    public void saveEmployee(Employee employee) {

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }
    }

    // Чтение данных
    public Employee getEmployee(int id) {

        Employee employee = new Employee();

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }

        return employee;
    }

    // Получение всех записей из БД
    public List<Employee> getAllEmployees() {

        List<Employee> employees = null;

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            employees = session
                    .createQuery("from Employee", Employee.class).getResultList();
            transaction.commit();
        }

        return employees;
    }

    // Поиск сотрудника по имени
    public List<Employee> findByName(String findName) {

        List<Employee> employees = null;

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();

            Query query = session
                    .createQuery("from Employee where name = :name", Employee.class);
            query.setParameter("name", findName);

            employees = query.getResultList();

            transaction.commit();
        }

        return employees;
    }

    // Удаление данных
    public void deleteEmployee(int id) {

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();
        }
    }
}
