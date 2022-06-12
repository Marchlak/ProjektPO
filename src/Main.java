import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LiniaLotnicza linia =new LiniaLotnicza();
        int petla;
        do {
            System.out.println("Witaj w Systemie kontroli lotów\n");
            System.out.println("1. Interefejs Uzytownika\n");
            System.out.println("2. Interfejs Admina\n");
            System.out.println("0. Wyjdz\n");
            petla = sc.nextInt();
            if (petla == 1)
            {


            }
            else if(petla==2)
            {
                System.out.println("Witaj w panelu admina\n");
                System.out.println("1. Wcztaj z pliku\n");
                System.out.println("2. Zapisz do pliku\n");
                System.out.println("3. Dodaj Lotnisko\n");
                System.out.println("4. Wypisz Lotniska\n");
                System.out.println("5. Usun Lotnisko\n");
                System.out.println("6. Dodaj Trase\n");
                System.out.println("7. Wypisz Trasy\n");
                System.out.println("8. Usun Trasy\n");
                System.out.println("9. Dodaj Samolot\n");
                System.out.println("10. Wypisz Samoloty\n");
                System.out.println("11. Wypisz klientow\n");
                System.out.println("12.Generuj Loty dla Samolotu\n");
                System.out.println("13.Usun Loty Samolotu\n");
                System.out.println("0. Wyjdz do menu glownego \n");

                System.out.println("0. Wyjdz\n");
                petla = sc.nextInt();
                do
                {
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
                            String nazwa=sc.nextLine();
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
                                System.out.println(lotniska.toString());
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
                                System.out.println(trasy.toString());
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
                            String model=sc.nextLine();


                        }
                        case 10 ->
                        {
                            System.out.println("\n");

                        }
                        case 11 ->
                        {
                            System.out.println("\n");

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
