import java.util.Scanner;

import menus.MenuAdministrador;
import menus.MenuBarbero;
import menus.MenuCliente;

import servicios.GestorCitas;
import servicios.GestorBarberos;
import servicios.GestorClientes;
import servicios.GestorReportes;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Gestores principales del sistema
        GestorCitas gestorCitas = new GestorCitas();
        GestorBarberos gestorBarberos = new GestorBarberos();
        GestorClientes gestorClientes = new GestorClientes();
        GestorReportes gestorReportes = new GestorReportes();

        int opcion;

        do {
            System.out.println("\n======================================");
            System.out.println("       BARBERÍA MERO ESTILO");
            System.out.println("======================================");
            System.out.println("1. Ingresar como Cliente");
            System.out.println("2. Ingresar como Barbero");
            System.out.println("3. Ingresar como Administrador");
            System.out.println("0. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        MenuCliente menuCliente = new MenuCliente(gestorCitas);
                        menuCliente.mostrar();
                        break;

                    case 2:
                        MenuBarbero.mostrarMenuBarbero(scanner, gestorCitas);
                        break;

                    case 3:
                        MenuAdministrador.mostrarMenu(
                                scanner,
                                gestorCitas,
                                gestorBarberos,
                                gestorClientes,
                                gestorReportes
                        );
                        break;

                    case 0:
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        System.out.println(" Opción inválida.");

                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                opcion = -1;
            }

        } while (opcion != 0);

        scanner.close();
    }
}