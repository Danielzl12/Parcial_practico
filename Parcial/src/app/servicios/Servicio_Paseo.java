package app.servicios;

import app.usuarios.clientes.Cliente;

public class Servicio_Paseo extends Servicio {
    private int cantidadHoras;
    private static final double PRECIO_POR_HORA = 16000;

    public Servicio_Paseo(int id, String origen, String destino, Cliente cliente, int cantidadHoras) {
        super(id, origen, destino, cliente);
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public double calcularCosto() {
        return this.cantidadHoras * PRECIO_POR_HORA;
    }
}