package app.servicios;

import app.usuarios.clientes.Cliente;

public class ServicioVacunacion extends Servicio {
    public static final double TARIFA_BASE = 30000;
    public static final double COSTO_FIJO_VACUNA = 15000;

    private static final double PRECIO_POR_KM = 1000;
    private final int distanciaKm;

    public ServicioVacunacion(int id, String origen, String destino, Cliente cliente, int distanciaKm) {
        super(id, origen, destino, cliente);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCosto() {
        double costoVisita = this.distanciaKm * PRECIO_POR_KM;
        return TARIFA_BASE + COSTO_FIJO_VACUNA + costoVisita;
    }
}