package lab5;

import java.time.LocalDate;

public final class Mieszkanie extends Atrybuty {
    private int numer_mieszkania;
    private int numer_pietra;

    public Mieszkanie(String ulica, int numer_domu, String miejscowosc, String kod_pocztowy, int powierzchnia, int cena,
            LocalDate data_obow_oferty, int numer_mieszkania, int numer_pietra) {
        super(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, data_obow_oferty);
        this.numer_mieszkania = numer_mieszkania;
        this.numer_pietra = numer_pietra;
    }

    @Override
    public String toString() { 
        return super.toString() + "; Numer mieszkania: " + numer_mieszkania + "; Numer piętra: " + numer_pietra;
    }

    public int getNumer_mieszkania() {
        return numer_mieszkania;
    }

    public int getNumer_pietra() {
        return numer_pietra;
    }
    
    
}
