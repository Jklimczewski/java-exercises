package lab5;

import java.time.LocalDate;

public sealed abstract class Atrybuty permits Dom, Mieszkanie {
    private String ulica;
    private int numer_domu;
    private String miejscowosc;
    private String kod_pocztowy;
    private int powierzchnia;
    private int cena;
    private LocalDate data_obow_oferty;

    Atrybuty(String ulica, int numer_domu, String miejscowosc, String kod_pocztowy, int powierzchnia, int cena,
            LocalDate data_obow_oferty) {
        this.ulica = ulica;
        this.numer_domu = numer_domu;
        this.miejscowosc = miejscowosc;
        this.kod_pocztowy = kod_pocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.data_obow_oferty = data_obow_oferty;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNumer_domu() {
        return numer_domu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public int getCena() {
        return cena;
    }

    public LocalDate getData_obow_oferty() {
        return data_obow_oferty;
    }

    @Override
    public String toString() {
        return "Ulica:" + ulica + "; numer_domu:" + numer_domu + "; miejscowosc:" + miejscowosc
                + "; kod_pocztowy:" + kod_pocztowy + "; powierzchnia:" + powierzchnia + "; cena:" + cena
                + "; data_obow_oferty:" + data_obow_oferty;
    }
}
