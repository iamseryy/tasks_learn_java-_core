package org.task5;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        var students = new ArrayList<>(List.of(
                new Student("Student1", new ArrayList<>(List.of(4.0,5.0,3.0,4.0,4.0,5.0)), Specialty.CHEMISTRY),
                new Student("Student2", new ArrayList<>(List.of(2.0,3.0,4.0,5.0,5.0,5.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student3", new ArrayList<>(List.of(4.0,5.0,3.0,4.0,4.0,4.0)), Specialty.PHYSICS),
                new Student("Student4", new ArrayList<>(List.of(5.0, 5.0, 5.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student5", new ArrayList<>(List.of(4.0,5.0,3.0,3.0,4.0,2.0)), Specialty.CHEMISTRY),
                new Student("Student6", new ArrayList<>(List.of(4.0,5.0,5.0,5.0,4.0,5.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student7", new ArrayList<>(List.of(4.0,5.0,3.0,3.0,4.0,5.0)), Specialty.CHEMISTRY),
                new Student("Student8", new ArrayList<>(List.of(5.0,5.0,5.0,5.0,4.0,4.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student9", new ArrayList<>(List.of(3.0,3.0,3.0,3.0,4.0,5.0)), Specialty.PHYSICS),
                new Student("Student10", new ArrayList<>(List.of(5.0,3.0,5.0,4.0,5.0,3.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student11", new ArrayList<>(List.of(4.0,2.0,3.0,3.0,2.0,5.0)), Specialty.CHEMISTRY),
                new Student("Student12", new ArrayList<>(List.of(5.0,3.0,3.0,5.0,5.0,5.0, 5.0, 5.0, 5.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student13", new ArrayList<>(List.of(4.0,4.0,3.0,3.0,4.0,5.0)), Specialty.PHYSICS),
                new Student("Student14", new ArrayList<>(List.of(5.0,5.0,5.0,5.0,5.0,4.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student15", new ArrayList<>(List.of(5.0,3.0,5.0,4.0,5.0,3.0)), Specialty.PHYSICS),
                new Student("Student16", new ArrayList<>(List.of(5.0,3.0,5.0,5.0,5.0,5.0)), Specialty.COMPUTER_SCIENCE),
                new Student("Student17", new ArrayList<>(List.of(5.0,3.0,5.0,4.0,5.0,3.0)), Specialty.CHEMISTRY)

        ));

        students.stream()
                .filter(student -> student.specialty().equals(Specialty.COMPUTER_SCIENCE))
                .filter(student -> student.grades().stream()
                                                    .mapToDouble(grade -> grade)
                                                    .average()
                                                    .orElse(0.0) > 4.5)
                .sorted(Comparator.comparingDouble(student-> student.grades().stream()
                                                                                .mapToDouble(grade -> grade)
                                                                                .average()
                                                                                .orElse(0.0) * (-1)))
                .limit(5)
                .forEach(student -> System.out.println(student + "; average grade = " + student.grades().stream()
                                                                                            .mapToDouble(grade -> grade)
                                                                                            .average()
                                                                                            .orElse(0.0)));
    }
}
