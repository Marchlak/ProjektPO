public class Data {
   private int rok, miesiac, dzien, czas;

    public Data(int rok, int miesiac, int dzien, int czas){
        this.rok = rok;
        this.miesiac = miesiac;
        this.dzien = dzien;
        this.czas = czas;
    }

    public boolean czyDatajestwczesniejsza(Data data){  //poprawic ify
        boolean wynik = false;
        if(data.rok<=rok){
            if(data.miesiac<=miesiac){
                if(data.dzien<=dzien){
                    if(data.czas<czas){
                        wynik = true;
                    }
                }
            }
        }
        return wynik;
    }

    public int getRok() {
        return rok;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public int getDzien() {
        return dzien;
    }

    public int getCzas() {
        return czas;
    }
}

