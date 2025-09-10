public class Administrador extends Usuario {

    public Administrador(int id, String nombre, String email) {
        super(id, nombre, email);
    }

    public void registrarNuevoDomiciliario(String nombre, String email, TipoVehiculo vehiculo) {
        System.out.println("Admin " + getNombre() + " ha registrado a un nuevo domiciliario.");
    }
}