package Ecuaciones_lineales.Gauss_seidel;

//Importa la funcion calcularError reutilizando el metodo de Jacobi
import static Ecuaciones_lineales.JACOBI.MetodoJacobi.calcularError;

public class GaussSeidelMetodo {

    public static double[] gaussSeidel(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();
        //Un solo vector que evoluciona al instante

        System.out.println("\n--- EJECUCION METODO DE GAUSS-SEIDEL ---");
        System.out.printf("Iteracion 0: x1 = %.6f, x2 = %.6f, x3 = %.6f | Error = N/A\n", x[0], x[1], x[2]);

        for (int iter = 1; iter <= maxIter; iter++) {
            double[] xAnt = x.clone();
            //respaldamos el estado anterior para el error

            for (int i = 0; i < n; i++) {
                double suma = b[i];
                // Arranca con el término independiente b_i

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma -= A[i][j] * x[j];
                    }
                }
                x[i] = suma / A[i][i];
            }

            double error = calcularError(xAnt, x);

            System.out.printf("Iteración %d: x1 = %.6f, x2 = %.6f, x3 = %.6f | Error = %.6f\n", 
                              iter, x[0], x[1], x[2], error);

            if (error < tol) {
                System.out.println(">> Convergencia alcanzada en " + iter + " iteraciones.");
                return x;
            }
        }
        return x;
    }
}