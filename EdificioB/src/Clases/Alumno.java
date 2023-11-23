package Clases;

public class Alumno {
    //Atributos
    private int no_cuenta;
    private int id_facultad;
    private String nombre;
    private String apellido_materno;
    private String apellido_paterno;
    private String clave;
    private String periodo_ingreso;
    private String periodo_egreso;
    private String sexo;

    //Metodos
    public Alumno(){
    
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
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

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPeriodo_ingreso() {
        return periodo_ingreso;
    }

    public void setPeriodo_ingreso(String periodo_ingreso) {
        this.periodo_ingreso = periodo_ingreso;
    }

    public String getPeriodo_egreso() {
        return periodo_egreso;
    }

    public void setPeriodo_egreso(String periodo_egreso) {
        this.periodo_egreso = periodo_egreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}