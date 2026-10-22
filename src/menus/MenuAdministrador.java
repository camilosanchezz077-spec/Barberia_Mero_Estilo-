package menus;

import java.util.Scanner;
import servicios.GestorCitas;
import servicios.GestorBarberos;
import servicios.GestorClientes;
import servicios.GestorReportes;

public class MenuAdministrador {

    public static void mostrarMenu(Scanner scanner, GestorCitas gestorCitas, GestorBarberos gestorBarberos, GestorClientes gestorClientes, GestorReportes gestorReportes) {
        int opcion = -1;

        do {
            System.out.println("\n========================================");
            System.out.println("      MENÚ PRINCIPAL - ADMINISTRADOR    ");
            System.out.println("========================================");
            System.out.println("1. Gestionar Barberos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Ver Agenda General de Citas");
            System.out.println("4. Marcar Cita como Atendida");
            System.out.println("5. Ver Reporte de Ingresos");
            System.out.println("6. Ver Estadísticas Generales de Citas");
            System.out.println("0. Salir / Cerrar Sesión");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- GESTIÓN DE BARBEROS ---");
                        // Aquí puedes llamar a los métodos de tu GestorBarberos
                        break;

                    case 2:
                        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
                        // Aquí puedes llamar a los métodos de tu GestorClientes
                        break;

                    case 3:
                        gestorCitas.consultarAgendaGeneral();
                        break;

                    case 4:
                        System.out.print("Ingrese el ID de la cita a marcar como ATENDIDA: ");
                        int idCita = Integer.parseInt(scanner.nextLine());
                        gestorCitas.marcarComoAtendida(idCita);
                        break;

                    case 5:
                        gestorCitas.consultarIngresos();
                        break;

                    case 6:
                        System.out.println("\nGenerando estadísticas del sistema...");
                        // Llamada a reportes si se pasa la lista de citas
                        break;

                    case 0:
                        System.out.println("Cerrando sesión de administrador...");
                        break;

                    default:
                        System.out.println("❌ Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }
}
