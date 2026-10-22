package servicios;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;

public class GestorClientes {

private final List<Cliente> clientes = new ArrayList<>();

// Registrar un cliente
public boolean registrarCliente(String nombre, String documento,
String telefono, String observaciones) {

if (buscarCliente(documento) != null) {
System.out.println("Error: el documento ya está registrado.");
return false;
}

try {
Cliente nuevo = new Cliente(
nombre, documento, telefono, observaciones
);

clientes.add(nuevo);
System.out.println("Cliente registrado correctamente.");
return true;

} catch (IllegalArgumentException e) {
System.out.println("Error: " + e.getMessage());
return false;
}
}

// Listar todos los clientes
public void listarClientes() {
if (clientes.isEmpty()) {
System.out.println("No hay clientes registrados.");
return;
}

for (Cliente cliente : clientes) {
System.out.println(cliente);
}
}

// Buscar un cliente por documento
public Cliente buscarCliente(String documento) {
if (documento == null || documento.trim().isEmpty()) {
return null;
}

for (Cliente cliente : clientes) {
if (cliente.getDocumento()
.equalsIgnoreCase(documento.trim())) {
return cliente;
}
}

return null;
}

// Consultar un cliente
public void consultarCliente(String documento) {
Cliente cliente = buscarCliente(documento);

if (cliente == null) {
System.out.println("Cliente no encontrado.");
} else {
System.out.println(cliente);
}
}

// Actualizar los datos de un cliente
public boolean actualizarCliente(String documento,
String nuevoNombre,
String nuevoTelefono,
String nuevasObservaciones) {

Cliente cliente = buscarCliente(documento);

if (cliente == null) {
System.out.println("Cliente no encontrado.");
return false;
}

// Validamos todos los datos antes de modificar el objeto.
if (nuevoNombre == null || nuevoNombre.trim().isEmpty()
|| nuevoTelefono == null
|| nuevoTelefono.trim().isEmpty()) {
System.out.println("El nombre y el teléfono son obligatorios.");
return false;
}

cliente.setNombre(nuevoNombre);
cliente.setTelefono(nuevoTelefono);
cliente.setObservaciones(nuevasObservaciones);

System.out.println("Cliente actualizado correctamente.");
return true;
}

// Permite que otro módulo consulte la lista sin modificarla.
public List<Cliente> obtenerClientes() {
return new ArrayList<>(clientes);
}
}
