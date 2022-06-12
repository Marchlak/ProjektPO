public class Lotnisko {
    private double X;
    private double Y;
    private String miasto;

    public Lotnisko(double x, double y, String miasto) {
        X = x;
        Y = y;
        this.miasto = miasto;
    }

    public double obliczodleglosc(Lotnisko L)
    {
      return Math.sqrt(Math.pow(X-L.X,2)+Math.pow(Y-L.Y,2));
      // wzór do zmiany narazie taki podstawowy
    }

    public double getY() {
        return Y;
    }
    public String getMiasto() {
        return miasto;
    }
    public double getX() {
        return X;
    }

    @Override
    public String toString() {
        return "Lotniskow miescie -" + miasto + " o wspolrzednych - " +
                "X=" + X +
                ", Y=" + Y ;
    }
}
