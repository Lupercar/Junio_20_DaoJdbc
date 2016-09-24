package entidades;

public class Cliente {
    private int id;
    private String nombre;

    public Cliente() {
    }
    
    public Cliente(int id, String nombre) {
        super();
        this.setId(id);
        this.setNombre(nombre);
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + 
                "id=" + this.getId() + 
                ", nombre=" + this.getNombre() + 
                '}';
    }
}//fin class entidades.Cliente
