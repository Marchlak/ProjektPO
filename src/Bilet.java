public class Bilet {
    String skad, dokad;
    Data data;

    public Bilet(String skad, String dokad, Data data){
        this.skad = skad;
        this.dokad = dokad;
        this.data = data;
    }

    public String getDokad() {
        return dokad;
    }

    public String getSkad() {
        return skad;
    }

    public Data getData() {
        return data;
    }
}
