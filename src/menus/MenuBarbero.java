package menus;

import servicios.GestorCitas;
import java.util.Scanner;

public class MenuBarbero {
    
    public static void mostrarMenuBarbero(Scanner scanner, GestorCitas gestorCitas) {
        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ BARBERO ==========");
            System.out.println("1. Consultar mi agenda e historial");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            // Leemos la opción del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("❌ Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre de barbero: ");
                    String nombreBarbero = scanner.nextLine();
                    
                    // Llamamos al método que creamos en el GestorCitas
                    gestorCitas.consultarAgendaBarbero(nombreBarbero);
                    break;
                    
                case 2:
                    System.out.println("Regresando al menú principal...");
                    break;
                    
                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 2);
    }
}
