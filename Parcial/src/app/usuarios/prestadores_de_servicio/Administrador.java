package app.usuarios.prestadores_de_servicio;

import app.usuarios.main.Usuario;
import app.vehiculos.TipoVehiculo;

public class Administrador extends Usuario {

    public Administrador(int id, String nombre, String email) {
        super(id, nombre, email);
    }

    public void registrarNuevoDomiciliario(String nombre, String email, TipoVehiculo vehiculo) {
    }
}