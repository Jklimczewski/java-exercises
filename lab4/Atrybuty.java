package lab4;

import java.time.LocalTime;

public sealed abstract class Atrybuty permits Zadanie, Spotkanie {
    public static final LocalTime MIN_GODZINA = LocalTime.parse("08:00");

    private String opis;
    private LocalTime czas_poczatku;
    private LocalTime czas_zakonczenia;

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzas_poczatku() {
        return czas_poczatku;
    }

    public LocalTime getCzas_zakonczenia() {
        return czas_zakonczenia;
    }

    Atrybuty(String opis, LocalTime czas_poczatku, LocalTime czas_zakonczenia) {
        this.opis = opis;
        this.czas_poczatku = czas_poczatku;
        this.czas_zakonczenia = czas_zakonczenia;
    }
    
    @Override
    public String toString() { 
        return "Opis: " + getOpis() + "; Początek: " + getCzas_poczatku() + "; Koniec: " + getCzas_zakonczenia();
    }
}
