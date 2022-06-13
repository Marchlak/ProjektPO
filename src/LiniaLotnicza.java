import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LiniaLotnicza {
    private ArrayList<Lot> loty;
    private ArrayList<Lotnisko> lotniska;
    private ArrayList<Klient> klienci;
    private ArrayList<Trasa> trasy;
     ArrayList<Samolot> samoloty;
    private Flota flota;
    public LiniaLotnicza(){
        loty = new ArrayList<>();
        lotniska = new ArrayList<>();
        klienci = new ArrayList<>();
        trasy = new ArrayList<>();
        flota = new Flota();
        samoloty = new ArrayList<>();
    }
    public void dodajSamolot(Samolot samolot)
    {
        flota.dodajSamolot(samolot);
    }
    public void usunSamolot(int indeks)
    {
        flota.usunSamolot(indeks);
    }
    public void dodajTrase(Trasa t)
    {
        trasy.add(t);
    }
    public void usunTrase(int indeks)
    {
        trasy.remove(indeks);
    }
    public void dodajLotnisko(Lotnisko l)
    {
      lotniska.add(l);
    }
    public void usunLotnisko(int indeks)
    {
        lotniska.remove(indeks);
    }
    public void dodajKlienta(Klient k)
    {
      klienci.add(k);
    }
   public void usunKlienta(Klient k)
    {
        klienci.remove(k);
    }
    public void dodajLot(Lot l)
    {
       loty.add(l);
    }
    public void usunLot(Lot l)
    {
        loty.remove(l);
    }
    public void zarezerwujBilet(Lot lot, Klient klient){
        if(lot.czysawolnebilety()){
            klient.dodajBilet(lot.getWolnebilety().get(0));
            lot.zarezerwujBilet(lot.getWolnebilety().get(0));
        }
        else{
            System.out.println("Brak wolnych miejsc");
        }
    }

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }
    public Lotnisko getLotnisko(int indeks){

        return lotniska.get(indeks);
    }

    public ArrayList<Trasa> getTrasy()
    {
        return trasy;
    }
    public ArrayList<Samolot> getSamoloty()
    {
        return flota.getSamoloty();
    }
    public int ileLotnisk()
    {
        return lotniska.size();
    }
    public int ileSamolotow()
    {
        return flota.ileSamolotow();
    }
    public int ileTras()
    {
        return trasy.size();
    }
    public ArrayList <Lotnisko>  wczytajLotniska() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));


        String[] linia = scanner.nextLine().split(";");


        for(int i = 0; i< linia.length;i++) {
            String[] parametry = linia[i].split(" ");
            double x = Double.parseDouble(parametry[0]);
            double y = Double.parseDouble(parametry[1]);
            String miasto = parametry[2];
            Lotnisko l = new Lotnisko(x, y, miasto);
            lotniska.add(l);

        }
        return lotniska;
    }
    public ArrayList <Trasa> wczytajTrasy() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        scanner.nextLine();

        String[] linia = scanner.nextLine().split(";");
        for(int i=0;i< linia.length;i++) {
            String[] parametry = linia[i].split(" ");
            int x = Integer.parseInt(parametry[0]);
            int y = Integer.parseInt(parametry[1]);
            Trasa trasa = new Trasa(lotniska.get(x), lotniska.get(y));
            trasy.add(trasa);
        }
        return trasy;
    }
    public ArrayList<Lot> wczytajLoty() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));


        for(int i = 0;i<2;i++){
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");

        for(int i=0;i< linia.length;i++) {
            String[] parametry = linia[i].split(" ");
            int rok = Integer.parseInt(parametry[0]);
            int miesac = Integer.parseInt(parametry[1]);
            int dzien = Integer.parseInt(parametry[2]);
            int godzina = Integer.parseInt(parametry[3]);
            int minuta = Integer.parseInt(parametry[4]);
            int wtrasa = Integer.parseInt(parametry[5]);
            int miejsca = Integer.parseInt(parametry[6]);
            int nrsamolotu = Integer.parseInt(parametry[7]);

            LocalDateTime czas = LocalDateTime.of(LocalDate.of(rok,miesac,dzien), LocalTime.of(godzina,minuta));
            Lot lot = new Lot(czas,trasy.get(wtrasa),miejsca,nrsamolotu);
            loty.add(lot);
        }
        return loty;
    }
    public ArrayList <Samolot>  wczytajSamoloty() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));


        for (int i = 0; i < 3; i++) {
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        for (int i = 0; i < linia.length; i++) {
            String[] parametry = linia[i].split(" ");
            double zasieg = Double.parseDouble(parametry[0]);
            int liczbamiejsc = Integer.parseInt(parametry[1]);
            String model = parametry[2];
            Samolot samolot = new Samolot(zasieg,liczbamiejsc,model);
            samoloty.add(samolot);
        }





        return samoloty;
    }
    public ArrayList<Samolot> dodajLotyDoSamolotow(){
        for(int i=0;i< loty.size();i++){
            samoloty.get(loty.get(i).nrsamolotu).dodajLot2(loty.get(i));
        }
        return samoloty;
    }
    public ArrayList<Klient> wczytajFirmy() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        for (int i = 0; i < 4; i++) {
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        for (int i = 0; i < linia.length; i++) {
            String[] parametry = linia[i].split(" ");
            String nazwa = parametry[0];
            String narodowosc = parametry[1];
            int KRS = Integer.parseInt(parametry[2]);
            Firma firma = new Firma(nazwa,narodowosc,KRS);

            String[] ids = parametry[3].split("/");
            for(int j=0;j<ids.length;j++){
                for(int k=0;k<loty.size();k++){
                    if(loty.get(k).id.equals(ids[j])){
                        Bilet bilet = new Bilet(loty.get(k).trasa.getA().getMiasto(),
                                loty.get(k).trasa.getB().getMiasto(),loty.get(k).poczatek,loty.get(k).id);
                        firma.dodajBilet(bilet);

                    }
                }
            }

            klienci.add(firma);
        }
        return klienci;
    }
    public void wczytajIndywidualnych() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        for (int i = 0; i < 5; i++) {
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        for (int i = 0; i < linia.length; i++) {
            String[] parametry = linia[i].split(" ");
            String imie = parametry[0];
            String nazwisko = parametry[1];
            String narodowosc = parametry[2];
            int wiek = Integer.parseInt(parametry[3]);
            Indywidualny indywidualny=new Indywidualny(imie,nazwisko,narodowosc,wiek);


            String[] ids = parametry[4].split("/");
            for(int j=0;j<ids.length;j++) {
                for (int k = 0; k < loty.size(); k++) {
                    if (loty.get(k).id.equals(ids[j])) {
                        Bilet bilet = new Bilet(loty.get(k).trasa.getA().getMiasto(),
                                loty.get(k).trasa.getB().getMiasto(), loty.get(k).poczatek, loty.get(k).id);
                        indywidualny.dodajBilet(bilet);

                    }
                }


            }
            klienci.add(indywidualny);
        }
    }
    public void wczytaj() throws FileNotFoundException {
        wczytajLotniska();
        wczytajTrasy();
        wczytajLoty();
        wczytajSamoloty();
        dodajLotyDoSamolotow();
        wczytajFirmy();
        wczytajIndywidualnych();
    }
}
