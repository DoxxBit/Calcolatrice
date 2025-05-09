package interfacciaCalcolatriceSwing;

public class Operazioni {
    public static double somma(double a, double b) {
        return a + b;
    }

    public static double sottrazione(double a, double b) {
        return a - b;
    }

    public static double moltiplicazione(double a, double b) {
        return a * b;
    }

    public static double divisione(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisione per zero");
        }
        return a / b;
    }
}

