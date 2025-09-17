package app.usuarios.main;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String numero; // Añadido según UML

    public Usuario(int id, String nombre, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNumero() { return numero; }
}