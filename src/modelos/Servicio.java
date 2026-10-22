package modelos;

public class Servicio {
    private String nombreServicio;
    private double precio;
    private int duracionMinutos; // Duración en minutos según las reglas del negocio

    // Constructor vacío
    public Servicio() {
    }

    // Constructor con parámetros
    public Servicio(String nombreServicio, double precio, int duracionMinutos) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
    }

    // Getters y Setters
    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public String toString() {
        return "Servicio [Nombre=" + nombreServicio + ", Precio=$" + precio + ", Duración=" + duracionMinutos + " mins]";
    }
}