package actividad3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {
    private List<almacen> almacenes; // Lista de almacenes

    // Constructor
    public Grafo() {
        almacenes = new ArrayList<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(almacen almacen) {
        almacenes.add(almacen);
    }

    // Método DFS (recorrido en profundidad)
    public void DFS(int inicio) {
        boolean[] visitado = new boolean[almacenes.size()];
        DFSUtil(inicio, visitado);
    }

    // Método auxiliar para DFS
    private void DFSUtil(int v, boolean[] visitado) {
        if (v < 0 || v >= almacenes.size()) {
            System.out.println("Índice fuera de rango: " + v);
            return;
        }

        visitado[v] = true;
        System.out.println("Visita DFS: " + almacenes.get(v).getNombre());

        // Recorrer los destinos del almacén actual
        for (int destino : almacenes.get(v).getDestinos()) {
            if (destino >= 0 && destino < almacenes.size() && !visitado[destino]) {
                DFSUtil(destino, visitado); // Llamada recursiva para recorrer el destino
            } else {
                System.out.println("Destino inválido: " + destino);
            }
        }
    }

    // Método BFS (recorrido en anchura)
    public void BFS(int inicio) {
        if (inicio < 0 || inicio >= almacenes.size()) {
            System.out.println("Índice de inicio fuera de rango: " + inicio);
            return;
        }

        boolean[] visitado = new boolean[almacenes.size()];
        Queue<Integer> cola = new LinkedList<>();
        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println("Visita BFS: " + almacenes.get(nodo).getNombre());

            // Recorrer los destinos del almacén actual
            for (int destino : almacenes.get(nodo).getDestinos()) {
                if (destino >= 0 && destino < almacenes.size() && !visitado[destino]) {
                    visitado[destino] = true;
                    cola.add(destino);
                } else {
                    System.out.println("Destino inválido: " + destino);
                }
            }
        }
    }
}
