public class Trasa {
private Lotnisko A,B;
private double odleglosc;

    public Trasa(Lotnisko a, Lotnisko b) {
        A = a;
        B = b;
        odleglosc=A.obliczodleglosc(B);
    }

    public Lotnisko getA() {
        return A;
    }

    public Lotnisko getB() {
        return B;
    }

    public double getOdleglosc() {
        return odleglosc;
    }
}
