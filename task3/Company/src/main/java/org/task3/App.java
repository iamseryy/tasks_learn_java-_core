package org.task3;

import org.task3.model.Director;
import org.task3.model.Employee;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        var employee1 = new Employee("empl1", "empl1", "empl1", 33, 100000, Calendar.getInstance());
        var employee2 = new Employee("empl2", "empl2", "empl2", 44, 200000, Calendar.getInstance());
        Employee director = new Director("dir", "dir", "dir", 40, 900000, Calendar.getInstance());

        var employees = new ArrayList<Employee>();
        employees.add(employee2);
        employees.add(director);
        employees.add(employee1);
        employees.forEach(it -> System.out.println(it.toString()));

        System.out.println("\nsorted by hiringDate:");
        Collections.sort(employees);
        employees.forEach(it -> System.out.println(it.toString()));

        System.out.println("\nset salary employee1");
        Director.changeSalary(employee1, 300000);
        System.out.println(employee1.toString());

        System.out.println("\nset salary all");
        Director.changeSalary(employees, 500000);
        employees.forEach(it -> System.out.println(it.toString()));
    }



}
