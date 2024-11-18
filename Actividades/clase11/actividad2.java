public class actividad2 {

    static int N = 4; // Para que el tablero sea 4x4

    
    public static boolean chequeoEscritorio(int tablero[][], int fila, int col) {
         for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1) {    // para verificar fila (escritorio)
                return false;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 1) {       // para verificar columna (escritorio)
                return false;
            }
        }
        return true;
    }

    
    public static boolean chequeoSilla(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2) {        // para verificar fila (sillas)
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 2) {          // para verificar columna (sillas)
                return false;
            }
        }
        return true;
    }

    // funcion para resolucion de problema
    public static void resolverDisenoInteriores() {
        int[][] tablero = new int[N][N]; 
        colocarEscritorios(tablero, 0, 0); 
    }

    // funcion para poner escritorios
    public static boolean colocarEscritorios(int[][] tablero, int fila, int escritoriosColocados) {
        if (escritoriosColocados == 4) { 
            colocarSillas(tablero, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chequeoEscritorio(tablero, i, j)) {
                    tablero[i][j] = 1;
                    colocarEscritorios(tablero, i + 1, escritoriosColocados + 1);
                    tablero[i][j] = 0;
                }
            }
        }

        return false; 
    }

    public static boolean colocarSillas(int[][] tablero, int fila, int sillasColocadas) {
        if (sillasColocadas == 4) { 
            imprimirTablero(tablero);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chequeoSilla(tablero, i, j) && tablero[i][j] == 0) {
                    tablero[i][j] = 2;
                    colocarSillas(tablero, i + 1, sillasColocadas + 1);
                    tablero[i][j] = 0;
                }
            }
        }

        return false; 
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("E "); 
                } else if (tablero[i][j] == 2) {
                    System.out.print("S "); 
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }public static void main(String[] args) {
        resolverDisenoInteriores();
    }
}