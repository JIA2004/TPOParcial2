package Clase14;

public class actividad2 {

    // tamaño del tablero
    private static final int SIZE = 6;

    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 6, 0, 0, 0},
            {0, 0, 0, 0, 6, 0},
            {0, 4, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0},
            {0, 0, 1, 0, 0, 5},
            {0, 0, 0, 0, 0, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("El sudoku no tiene solucion.");
        }
    }

    // resolvemos sudoku con backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { 
                    for (int num = 1; num <= 6; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            
                            if (solveSudoku(board)) {
                                return true;
                            }

                            
                            board[row][col] = 0;
                        }
                    }
                    return false; // Si no hay numero valido retrocede
                }
            }
        }
        return true; // si se encontro un tablero valido completo 
    }

    // verificamos si un numero puede colocarse en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // verificamos si el número esta en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar si el número está en el 2x3
        int startRow = row - row % 2; 
        int startCol = col - col % 3; 
        for (int i = 0; i < 2; i++) { 
            for (int j = 0; j < 3; j++) { 
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true; 
    }

    // imprime el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}

