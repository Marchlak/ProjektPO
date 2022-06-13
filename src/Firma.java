public class Firma extends Klient {

    private int KRS;
    private String nazwa;
    private String narodowosc;

    public Firma(String nazwa, String narodowosc, int KRS) {
        this.nazwa = nazwa;
        this.KRS = KRS;
        this.narodowosc = narodowosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getKRS() {
        return KRS;
    }

    public String getNarodowosc() {
        return narodowosc;
    }
}
