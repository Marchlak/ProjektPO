import java.util.ArrayList;
public class Samolot {
    private int zasieg,liczbamiejsc;
    private String model;
    private ArrayList<Lot> Loty;

    public Samolot(int zasieg, int liczbamiejsc, String model) {
        this.zasieg = zasieg;
        this.liczbamiejsc = liczbamiejsc;
        this.model = model;
    }
    ///Dodaję indeks do metody żeby wiedzieć który z listy usunąć
    void dodajLot(Lot lot,int indeks)
    {
        Loty.add(indeks,lot);
    }
    void usunLot(int indeks)
    {
     Loty.remove(indeks);
    }

    public int getZasieg() {
        return zasieg;
    }

    public int getLiczbamiejsc() {
        return liczbamiejsc;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Lot> getLoty() {
        return Loty;
    }
}
