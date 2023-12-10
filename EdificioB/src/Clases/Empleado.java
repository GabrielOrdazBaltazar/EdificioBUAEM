package Clases;

public class Empleado {
    //Atributos
    private int id_empleado;
    private int id_facultad;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String clave;
    private String puesto;

    //Metodos
    public Empleado(){
        
    }

    public Empleado(int id_empleado, int id_facultad, String nombre, String apellido_paterno, String apellido_materno, String clave, String puesto) {
        this.id_empleado = id_empleado;
        this.id_facultad = id_facultad;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.clave = clave;
        this.puesto = puesto;
    }
    

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    

    
}
