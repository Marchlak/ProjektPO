import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        LiniaLotnicza linia =new LiniaLotnicza();
        int petla;
        do {
            System.out.println("Witaj w Systemie kontroli lotow");
            System.out.println("1. Zarezeruwj Bilet");
            System.out.println("2. Interfejs Admina");
            System.out.println("0. Wyjdz");
            System.out.println("");
            petla = sc.nextInt();
            if (petla == 1)
            {
                do {
                    System.out.println("Witaj w panelu użytkownika");
                    System.out.println("1. Podaj skad dokad chcesz leciec");
                    String miasto1=sc2.nextLine();
                    String miasto2=sc2.nextLine();
                    if(-1==linia.czyjesttakatrasa(miasto1,miasto2))
                    {
                        System.out.println("Nie ma takiej trasy");
                        break;
                    }
                    else
                    {
                        System.out.println(" Podaj kiedy szukasz lotu");
                        int rok = sc.nextInt();
                        int mies = sc.nextInt();
                        int dzien = sc.nextInt();
                        int godzina = sc.nextInt();
                        int minuta = sc.nextInt();
                        LocalDateTime poczateklotu = LocalDateTime.of(rok,mies,dzien,godzina,minuta);
                        ArrayList<Integer> dostepneloty=linia.WyswietlLoty(poczateklotu,poczateklotu.plusWeeks(1),linia.czyjesttakatrasa(miasto1,miasto2));
                        if(dostepneloty.isEmpty())
                        {
                            System.out.println("Przepraszamy w tym czasie nie ma zadnych lotow");
                            break;
                        }
                        for (int i: dostepneloty)
                        {
                            System.out.println(linia.getLot(linia.czyjesttakatrasa(miasto1,miasto2)).toString());
                        }
                        System.out.println("Wybierz indeks lotu");
                        int indekslotu= sc.nextInt();
                        System.out.println("Podaj imie:");
                        String imie=sc2.nextLine();
                        System.out.println("Podaj nazwisko:");
                        String nazwisko=sc2.nextLine();
                        int nrklienta= czyjesttakiklient(linia,nazwisko,imie);
                        if(nrklienta==-1){
                            System.out.println("Nie ma takiego klienta");
                        }
                        else{
                            System.out.println("Ile biletow:");
                            int ile =sc.nextInt();
                            linia.zarezerwujBilet(ile,linia.getLot(indekslotu),linia.getKlienci().get(nrklienta));
                        }

                     /*   System.out.println("Podaj KRS:");
                        int KRS=sc2.nextInt();
                        int nrfirmy= czyjesttakafirma(linia,KRS);
                        if(nrfirmy==-1){
                            System.out.println("Nie ma takiego klienta");
                        }
                        else{
                            System.out.println("Ile biletow:");
                            int ile =sc.nextInt();
                            linia.zarezerwujBilet(ile,linia.getLot(indekslotu),linia.getKlienci().get(nrfirmy));
                        }*/



                    }


                }while(petla!=0);



            }
            else if(petla==2)
            {

                do
                {
                    System.out.println("Witaj w panelu admina");
                    System.out.println("1. Wcztaj z pliku");
                    System.out.println("2. Zapisz do pliku");
                    System.out.println("3. Dodaj Lotnisko");
                    System.out.println("4. Wypisz Lotniska");
                    System.out.println("5. Usun Lotnisko");
                    System.out.println("6. Dodaj Trase");
                    System.out.println("7. Wypisz Trasy");
                    System.out.println("8. Usun Trasy");
                    System.out.println("9. Dodaj Samolot");
                    System.out.println("10. Wypisz Samoloty");
                    System.out.println("11. Usun Samolot");
                    System.out.println("12.Generuj Loty dla Samolotu");
                    System.out.println("13.Wypisz Loty Samolotu");
                    System.out.println("14 Wypisz wszystkie loty");
                    System.out.println("15 Usun lot konkretnego samolotu");
                    System.out.println("16 Wypisz klientow");
                    System.out.println("0. Wyjdz do menu glownego");


                    petla = sc.nextInt();

                    switch(petla) {
                        case 1 -> {

                            linia.wczytaj();
                            System.out.println("Wczytano");
                        }
                        case 2 ->
                        {
                            linia.zapisz();
                            System.out.println("Zapisano");
                        }
                        case 3 ->
                        {
                            System.out.println("Wpisz miasto z w ktorym znajduje sie lotnisko");
                            String nazwa=sc2.nextLine();
                            System.out.println("Wpisz Koordynaty na ktorych znajduje sie lotnisko");
                            double x=sc.nextDouble();
                            double y=sc.nextDouble();
                            if(Math.abs(x)>180 || Math.abs(y)>90) {
                             System.out.println("Zle koordynaty");
                            }
                            else
                            {
                                Lotnisko lotnisko = new Lotnisko(x, y, nazwa);
                                linia.dodajLotnisko(lotnisko);
                            }
                        }
                        case 4 ->
                        {
                            System.out.println("Dostepne lotniska");
                            ArrayList<Lotnisko> lotniska = linia.getLotniska();
                            for (Lotnisko L: lotniska)
                            {
                                System.out.println(L.toString());
                            }
                        }
                        case 5 ->
                        {
                            System.out.println("Podaj indeks lotniska ktorego chcesz usunac");
                            int indeks=sc.nextInt()-1;
                            if(indeks<0 || indeks+1>linia.ileLotnisk())
                            {
                             System.out.println("Nie ma takiego lotniska");
                            }
                            else {
                                linia.usunLotnisko(indeks);
                            }

                        }
                        case 6 ->
                        {
                            System.out.println("Podaj indeksy lotnisk ktore z ktorych chcesz zrobic trase");
                            int indeksA=sc.nextInt()-1;
                            int indeksB=sc.nextInt()-1;
                            if(indeksA<0 || indeksA+1>linia.ileLotnisk() || indeksB<0 || indeksB+1>linia.ileLotnisk())
                            {
                                System.out.println("Bledne indeksy");
                            }
                                else
                                {
                            Trasa trasa = new Trasa(linia.getLotnisko(indeksA), linia.getLotnisko(indeksB));
                            linia.dodajTrase(trasa);
                                }

                        }
                        case 7 ->
                        {
                            System.out.println("Dostepne trasy");
                            ArrayList<Trasa> trasy = linia.getTrasy();
                            for (Trasa T: trasy)
                            {
                                System.out.println(T.toString());
                            }
                        }
                        case 8 ->
                        {
                            System.out.println("Podaj indeks trasy ktora chcesz usunac");
                            int indeks=sc.nextInt()-1;
                            if(indeks<0 || indeks+1>linia.ileTras())
                            {
                                System.out.println("Nie ma takiej trasy");
                            }
                            else
                            {
                                linia.usunTrase(indeks);
                            }
                        }
                        case 9 ->
                                {
                            System.out.println("Podaj nazwe modelu Samolotu");
                            String model=sc2.nextLine();
                            System.out.println("Podaj liczbe miejsc Samolotu");
                            int miejsca=sc.nextInt();
                            System.out.println("Podaj zasieg Samolotu");
                            double zasieg=sc.nextDouble();
                            Samolot samolot= new Samolot(zasieg,miejsca,model);
                            linia.dodajSamolot(samolot);
                        }
                        case 10 ->
                        {
                            System.out.println("Dostepne Samoloty");
                            ArrayList<Samolot> samoloty = linia.getSamoloty();
                            for (Samolot S: samoloty)
                            {
                                System.out.println(S.toStringSamolot());
                            }


                        }
                        case 11 ->
                        {
                            System.out.println("Podaj indeks samolotu ktory chcesz usunac");
                            int indeks=sc.nextInt()-1;
                            if(indeks<0 || indeks+1>linia.ileSamolotow())
                            {
                                System.out.println("Nie ma takiego samolotu");
                            }
                            else
                            {
                                linia.usunSamolot(indeks);
                            }
                        }
                        case 12 ->
                        {
                            System.out.println("Podaj indeks samolotu do ktorego chcesz wygenerowac lot");
                            int isam= sc.nextInt()-1;
                            if(isam<0 || isam+1>linia.ileSamolotow())
                            {
                                System.out.println("Nie ma takiego samolotu");
                                break;
                            }
                            System.out.println("Podaj indeks trasy do ktorej ma zostac wygenerowany lot");
                            int itras = sc.nextInt()-1;
                            if(itras<0 || itras+1>linia.ileTras())
                            {
                                System.out.println("Nie ma takiej trasy");
                                break;
                            }
                            if(!linia.getSamolot(isam).czyZasiegjestWystarczajcy(linia.getTrasa(itras)))
                            {
                                System.out.println("Zasieg jest niewystarczajcy" + linia.getTrasa(itras).getOdleglosc());
                                break;
                            }
                            System.out.println("Podaj czas w ktorym ma sie odbyc pierwszy lot");
                            int rok = sc.nextInt();
                            int mies = sc.nextInt();
                            int dzien = sc.nextInt();
                            int godzina = sc.nextInt();
                            int minuta = sc.nextInt();

                            LocalDateTime odlot = LocalDateTime.of(rok,mies,dzien,godzina,minuta);

                            System.out.println("Podaj co ile dni ma odbywac sie lot");
                            int coiledni=sc.nextInt();
                            System.out.println("Podaj ile razy chcesz powtórzyc lot");
                            int ilerazypowtorzyc=sc.nextInt();
                            linia.GenerowanieLotow(ilerazypowtorzyc,coiledni,odlot,linia.getTrasa(itras),isam);
                        }
                        case 13 ->
                        {
                            System.out.println("Podaj indeks ktorego samolotu chcesz wypisac loty");

                            int indeks = sc.nextInt()-1;
                            if(indeks<0 || indeks+1>linia.ileSamolotow())
                            {
                                System.out.println("Nie ma takiego samolotu");
                                break;
                            }
                            ArrayList<Lot> loty = linia.getSamolot(indeks).getLoty();
                            for (Lot L: loty)
                            {
                                System.out.println(L.toString());
                            }
                        }
                        case 14 ->
                                {
                                    System.out.println("Dostepne Loty\n");
                                    ArrayList<Lot> loty = linia.getLoty();
                                    for (Lot L: loty)
                                    {
                                        System.out.println(L.toString());
                                    }

                                }
                        case 15 ->
                                {
                                    System.out.println("Podaj indeks samolotu z ktorego chcesz usunac lot");
                                    int isam= sc.nextInt()-1;
                                    if(isam<0 || isam+1>linia.ileSamolotow())
                                    {
                                        System.out.println("Nie ma takiego samolotu");
                                        break;
                                    }
                                    System.out.println("Podaj ktory lot chcesz usunac");
                                    int ilot= sc.nextInt()-1;
                                    if(ilot<0 || ilot+1>linia.ilelotow(isam))
                                    {
                                        System.out.println("Nie ma takiego lotu" + isam);
                                        break;
                                    }
                                    linia.usunLotsamolotu(isam,ilot);

                                }
                        case 16 -> {
                            System.out.println("Klienci indywidualni:");
                            for (int i = 0; i < linia.getKlienci().size(); i++) {
                                if (linia.getKlienci().get(i) instanceof Indywidualny) {
                                    System.out.println(((Indywidualny) linia.getKlienci().get(i)).getImie() +
                                            " " + ((Indywidualny) linia.getKlienci().get(i)).getNazwisko() +
                                            " " + ((Indywidualny) linia.getKlienci().get(i)).getNarodowosc());
                                    for (int j = 0; j < ((Indywidualny) linia.getKlienci().get(i)).getBilety().size(); j++) {
                                        System.out.println(((Indywidualny) linia.getKlienci().get(i)).getBilety().get(j).getSkad()+"-"+
                                                ((Indywidualny) linia.getKlienci().get(i)).getBilety().get(j).getDokad()+" "+
                                                ((Indywidualny) linia.getKlienci().get(i)).getBilety().get(j).getData());
                                    }
                                }
                            }

                            System.out.println("Firmy:");
                            for (int i = 0; i < linia.getKlienci().size(); i++) {
                                if (linia.getKlienci().get(i) instanceof Firma) {
                                    System.out.println(((Firma) linia.getKlienci().get(i)).getNazwa() +
                                            " " + ((Firma) linia.getKlienci().get(i)).getNarodowosc());

                                    for (int j = 0; j < ((Firma) linia.getKlienci().get(i)).getBilety().size(); j++) {
                                        System.out.println(((Firma) linia.getKlienci().get(i)).getBilety().get(j).getSkad()+"-"+
                                                ((Firma) linia.getKlienci().get(i)).getBilety().get(j).getDokad()+" "+
                                                ((Firma) linia.getKlienci().get(i)).getBilety().get(j).getData());
                                    }
                                }
                            }
                            System.out.println("\n");
                        }
                    }

                }while(petla!=0);
                petla=1;
            }



        }while(petla!=0);
    }
    public static int czyjesttakiklient(LiniaLotnicza l,String nazwisko,String imie){
        int numer =-1;
        for(int i=0;i<l.getKlienci().size();i++){
            if(l.getKlienci().get(i) instanceof Indywidualny) {
                if(((Indywidualny) l.getKlienci().get(i)).getImie().equals(imie)){
                    if(((Indywidualny) l.getKlienci().get(i)).getNazwisko().equals(nazwisko)){
                        System.out.println("tak");
                        numer=i;
                        break;
                    }
                }
            }
        }

        return numer;
    }
    public static int czyjesttakafirma(LiniaLotnicza l,int KRS){
        int numer =-1;
        for(int i=0;i<l.getKlienci().size();i++){
            if(l.getKlienci().get(i) instanceof Firma) {
                if(((Firma) l.getKlienci().get(i)).getKRS()==KRS){
                    numer =i;
                    break;
                }

            }
        }

        return numer;
    }
}
