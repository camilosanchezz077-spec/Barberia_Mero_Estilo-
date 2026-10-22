package modelos;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String telefono;
    private String documento;
    private String observaciones;

    public Cliente() {}

    public Cliente(String idCliente, String nombre, String telefono, String documento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.observaciones = "";
    }

    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getDocumento() { return documento; }
    public String getObservaciones() { return observaciones; }

    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setDocumento(String documento) { this.documento = documento; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}