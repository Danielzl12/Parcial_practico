package app.usuarios.clientes;

import app.usuarios.main.Usuario;

public class Cliente extends Usuario {
    private String direccion;
    private Mascota_clase mascota;

    public Cliente(int id, String nombre, String numero, String direccion, Mascota_clase mascota) {
        super(id, nombre, numero);
        this.direccion = direccion;
        this.mascota = mascota;
    }

    public String getDireccion() { return direccion; }
    public Mascota_clase getMascota() { return mascota; }
}