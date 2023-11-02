package org.task5;

import java.util.List;

public record Student(String name, List<Integer> assessments, Specialty specialty) {
}
