public class Domiciliario extends Usuario {
    private TipoVehiculo tipoVehiculo;
    private double calificacionConductor;

    public Domiciliario(int id, String nombre, String email, TipoVehiculo tipoVehiculo) {
        super(id, nombre, email);
        this.tipoVehiculo = tipoVehiculo;
        this.calificacionConductor = 0;
    }

    public void aceptarServicio() {
        System.out.println("El domiciliario " + getNombre() + " ha aceptado un servicio.");
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo; }
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo; }
    public double getCalificacionConductor() {
        return calificacionConductor; }
    public void setCalificacionConductor(double calificacionConductor) {
        this.calificacionConductor = calificacionConductor; }
}