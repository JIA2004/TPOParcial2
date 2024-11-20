

public class DeteccionAtaques {

    
    private static final int MAX_INTENTOS_FALLIDOS = 5;

    
    public static void verificarIntentosFallidos(int intentosFallidosLogin) {
        if (intentosFallidosLogin > MAX_INTENTOS_FALLIDOS) {
            System.out.println("Bloquear IP: Ataque de fuerza bruta detectado.");
        } else if (intentosFallidosLogin > 0) {
            System.out.println("Generar alerta: Intentos de login fallidos.");
        }
    }

    
    public static void verificarAccesoNoAutorizado(boolean accesoNoAutorizado) {
        if (accesoNoAutorizado) {
            System.out.println("Bloquear acceso: Intento de acceso no autorizado.");
        }
    }

    
    public static void verificarPhishing(boolean esPhishing) {
        if (esPhishing) {
            System.out.println("Generar alerta: Posible ataque de phishing detectado.");
        }
    }


    public static void main(String[] args) {

        boolean actividadSospechosa = true;  // Puede ser "true" o "false"
        int intentosFallidosLogin = 6;  // Número de intentos fallidos
        boolean accesoNoAutorizado = true;  // True si se intenta acceso no autorizado
        boolean esPhishing = false;  // True si se detecta un posible ataque de phishing

        if (actividadSospechosa) {
            
            verificarIntentosFallidos(intentosFallidosLogin);

            
            verificarAccesoNoAutorizado(accesoNoAutorizado);

            verificarPhishing(esPhishing);
        } else {
            System.out.println("Fin: No se detectaron actividades sospechosas.");
        }
    }
}


