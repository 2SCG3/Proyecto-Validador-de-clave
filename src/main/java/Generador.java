// En este archivo se define la clase Generador que contiene métodos para generar contraseñas seguras.

import java.util.Random;

public class Generador {

    // variables estaticas para definir los conjuntos de caracteres
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIALES = ".,*";
    private static final String TODOS = MAYUSCULAS + MINUSCULAS + NUMEROS + ESPECIALES;

    private static final Random random = new Random();
    
    // Método para mezclar un array de caracteres
    private static void mezclarArray(char[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Intercambiar array[i] y array[j]
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }    
    // Método para generar una contraseña sugerida que cumpla con los requisitos.
    public static String generarContrasena() {
        char[] psswd = new char[16];

        // Asegurar que tenga al menos un carácter de cada tipo requerido
        psswd[0] = MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length()));
        psswd[1] = MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length()));
        psswd[2] = NUMEROS.charAt(random.nextInt(NUMEROS.length()));
        psswd[3] = ESPECIALES.charAt(random.nextInt(ESPECIALES.length()));

        // Rellenar los 12 caracteres restantes con caracteres aleatorios
        for (int i = 4; i < 16; i++) {
            psswd[i] = TODOS.charAt(random.nextInt(TODOS.length()));
        }

        // Mezclar el array para que no siempre estén en el mismo orden
        mezclarArray(psswd);
        return new String(psswd);
    }

    // Método para generar múltiples contraseñas sugeridas
    public static String[] generarMultiplesContrasenas(int cantidad) {
        String[] psswds = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            psswds[i] = generarContrasena();
        }
        return psswds;
    }

    // Método principal para probar el generador de mensajes
    public static void main(String[] args) {
        System.out.println("=== Generador de Mensajes ===\n");

        // Generar y mostrar 10 mensajes de ejemplo
            String psswd = generarContrasena();
            System.out.println(psswd);
    }

}