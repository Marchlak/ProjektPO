import java.time.LocalDate;

public class Bilet {
    String skad, dokad;
    LocalDate data;

    public Bilet(String skad, String dokad, LocalDate data){
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

    public LocalDate getData() {
        return data;
    }
}
