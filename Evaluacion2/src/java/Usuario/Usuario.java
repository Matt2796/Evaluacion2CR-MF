package Usuario;

public class Usuario {
    private String run;
    private String nombre;
    private String apellido;
    private String password;

    public Usuario() {
    }

    public Usuario(String run, String nombre, String apellido, String password) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
