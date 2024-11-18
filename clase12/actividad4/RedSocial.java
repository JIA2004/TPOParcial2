package actividad4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RedSocial {
    private List<Usuario> usuarios;

    public RedSocial() {
        usuarios = new ArrayList<>();
    }

    // Agregar un nuevo usuario a la red social
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Conectar dos usuarios como amigos (relación bidireccional)
    public void agregarAmistad(int usuarioId1, int usuarioId2) {
        usuarios.get(usuarioId1).agregarAmigo(usuarioId2);
        usuarios.get(usuarioId2).agregarAmigo(usuarioId1);
    }

    // Método DFS (recorrido en profundidad) desde un usuario
    public void DFS(int inicio) {
        boolean[] visitado = new boolean[usuarios.size()];
        DFSUtil(inicio, visitado);
    }

    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.println("Visita DFS: " + usuarios.get(v).getNombre());

        for (int amigoId : usuarios.get(v).getAmigos()) {
            if (!visitado[amigoId]) {
                DFSUtil(amigoId, visitado);
            }
        }
    }

    // Método BFS (recorrido en anchura) desde un usuario
    public void BFS(int inicio) {
        boolean[] visitado = new boolean[usuarios.size()];
        Queue<Integer> cola = new LinkedList<>();
        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int usuarioId = cola.poll();
            System.out.println("Visita BFS: " + usuarios.get(usuarioId).getNombre());

            for (int amigoId : usuarios.get(usuarioId).getAmigos()) {
                if (!visitado[amigoId]) {
                    visitado[amigoId] = true;
                    cola.add(amigoId);
                }
            }
        }
    }
}
