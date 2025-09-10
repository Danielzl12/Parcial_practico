public class Mascota_clase {
    private String nombre;
    private String raza;

    public Mascota_clase(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
}