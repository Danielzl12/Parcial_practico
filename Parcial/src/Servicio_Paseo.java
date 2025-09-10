public class Servicio_Paseo extends Servicio {
    private int horasDelPaseo;
    private int PRECIO_POR_MEDIA_HORA = 8000;

    public Servicio_Paseo(int id, String origen, String destino, Cliente cliente, Domiciliario domiciliario, int horasDelPaseo) {
        super(id, origen, destino, cliente, domiciliario);
        this.horasDelPaseo = horasDelPaseo;
    }

    @Override
    public double calcularCosto() {
        return this.horasDelPaseo * PRECIO_POR_MEDIA_HORA;
    }
}