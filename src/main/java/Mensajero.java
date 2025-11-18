
public class Mensajero {

    // Método para mostrar el saludo inicial
    public static void mostrarSaludo() {
        System.out.println("=== Bienvenido al Generador y Validador de Contraseñas ===");
        System.out.println("¿Sabías que una contraseña débil es la causa más común de brechas de seguridad?");
        System.out.println("Una buena contraseña es tu primera línea de defensa contra el robo de identidad y acceso");
        System.out.println("no autorizado a tus cuentas. En la era digital, proteger tus credenciales es fundamental.\n");
        System.out.println("Este validador te ayudará a crear una contraseña robusta que cumpla con estándares");
        System.out.println("de ciberseguridad. Recuerda: nunca compartas tus contraseñas y cámbialas regularmente.\n");
        System.out.println("¡Vamos a crear una contraseña segura juntos!");
    }
    
    public static void mostrarRequisitos() {
        
        System.out.println("Tu contraseña debe cumplir con los siguientes requisitos de seguridad:\n");
        System.out.println("- Minimo 8 caracteres");
        System.out.println("- Al menos una letra mayúscula");
        System.out.println("- Al menos una letra minúscula");
        System.out.println("- Al menos un número");
        System.out.println("- Al menos uno de estos caracteres especiales: . , *");
    }

    // Recomendaciones finales de seguridad
    public static void mostrarRecomendaciones() {
        System.out.println("\n=== RECOMENDACIONES DE SEGURIDAD ===");
        System.out.println("1. No reutilices la misma contraseña en diferentes sitios web.");
        System.out.println("2. Considera usar un gestor de contraseñas para almacenar y generar contraseñas seguras.");
        System.out.println("3. Cambia tus contraseñas regularmente.");
    }

    public static void despedirUsuario() {
        System.out.println("\nGracias por usar el Generador y Validador de Contraseñas.");
        System.out.println("Recuerda siempre mantenerte seguro en línea. ¡Hasta luego!");
    }

    // Metodo main para pruebas
    public static void main(String[] args) {
        mostrarSaludo();
        System.out.println();
        mostrarRequisitos();
        System.out.println();
        mostrarRecomendaciones();
    }

}