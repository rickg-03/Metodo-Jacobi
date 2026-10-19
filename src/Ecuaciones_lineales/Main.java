package Ecuaciones_lineales;
import Ecuaciones_lineales.Gauss_seidel.GaussSeidelMetodo;
import Ecuaciones_lineales.JACOBI.MetodoJacobi;

public class Main {
    public static void main(String[] neu){
            double[] solJacobi = MetodoJacobi.jacobi(
            SistemaEcuaciones.A, 
            SistemaEcuaciones.b, 
            SistemaEcuaciones.xInicial, 
            SistemaEcuaciones.TOLERANCIA, 
            SistemaEcuaciones.MAX_ITERACIONES
        );

        double[] solGaussSeidel = GaussSeidelMetodo.gaussSeidel(
            SistemaEcuaciones.A, 
            SistemaEcuaciones.b, 
            SistemaEcuaciones.xInicial, 
            SistemaEcuaciones.TOLERANCIA, 
            SistemaEcuaciones.MAX_ITERACIONES
        );

        
        System.out.println("--RESUMEN COMPARATIVO--");
        System.out.printf("Solucion Jacobi:        x1 = %.4f, x2 = %.4f, x3 = %.4f\n", solJacobi[0], solJacobi[1], solJacobi[2]);
        System.out.printf("Solucion Gauss-Seidel:  x1 = %.4f, x2 = %.4f, x3 = %.4f\n", solGaussSeidel[0], solGaussSeidel[1], solGaussSeidel[2]);
        System.out.println("");
    }
}