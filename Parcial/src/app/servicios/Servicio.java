package app.servicios;

import app.usuarios.clientes.Cliente;
import app.usuarios.prestadores_de_servicio.Domiciliario;

public abstract class Servicio {
    protected int id;
    protected String origen;
    protected String destino;
    protected Cliente cliente;
    protected Domiciliario domiciliario;
    protected EstadoServicio estado = EstadoServicio.PENDIENTE;

    public Servicio(int id, String origen, String destino, Cliente cliente) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.cliente = cliente;
    }

    public abstract double calcularCosto();

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Domiciliario getDomiciliario() { return domiciliario; }
    public EstadoServicio getEstado() { return estado; }

    // Setters
    public void asignarDomiciliario(Domiciliario domiciliarioAsignado) {
        if (domiciliarioAsignado != null && domiciliarioAsignado.isDisponible()) {
            this.domiciliario = domiciliarioAsignado;
            this.estado = EstadoServicio.EN_PROGRESO;
            domiciliarioAsignado.setDisponible(false);
        }
    }
}