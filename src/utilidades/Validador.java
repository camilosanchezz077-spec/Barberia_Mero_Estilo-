package utilidades;

import java.util.Scanner;

public class Validador {

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida: escriba un número entero.");
            }
        }
    }

    public static int leerEnteroEnRango(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            int valor = leerEntero(sc, mensaje);
            if (valor >= min && valor <= max) {
                return valor;
            }
            System.out.println("Opción fuera de rango: escriba un número entre " + min + " y " + max + ".");
        }
    }

    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este dato es obligatorio y no puede estar vacío.");
        }
    }

    public static double leerDecimalPositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(linea);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("El valor debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida: escriba un número, por ejemplo 15000.");
            }
        }
    }
}