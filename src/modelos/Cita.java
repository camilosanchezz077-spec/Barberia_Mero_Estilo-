package modelos;

public class Cita {
    private int idCita;
    private Cliente cliente;
    private Barbero barbero;
    private Servicio servicio;
    private String fechaHora;
    private String estado;

    // Constructor completo
    public Cita(int idCita, Cliente cliente, Barbero barbero, Servicio servicio, String fechaHora, String estado) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicio = servicio;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    // Getters
    public int getIdCita() { return idCita; }
    public Cliente getCliente() { return cliente; }
    public Barbero getBarbero() { return barbero; }
    public Servicio getServicio() { return servicio; }
    public String getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }

    // Setters
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Cita #" + idCita + 
               " | Cliente: " + cliente.getNombre() +
               " | Barbero: " + barbero.getNombre() +
               " | Servicio: " + servicio.getNombreServicio() +
               " | Fecha: " + fechaHora +
               " | Estado: " + estado;
    }
}