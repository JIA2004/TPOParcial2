package clase11.actividad1;
import java.util.LinkedList;

public class GrafoDFS {
    private int V; // número de vértices
    private LinkedList<Integer>[] adj; // listas de adyacencia para cada vértice

    @SuppressWarnings("unchecked")
    public GrafoDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>(); 
        }
    }

    // para agregar arista
    public void agregarArista(int v, int w) {
        adj[v].add(w); 
    }


    // metodo de DFS recursivo
    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visitado[n]) {
                DFSUtil(n, visitado); 
            }
        }
    }

    
    public void DFS(int inicio) {
        boolean[] visitado = new boolean[V];
        DFSUtil(inicio, visitado);
    }


    public static void main(String[] args) {

        // DFS
        GrafoDFS g1 = new GrafoDFS(9); // Crear un grafo con 6 vértices (0 a 6)

        // agregamos aristas al grafo
        g1.agregarArista(0, 1);
        g1.agregarArista(1, 3);
        g1.agregarArista(3, 6);
        g1.agregarArista(1, 4);
        g1.agregarArista(4, 7);
        g1.agregarArista(4, 8);
        g1.agregarArista(0, 2);
        g1.agregarArista(2, 5);
        
        
        System.out.println("");
        System.out.println("Recorrido DFS empezando desde el vértice 0:");

        g1.DFS(0);
    }
}