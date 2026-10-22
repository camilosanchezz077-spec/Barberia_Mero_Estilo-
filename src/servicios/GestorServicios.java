package servicios;

import modelos.Servicio;
import java.util.ArrayList;

public class GestorServicios {
    private ArrayList<Servicio> listaServicios;

    public GestorServicios() {
        this.listaServicios = new ArrayList<>();
    }

    public boolean registrarServicio(String nombreServicio, double precio, int duracionMinutos) {
        if (precio <= 0) {
            System.out.println("❌ Error: El precio debe ser mayor a cero.");
            return false;
        }

        if (duracionMinutos <= 0) {
            System.out.println("❌ Error: La duración debe ser mayor a cero.");
            return false;
        }

        Servicio nuevoServicio = new Servicio(nombreServicio, precio, duracionMinutos);
        listaServicios.add(nuevoServicio);
        System.out.println("✅ ¡Servicio registrado con éxito!");
        return true;
    }

    public void listarServicios() {
        if (listaServicios.isEmpty()) {
            System.out.println("⚠️ No hay servicios registrados en el catálogo.");
            return;
        }

        System.out.println("\n--- CATÁLOGO DE SERVICIOS ---");
        for (Servicio servicio : listaServicios) {
            System.out.println(servicio);
        }
        System.out.println("-----------------------------");
    }
}
