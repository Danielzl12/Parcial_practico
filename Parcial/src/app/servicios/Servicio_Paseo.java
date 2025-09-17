package app.servicios;

import app.usuarios.clientes.Cliente;

public class Servicio_Paseo extends Servicio {
    private int cantidadMediasHoras;
    private static final double PRECIO_POR_MEDIA_HORA = 8000;

    public Servicio_Paseo(int id, String origen, String destino, Cliente cliente, int cantidadMediasHoras) {
        super(id, origen, destino, cliente);
        this.cantidadMediasHoras = cantidadMediasHoras;
    }

    @Override
    public double calcularCosto() {
        return this.cantidadMediasHoras * PRECIO_POR_MEDIA_HORA;
    }
}