package lab2;

import java.util.Scanner;

public class Zad2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Program umożliwiający powołanie do życia walca.");
        Walec walec = new Walec();
        boolean stillWorking = true;

        while (stillWorking) {
            int wybor = opcje();
            switch (wybor) {
                case 1 -> wyswietlenieParametrow(walec);
                case 2 -> zmianaParametrow(walec);
                case 3 -> wyswietlenieWlasciwosci(walec);
                case 4 -> stillWorking = pozegnanie();
            }
        }
    }

    static int opcje() {
        System.out.println();
        System.out.print(
                "1) Wyświetlenie parametrów walca\n" +
                        "2) Zmiana wartości parametrów walca\n" +
                        "3) Wyświetlenie pól powierzchni i objętości walca\n" +
                        "4) Wyjście z programu\n" +
                        "Wybierz opcję: ");
        int result = scanner.nextInt();
        System.out.println();
        return result;
    }

    static void wyswietlenieWlasciwosci(Walec walec) {
        System.out.println("Pole powierchni bocznej: " + walec.pPowierzchniBocznej());
        System.out.println("Pole podstawy: " + walec.polePodstawy());
        System.out.println("Pole powierzchni całkowitej: " + walec.pPowierzchniCalkowitej());
        System.out.println("Objętość: " + walec.objetosc());
    }

    static void wyswietlenieParametrow(Walec walec) {
        System.out.println(walec.getPromien());
        System.out.println(walec.getWysokosc());
    }

    static void zmianaParametrow(Walec walec) {
        System.out.print("Podaj promień: ");
        double promien = scanner.nextDouble();
        System.out.print("Podaj wysokość: ");
        double wysokosc = scanner.nextDouble();

        walec.setPromien(promien);
        walec.setWysokosc(wysokosc);
    }

    static boolean pozegnanie() {
        System.out.println("Żegnaj!");
        return false;
    }
}