package lab5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Zad5 {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Program do obsługi ofert sprzedaży mieszkań i domów.");
        ListaOfert listaOfert = new ListaOfert();
        dodajDomyslneOferty(listaOfert);
        boolean stillWorking = true;

        while (stillWorking) {
            int wybor = opcje();
            switch (wybor) {
                case 1 -> dodajOferteDomu(listaOfert);
                case 2 -> dodajOferteMieszkania(listaOfert);
                case 3 -> wyswietlenieWszystkichDomow(listaOfert);
                case 4 -> wyswietlenieWszystkichMieszkan(listaOfert);
                case 5 -> wyswietlenieDomowMiejscowoscIPow(listaOfert);
                case 6 -> wyswietlenieMieszkanMiejscowoscCenaPietr(listaOfert);
                case 7-> stillWorking = pozegnanie();
            }
        }
    }

    static void dodajDomyslneOferty(ListaOfert listaOfert) {
        Dom dom1 = new Dom("dsa", 1, "Olsztyn", "10-693", 100, 1000, LocalDate.parse("2023-05-24"), 150);
        Dom dom2 = new Dom("dsa", 1, "Olsztyn", "10-693", 100, 1000, LocalDate.parse("2023-05-25"), 150);
        Mieszkanie mieszkanie1 = new Mieszkanie("dsa", 1, "Olsztyn", "10-693", 100, 1000, LocalDate.parse("2023-05-24"), 15, 2);
        Mieszkanie mieszkanie2 = new Mieszkanie("dsa", 1, "Olsztyn", "10-693", 100, 1000, LocalDate.parse("2023-05-24"), 12, 3);
        listaOfert.addHouseForSell(dom1);
        listaOfert.addHouseForSell(dom2);
        listaOfert.addFlatForSell(mieszkanie1);
        listaOfert.addFlatForSell(mieszkanie2);
    }

    static int opcje() {
        System.out.println();
        System.out.print(
        "1) Dodanie oferty sprzedaży domu\n" +
        "2) Dodanie oferty sprzedaży mieszkania\n" +
        "3) Wyświetlenie wszystkich aktualnych ofert sprzedaży domów\n" +
        "4) Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań\n" +
        "5) Wyświetlenie aktualnych ofert domów w podanej miejscowości i powierzchni nie mniejszej od podanej\n" +
        "6) Wyświetlenie aktualnych ofert mieszkań w podanej miejscowości, nie droższych od podanej wartości i od podanego piętra wzwyż\n" +
        "7) Wyjście\n" +
        "Wybierz opcję: ");
        int result = scannerInt.nextInt();
        System.out.println();
        return result;
    }

    static String podajUlice() {
        System.out.print("Podaj ulicę: ");
        return scannerStr.nextLine();
    }
    static int podajNumerDomu() {
        System.out.print("Podaj numer domu: ");
        return scannerInt.nextInt();
    }
    static String podajMiejscowosc() {
        System.out.print("Podaj miejscowość: ");
        return scannerStr.nextLine();
    }
    static String podajKodPocztowy() {
        System.out.print("Podaj kod pocztowy: ");
        return scannerStr.nextLine();
    }
    static int podajPowierzchnie() {
        System.out.print("Podaj powierzchnię: ");
        return scannerInt.nextInt();
    }
    static int podajCene() {
        System.out.print("Podaj cenę: ");
        return scannerInt.nextInt();
    }
    static LocalDate podajDateObowOferty() {
        System.out.print("Podaj datę obowiązywania oferty: ");
        LocalDate data = LocalDate.parse(scannerStr.nextLine());
        return data;
    }
    static int podajPowDzialki() {
        System.out.print("Podaj powiechnię działki: ");
        return scannerInt.nextInt();
    }
    static int podajPietro() {
        System.out.print("Podaj numer piętra: ");
        return scannerInt.nextInt();
    }
    static int podajNrMieszkania() {
        System.out.print("Podaj numer mieszkania: ");
        return scannerInt.nextInt();
    }
    
    
    static void dodajOferteDomu(ListaOfert listaOfert) {
        String ulica = podajUlice();
        int numer_domu = podajNumerDomu();
        String miejscowosc = podajMiejscowosc();
        String kod_pocztowy = podajKodPocztowy();
        int powierzchnia = podajPowierzchnie();
        int cena = podajCene();
        LocalDate data_ob_oferty = podajDateObowOferty();
        int powierzchnia_dzialki = podajPowDzialki();

        Dom dom = new Dom(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, data_ob_oferty, powierzchnia_dzialki);
        listaOfert.addHouseForSell(dom);
    }

    static void dodajOferteMieszkania(ListaOfert listaOfert) {
        String ulica = podajUlice();
        int numer_domu = podajNumerDomu();
        String miejscowosc = podajMiejscowosc();
        String kod_pocztowy = podajKodPocztowy();
        int powierzchnia = podajPowierzchnie();
        int cena = podajCene();
        LocalDate data_ob_oferty = podajDateObowOferty();
        int numer_mieszkania = podajNrMieszkania();
        int numer_pietra = podajPietro();

        Mieszkanie mieszkanie = new Mieszkanie(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, data_ob_oferty, numer_mieszkania, numer_pietra);
        listaOfert.addFlatForSell(mieszkanie);
    }

    static void wyswietlenieWszystkichDomow(ListaOfert listaOfert) {
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Dom y && !(y.getData_obow_oferty().isBefore(LocalDate.now()));
        ArrayList<Atrybuty> oferty = listaOfert.showCurrentOffers(lambda);
        wyswietlOfertPetla(oferty);
    }

    static void wyswietlenieWszystkichMieszkan(ListaOfert listaOfert) {
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Mieszkanie y && !(y.getData_obow_oferty().isBefore(LocalDate.now()));
        ArrayList<Atrybuty> oferty = listaOfert.showCurrentOffers(lambda);
        wyswietlOfertPetla(oferty);
    }

    static void wyswietlenieDomowMiejscowoscIPow(ListaOfert listaOfert) {
        String miejscowosc = podajMiejscowosc();
        int powierzchnia = podajPowierzchnie();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Dom y && !(y.getData_obow_oferty().isBefore(LocalDate.now())) 
            && y.getMiejscowosc().equals(miejscowosc) && y.getPowierzchnia() >= powierzchnia;
        ArrayList<Atrybuty> oferty = listaOfert.showCurrentOffers(lambda);
        wyswietlOfertPetla(oferty);
    }

    static void wyswietlenieMieszkanMiejscowoscCenaPietr(ListaOfert listaOfert) {
        String miejscowosc = podajMiejscowosc();
        int cena = podajCene();
        int pietro = podajPietro();
        System.out.println();
        Predicate<Atrybuty> lambda = x -> x instanceof Mieszkanie y && !(y.getData_obow_oferty().isBefore(LocalDate.now())) 
            && y.getMiejscowosc().equals(miejscowosc) && y.getCena() <= cena && y.getNumer_pietra() >= pietro;
        ArrayList<Atrybuty> oferty = listaOfert.showCurrentOffers(lambda);
        wyswietlOfertPetla(oferty);
    }
    
    static void wyswietlOfertPetla(ArrayList<Atrybuty> oferty) {
        for (Atrybuty oferta : oferty) {
            System.out.println(oferta);
        }
    }

    static boolean pozegnanie() {
        System.out.println("Żegnaj!");
        return false;
    }
}
