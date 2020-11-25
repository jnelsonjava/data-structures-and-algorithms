package hrank.basics;

import java.util.List;

public class RoundingGrades {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int i = 0; i < grades.size(); i++) {
            grades.set(i, roundGrade(grades.get(i)));
        }
        return grades;
    }

    private static int roundGrade(int grade) {
        if (grade < 38 || grade % 5 < 3) return grade;
        return grade + 5 - (grade % 5);
    }
}
