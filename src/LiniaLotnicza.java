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
    public void dodajSamolot(Samolot samolot)
    {
        flota.dodajSamolot(samolot);
    }
    public void usunSamolot(int indeks)
    {
        flota.usunSamolot(indeks);
    }
    public void dodajTrase(Trasa t)
    {
        trasy.add(t);
    }
    public void usunTrase(int indeks)
    {
        trasy.remove(indeks);
    }
    public void dodajLotnisko(Lotnisko l)
    {
      lotniska.add(l);
    }
    public void usunLotnisko(int indeks)
    {
        lotniska.remove(indeks);
    }
    public void dodajKlienta(Klient k)
    {
      klienci.add(k);
    }
   public void usunKlienta(Klient k)
    {
        klienci.remove(k);
    }
    public void dodajLot(Lot l)
    {
       loty.add(l);
    }
    public void usunLot(Lot l)
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
    public Lotnisko getLotnisko(int indeks){

        return lotniska.get(indeks);
    }

    public ArrayList<Trasa> getTrasy()
    {
        return trasy;
    }
    public ArrayList<Samolot> getSamoloty()
    {
        return flota.getSamoloty();
    }
    public int ileLotnisk()
    {
        return lotniska.size();
    }
    public int ileSamolotow()
    {
        return flota.ileSamolotow();
    }
    public int ileTras()
    {
        return trasy.size();
    }
}
