public class ProblemaViajante {

    // cálculo del factorial de un número
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Número de ciudades
        int n = 6;


        long combinaciones = factorial(n - 1);  

        // Imprimir el resultado
        System.out.println("El número de combinaciones posibles para " + n + " ciudades es: " + combinaciones);
    }
}

