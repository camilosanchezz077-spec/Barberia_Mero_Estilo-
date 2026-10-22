package modelos;

public class Barbero {
    private String idBarbero;
    private String nombre;
    private String especialidad;  // Solo estos 3 ✅

    public Barbero() {}

    // ✅ Único constructor: 3 datos
    public Barbero(String idBarbero, String nombre, String especialidad) {
        this.idBarbero = idBarbero;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters
    public String getIdBarbero() { return idBarbero; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    // Setters
    public void setIdBarbero(String idBarbero) { this.idBarbero = idBarbero; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}