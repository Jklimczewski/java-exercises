package lab5;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Atrybuty> oferty = new ArrayList<>();

    public void addHouseForSell(Dom dom) {
        oferty.add(dom);
    }

    public void addFlatForSell(Mieszkanie mieszkanie) {
        oferty.add(mieszkanie);
    }

    public ArrayList<Atrybuty> showCurrentOffers(Predicate<Atrybuty> predykat) {
        ArrayList<Atrybuty> ofertyDoWyswietlenia = new ArrayList<Atrybuty>();
        for (Atrybuty oferta : oferty) {
            if (predykat.test(oferta)) {
                ofertyDoWyswietlenia.add(oferta);
            }
        }
        return ofertyDoWyswietlenia;
    }
}