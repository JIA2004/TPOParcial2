package actividad2;
import java.util.LinkedList;

public class GrafoBFS {
    private int V;
    private LinkedList<Integer>[] adj;

    public GrafoBFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void agregarArista(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int inicio) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            inicio = cola.poll();
            System.out.print(inicio + " ");

            for (int n : adj[inicio]) {
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoBFS g = new GrafoBFS(9);  // Cambié Grafo a Grafo1 aquí

        g.agregarArista(0, 1);
        g.agregarArista(1, 3);
        g.agregarArista(3, 6);
        g.agregarArista(1, 4);
        g.agregarArista(4, 7);
        g.agregarArista(4, 8);
        g.agregarArista(0, 2);
        g.agregarArista(2, 5);

        System.out.println("Recorrido BFS empezando desde el vértice 0:");
        
        g.BFS(0);
    }
}
