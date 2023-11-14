/*
 * Clase Jefe
 */
package modelo;

public class Jefe {
    
    private int id;
    private String nombre;
    private String usuario;
    private String password;
    private String foto;
    private double sueldoAPagar;

    public Jefe(int id, String usuario, String password, String foto) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.foto = foto;
        this.sueldoAPagar = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getSueldoAPagar() {
        return sueldoAPagar;
    }

    public void setSueldoAPagar(double sueldoAPagar) {
        this.sueldoAPagar = sueldoAPagar;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (Jefe)";
    }
}
