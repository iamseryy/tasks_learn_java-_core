package org.task3.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee implements Comparable<Employee>{
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private int salary;
    private Calendar hiringDate;

    public Employee(String name, String surname, String patronymic, int age, int salary, Calendar hiringDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.salary = salary;
        this.hiringDate = hiringDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Calendar getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public int compareTo(Employee employee) {
        return hiringDate.compareTo(employee.getHiringDate());
    }

    @Override
    public String toString() {
        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", hiringDate=" + simpleDateFormat.format(hiringDate.getTime()) +
                '}';
    }
}
