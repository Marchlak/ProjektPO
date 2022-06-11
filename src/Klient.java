import java.util.ArrayList;

public class Klient {
    private String imie,nazwisko, narodowosc;
    private int wiek;
    ArrayList <Bilet> bilety;

    public Klient (String imie, String nazwisko, String narodowosc, int wiek){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.narodowosc = narodowosc;
        this.wiek = wiek;
    }

    public void dodajBilet(Bilet bilet){
        bilety.add(bilet);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public int getWiek() {
        return wiek;
    }

    public ArrayList<Bilet> getBilety() {
        return bilety;
    }
}
