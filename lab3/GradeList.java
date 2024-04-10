package lab3;

import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> grades = new ArrayList<Double>();

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void addNewGrade(double grade) {
        grades.add(grade);
    }

    public double getAvg() {
        if (grades.isEmpty()) {
            return -1;
        }
        double avg = 0;
        for (Double grade : grades) {
            avg += grade;
        }
        return avg / grades.size();
    }

    public double getMin() {
        if (grades.isEmpty()) {
            return -1;
        }
        double min = grades.get(0);
        for (Double grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    public double getMax() {
        if (grades.isEmpty()) {
            return -1;
        }
        double max = grades.get(0);
        for (Double grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }
}
