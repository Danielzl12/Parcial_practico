public class Cliente extends Usuario {
    private String direccion;
    private Mascota_clase mascotaClase;

    public Cliente(int id, String nombre, String email, String direccion, Mascota_clase mascotaClase) {
        super(id, nombre, email);
        this.direccion = direccion;
        this.mascotaClase = mascotaClase;
    }

    public void solicitarServicio() {
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = direccion; }
    public Mascota_clase getMascota() {
        return mascotaClase; }
    public void setMascota(Mascota_clase mascotaClase) {
        this.mascotaClase = mascotaClase; }
}