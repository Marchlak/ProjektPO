import java.time.LocalDateTime;

public class Bilet {
    String skad, dokad;
    LocalDateTime data;
    String idLotu;

    public Bilet(String skad, String dokad, LocalDateTime data, String idLotu){
        this.skad = skad;
        this.dokad = dokad;
        this.data = data;
        this.idLotu=idLotu;
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