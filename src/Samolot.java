import java.time.LocalDateTime;
import java.util.ArrayList;

public class Samolot {
    private int liczbamiejsc;
    double zasieg;
    private String model;
    private ArrayList<Lot> Loty;

    public Samolot(double zasieg, int liczbamiejsc, String model) {
        this.zasieg = zasieg;
        this.liczbamiejsc = liczbamiejsc;
        this.model = model;
        Loty = new ArrayList<>();
    }

    public boolean czyZasiegjestWystarczajcy(Trasa tr)
    {
        boolean wynik= false;
        double x;
        x=tr.getOdleglosc();
        if(x<=zasieg)
        {
            wynik=true;
        }
        return wynik;
    }

    public boolean czySamolotmaczas(LocalDateTime pocz, LocalDateTime kon)
    {
        for (Lot l: Loty)
        {
            if(!pocz.isBefore(l.getKoniec()) && kon.isBefore(l.getPoczatek()))
            {
                return true;
            }
        }
        return false;
    }
    ///Dodaję indeks do metody żeby wiedzieć który z listy usunąć
    public void dodajLot(Lot lot,int indeks)
    {
        Loty.add(indeks,lot);
    }
    public void dodajLot2(Lot lot){
        Loty.add(lot);
    }
    public void usunLot(int indeks)
    {
        Loty.remove(indeks);
    }

    public double getZasieg() {
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


    public String toStringSamolot() {
        return "Samolot" +
                "liczbamiejsc=" + liczbamiejsc +
                ", zasieg=" + zasieg +
                ", model='" + model + '\'';
    }
}
