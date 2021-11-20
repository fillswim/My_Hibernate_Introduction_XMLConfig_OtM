package com.fillswim.hibernate.One_to_Many;

import com.fillswim.hibernate.One_to_Many.Entity.Department;
import com.fillswim.hibernate.One_to_Many.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentDAO {

    // Обновление Сохранение или обновление данных
    public void saveDepartment(Department department) {

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            session.merge(department);
            transaction.commit();
        }
    }

    // Чтение данных
    public Department getDepartment(int id) {

        Department department = new Department();
        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            department = session.get(Department.class, id);
            transaction.commit();
        }

        return department;
    }

    // Получение всех департаментов из БД
    public List<Department> getAllDepartments() {
        List<Department> departments = null;

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            departments = session
                    .createQuery("from Department", Department.class)
                    .getResultList();
            transaction.commit();
        }

        return departments;
    }

    // Поиск департамента по названию
    public List<Department> findByName(String findName) {

        List<Department> departments = null;

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();

            Query query = session
                    .createQuery("from Department where name = :name", Department.class);
            query.setParameter("name", findName);

            departments = query.getResultList();

            transaction.commit();
        }

        return departments;
    }

    // Удаление департамента и работников в нем
    public void deleteDepartment(int id) {

        try (SessionFactory sessionFactory =
                     new Configuration()
                             .configure("hibernate.cfg.xml")
                             .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, 2);
            session.delete(department);
            transaction.commit();
        }
    }


}
