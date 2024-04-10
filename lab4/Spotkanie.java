package lab4;

import java.time.LocalTime;

public final class Spotkanie extends Atrybuty {
    private Priorytet priorytet;

    public Priorytet getPriorytet() {
        return priorytet;
    }

    public Spotkanie(String opis, LocalTime czas_poczatku, LocalTime czas_zakonczenia, Priorytet priorytet) {
        super(opis, czas_poczatku, czas_zakonczenia);
        this.priorytet = priorytet;
    }

    @Override
    public String toString() { 
        return super.toString() + "; Priorytet: " + priorytet;
    }
}
