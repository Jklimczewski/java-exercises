package lab4;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.ArrayList;

public class Zad4 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Program do obsługi spotkań na przestrzeni tygodnia.");
        Kalendarz kalendarz = new Kalendarz();
        dodajDomyslneWydarzenia(kalendarz);
        boolean stillWorking = true;

        while (stillWorking) {
            int wybor = opcje();
            switch (wybor) {
                case 1 -> dodajSpotkanieNaDzien(kalendarz);
                case 2 -> dodajZadanieNaDzien(kalendarz);
                case 3 -> usunSpotkanieZDnia(kalendarz);
                case 4 -> usunZadanieZDnia(kalendarz);
                case 5 -> wyswietlenieWszystkichSpotkanDnia(kalendarz);
                case 6 -> wyswietlenieWszystkichZadanDnia(kalendarz);
                case 7 -> wyswietlenieSpotkanPriorytet(kalendarz);
                case 8 -> wyswietlenieSpotkanStatus(kalendarz);
                case 9 -> wyswietlenieSpotkanGodzinaIPriorytet(kalendarz);
                case 10 -> wyswietlenieZadanGodzinaIStatus(kalendarz);
                case 11-> stillWorking = pozegnanie();
            }
        }
    }

    static void dodajDomyslneWydarzenia(Kalendarz kalendarz) {
        Spotkanie spotkanie1 = new Spotkanie("dsa", LocalTime.parse("09:00"), LocalTime.parse("09:15"), Priorytet.NISKI);
        Spotkanie spotkanie2 = new Spotkanie("dsa", LocalTime.parse("10:00"), LocalTime.parse("10:15"), Priorytet.SREDNI);
        Zadanie zadanie1 = new Zadanie("dsa", LocalTime.parse("09:00"), LocalTime.parse("09:15"), Status.PLANOWANE);
        Zadanie zadanie2 = new Zadanie("dsa", LocalTime.parse("10:00"), LocalTime.parse("10:15"), Status.POTWIERDZONE);
        kalendarz.addEventToDay(1, spotkanie1);
        kalendarz.addEventToDay(1, spotkanie2);
        kalendarz.addEventToDay(1, zadanie1);
        kalendarz.addEventToDay(1, zadanie2);
    }

    static int opcje() {
        System.out.println();
        System.out.print(
        "1) Dodanie spotkania na wybrany dzień\n" +
        "2) Dodanie zadania na wybrany dzień\n" +
        "3) Usunięcie spotkania z wybranego dnia\n" +
        "4) Usunięcie zadania z wybranego dnia\n" +
        "5) Wyświetlenie wszystkich spotkań z dnia\n" +
        "6) Wyświetlenie wszystkich zadań z dnia\n" +
        "7) Wyświetlenie spotkań z dnia o podanym priorytecie\n" +
        "8) Wyświetlenie zadań z dnia o podanym statusie\n" +
        "9) Wyświetlenie spotkań z dnia o podanym priorytecie i po podanej godzinie\n" +
        "10) Wyświetlenie zadań z dnia o podanym statusie i przed podaną godziną \n" +
        "11) Wyjście\n" +
        "Wybierz opcję: ");
        int result = Integer.valueOf(scanner.nextLine());
        System.out.println();
        return result;
    }

    static int podajDzien() {
        System.out.print("Podaj dzień (1,2,3,4,5,6,7): ");
        return Integer.valueOf(scanner.nextLine());
    }
    static String podajOpis() {
        System.out.print("Podaj opis spotkania: ");
        return scanner.nextLine();
    }
    static LocalTime podajGodzine() {
        System.out.print("Podaj godzinę (GG:MM): ");
        LocalTime godzina = LocalTime.parse(scanner.nextLine());
        return godzina;
    }
    static LocalTime podajGodzineRozpoczecia() {
        boolean zlaGodzina = true;
        LocalTime godzinaRozpoczecia = Spotkanie.MIN_GODZINA;
        while (zlaGodzina) {
            System.out.print("Podaj godzinę rozpoczęcia (GG:MM): ");
            godzinaRozpoczecia = LocalTime.parse(scanner.nextLine());
            if (godzinaRozpoczecia.isAfter(Spotkanie.MIN_GODZINA)) {
                zlaGodzina = false;
                break;
            }
            System.out.println("BŁĄD: Najwcześniejsza godzina to: " + Spotkanie.MIN_GODZINA);
        }
        return godzinaRozpoczecia;
    }
    static LocalTime podajGodzineZakonczenia(LocalTime godzinaRozpoczecia) {
        boolean zlaGodzina = true;
        LocalTime godzinaZakonczenia = Spotkanie.MIN_GODZINA;
        while (zlaGodzina) {
            System.out.print("Podaj godzinę zakończenia (GG:MM): ");
            godzinaZakonczenia = LocalTime.parse(scanner.nextLine());
            if (godzinaZakonczenia.isAfter(godzinaRozpoczecia)) {
                zlaGodzina = false;
                break;
            }
            System.out.println("BŁĄD: Nie możesz skończyć spotkania zanim je zacząłeś!:)");
        }
        return godzinaZakonczenia;
    }
    static int podajNumerSpotkania(Kalendarz kalendarz, int dzien) {
        boolean zlyNumer = true;
        int numer = 0;
        while (zlyNumer) {
            System.out.print("Podaj numer spotkania: ");
            numer = Integer.valueOf(scanner.nextLine());
            if (kalendarz.checkIfIndexExists(dzien, numer)) {
                zlyNumer = false;
                break;
            }
            System.out.println("BŁĄD: Podaj numer z listy!");
        }
        return numer;
    }
    static Priorytet podajPriorytet() {
        Priorytet priorytetFinalny = Priorytet.NISKI;
        int priorytetLiczba = 1;
        boolean zlaLiczba = true;

        while (zlaLiczba) {
            System.out.print("Podaj priorytet (niski - 1, średni - 2, wysoki - 3): ");
            priorytetLiczba = Integer.valueOf(scanner.nextLine());
            if (priorytetLiczba == 1 || priorytetLiczba == 2 || priorytetLiczba == 3) {
                zlaLiczba = false;
                break;
            }
            System.out.println("BŁĄD: Podaj poprawną liczbę!");
        }
        switch (priorytetLiczba) {
            case 1 -> priorytetFinalny = Priorytet.NISKI;
            case 2 -> priorytetFinalny = Priorytet.SREDNI;
            case 3 -> priorytetFinalny = Priorytet.WYSOKI;
        }
        return priorytetFinalny;
    }

    static Status podajStatus() {
        Status statusFinalny = Status.PLANOWANE;
        int statusLiczba = 1;
        boolean zlaLiczba = true;

        while (zlaLiczba) {
            System.out.print("Podaj status (planowane - 1, potwierdzone - 2, realizowane - 3, wykonane - 4): ");
            statusLiczba = Integer.valueOf(scanner.nextLine());
            if (statusLiczba >= 1 && statusLiczba <= 4) {
                zlaLiczba = false;
                break;
            }
            System.out.println("BŁĄD: Podaj poprawną liczbę!");
        }
        switch (statusLiczba) {
            case 1 -> statusFinalny = Status.PLANOWANE;
            case 2 -> statusFinalny = Status.POTWIERDZONE;
            case 3 -> statusFinalny = Status.REALIZOWANE;
            case 4 -> statusFinalny = Status.WYKONANE;
        }
        return statusFinalny;
    }
    
    static void dodajZadanieNaDzien(Kalendarz kalendarz) {
        int dzien = podajDzien();
        String opis = podajOpis();
        LocalTime godzina_rozpoczecia = podajGodzineRozpoczecia();
        LocalTime godzina_zakonczenia = podajGodzineZakonczenia(godzina_rozpoczecia);
        Status status = podajStatus();

        Zadanie zadanie = new Zadanie(opis, godzina_rozpoczecia, godzina_zakonczenia, status);
        kalendarz.addEventToDay(dzien, zadanie);
    }

    static void dodajSpotkanieNaDzien(Kalendarz kalendarz) {
        int dzien = podajDzien();
        String opis = podajOpis();
        LocalTime godzina_rozpoczecia = podajGodzineRozpoczecia();
        LocalTime godzina_zakonczenia = podajGodzineZakonczenia(godzina_rozpoczecia);
        Priorytet priorytet = podajPriorytet();

        Spotkanie spotkanie = new Spotkanie(opis, godzina_rozpoczecia, godzina_zakonczenia, priorytet);
        kalendarz.addEventToDay(dzien, spotkanie);
    }

    static void usunSpotkanieZDnia(Kalendarz kalendarz) {
        int dzien = podajDzien();
        System.out.println();
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, x -> x instanceof Spotkanie);
        wyswietlWydarzeniaPetla(wydarzenia);

        int numer = podajNumerSpotkania(kalendarz, dzien);
        Atrybuty doUsuniecia = wydarzenia.get(numer);
        kalendarz.deleteEventOfDay(dzien, doUsuniecia);
    }

    static void usunZadanieZDnia(Kalendarz kalendarz) {
        int dzien = podajDzien();
        System.out.println();
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, x -> x instanceof Zadanie);
        wyswietlWydarzeniaPetla(wydarzenia);

        int numer = podajNumerSpotkania(kalendarz, dzien);
        Atrybuty doUsuniecia = wydarzenia.get(numer);
        kalendarz.deleteEventOfDay(dzien, doUsuniecia);
    }

    static void wyswietlenieWszystkichSpotkanDnia(Kalendarz kalendarz) {
        int dzien = podajDzien();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Spotkanie;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlenieWszystkichZadanDnia(Kalendarz kalendarz) {
        int dzien = podajDzien();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Zadanie;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlenieSpotkanPriorytet(Kalendarz kalendarz) {
        int dzien = podajDzien();
        Priorytet priorytet = podajPriorytet();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Spotkanie y && y.getPriorytet() == priorytet;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlenieSpotkanStatus(Kalendarz kalendarz) {
        int dzien = podajDzien();
        Status status = podajStatus();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Zadanie y && y.getStatus() == status;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlenieSpotkanGodzinaIPriorytet(Kalendarz kalendarz) {
        int dzien = podajDzien();
        Priorytet priorytet = podajPriorytet();
        LocalTime godzina = podajGodzine();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Spotkanie y && y.getCzas_poczatku().isAfter(godzina) && y.getPriorytet() == priorytet;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlenieZadanGodzinaIStatus(Kalendarz kalendarz) {
        int dzien = podajDzien();
        Status status = podajStatus();
        LocalTime godzina = podajGodzine();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Zadanie y && y.getCzas_poczatku().isBefore(godzina) && y.getStatus() == status;
        ArrayList<Atrybuty> wydarzenia = kalendarz.showMeetingsPredicate(dzien, lambda);
        wyswietlWydarzeniaPetla(wydarzenia);
    }

    static void wyswietlWydarzeniaPetla(ArrayList<Atrybuty> wydarzenia) {
        for (Atrybuty wydarzenie : wydarzenia) {
            System.out.println(wydarzenie);
        }
    }

    static boolean pozegnanie() {
        System.out.println("Żegnaj!");
        return false;
    }
}
