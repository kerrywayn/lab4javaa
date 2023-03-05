package main;

public class Main {
    public final static double a = 1.5;
    private static final double EPS = 1e-6;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        double[] x = fillX(0.8, 2, 0.005);
        double[] y = fillY(x);
        int numMin = numMin(y);
        int numMax = numMax(y);
        double sum = sum(y);
        double avg = avg(y);
        System.out.printf("Мінімальний Y = %6.3f для X = %6.3f\n", y[numMin], x[numMin]);
        System.out.printf("Максимальний Y = %6.3f для X = %6.3f\n", y[numMax], x[numMax]);
        System.out.printf("Сума = %6.3f\nСереднє арифметичне = %6.3f\n", sum, avg);

    }

    public double f(double x){
        if (x < 1.7-EPS) {
            return Math.PI*x*x-7/(x*x);
        } else if (x > 1.7+EPS) {
            return Math.log10(x+7*Math.sqrt(x));
        } else {
            return a*x*x*x+7*Math.sqrt(x);
        }

    }

    public int calcSteps(double start, double end, double step){
        return (int) ((end-start)/step+1);
    }

    public double[] fillX(double start, double end, double step) {
        double[] array = new double[calcSteps(start, end, step)];
        for (int i = 0; i < array.length; i++) {
            array[i] = start+i*step;
        }
        return array;
    }

    public double[] fillY(double[] x) {
        double[] array = new double[x.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = f(x[i]);
        }
        return array;
    }

    public int numMin(double[] a) {
        double min = a[0];
        int numMin = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]< min){
                min = a[i];
                numMin = i;
            }
        }
        return numMin;
    }

    public int numMax(double[] a) {
        double max = a[0];
        int numMax = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                numMax = i;
            }
        }
        return numMax;
    }

    public double sum(double[] a) {
        double s = 0;
        for (double v : a) {
            s += v;
        }
        return s;
    }

    public double avg(double[] a) {
        return sum(a)/a.length;
    }
}
