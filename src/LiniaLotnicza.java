import java.util.ArrayList;

public class LiniaLotnicza {
    private ArrayList<Lot> loty;
    private ArrayList<Lotnisko> lotniska;
    private ArrayList<Klient> klienci;
    private ArrayList<Trasa> trasy;
    private Flota flota;
    void dodajTrase(Trasa t)
    {
        trasy.add(t);
    }
    void usunTrase(Trasa t)
    {
        trasy.remove(t);
    }
    void dodajLotnisko(Lotnisko l)
    {
      lotniska.add(l);
    }
    void usunLotnisko(Lotnisko l)
    {
        lotniska.remove(l);
    }
    void dodajKlienta(Klient k)
    {
      klienci.add(k);
    }
    void usunKlienta(Klient k)
    {
        klienci.remove(k);
    }
    void dodajLot(Lot l)
    {
       loty.add(l);
    }
    void usunLot(Lot l)
    {
        loty.remove(l);
    }

}
