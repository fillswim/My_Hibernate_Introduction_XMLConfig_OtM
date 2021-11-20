package com.fillswim.hibernate.One_to_Many.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int max_salary;
    private int min_salary;

    @OneToMany(mappedBy = "department", // Связь прописана в поле "department" класса Employee
            cascade = {
                    CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Department() {
    }

    public Department(String name, int max_salary, int min_salary) {
        this.name = name;
        this.max_salary = max_salary;
        this.min_salary = min_salary;
    }

    // Метод для добавление работников в департамент
    public void addEmployeeToDepartment(Employee employee) {

        if (employees == null) {
            employees = new ArrayList<>();
        }

        employees.add(employee);
        employee.setDepartment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max_salary=" + max_salary +
                ", min_salary=" + min_salary +
                '}';
    }
}
