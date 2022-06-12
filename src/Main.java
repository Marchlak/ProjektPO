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
                        case 1 ->  {

                        }
                        case 2 ->
                        {

                        }
                        case 3 ->
                        {

                        }
                        case 4 ->
                        {

                        }
                        case 5 ->
                        {

                        }
                        case 6 ->
                        {

                        }
                        case 7 ->
                        {

                        }
                        case 8 ->
                        {

                        }
                        case 9 ->
                        {

                        }
                        case 10 ->
                        {

                        }
                        case 11 ->
                        {

                        }
                        case 12 ->
                        {

                        }
                        case 13 ->
                        {

                        }
                    }



                }while(petla!=0);
            }



        }while(petla!=0);



    }
}
