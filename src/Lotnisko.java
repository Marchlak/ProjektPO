public class Lotnisko {
    private double X;
    private double Y;
    private String miasto;

    public Lotnisko(double x, double y, String miasto) {
        X = x;
        Y = y;
        this.miasto = miasto;
    }

    public double obliczodleglosc(Lotnisko L) //metoda obliczająca odległość między lotniskami
    {
      return Math.sqrt(Math.pow(X-L.X,2)+Math.pow(Y-L.Y,2))*111.32;
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
        return  miasto ;
    }
}
