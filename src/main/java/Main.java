import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {

    // Indicadores de seguridad
    private static final String fuerte = "Nivel de seguridad: fuerte.";
    private static final String media = "Nivel de seguridad: media.";
    private static final String debil = "Nivel de seguridad: débil.";

    // Mensajes de seguridad
    private static final String msgFuerte = "Tu contraseña cumple con los requisitos de seguridad." + fuerte;
    private static final String msgMedia = "Tu contraseña cumple con los requisitos de seguridad." + media;
    private static final String msgDebil = "Tu contraseña debe tener al menos 8 caracteres." + debil;

    // Saludo inicial 
    private static final String saludo = "=== VALIDADOR DE CONTRASEÑAS SEGURAS ===\n\n" +
        "¿Sabías que una contraseña débil es la causa más común de brechas de seguridad?\n" +
        "Una buena contraseña es tu primera línea de defensa contra el robo de identidad y acceso\n" +
        "no autorizado a tus cuentas. En la era digital, proteger tus credenciales es fundamental.\n\n" +
        "Este validador te ayudará a crear una contraseña robusta que cumpla con estándares\n" +
        "de ciberseguridad. Recuerda: nunca compartas tus contraseñas y cámbia las regularmente.\n\n" +
        "¡Vamos a crear una contraseña segura juntos!";

    // Método para mostrar los requisitos de la contraseña.
    public static String mostrarRequisitos() {
        return "Tu contraseña debe cumpli con los siguientes requisitos de seguridad:\n" + 
            "- Minimo 8 caracteres\n" +
            "- Al menos una letra mayúscula\n" +
            "- Al menos una letra minúscula\n" +
            "- Al menos un número\n" +
            "- Al menos uno de estos caracteres especiales: . , *";
    }
    // Método para analizar y mostrar los requisitos faltantes.
    public static void validarContrasena(String msj) {
        System.out.println("\nFaltan los siguientes requisitos:");

            if (!msj.matches(".*[A-Z].*")) {
                System.out.println("- Letra mayúscula");
            }
            if (!msj.matches(".*[a-z].*")) {
                System.out.println("- Letra minúscula");
            }
            if (!msj.matches(".*[0-9].*")) {
                System.out.println("- Número");
            }
            if (!msj.matches(".*[.,*].*")) {
                System.out.println("- Carácter especial (. , o *)");
            }
        }

    public static void main(String[] args) {
        System.out.println(saludo);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println(mostrarRequisitos());
        System.out.print("¿Deseas crear una contraseña manualmente o generar una automáticamente? (manual/generar): ");
        String opcion = scanner.nextLine().toLowerCase();

        String entrada;

        if (opcion.equals("generar")) {
            entrada = Generador.generarContrasena();
            System.out.println("Tu contraseña generada es: " + entrada);
            System.out.println("Tu contraseña ha sido creada exitosamente.");
            scanner.close();
            return;
        }

        System.out.print("Crea tu contraseña: ");

        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,*]).+$";
        Pattern patron = Pattern.compile(regex);
        Matcher matcher;
        
        // Generar una contraseña sugerida
        String contrasenaSugerida = Generador.generarContrasena();

        boolean esValido = false;

        while (!esValido) {
            entrada = scanner.nextLine();
            matcher = patron.matcher(entrada);
            
            // Verficar si la contraseña tiene minimo 8 caracteres
            if (entrada.length() < 8) {
                System.out.println(msgDebil); // contraseña débil
                validarContrasena(entrada);
                System.out.println("Sugerencias: " + contrasenaSugerida);
                System.out.print("Intentalo de nuevo: ");
            } else if (entrada.length() == 8) {
                if (matcher.matches()) {
                    System.out.println(msgMedia); // contraseña media
                    System.out.println("Tu contraseña ha sido creada exitosamente.");
                    esValido = true;
                } else {
                    System.out.println("Tu contraseña NO cumple con los requisitos: ");
                    validarContrasena(entrada);
                    System.out.println("Sugerencias: " + contrasenaSugerida);
                    System.out.print("Intentalo de nuevo: ");
                }
            } else {
                if (matcher.matches()) {
                    System.out.println(msgFuerte); // contraseña fuerte
                    System.out.println("Tu contraseña ha sido creada exitosamente.");
                    esValido = true;
                } else {
                    System.out.println("Tu contraseña NO cumple con los requisitos: ");
                    validarContrasena(entrada);
                    System.out.println("Sugerencias: " + contrasenaSugerida);
                    System.out.print("Intentalo de nuevo: ");
                }                
            }
        }
    scanner.close();

    }
}
