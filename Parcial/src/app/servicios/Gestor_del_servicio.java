package app.servicios;

import app.usuarios.clientes.Cliente;
import app.usuarios.clientes.Mascota_clase;
import app.usuarios.prestadores_de_servicio.Domiciliario;
import app.vehiculos.TipoVehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gestor_del_servicio {
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Domiciliario> domiciliarios = new ArrayList<>();
    private final List<Servicio> servicios = new ArrayList<>();
    private int seqCliente = 1, seqDomiciliario = 1, seqServicio = 1;

    public Cliente registrarCliente(String nombre, String numero, String direccion, Mascota_clase mascota) {
        Cliente nuevoCliente = new Cliente(seqCliente++, nombre, numero, direccion, mascota);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    public Domiciliario registrarDomiciliario(String nombre, String numero, TipoVehiculo vehiculo) {
        Domiciliario nuevoDomiciliario = new Domiciliario(seqDomiciliario++, nombre, numero, vehiculo);
        domiciliarios.add(nuevoDomiciliario);
        return nuevoDomiciliario;
    }

    public List<Cliente> getClientes() { return clientes; }

    private Domiciliario tomarDisponible() {
        return domiciliarios.stream()
                .filter(Domiciliario::isDisponible)
                .findFirst()
                .orElse(null);
    }

    public Servicio crearServicioVacunacion(int idCliente, String origen, String destino, int distanciaKm) {
        Cliente clienteAsociado = clientes.stream()
                .filter(cliente -> cliente.getId() == idCliente)
                .findFirst()
                .orElse(null);
        if (clienteAsociado == null) return null;

        Servicio nuevoServicio = new ServicioVacunacion(seqServicio++, origen, destino, clienteAsociado, distanciaKm);
        servicios.add(nuevoServicio);
        return nuevoServicio;
    }

    public Servicio crearOtroServicio(int tipo, int idCliente, String origen, String destino, double valorVariable) {
        Cliente clienteAsociado = clientes.stream()
                .filter(cliente -> cliente.getId() == idCliente)
                .findFirst()
                .orElse(null);
        if (clienteAsociado == null) return null;

        Servicio nuevoServicio = null;
        switch (tipo) {
            case 1 -> nuevoServicio = new Servicio_Transporte(seqServicio++, origen, destino, clienteAsociado, (int) valorVariable);
            case 2 -> nuevoServicio = new Servicio_Paseo(seqServicio++, origen, destino, clienteAsociado, (int) valorVariable);
            case 3 -> nuevoServicio = new Servicio_Entrega(seqServicio++, origen, destino, clienteAsociado, valorVariable);
        }

        if (nuevoServicio != null) {
            servicios.add(nuevoServicio);
        }
        return nuevoServicio;
    }

    public int asignarServiciosPendientes() {
        int contadorAsignados = 0;
        List<Servicio> serviciosPendientes = servicios.stream()
                .filter(servicio -> servicio.getEstado() == EstadoServicio.PENDIENTE)
                .collect(Collectors.toList());

        for (Servicio servicio : serviciosPendientes) {
            Domiciliario domiciliarioDisponible = tomarDisponible();
            if (domiciliarioDisponible != null) {
                servicio.asignarDomiciliario(domiciliarioDisponible);
                System.out.println("Servicio ID " + servicio.getId() + " asignado a " + domiciliarioDisponible.getNombre() + ". En progreso...");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                servicio.estado = EstadoServicio.COMPLETADO;
                domiciliarioDisponible.setDisponible(true);
                System.out.println("Servicio ID " + servicio.getId() + " completado.");

                contadorAsignados++;
            } else {
                System.out.println("No hay más domiciliarios disponibles.");
                break;
            }
        }
        return contadorAsignados;
    }

    public List<Servicio> getServiciosCompletados() {
        return servicios.stream()
                .filter(servicio -> servicio.getEstado() == EstadoServicio.COMPLETADO)
                .collect(Collectors.toList());
    }

    public double getCostoTotalServiciosCompletados() {
        return getServiciosCompletados().stream()
                .mapToDouble(Servicio::calcularCosto)
                .sum();
    }
}