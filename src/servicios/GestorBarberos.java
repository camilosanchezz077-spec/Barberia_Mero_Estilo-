package servicios;

import modelos.Barbero;
import java.util.ArrayList;

public class GestorBarberos {
    
    private ArrayList<Barbero> listaBarberos;

    
    public GestorBarberos() {
        this.listaBarberos = new ArrayList<>();
    }

    
    public Barbero buscarPorId(String idBarbero) {
        for (Barbero barbero : listaBarberos) {
            if (barbero.getIdBarbero().equalsIgnoreCase(idBarbero)) {
                return barbero; 
            }
        }
        return null; 
    }

    
    public boolean registrarBarbero(String idBarbero, String nombre, String especialidad) {
        
        if (buscarPorId(idBarbero) != null) {
            System.out.println("❌ Error: Ya existe un barbero registrado con el ID " + idBarbero);
            return false;
        }

        
        Barbero nuevoBarbero = new Barbero(idBarbero, nombre, especialidad);
        
        
        listaBarberos.add(nuevoBarbero);
        System.out.println("✅ ¡Barbero " + nombre + " registrado con éxito!");
        return true;
    }


    public void listarBarberos() {
        if (listaBarberos.isEmpty()) {
            System.out.println("⚠️ No hay barberos registrados en el sistema.");
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("       LISTA DE BARBEROS REGISTRADOS       ");
        System.out.println("==========================================");
        
        for (Barbero barbero : listaBarberos) {
            System.out.println(barbero); 
        }
        System.out.println("==========================================\n");
    }
}