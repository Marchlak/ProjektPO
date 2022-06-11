public class Indywidualny extends Klient  {

    private String imie,nazwisko;
    private int wiek;
    private String narodowosc;

    public Indywidualny(String imie, String nazwisko, String narodowosc, int wiek){

        this.narodowosc = narodowosc;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public int getWiek() {
        return wiek;
    }
}
