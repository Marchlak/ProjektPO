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

    void scalanie(ArrayList<Lot> genlot)
    {
        ArrayList<Integer> indeksy = new ArrayList<Integer>();
        ArrayList<Lot> pomoc = new ArrayList<Lot>();
       for(int i=0;i<genlot.size()+Loty.size();i++)
       {
        if(!genlot.isEmpty() && !Loty.isEmpty())
        {
            if(genlot.get(0).getPoczatek().isBefore(Loty.get(0).getPoczatek()))
            {
                pomoc.add(genlot.get(0));
                indeksy.add(i);
                genlot.remove(0);
            }
            else if(Loty.get(0).getPoczatek().isBefore(genlot.get(0).getPoczatek()))
            {
                pomoc.add(Loty.get(0));
                Loty.remove(0);
            }
        }
        else if(genlot.isEmpty())
        {
            pomoc.addAll(Loty);
            indeksy.add(i);
            Loty.removeAll(Loty);
            break;
        }
        else if(Loty.isEmpty())
        {
            pomoc.addAll(genlot);
            genlot.removeAll(genlot);
            break;
        }
       }
       Loty.addAll(pomoc);
       usuwanie(indeksy);
       pomoc.removeAll(pomoc);
    }
    private void usuwanie (ArrayList<Integer> nowowygenerowaneloty)
    {
        ArrayList<Integer> dousuniecia = new ArrayList<>();
       for(int i=0;i<nowowygenerowaneloty.size();i++)
       {
           int x=nowowygenerowaneloty.get(0);
           nowowygenerowaneloty.remove(0);
           if(x==0)
           {
                if(Loty.get(x).getKoniec().plusHours(12).isAfter(Loty.get(x+1).getPoczatek()))
                {
                    dousuniecia.add(x);
                }
           }
           else if(x==Loty.size()-1)
           {
               if(Loty.get(x).getPoczatek().minusHours(12).isBefore(Loty.get(x-1).getPoczatek()))
               {
                   dousuniecia.add(x);
               }
           }
           else if (Loty.get(x).getKoniec().plusHours(12).isAfter(Loty.get(x+1).getPoczatek()) || Loty.get(x).getPoczatek().minusHours(12).isBefore(Loty.get(x-1).getPoczatek()) )
           {
               dousuniecia.add(x);
           }
       }
       for(int i=0;i<dousuniecia.size();i++)
       {
           Loty.remove(dousuniecia.get(dousuniecia.size()-1-i));
       }
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
