package Ecuaciones_lineales;

public class SistemaEcuaciones {
    public static final double[][] A = {
        {5.0, 1.0, 1.0},
        {1.0, 4.0, 1.0},
        {1.0, 2.0, 5.0}
    };

    public static final double[] b = {7.0, 6.0, 8.0};
    public static final double[] xInicial = {0.0, 0.0, 0.0};
    public static final double TOLERANCIA = 0.0001;
    public static final int MAX_ITERACIONES = 100;
}