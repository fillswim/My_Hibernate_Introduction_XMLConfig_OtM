package com.fillswim.hibernate.One_to_Many;

import com.fillswim.hibernate.One_to_Many.Entity.Department;
import com.fillswim.hibernate.One_to_Many.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Сохранение департамента в БД
//        Employee employee1 = new Employee("Mike", "Smirnov", 700);
//        Employee employee2 = new Employee("Nate", "Trump", 780);
//
//        Department department = new Department("HR", 600, 1500);
//        department.addEmployeeToDepartment(employee1);
//        department.addEmployeeToDepartment(employee2);
//
//        departmentDAO.saveDepartment(department);

        // Получение департамента из базы и работников в нём
//        Department department = departmentDAO.getDepartment(1);
//        System.out.println(department);
//
//            // Работает только для (fetch = FetchType.EAGER) в Department
//        List<Employee> employees = department.getEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        // Изменение департамента
//        Department department = departmentDAO.getDepartment(1);
//        department.setName("IT");
//        departmentDAO.saveDepartment(department);

            // Изменение работника
//        Department department = departmentDAO.getDepartment(1);
//        Employee employee = department.getEmployees().get(1);
//        System.out.println(employee);
//        employee.setSalary(800);
//        System.out.println(employee);
//        departmentDAO.saveDepartment(department);

        // Изменение работника
        Employee employee = employeeDAO.getEmployee(2);
        System.out.println(employee);
        employee.setSalary(900);
        System.out.println(employee);
        employeeDAO.saveEmployee(employee);

        // Получение всех департаментов из БД
//        List<Department> departments = departmentDAO.getAllDepartments();
//        for (Department department : departments) {
//            System.out.println(department);
//        }

        // Поиск департамента по названию
//        List<Department> departments = departmentDAO.findByName("IT");
//        for (Department department : departments) {
//            System.out.println(department);
//        }

        // Удаление департамента и работников в нем
//        departmentDAO.deleteDepartment(1);
    }
}
