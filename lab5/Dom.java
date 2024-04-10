package lab5;

import java.time.LocalDate;

public final class Dom extends Atrybuty {
    private int powierzchnia_dzialki;

    public int getPowierzchnia_dzialki() {
        return powierzchnia_dzialki;
    }

    public Dom(String ulica, int numer_domu, String miejscowosc, String kod_pocztowy, int powierzchnia, int cena,
            LocalDate data_obow_oferty, int powierzchnia_dzialki) {
        super(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, data_obow_oferty);
        this.powierzchnia_dzialki = powierzchnia_dzialki;
    }

    @Override
    public String toString() { 
        return super.toString() + "; Powierzchnia_działki: " + powierzchnia_dzialki;
    }
    
}
