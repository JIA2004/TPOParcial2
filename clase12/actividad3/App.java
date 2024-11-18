package actividad3;

public class App {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Crear almacenes
        almacen centroDistribucion = new almacen(0, "Centro Distribucion");
        almacen almacen1 = new almacen(1, "Almacen 1");
        almacen almacen2 = new almacen(2, "Almacen 2");
        almacen almacen3 = new almacen(3, "Almacen 3");

        
        centroDistribucion.agregarDestino(1); 
        centroDistribucion.agregarDestino(2); 
        centroDistribucion.agregarDestino(3); 

        // Agregar los almacenes al grafo
        grafo.agregarAlmacen(centroDistribucion);
        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);

        // Realizar DFS y BFS desde el almacén 0 (Centro Distribución)
        grafo.DFS(0);
        grafo.BFS(0);
    }
}
