import java.util.ArrayList;

public class Flota {
    ArrayList <Samolot> samoloty;

    public Flota(){
        samoloty = new ArrayList<>();
    }
    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    public void dodajSamolot(Samolot s){
        samoloty.add(s);
    }
    public void usunSamolot(int indeks){
        samoloty.remove(indeks);
    }
}
