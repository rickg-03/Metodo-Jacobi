package Ecuaciones_lineales.JACOBI;

public class MetodoJacobi{
    public static double calcularError(double[] xAnt, double[] xAct) {
        double maxDiff = 0.0;
        double maxVal = 0.0;
        for (int i = 0; i < xAct.length; i++) {
            double diff = Math.abs(xAct[i] - xAnt[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
            double val = Math.abs(xAct[i]);
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal == 0 ? maxDiff : maxDiff / maxVal;
    }

    public static double[] jacobi(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();
        System.out.println("--- EJECUCION METODO DE JACOBI ---");
        System.out.printf("Iteracion 0: x1 = %.6f, x2 = %.6f, x3 = %.6f | Error = N/A\n", x[0], x[1], x[2]);

        for (int iter = 1; iter <= maxIter; iter++) {
            double[] xNuevo = new double[n];

            for (int i = 0; i < n; i++) {
                double suma = b[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma -= A[i][j] * x[j];
                    }
                }
                xNuevo[i] = suma / A[i][i];
            }

            double error = calcularError(x, xNuevo);
            x = xNuevo;

            System.out.printf("Iteracion %d: x1 = %.6f, x2 = %.6f, x3 = %.6f | Error = %.6f\n", 
                              iter, x[0], x[1], x[2], error);

            if (error < tol) {
                System.out.println(">> Convergencia alcanzada en " + iter + " iteraciones.");
                return x;
            }
        }
        return x;
    }
}