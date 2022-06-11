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

    public boolean czySamolotmaczas(Data pocz, Data kon)
    {
        for (Lot l: Loty)
        {
            if(!pocz.czyDatajestwczesniejsza(l.getKoniec()) && kon.czyDatajestwczesniejsza(l.getPoczatek()))
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
}
