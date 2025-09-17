package app.usuarios.main;

public abstract class Usuario {
    private int id;
    private String nombre;
    private String numero;

    public Usuario(int id, String nombre, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

//Get y set
    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }
    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
    public String getNumero() {
        return numero; }
    public void setNumero(String numero) {
        this.numero = numero; }
}