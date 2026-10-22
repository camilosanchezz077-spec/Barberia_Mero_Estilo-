package servicios;

import modelos.Cita;
import modelos.Barbero;
import java.util.ArrayList;

public class GestorCitas {
    private ArrayList<Cita> listaCitas = new ArrayList<>();

    // : Reservar una cita (evitando cruces)
    public boolean reservarCita(Cita nuevaCita) {
        for (Cita c : listaCitas) {
            if (c.getBarbero().getNombre().equalsIgnoreCase(nuevaCita.getBarbero().getNombre()) &&
                c.getFechaHora().equals(nuevaCita.getFechaHora()) &&
                !c.getEstado().equalsIgnoreCase("Cancelada")) {
                
                System.out.println("Error: El barbero ya tiene una cita en este horario.");
                return false;
            }
        }
        listaCitas.add(nuevaCita);
        System.out.println("Cita reservada con éxito. ID: " + nuevaCita.getIdCita());
        return true;
    }

    // HU-05: Consultar la agenda general
    public void consultarAgendaGeneral() {
        System.out.println("\n--- AGENDA GENERAL DE CITAS ---");
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        for (Cita c : listaCitas) {
            System.out.println(c.toString());
        }
    }

    // HU-12 Parte A: Marcar cita como atendida
    public boolean marcarComoAtendida(int idCita) {
        for (Cita c : listaCitas) {
            if (c.getIdCita() == idCita) {
                c.setEstado("Atendida");
                System.out.println("✅ Cita #" + idCita + " marcada como ATENDIDA.");
                return true;
            }
        }
        System.out.println("❌ Cita no encontrada.");
        return false;
    }

    // HU-12 Parte B: Consultar ingresos
    public void consultarIngresos() {
        double totalIngresos = 0;
        int contador = 0;
        for (Cita c : listaCitas) {
            if (c.getEstado().equalsIgnoreCase("Atendida")) {
                totalIngresos += c.getServicio().getPrecio();
                contador++;
            }
        }
        System.out.println("\n--- REPORTE DE INGRESOS ---");
        System.out.println("Citas atendidas: " + contador);
        System.out.println("Total de ingresos: $" + totalIngresos);
    }
    
    // HU-06: Consultar agenda e historial personal del barbero
    public void consultarAgendaBarbero(String nombreBarbero) {
        System.out.println("\n==========================================");
        System.out.println("   AGENDA E HISTORIAL PARA: " + nombreBarbero);
        System.out.println("==========================================");
        
        boolean encontrada = false;

        for (Cita c : listaCitas) {
            if (c.getBarbero().getNombre().equalsIgnoreCase(nombreBarbero)) {
                encontrada = true;
                
                System.out.println("• ID Cita: " + c.getIdCita() + 
                                    " | Fecha/Hora: " + c.getFechaHora() + 
                                    " | Servicio: " + c.getServicio().getNombreServicio() + 
                                    " | Estado: " + c.getEstado());
            }
        }

        if (!encontrada) {
            System.out.println("⚠️ No tienes citas registradas en este momento.");
        }
        System.out.println("==========================================\n");
    }

    // HU-08: Consultar barberos disponibles para una fecha y hora específica
    public void verBarberosDisponibles(String fechaHoraDeseada, ArrayList<Barbero> listaGeneralBarberos) {
        System.out.println("\n==========================================");
        System.out.println("   BARBEROS DISPONIBLES PARA: " + fechaHoraDeseada);
        System.out.println("==========================================");

        boolean hayDisponibles = false;

        // Recorremos todos los barberos registrados en el sistema
        for (Barbero barbero : listaGeneralBarberos) {
            boolean estaOcupado = false;

            // Revisamos las citas para ver si este barbero tiene cruce en ese horario
            for (Cita c : listaCitas) {
                if (c.getBarbero().getIdBarbero().equalsIgnoreCase(barbero.getIdBarbero()) &&
                    c.getFechaHora().equals(fechaHoraDeseada) &&
                    !c.getEstado().equalsIgnoreCase("Cancelada")) { // Las canceladas no ocupan espacio
                    
                    estaOcupado = true;
                    break; // Salimos del ciclo de citas porque ya encontramos un cruce
                }
            }

            // Si el barbero no está ocupado, lo imprimimos como disponible
            if (!estaOcupado) {
                hayDisponibles = true;
                System.out.println("✅ ID: " + barbero.getIdBarbero() + 
                                    " | Nombre: " + barbero.getNombre() + 
                                    " | Especialidad: " + barbero.getEspecialidad());
            }
        }

        // Si ningún barbero pasó el filtro, informamos al cliente
        if (!hayDisponibles) {
            System.out.println("⚠️ Lo sentimos, no hay barberos disponibles para este horario.");
        }
        System.out.println("==========================================\n");
    }
}