package org.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        var students = new ArrayList<>(List.of(
                new Student("Student1", new ArrayList<>(List.of(4,5,3,4,4,5)), Specialty.CHEMISTRY),
                new Student("Student2", new ArrayList<>(List.of(5,5,5,5,4,4)), Specialty.COMPUTER_SCIENCE),
                new Student("Student3", new ArrayList<>(List.of(4,5,3,4,4,4)), Specialty.PHYSICS),
                new Student("Student4", new ArrayList<>(List.of(4,5,3,4,4,3)), Specialty.COMPUTER_SCIENCE),
                new Student("Student5", new ArrayList<>(List.of(4,5,3,3,4,2)), Specialty.CHEMISTRY),
                new Student("Student6", new ArrayList<>(List.of(4,5,3,4,4,1)), Specialty.COMPUTER_SCIENCE),
                new Student("Student7", new ArrayList<>(List.of(4,5,3,3,4,5)), Specialty.CHEMISTRY),
                new Student("Student8", new ArrayList<>(List.of(4,5,5,5,5,5)), Specialty.COMPUTER_SCIENCE),
                new Student("Student9", new ArrayList<>(List.of(3,3,3,3,4,5)), Specialty.PHYSICS),
                new Student("Student10", new ArrayList<>(List.of(5,3,5,4,5,3)), Specialty.COMPUTER_SCIENCE),
                new Student("Student11", new ArrayList<>(List.of(4,2,3,3,2,5)), Specialty.CHEMISTRY),
                new Student("Student12", new ArrayList<>(List.of(3,3,3,5,4,3)), Specialty.COMPUTER_SCIENCE),
                new Student("Student13", new ArrayList<>(List.of(4,4,3,3,4,5)), Specialty.PHYSICS),
                new Student("Student14", new ArrayList<>(List.of(3,3,3,3,3,3)), Specialty.COMPUTER_SCIENCE)
        ));

        students.stream()
                .filter(student -> student.specialty().equals(Specialty.COMPUTER_SCIENCE))
                .filter(student -> student.assessments().stream()
                        .mapToInt(assessment -> assessment)
                        .average()
                        .getAsDouble() > 4.5)
                .limit(5)
                .forEach(System.out::println);
    }
}
