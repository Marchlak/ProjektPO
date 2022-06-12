import java.util.ArrayList;

public class LiniaLotnicza {
    private ArrayList<Lot> loty;
    private ArrayList<Lotnisko> lotniska;
    private ArrayList<Klient> klienci;
    private ArrayList<Trasa> trasy;
    private Flota flota;
    public LiniaLotnicza(){
        loty = new ArrayList<>();
        lotniska = new ArrayList<>();
        klienci = new ArrayList<>();
        trasy = new ArrayList<>();
        flota = new Flota();
    }
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
    void usunLotnisko(int indeks)
    {
        lotniska.remove(indeks);
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
    public void zarezerwujBilet(Lot lot, Klient klient){
        if(lot.czysawolnebilety()){
            klient.dodajBilet(lot.getWolnebilety().get(0));
            lot.zarezerwujBilet(lot.getWolnebilety().get(0));
        }
        else{
            System.out.println("Brak wolnych miejsc");
        }
    }

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }
}
