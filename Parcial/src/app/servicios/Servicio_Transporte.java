package app.servicios;

import app.usuarios.clientes.Cliente;

public class Servicio_Transporte extends Servicio {
    private int distanciaKm;
    private static final double PRECIO_POR_KM = 1200;

    public Servicio_Transporte(int id, String origen, String destino, Cliente cliente, int distanciaKm) {
        super(id, origen, destino, cliente);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCosto() {
        return this.distanciaKm * PRECIO_POR_KM;
    }
}