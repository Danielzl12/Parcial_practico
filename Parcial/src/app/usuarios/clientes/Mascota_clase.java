package app.usuarios.clientes;

public class Mascota_clase {
    private String nombre;
    private String raza;

    public Mascota_clase(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }

    @Override
    public String toString() {
        return nombre + " (" + raza + ")";
    }
}