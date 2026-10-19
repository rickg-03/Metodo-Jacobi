# Métodos Iterativos: Jacobi y Gauss-Seidel

---

## 📐 Descripción del Proyecto

Este proyecto implementa el metodo Jacobi y Gauss-Seidel. Está organizado siguiendo una arquitectura modular mediante paquetes en Java separando la definición del sistema, la lógica de cada método numérico y la ejecución principal.

### Sistema de Ecuaciones Resuelto
$$\begin{cases}
5x_1 + x_2 + x_3 = 7 \\
x_1 + 4x_2 + x_3 = 6 \\
x_1 + 2x_2 + 5x_3 = 8
\end{cases}$$

- **Tolerancia ($\varepsilon$):** $0.0001$ ($10^{-4}$)
- **Vector Inicial ($\mathbf{x}^{(0)}$):** $[0.0, 0.0, 0.0]^T$
- **Máximo de Iteraciones:** $100$

---

## 📁 Modularidad y Estructura del Proyecto

El código está estructurado en paquetes Java dentro del directorio `src/` para garantizar un diseño modular.

```text
Metodo Jacobi/
└── src/
    └── Ecuaciones_lineales/
        ├── SistemaEcuaciones.java         
        ├── Main.java                      
        ├── JACOBI/
        │   └── MetodoJacobi.java          
        └── Gauss_seidel/
            └── GaussSeidelMetodo.java     
```

### Módulos:
1. **`Ecuaciones_lineales.SistemaEcuaciones`**: Contiene la matriz de coeficientes $A$, el vector $b$, el punto inicial $x^{(0)}$, la tolerancia de convergencia y el límite máximo de iteraciones.
2. **`Ecuaciones_lineales.JACOBI.MetodoJacobi`**: Implementa la lógica de Jacobi actualizando los componentes de forma simultánea. Aloja el método estático `calcularError` para la norma infinito relativa.
3. **`Ecuaciones_lineales.Gauss_seidel.GaussSeidelMetodo`**: Implementa el método de Gauss-Seidel actualizando el vector de soluciones sobre la marcha. Reutiliza el cálculo de error mediante un `import static`.
4. **`Ecuaciones_lineales.Main`**: Ejecuta ambos métodos y muestra la tabla comparativa final.
