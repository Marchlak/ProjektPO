import java.time.LocalDateTime;

public class Bilet {
    String skad, dokad;
    LocalDateTime data;

    public Bilet(String skad, String dokad, LocalDateTime data){
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

    public LocalDateTime getData() {
        return data;
    }
}