
import java.util.*;

public class nodo {
    String aeropuerto;
    int costo;
    List<String> ruta;

    public nodo(String aeropuerto, int costo, List<String> ruta) {
        this.aeropuerto = aeropuerto;
        this.costo = costo;
        this.ruta = new ArrayList<>(ruta);
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public int getCosto() {
        return costo;
    }

    public List<String> getRuta() {
        return ruta;
    }
}
