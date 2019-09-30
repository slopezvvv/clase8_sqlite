package cl.tuserver.clase8_sqlite.DTO;

public class Usuario {
    private final int rut;
    private String nombre, email;

    public Usuario(int rut, String nombre){
        this.rut = rut;
        setNombre(nombre);
    }

    public int getRut() {
        return rut;
    }

    public String getEmail(){
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email){
        if(!email.isEmpty())
            this.email = email;
    }
}
