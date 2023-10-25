package org.task3.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Director extends Employee{
    public Director(String name, String surname, String patronymic, int age, int salary, Calendar hiringDate) {
        super(name, surname, patronymic, age, salary, hiringDate);
    }

    public static boolean changeSalary(Employee employee, int salary){
        if (employee instanceof Director){
            return false;
        }

        employee.setSalary(salary);

        return true;
    }

    public static void changeSalary(List<Employee> employees, int salary){
        employees.stream()
                .filter(it-> !(it instanceof Director))
                .forEach(it -> it.setSalary(salary));
    }
}
