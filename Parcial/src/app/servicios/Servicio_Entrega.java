package app.servicios;

import app.usuarios.clientes.Cliente;

public class Servicio_Entrega extends Servicio {
    private double valorProducto;
    private static final double COSTO_FIJO = 5000;
    private static final double PORCENTAJE_VALOR = 0.10; // 10%

    public Servicio_Entrega(int id, String origen, String destino, Cliente cliente, double valorProducto) {
        super(id, origen, destino, cliente);
        this.valorProducto = valorProducto;
    }

    @Override
    public double calcularCosto() {
        return COSTO_FIJO + (this.valorProducto * PORCENTAJE_VALOR);
    }
}