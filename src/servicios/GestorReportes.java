package servicios;

import modelos.Cita;
import java.util.ArrayList;

public class GestorReportes {

    // Generar reporte detallado de ingresos por citas atendidas
    public void generarReporteIngresos(ArrayList<Cita> listaCitas) {
        double totalIngresos = 0;
        int contadorAtendidas = 0;

        System.out.println("\n========================================");
        System.out.println("          REPORTE DE INGRESOS           ");
        System.out.println("========================================");

        if (listaCitas == null || listaCitas.isEmpty()) {
            System.out.println("No hay citas registradas en el sistema.");
            System.out.println("========================================");
            return;
        }

        for (Cita c : listaCitas) {
            if (c.getEstado() != null && c.getEstado().equalsIgnoreCase("Atendida")) {
                totalIngresos += c.getServicio().getPrecio();
                contadorAtendidas++;
            }
        }

        System.out.println("Total de citas atendidas: " + contadorAtendidas);
        System.out.println("Ingresos totales acumulados: $" + totalIngresos);
        System.out.println("========================================");
    }

    // Generar reporte del estado de todas las citas (Pendientes, Atendidas, Canceladas)
    public void generarReporteEstadoCitas(ArrayList<Cita> listaCitas) {
        System.out.println("\n========================================");
        System.out.println("        ESTADÍSTICAS GENERALES DE CITAS  ");
        System.out.println("========================================");

        if (listaCitas == null || listaCitas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            System.out.println("========================================");
            return;
        }

        int pendientes = 0;
        int atendidas = 0;
        int canceladas = 0;

        for (Cita c : listaCitas) {
            String estado = c.getEstado();
            if (estado != null) {
                if (estado.equalsIgnoreCase("Pendiente")) {
                    pendientes++;
                } else if (estado.equalsIgnoreCase("Atendida")) {
                    atendidas++;
                } else if (estado.equalsIgnoreCase("Cancelada")) {
                    canceladas++;
                }
            }
        }

        System.out.println("Total de citas en el sistema: " + listaCitas.size());
        System.out.println("- Pendientes: " + pendientes);
        System.out.println("- Atendidas: " + atendidas);
        System.out.println("- Canceladas: " + canceladas);
        System.out.println("========================================");
    }
}
