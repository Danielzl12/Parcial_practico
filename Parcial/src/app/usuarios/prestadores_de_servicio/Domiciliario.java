package app.usuarios.prestadores_de_servicio;

import app.usuarios.main.Usuario;
import app.vehiculos.TipoVehiculo;

public class Domiciliario extends Usuario {
    private TipoVehiculo vehiculo;
    private double calificacion;
    private boolean disponible = true;

    public Domiciliario(int id, String nombre, String numero, TipoVehiculo vehiculo) {
        super(id, nombre, numero);
        this.vehiculo = vehiculo;
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public TipoVehiculo getVehiculo() { return vehiculo; }
    public double getCalificacion() { return calificacion; }
}