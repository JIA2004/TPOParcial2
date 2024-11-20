
public class Vuelo {
    private String destino;
    private int costo;

    // Constructor de la clase Vuelo
    public Vuelo(String destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }

    // Métodos getter
    public String getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }

    // Método setter si es necesario
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }


    @Override
    public String toString() {
        return "Vuelo a " + destino + " con costo: " + costo;
    }
}
