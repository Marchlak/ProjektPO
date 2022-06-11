import java.util.ArrayList;

public class Lot {
    Data poczatek, koniec;
    int liczbamiejsc;
    Trasa trasa;
    ArrayList <Bilet> wolnebilety;

    public Lot(Data poczatek, Data koniec, Trasa trasa, int liczbamiejsc){
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.liczbamiejsc = liczbamiejsc;
        this.trasa = trasa;
    }

    public boolean czysawolnebilety(){
        boolean wynik = false;
        if(wolnebilety.size()>0){
            wynik = true;
        }
        return wynik;
    }
    public void zarezerwujBilet(Bilet bilet){ //dokonczyc
      wolnebilety.remove(bilet);
    }

    public Data getPoczatek() {
        return poczatek;
    }

    public Data getKoniec() {
        return koniec;
    }

    public int getLiczbamiejsc() {
        return liczbamiejsc;
    }

    public Trasa getTrasa() {
        return trasa;
    }
}
