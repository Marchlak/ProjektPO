import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class LiniaLotnicza {
    private ArrayList<Lot> loty;
    private ArrayList<Lotnisko> lotniska;
    private ArrayList<Klient> klienci;
    private ArrayList<Trasa> trasy;
     ArrayList<Samolot> samoloty;
    public LiniaLotnicza(){
        loty = new ArrayList<>();
        lotniska = new ArrayList<>();
        klienci = new ArrayList<>();
        trasy = new ArrayList<>();
        samoloty = new ArrayList<>();
    }
    public void dodajSamolot(Samolot samolot)
    {
        samoloty.add(samolot);
    }
    public void usunSamolot(int indeks)
    {
        samoloty.remove(indeks);
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
    public Trasa getTrasa(int indeks)
    {
        return trasy.get(indeks);
    }
    public Samolot getSamolot(int indeks)
    {
        return samoloty.get(indeks);
    }

    public ArrayList<Trasa> getTrasy()
    {
        return trasy;
    }
    public ArrayList<Samolot> getSamoloty()
    {
        return samoloty;
    }
    public int ileLotnisk()
    {
        return lotniska.size();
    }
    public int ileSamolotow()
    {
        return samoloty.size();
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
    public void wczytaj() throws FileNotFoundException {
        wczytajLotniska();
        wczytajTrasy();
        wczytajLoty();
        wczytajSamoloty();
        dodajLotyDoSamolotow();
    }
    public ArrayList<Integer> GenerowanieLotow(int ilelotow, int coiledni, LocalDateTime poczatek, Trasa trasa, Samolot samolot)
    {
        ArrayList<int> Lista_lotow_ktore_mozna_utworzyc;
        LocalDateTime koniec = poczatek.plusHours(6);
       if(samolot.czyZasiegjestWystarczajcy(trasa))
       {
           for (int i = 0; i <ilelotow ; i++)
           {
               Lista_lotow_ktore_mozna_utworzyc.add(samolot.czySamolotmaczas(poczatek.plusDays(i*coiledni),koniec.plusDays(i*coiledni)));
           }
       }
       return Lista_lotow_ktore_mozna_utworzyc;

    }

}
