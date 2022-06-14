import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
     String path="input.txt";
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
    public void usunSamolot(int indeks) {
        for(int k=0;k<loty.size();k++){
            if(loty.get(k).nrsamolotu==indeks){
                loty.remove(loty.get(k));
            }
        }
        if(samoloty.size()>indeks+1){
            for(int i=indeks+1;i<samoloty.size();i++){
                for(int j=0;j<samoloty.get(i).getLoty().size();j++){
                    samoloty.get(i).getLoty().get(j).nrsamolotu--;
                }
            }
        }
        if(samoloty.size()==0){
            loty.clear();
        }
        if(samoloty.size()>0) {
            samoloty.remove(samoloty.get(indeks));
        }
    }
    public void dodajTrase(Trasa t)
    {
        trasy.add(t);
    }
    public void usunTrase(int indeks) {
        boolean czywystepuje = false;
        String miastoA = trasy.get(indeks).getA().getMiasto();
        String miastoB = trasy.get(indeks).getB().getMiasto();
        for (int i = 0; i < loty.size(); i++) {
            if (loty.get(i).trasa.getA().getMiasto().equals(miastoA) && loty.get(i).trasa.getB().getMiasto().equals(miastoB)) {
                czywystepuje = true;
            }
        }
        if (czywystepuje) {
            System.out.println("Nie mozna usunac trasy");
        } else {
            trasy.remove(trasy.get(indeks));
        }
    }
    public void dodajLotnisko(Lotnisko l)
    {
      lotniska.add(l);
    }
    public void usunLotnisko(int indeks) {
        String miasto=lotniska.get(indeks).getMiasto();
        boolean czywystepuje=false;
        for(int i=0;i<loty.size();i++){
            if(loty.get(i).trasa.getA().getMiasto().equals(miasto)||loty.get(i).trasa.getB().getMiasto().equals(miasto)){
                czywystepuje=true;
            }
        }
        if(czywystepuje){
            System.out.println("Nie mozna usunac tego lotniska, gdyz jest ono czescia jednej z tras");
        }
        else{
            lotniska.remove(lotniska.get(indeks));
        }
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
    public void zarezerwujBilet(int ile,Lot lot, Klient klient){
        if(lot.czysawolnebilety(ile)){
            for(int i=0;i<ile;i++) {
                klient.dodajBilet(lot.getWolnebilety().get(0));
                lot.zarezerwujBilet(lot.getWolnebilety().get(0));
            }
        }
        else{
            System.out.println("Brak wolnych miejsc");
        }
    }
///getttery
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

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    public ArrayList <Lotnisko>  wczytajLotniska() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));


        String[] linia = scanner.nextLine().split(";");

        if(linia.length>1) {
            for (int i = 0; i < linia.length; i++) {
                String[] parametry = linia[i].split(" ");
                double x = Double.parseDouble(parametry[0]);
                double y = Double.parseDouble(parametry[1]);
                String miasto = parametry[2];
                Lotnisko l = new Lotnisko(x, y, miasto);
                lotniska.add(l);

            }
        }
        return lotniska;
    }
    public ArrayList <Trasa> wczytajTrasy() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        scanner.nextLine();

        String[] linia = scanner.nextLine().split(";");
        if(linia.length>1) {
            for (int i = 0; i < linia.length; i++) {
                String[] parametry = linia[i].split(" ");
                int x = Integer.parseInt(parametry[0]);
                int y = Integer.parseInt(parametry[1]);
                Trasa trasa = new Trasa(lotniska.get(x), lotniska.get(y));
                trasy.add(trasa);
            }
        }
        return trasy;
    }
    public ArrayList<Lot> wczytajLoty() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));


        for(int i = 0;i<2;i++){
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        if(linia.length>1) {
            for (int i = 0; i < linia.length; i++) {
                String[] parametry = linia[i].split(" ");
                int rok = Integer.parseInt(parametry[0]);
                int miesac = Integer.parseInt(parametry[1]);
                int dzien = Integer.parseInt(parametry[2]);
                int godzina = Integer.parseInt(parametry[3]);
                int minuta = Integer.parseInt(parametry[4]);
                int wtrasa = Integer.parseInt(parametry[5]);
                int miejsca = Integer.parseInt(parametry[6]);
                int nrsamolotu = Integer.parseInt(parametry[7]);

                LocalDateTime czas = LocalDateTime.of(LocalDate.of(rok, miesac, dzien), LocalTime.of(godzina, minuta));
                Lot lot = new Lot(czas, trasy.get(wtrasa), miejsca, nrsamolotu);
                loty.add(lot);
            }
        }
        return loty;
    }
    public ArrayList <Samolot>  wczytajSamoloty() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));


        for (int i = 0; i < 3; i++) {
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        if(linia.length>1) {
            for (int i = 0; i < linia.length; i++) {
                String[] parametry = linia[i].split(" ");
                double zasieg = Double.parseDouble(parametry[0]);
                int liczbamiejsc = Integer.parseInt(parametry[1]);
                String model = parametry[2];
                Samolot samolot = new Samolot(zasieg, liczbamiejsc, model);
                samoloty.add(samolot);
            }


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
        Scanner scanner = new Scanner(new File(path));
        for (int i = 0; i < 4; i++) {
            scanner.nextLine();
        }
        String[] linia = scanner.nextLine().split(";");
        if(linia.length>1) {
            for (int i = 0; i < linia.length; i++) {
                String[] parametry = linia[i].split(" ");
                String nazwa = parametry[0];
                String narodowosc = parametry[1];
                int KRS = Integer.parseInt(parametry[2]);
                Firma firma = new Firma(nazwa, narodowosc, KRS);
                String tmp="";
                if(parametry.length>3){
                    tmp=parametry[3];
                }

                String[] ids = tmp.split("/");
                if(ids.length>1) {
                    for (int j = 0; j < ids.length; j++) {
                        for (int k = 0; k < loty.size(); k++) {
                            if (loty.get(k).id.equals(ids[j])) {
                                Bilet bilet = new Bilet(loty.get(k).trasa.getA().getMiasto(),
                                        loty.get(k).trasa.getB().getMiasto(), loty.get(k).poczatek, loty.get(k).id);
                                firma.dodajBilet(bilet);

                            }
                        }
                    }
                }
                klienci.add(firma);
            }
        }
        return klienci;
    }
    public void wczytajIndywidualnych() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
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
            String tmp="";
            if(parametry.length>4){
                tmp=parametry[4];
            }



            String[] ids = tmp.split("/");
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
    public void zapisz() throws IOException {
        PrintWriter writer = new PrintWriter(new File(path));
        String llotniska = "";
        String ltrasy="";
        String lloty="";
        String lsamoloty="";
        String lfirmy="";
        String lindywidualny="";
        for(int i=0;i<lotniska.size();i++){
            llotniska = llotniska+lotniska.get(i).getX()+" "+lotniska.get(i).getY()+" "+lotniska.get(i).getMiasto()+";";
        }
        for(int i=0;i<trasy.size();i++){
            for(int j=0;j<lotniska.size();j++){
                if(trasy.get(i).getA().getMiasto().equals(lotniska.get(j).getMiasto())){
                    ltrasy = ltrasy+j+" ";
                    for(int k=0;k<lotniska.size();k++){
                        if(trasy.get(i).getB().getMiasto().equals(lotniska.get(k).getMiasto())){
                            ltrasy = ltrasy+k+";";
                        }
                    }
                }

            }
        }
        for(int i=0;i<loty.size();i++){
            for(int j=0;j<trasy.size();j++){
                if(loty.get(i).trasa.equals(trasy.get(j))){
                    lloty=lloty+loty.get(i).poczatek.getYear()+" "+loty.get(i).poczatek.getMonthValue()+" "+
                            loty.get(i).poczatek.getDayOfMonth()+" "+loty.get(i).poczatek.getHour()+" "+loty.get(i).poczatek.getMinute()+
                            " "+j+" "+loty.get(i).wolnebilety.size()+" "+loty.get(i).nrsamolotu+";";
                }
            }


        }
        for(int i=0;i<samoloty.size();i++){
            lsamoloty=lsamoloty+samoloty.get(i).zasieg+" "+samoloty.get(i).getLiczbamiejsc()+" "
                    +samoloty.get(i).getModel()+";";
        }
        for(int i=0;i<klienci.size();i++){
            if(klienci.get(i) instanceof Firma){

                lfirmy=lfirmy+((Firma) klienci.get(i)).getNazwa()+" "+((Firma) klienci.get(i)).getNarodowosc()+
                        " "+((Firma) klienci.get(i)).getKRS()+" ";
                for(int j=0;j<klienci.get(i).getBilety().size();j++){
                    lfirmy=lfirmy+klienci.get(i).getBilety().get(j).idLotu;
                    if(j!=(klienci.get(i).getBilety().size()-1)){
                        lfirmy=lfirmy+"/";
                    }
                }
                lfirmy = lfirmy+";";
            }

        }
        for(int i=0;i<klienci.size();i++){
            if(klienci.get(i) instanceof Indywidualny){

                lindywidualny=lindywidualny+((Indywidualny) klienci.get(i)).getImie()+" "+
                        ((Indywidualny) klienci.get(i)).getNazwisko()+" "+((Indywidualny) klienci.get(i)).getNarodowosc()+" "+
                        ((Indywidualny) klienci.get(i)).getWiek()+" ";
                for(int j=0;j<klienci.get(i).getBilety().size();j++){
                    lindywidualny=lindywidualny+klienci.get(i).getBilety().get(j).idLotu;
                    if(j!=(klienci.get(i).getBilety().size()-1)){
                        lindywidualny=lindywidualny+"/";
                    }
                }
                lindywidualny = lindywidualny+";";
            }

        }



        writer.println(llotniska);
        writer.println(ltrasy);
        writer.println(lloty);
        writer.println(lsamoloty);
        writer.println(lfirmy);
        writer.println(lindywidualny);
        writer.close();

    }
    public void GenerowanieLotow(int ilelotow, int coiledni, LocalDateTime poczatek, Trasa trasa, int indeksSamolotu)//funkcja generowania lotów
    {
        ArrayList<Lot> listalotow =new ArrayList<>();

           for (int i = 0; i <ilelotow ; i++)
           {
               Lot lot = new Lot(poczatek.plusDays(i*coiledni),trasa,samoloty.get(indeksSamolotu).getLiczbamiejsc(),indeksSamolotu);
               listalotow.add(lot);
           }
           loty.removeAll(samoloty.get(indeksSamolotu).getLoty());
           samoloty.get(indeksSamolotu).scalanie(listalotow);
           loty.addAll(samoloty.get(indeksSamolotu).getLoty());
    }


    public ArrayList<Lot> getLoty() {
        return loty;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public ArrayList<Integer> WyswietlLoty(LocalDateTime Od,LocalDateTime Do,int indekstrasy)
    {
        ArrayList<Integer> indeksylotow= new ArrayList<Integer>();
        int i=0;
        for (Lot L: loty)
        {
            if(L.getPoczatek().isAfter(Od) && L.getPoczatek().isBefore(Do) && L.getTrasa().equals(trasy.get(indekstrasy)))
            {
             indeksylotow.add(i);
            }
            i++;
        }
        return indeksylotow;
    }
    public int czyjesttakatrasa(String miasto1,String miasto2)
    {
        int wynik=-1;
        int i=0;
        for (Trasa T: trasy)
        {
            if(T.getA().getMiasto().equals(miasto1) && T.getB().getMiasto().equals(miasto2))
            {
                wynik=i;
            }
            i++;
        }
        return wynik;
    }
    public Lot getLot(int indeks)
    {
        return loty.get(indeks);
    }
    public int ilelotow(int indeks)
    {
       return samoloty.get(indeks).getLoty().size();
    }
    public void usunLotsamolotu(int indekssam,int indekslot)
    {
        Lot lot = samoloty.get(indekssam).getLot(indekslot);
        samoloty.get(indekssam).usunLot(indekslot);
        loty.remove(lot);
    }
}
