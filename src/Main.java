import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args)
    {
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
                    System.out.println("1. Rezerwacja biletu");
                    System.out.println("2. Usuniecie rezerawcji");
                    System.out.println("0. Powrot do menu glownego");
                    switch(petla)
                    {

                        case 1 ->
                                {
                                    System.out.println("");
                                }
                        case 2 ->
                                {
                                    System.out.println("");



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
                    System.out.println("11. Wypisz klientow");
                    System.out.println("12.Generuj Loty dla Samolotu");
                    System.out.println("13.Usun Loty Samolotu");
                    System.out.println("0. Wyjdz do menu glownego");


                    petla = sc.nextInt();

                    switch(petla) {
                        case 1 -> {
                            System.out.println("\n");

                        }
                        case 2 ->
                        {
                            System.out.println("\n");

                        }
                        case 3 ->
                        {
                            System.out.println("Wpisz miasto z w ktorym znajduje sie lotnisko\n");
                            String nazwa=sc2.nextLine();
                            System.out.println("Wpisz Koordynaty na ktorych znajduje sie lotnisko\n");
                            int x=sc.nextInt();
                            int y=sc.nextInt();
                            Lotnisko lotnisko=new Lotnisko(x,y,nazwa);
                            linia.dodajLotnisko(lotnisko);
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
                            linia.usunLotnisko(indeks);

                        }
                        case 6 ->
                        {
                            System.out.println("Podaj indeksy lotnisk ktore z ktorych chcesz zrobic trase\n");
                            int indeksA=sc.nextInt();
                            int indeksB=sc.nextInt();
                            Trasa trasa = new Trasa(linia.getLotnisko(indeksA),linia.getLotnisko(indeksB));
                            linia.dodajTrase(trasa);

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
                            linia.usunTrase(sc.nextInt()-1);
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
                            linia.usunSamolot(sc.nextInt()-1);
                        }
                        case 12 ->
                        {
                            System.out.println("\n");

                        }
                        case 13 ->
                        {
                            System.out.println("\n");
                        }
                    }



                }while(petla!=0);
            }



        }while(petla!=0);



    }
}
