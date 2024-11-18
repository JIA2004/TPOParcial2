package actividad4;

public class App {

    public static void main(String[] args) {
        // Crear la red social (grafo)
        RedSocial redSocial = new RedSocial();

        // Crear usuarios
        Usuario usuario1 = new Usuario(0, "Juan");
        Usuario usuario2 = new Usuario(1, "Maria");
        Usuario usuario3 = new Usuario(2, "Carlos");
        Usuario usuario4 = new Usuario(3, "Ana");
        Usuario usuario5 = new Usuario(4, "Luis");

        // Agregar usuarios a la red social
        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);
        redSocial.agregarUsuario(usuario5);

        // Establecer amistades
        redSocial.agregarAmistad(0, 1); // Juan y Maria son amigos
        redSocial.agregarAmistad(0, 2); // Juan y Carlos son amigos
        redSocial.agregarAmistad(1, 3); // Maria y Ana son amigas
        redSocial.agregarAmistad(2, 4); // Carlos y Luis son amigos

        // Realizar recorrido DFS desde el usuario 0 (Juan)
        System.out.println("Recorrido DFS desde Juan:");
        redSocial.DFS(0);

        // Realizar recorrido BFS desde el usuario 0 (Juan)
        System.out.println("\nRecorrido BFS desde Juan:");
        redSocial.BFS(0);
    }
}

