
import java.time.LocalDateTime;
import java.util.ArrayList;




public class Lot {
    LocalDateTime poczatek, koniec;
    int liczbamiejsc;
    Trasa trasa;
    ArrayList<Bilet> wolnebilety;

    public Lot(LocalDateTime poczatek, LocalDateTime koniec, Trasa trasa, int liczbamiejsc){
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.liczbamiejsc = liczbamiejsc;
        this.trasa = trasa;
        wolnebilety = new ArrayList<>();
        generujBilety();
    }

    public boolean czysawolnebilety(){
        boolean wynik = false;
        if(wolnebilety.size()>0){
            wynik = true;
        }
        return wynik;
    }
    private void generujBilety(){
        for(int i=0;i<liczbamiejsc;i++){
            Bilet b = new Bilet(trasa.getA().getMiasto(),trasa.getB().getMiasto(),poczatek);
            wolnebilety.add(b);
        }
    }
    public void zarezerwujBilet(Bilet bilet){ //dokonczyc
        wolnebilety.remove(bilet);
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
}