package lab3;

import java.util.Scanner;

public class Zad3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Program umożliwiający działanie z ocenami studenta.");
        GradeList oceny = new GradeList();
        boolean stillWorking = true;

        while (stillWorking) {
            int wybor = opcje();
            switch (wybor) {
                case 1 -> dodawanieOceny(oceny);
                case 2 -> wyliczenieSredniej(oceny);
                case 3 -> wartoscMinimalna(oceny);
                case 4 -> wartoscMaksymalna(oceny);
                case 5 -> stillWorking = pozegnanie();
            }
        }
    }
    static int opcje() {
        System.out.println();
        System.out.print(
        "1) Dodanie nowej oceny\n" +
        "2) Wyliczenie średniej z ocen\n" +
        "3) Najwyższa ocena\n" +
        "4) Najniższa ocena\n" +
        "5) Wyjście z programu\n" +
        "Wybierz opcję: ");
        int result = scanner.nextInt();
        System.out.println();
        return result;
    }

    static void dodawanieOceny(GradeList oceny) {
        System.out.print("Podaj ocenę: ");
        double grade = scanner.nextDouble();
        if (grade >= 2 && grade <= 5) {
            oceny.addNewGrade(grade);
            System.out.println("Dodano nową ocenę! ");
        } else {
            System.out.println("Podałeś złą ocenę!");
        }
    }

    static void wyliczenieSredniej(GradeList oceny) {
        double avg = oceny.getAvg();
        if (avg == -1) {
            System.out.println("Brak ocen!");
        } else {
            System.out.println("Średnia: " + avg);
        }
    }

    static void wartoscMinimalna(GradeList oceny) {
        double min = oceny.getMin();
        if (min == -1) {
            System.out.println("Brak ocen!");
        } else {
            System.out.println("Min: " + min);
        }
    }

    static void wartoscMaksymalna(GradeList oceny) {
        double max = oceny.getMax();
        if (max == -1) {
            System.out.println("Brak ocen!");
        } else {
            System.out.println("Max: " + max);
        }
    }

    static boolean pozegnanie() {
        System.out.println("Żegnaj!");
        return false;
    }
}
