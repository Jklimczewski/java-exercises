package lab2;

public class Walec {
    private double promien;
    private double wysokosc;
    
    public void setPromien(double promien) {
        this.promien = promien;
    }
    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getPromien() {
        return promien;
    }
    public double getWysokosc() {
        return wysokosc;
    }

    public Walec(double r, double h) {
        promien = r;
        wysokosc = h;
    }
    public Walec() {}

    public double polePodstawy() {
        return Math.PI * Math.pow(promien, 2);
    }
    public double pPowierzchniBocznej() {
        return 2 * Math.PI * promien * wysokosc;
    }
    public double pPowierzchniCalkowitej() {
        return 2 * polePodstawy() + pPowierzchniBocznej();
    }
    public double objetosc() {
        return polePodstawy() * wysokosc;
    }
}
