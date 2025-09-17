package app.servicios;

import app.usuarios.clientes.Cliente;
import app.usuarios.prestadores_de_servicio.Domiciliario;

public abstract class Servicio {
    protected int id;
    protected String direccion_origen;
    protected String direccion_destino;
    protected Cliente cliente;
    protected Domiciliario domiciliario;

    public Servicio(int id, String direccion_origen, String direccion_destino, Cliente cliente, Domiciliario domiciliario) {
        this.id = id;
        this.direccion_origen = direccion_origen;
        this.direccion_destino = direccion_destino;
        this.cliente = cliente;
        this.domiciliario = domiciliario;
    }

    public abstract double calcularCosto();

    // Getters y Setters
    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }
    public String getDireccion_origen() {
        return direccion_origen; }
    public void setDireccion_origen(String direccion_origen) {
        this.direccion_origen = direccion_origen; }
    public String getDireccion_destino() {
        return direccion_destino; }
    public void setDireccion_destino(String direccion_destino) {
        this.direccion_destino = direccion_destino; }
}