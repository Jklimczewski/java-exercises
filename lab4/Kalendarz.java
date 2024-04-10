package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class Kalendarz {
    private HashMap<Integer, ArrayList<Atrybuty>> wszystkieWydarzenia = new HashMap<>();

    private Kalendarz(int days) {
        for (int i = 1; i <= days; i++) {
            wszystkieWydarzenia.put(i, new ArrayList<Atrybuty>());
        }
    }
    public Kalendarz() {
        this(7);
    }

    public void addEventToDay(int day, Spotkanie meeting) {
        ArrayList<Atrybuty> aktualneWydarzenia = wszystkieWydarzenia.get(day);
        aktualneWydarzenia.add(meeting);
    }

    public void addEventToDay(int day, Zadanie zadanie) {
        ArrayList<Atrybuty> aktualneWydarzenia = wszystkieWydarzenia.get(day);
        aktualneWydarzenia.add(zadanie);
    }

    public void deleteEventOfDay(int day, Atrybuty meetingToDelete) {
        ArrayList<Atrybuty> aktualneWydarzenia = wszystkieWydarzenia.get(day);
        aktualneWydarzenia.remove(meetingToDelete);
    }

    public boolean checkIfIndexExists(int day, int indexOfMeeting) {
        ArrayList<Atrybuty> aktualneWydarzenia = wszystkieWydarzenia.get(day);
        if (indexOfMeeting < aktualneWydarzenia.size() && indexOfMeeting >= 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Atrybuty> showMeetingsPredicate(int day, Predicate<Atrybuty> predykat) {
        ArrayList<Atrybuty> aktualneWydarzenia = wszystkieWydarzenia.get(day);
        ArrayList<Atrybuty> wydarzeniaDoWyswietlenia = new ArrayList<Atrybuty>();
        for (Atrybuty wydarzenie : aktualneWydarzenia) {
            if (predykat.test(wydarzenie)) {
                wydarzeniaDoWyswietlenia.add(wydarzenie);
            }
        }
        return wydarzeniaDoWyswietlenia;
    }
}