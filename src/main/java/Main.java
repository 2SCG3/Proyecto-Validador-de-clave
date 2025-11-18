import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Mensajero.mostrarSaludo();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        Mensajero.mostrarRequisitos();
        System.out.print("\n¿Deseas crear una contraseña manualmente o generar una automáticamente? (manual/generar): ");
        
        String opcion;
        String entrada;

        while (true) {
            // System.out.print("Por favor, ingresa una opción (manual/generar): ");
            opcion = scanner.nextLine().toLowerCase();

            if (opcion.equals("generar")) {
                entrada = Generador.generarContrasena();
                System.out.println("\nTu contraseña ha sido creada exitosamente.");
                System.out.println("---> Tu contraseña generada es: " + entrada);
                Mensajero.mostrarRecomendaciones();
                Mensajero.despedirUsuario();
                return; 
            } 
            else if (opcion.equals("manual")) {
                break; 
            } 
            else {
                System.out.println("Opción no válida. Por favor, elige 'manual' o 'generar': ");
            }
        }

        System.out.print("Crea tu contraseña: ");

        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,*]).+$";
        Pattern patron = Pattern.compile(regex);
        Matcher matcher;
        
        boolean esValido = false;

        while (!esValido) {
            entrada = scanner.nextLine();
            matcher = patron.matcher(entrada);
            
            // Verficar si la contraseña tiene minimo 8 caracteres
            if (entrada.length() < 8) {
                Generador.indicadorSeguridad(1); // contraseña débil
                Generador.validarContrasena(entrada);
                System.out.println("Sugerencias: " + Generador.generarContrasena()); // generar nueva sugerencia
                System.out.print("\nIntentalo de nuevo: ");
            } else if (entrada.length() == 8) {
                if (matcher.matches()) {
                    Generador.indicadorSeguridad(2); // contraseña media
                    System.out.println("Tu contraseña ha sido creada exitosamente.");
                    Mensajero.mostrarRecomendaciones();
                    Mensajero.despedirUsuario();
                    esValido = true;
                } else {
                    System.out.println("\n" + "Tu contraseña NO cumple con los requisitos: ");
                    Generador.validarContrasena(entrada);
                    System.out.println("Sugerencias: " + Generador.generarContrasena());
                    System.out.print("\nIntentalo de nuevo: ");
                }
            } else {
                if (matcher.matches()) {
                    Generador.indicadorSeguridad(3); // contraseña fuerte
                    System.out.println("Tu contraseña ha sido creada exitosamente.");
                    Mensajero.mostrarRecomendaciones();
                    Mensajero.despedirUsuario();
                    esValido = true;
                } else {
                    System.out.println("Tu contraseña NO cumple con los requisitos: ");
                    Generador.validarContrasena(entrada);
                    System.out.println("Sugerencias: " + Generador.generarContrasena());
                    System.out.print("\nIntentalo de nuevo: ");
                }                
            }
        }
    scanner.close();

    }
}
