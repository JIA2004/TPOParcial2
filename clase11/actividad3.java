

public class actividad3 {

    private static final int N = 4; //tablero 4x4
    private static char[][] tablero = new char[N][N]; 
    private static boolean[] computadorasFilas = new boolean[N];
    private static boolean[] computadorasColumnas = new boolean[N];
    private static boolean[] impresorasFilas = new boolean[N];
    private static boolean[] impresorasColumnas = new boolean[N];
    private static int soluciones = 0; // Contador de configuraciones válidas

    public static void main(String[] args) {
        inicializarTablero();
        colocarComputadoras(0);
        System.out.println("Número total de configuraciones válidas: " + soluciones);
    }

    private static void inicializarTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }
    }

    // colocamos las computadoras en el tablero
    private static void colocarComputadoras(int fila) {
        if (fila == N) {
            colocarImpresoras(0); // cuando ya se colocarom todas las computadoras, se colocan con las impresoras
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!computadorasFilas[fila] && !computadorasColumnas[col]) {
                tablero[fila][col] = 'C';
                computadorasFilas[fila] = true;
                computadorasColumnas[col] = true;
                colocarComputadoras(fila + 1);

                tablero[fila][col] = '.';
                computadorasFilas[fila] = false;
                computadorasColumnas[col] = false;
            }
        }
    }

    // colocamos impresoras en el tablero
    private static void colocarImpresoras(int fila) {
        if (fila == N) {
            imprimirTablero();  // cuando ya se colocaron todas las impresoras, mostramos la solución
            soluciones++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!impresorasFilas[fila] && !impresorasColumnas[col] && tablero[fila][col] == '.') {
                tablero[fila][col] = 'P';
                impresorasFilas[fila] = true;
                impresorasColumnas[col] = true;

                colocarImpresoras(fila + 1);

                tablero[fila][col] = '.';
                impresorasFilas[fila] = false;
                impresorasColumnas[col] = false;
            }
        }
    }

    // mostramos solucion
    private static void imprimirTablero() {
        System.out.println("Configuración válida:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
