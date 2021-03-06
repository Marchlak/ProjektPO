
import java.time.LocalDateTime;
import java.util.ArrayList;




public class Lot {
    LocalDateTime poczatek, koniec;
    int liczbamiejsc;
    int nrsamolotu;
    String id;
    Trasa trasa;
    ArrayList<Bilet> wolnebilety;

    public Lot(LocalDateTime poczatek, Trasa trasa, int liczbamiejsc, int nrsamolotu){
        this.poczatek = poczatek;
        koniec = poczatek.plusHours(6);
        this.liczbamiejsc = liczbamiejsc;
        this.trasa = trasa;
        this.nrsamolotu = nrsamolotu;
        wolnebilety = new ArrayList<>();
        id = generujid();
        generujBilety();
    }

    public boolean czysawolnebilety(int ile){
        boolean wynik = false;
        if(wolnebilety.size()>=ile){
            wynik = true;
        }
        return wynik;
    }
    private void generujBilety(){
        for(int i=0;i<liczbamiejsc;i++){
            Bilet b = new Bilet(trasa.getA().getMiasto(),trasa.getB().getMiasto(),poczatek,id);
            wolnebilety.add(b);
        }
    }
    public void zarezerwujBilet(Bilet bilet){ //dokonczyc
        wolnebilety.remove(bilet);
        liczbamiejsc--;
    }
    public String generujid(){
      String s =nrsamolotu+poczatek.toString();
      return s;
    }

    public LocalDateTime getPoczatek() {
        return poczatek;
    }

    public LocalDateTime getKoniec() {
        return koniec;
    }

    public int getLiczbamiejsc() {
        return liczbamiejsc;
    }

    public Trasa getTrasa() {
        return trasa;
    }
    public ArrayList<Bilet> getWolnebilety() {
        return wolnebilety;
    }

    @Override
    public String toString() {
        return "Odlot o godzinie - " + poczatek +
                " przylot o godzinie - " + koniec +
                ", Z " + trasa;
    }
}