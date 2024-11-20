
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SistemaSeleccionViajes {

    // Grafo de aeropuertos y vuelos
    private static final Map<String, List<Vuelo>> vuelos = new HashMap<>();

    public static void main(String[] args) {

        inicializarVuelos();

        // Origen y destino
        String origen = "A";
        String destino = "D";

        // búsqueda con UCS
        buscarViajeMasBarato(origen, destino);
    }


    private static void inicializarVuelos() {
        vuelos.put("A", Arrays.asList(new Vuelo("B", 100), new Vuelo("C", 200)));
        vuelos.put("B", Arrays.asList(new Vuelo("D", 100), new Vuelo("C", 50)));
        vuelos.put("C", Arrays.asList(new Vuelo("D", 100)));
        vuelos.put("D", new ArrayList<>());
    }


    private static void buscarViajeMasBarato(String origen, String destino) {
        // Cola de prioridad (min-heap) basada en el costo
        PriorityQueue<nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));

        // Lista de aeropuertos visitados
        Set<String> visitados = new HashSet<>();

        // Inicializar la cola con el origen
        List<String> rutaInicial = new ArrayList<>();
        rutaInicial.add(origen);
        cola.offer(new nodo(origen, 0, rutaInicial));

        while (!cola.isEmpty()) {
            nodo nodoActual = cola.poll();

            // Si ya llegamos al destino, mostrar el resultado
            if (nodoActual.getAeropuerto().equals(destino)) {
                System.out.println("Ruta más barata: " + nodoActual.getRuta());
                System.out.println("Costo total: " + nodoActual.getCosto());
                return;
            }

            // Marcar el nodo actual como visitado
            if (visitados.contains(nodoActual.getAeropuerto())) {
                continue;
            }
            visitados.add(nodoActual.getAeropuerto());

            // Explorar los vuelos desde el nodo actual
            for (Vuelo vuelo : vuelos.getOrDefault(nodoActual.getAeropuerto(), new ArrayList<>())) {
                if (!visitados.contains(vuelo.getDestino())) {
                    List<String> nuevaRuta = new ArrayList<>(nodoActual.getRuta());
                    nuevaRuta.add(vuelo.getDestino());
                    int nuevoCosto = nodoActual.getCosto() + vuelo.getCosto();
                    cola.offer(new nodo(vuelo.getDestino(), nuevoCosto, nuevaRuta));
                }
            }
        }

        // Si no se encuentra ruta al destino
        System.out.println("No se puede llegar al destino desde el origen.");
    }
}
