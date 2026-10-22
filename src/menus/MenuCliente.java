package menus;

import servicios.GestorCitas;
import utilidades.Validador;
import java.util.Scanner;

public class MenuCliente {
    
    private GestorCitas gestorCitas;
    private Scanner scanner;

    public MenuCliente(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n======================================");
            System.out.println("        👤 MENÚ DE CLIENTE            ");
            System.out.println("======================================");
            System.out.println("1. Reservar nueva cita");
            System.out.println("2. Consultar mis citas");
            System.out.println("3. Cancelar cita");
            System.out.println("4. Volver al menú principal");
            System.out.println("======================================");
            opcion = Validador.leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    reservarCita();
                    break;
                case 2:
                    consultarMisCitas();
                    break;
                case 3:
                    cancelarCita();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private void reservarCita() {
        System.out.println("\n--- 📅 Reservar Cita ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese fecha y hora (ej: 2026-10-25 10:00): ");
        String fechaHora = scanner.nextLine();
        
        System.out.println("✅ Gracias " + nombre + ", su cita quedó agendada para: " + fechaHora);
    }

    private void consultarMisCitas() {
        System.out.println("\n--- 📋 Mis Citas ---");
        System.out.print("Ingrese su documento o nombre: ");
        String dato = scanner.nextLine();
        System.out.println("✅ Buscando citas para: " + dato);
        gestorCitas.consultarAgendaGeneral();
    }

    private void cancelarCita() {
        System.out.println("\n--- ❌ Cancelar Cita ---");
        int id = Validador.leerEntero(scanner, "Ingrese el ID de la cita a cancelar: ");
        System.out.println("✅ Solicitud de cancelación enviada para cita #" + id);
    }
}