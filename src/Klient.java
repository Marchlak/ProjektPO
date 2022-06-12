import java.util.ArrayList;

public abstract class Klient {
    ArrayList <Bilet> bilety;
    public Klient(){
        bilety = new ArrayList<>();
    }
    public void dodajBilet(Bilet bilet){
        bilety.add(bilet);
    }
    public ArrayList<Bilet> getBilety() {
        return bilety;
    }
}
