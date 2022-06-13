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
            System.out.println("Witaj w Systemie kontroli lotów");
            System.out.println("1. Interefejs Uzytownika");
            System.out.println("2. Interfejs Admina");
            System.out.println("0. Wyjdz");
            System.out.println("");
            petla = sc.nextInt();
            if (petla == 1)
            {
                do {
                    System.out.println("Witaj w panelu użytkownika");
                    System.out.println("1. Zaloguj sie");
                    System.out.println("2. Utworz konto");
                    System.out.println("0. Powrot do menu glownego");
                    switch(petla)
                    {
                        case 1 ->
                                {
                                    System.out.println("Podaj swoje imie i nazwisko");
                                    String imie = sc2.nextLine();
                                    String nazwisko = sc2.nextLine();

                                }
                        case 2 ->
                                {
                                    System.out.println("Podaj KRS firmy");
                                    String KRS = sc2.nextLine();
                                }

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
                    System.out.println("14.Usun Lot Samolotu");
                    System.out.println("15. Wypisz wszystkie loty");
                    System.out.println("0. Wyjdz do menu glownego");


                    petla = sc.nextInt();

                    switch(petla) {
                        case 1 -> {
                            System.out.println("Podaj nazwe pliku z ktorego wczytasz dane");
                            String nazwaPliku=sc2.nextLine();
                            linia.setPath(nazwaPliku);
                            linia.wczytaj();
                        }
                        case 2 ->
                        {
                            System.out.println("Podaj nazwe pliku");
                            String nazwaPliku=sc2.nextLine();
                            linia.setPath(nazwaPliku);
                            linia.zapisz();
                        }
                        case 3 ->
                        {
                            System.out.println("Wpisz miasto z w ktorym znajduje sie lotnisko\n");
                            String nazwa=sc2.nextLine();
                            System.out.println("Wpisz Koordynaty na ktorych znajduje sie lotnisko\n");
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
                            System.out.println("Dostępne lotniska \n");
                            ArrayList<Lotnisko> lotniska = linia.getLotniska();
                            for (Lotnisko L: lotniska)
                            {
                                System.out.println(L.toString());
                            }
                        }
                        case 5 ->
                        {
                            System.out.println("Podaj indeks lotniska ktorego chcesz usunac\n");
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
                            System.out.println("Podaj indeksy lotnisk ktore z ktorych chcesz zrobic trase\n");
                            int indeksA=sc.nextInt()-1;
                            int indeksB=sc.nextInt()-1;
                            if(indeksA<0 || indeksA+1>linia.ileTras() || indeksB<0 || indeksB+1>linia.ileTras())
                            {
                                System.out.println("Błędne indeksy");
                            }
                                else
                                {
                            Trasa trasa = new Trasa(linia.getLotnisko(indeksA), linia.getLotnisko(indeksB));
                            linia.dodajTrase(trasa);
                                }

                        }
                        case 7 ->
                        {
                            System.out.println("Dostepne trasy\n");
                            ArrayList<Trasa> trasy = linia.getTrasy();
                            for (Trasa T: trasy)
                            {
                                System.out.println(T.toString());
                            }
                        }
                        case 8 ->
                        {
                            System.out.println("Podaj indeks trasy ktora chcesz usunac\n");
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
                            System.out.println("Podaj nazwe modelu Samolotu\n");
                            String model=sc2.nextLine();
                            System.out.println("Podaj liczbe miejsc Samolotu\n");
                            int miejsca=sc.nextInt();
                            System.out.println("Podaj zasieg Samolotu\n");
                            double zasieg=sc.nextDouble();
                            Samolot samolot= new Samolot(zasieg,miejsca,model);
                            linia.dodajSamolot(samolot);
                        }
                        case 10 ->
                        {
                            System.out.println("Dostepne Samoloty\n");
                            ArrayList<Samolot> samoloty = linia.getSamoloty();
                            for (Samolot S: samoloty)
                            {
                                System.out.println(S.toStringSamolot());
                            }


                        }
                        case 11 ->
                        {
                            System.out.println("Podaj indeks samolotu ktory chcesz usunac\n");
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
                            System.out.println("Podaj indeks którego samolotu chcesz wypisać loty");

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
                    }

                }while(petla!=0);
                petla=1;
            }



        }while(petla!=0);
    }
}
