package lab4;

import java.time.LocalTime;

public final class Zadanie extends Atrybuty {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public Zadanie(String opis, LocalTime czas_poczatku, LocalTime czas_zakonczenia, Status status) {
        super(opis, czas_poczatku, czas_zakonczenia);
        this.status = status;
    }
    
    @Override
    public String toString() { 
        return super.toString() + "; Status: " + status;
    }
}
