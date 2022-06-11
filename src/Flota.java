import java.util.ArrayList;

public class Flota {
    ArrayList <Samolot> samoloty;

    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    public void dodajSamolot(Samolot s){
        samoloty.add(s);
    }
    public void usunSamolot(Samolot s){
        samoloty.remove(s);
    }
}
