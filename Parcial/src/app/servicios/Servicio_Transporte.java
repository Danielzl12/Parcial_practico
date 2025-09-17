package app.servicios;

import app.usuarios.clientes.Cliente;
import app.usuarios.prestadores_de_servicio.Domiciliario;

public class Servicio_Transporte extends Servicio {
    private int distanciaKm;
    private static final double PRECIO_POR_KM = 1200;

    public Servicio_Transporte(int id, String origen, String destino, Cliente cliente, Domiciliario domiciliario, int distanciaKm) {
        super(id, origen, destino, cliente, domiciliario);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCosto() {
        return this.distanciaKm * PRECIO_POR_KM;
    }
}