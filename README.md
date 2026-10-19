# Métodos Iterativos: Jacobi y Gauss-Seidel

Proyecto modular en Java para la resolución numérica de sistemas de ecuaciones lineales de la forma $A \mathbf{x} = \mathbf{b}$ utilizando los métodos iterativos de **Jacobi** y **Gauss-Seidel**.

---

## 📐 Descripción del Proyecto

Este proyecto implementa y compara dos de los algoritmos numéricos iterativos más fundamentales para resolver sistemas de ecuaciones lineales. Está organizado siguiendo una arquitectura modular mediante paquetes en Java, separando la definición del sistema, la lógica de cada método numérico y la ejecución principal.

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

## 📁 Estrategia de Modularidad y Estructura del Proyecto

El código está estructurado en paquetes Java dentro del directorio `src/` para garantizar un diseño modular, mantenible y escalable:

```text
Metodo Jacobi/
└── src/
    └── Ecuaciones_lineales/
        ├── SistemaEcuaciones.java         # Definición del sistema A, b y parámetros
        ├── Main.java                      # Clase principal de ejecución y comparativa
        ├── JACOBI/
        │   └── MetodoJacobi.java          # Algoritmo de Jacobi y cálculo de error
        └── Gauss_seidel/
            └── GaussSeidelMetodo.java     # Algoritmo de Gauss-Seidel (reutiliza calcularError)
```

### Roles de los Módulos:
1. **`Ecuaciones_lineales.SistemaEcuaciones`**: Contiene la matriz de coeficientes $A$, el vector $b$, el punto inicial $x^{(0)}$, la tolerancia de convergencia y el límite máximo de iteraciones.
2. **`Ecuaciones_lineales.JACOBI.MetodoJacobi`**: Implementa la lógica de Jacobi actualizando los componentes de forma simultánea. Aloja el método estático `calcularError` para la norma infinito relativa.
3. **`Ecuaciones_lineales.Gauss_seidel.GaussSeidelMetodo`**: Implementa el método de Gauss-Seidel actualizando el vector de soluciones sobre la marcha. Reutiliza el cálculo de error mediante un `import static`.
4. **`Ecuaciones_lineales.Main`**: Coordina la ejecución de ambos métodos y muestra la tabla comparativa final.

---

## 🚀 Compilación y Ejecución

### Requisitos
- JDK 8 o superior instalado.
- Visual Studio Code o cualquier IDE compatible con Java.

### Desde la Terminal

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio
   ```

2. **Compilar los archivos:**
   ```bash
   javac -d bin src/Ecuaciones_lineales/*.java src/Ecuaciones_lineales/JACOBI/*.java src/Ecuaciones_lineales/Gauss_seidel/*.java
   ```

3. **Ejecutar el programa principal:**
   ```bash
   java -cp bin Ecuaciones_lineales.Main
   ```

---

## 📊 Resultados Obtenidos

| Métrica / Resultado | Método de Jacobi | Método de Gauss-Seidel |
| :--- | :---: | :---: |
| **Iteraciones requeridas** | $10$ iteraciones | $5$ iteraciones |
| **Valor de $x_1$** | $0.999981$ | $1.000000$ |
| **Valor de $x_2$** | $0.999987$ | $1.000000$ |
| **Valor de $x_3$** | $0.999988$ | $1.000000$ |
| **Error Relativo Final** | $0.000030$ | $0.000000$ |

---

## 💡 Conclusión Técnica

El **Método de Gauss-Seidel** demostró ser significativamente más eficiente que el **Método de Jacobi** para este sistema, logrando la convergencia a la solución exacta $(1, 1, 1)$ en exactamente la **mitad de las iteraciones** (5 frente a 10). Esta aceleración se debe al uso inmediato de los componentes recién calculados dentro de la misma iteración, a diferencia de Jacobi que mantiene los valores congelados hasta la siguiente ronda.