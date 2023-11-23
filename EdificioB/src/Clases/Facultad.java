package Clases;

public class Facultad {
    //Atributos 
    private int    id_institucion;
    private String nombre;

    //Metodos 
    public Facultad(){

    }

    public Facultad(int id_institucion, String nombre){
        this.id_institucion = id_institucion;
        this.nombre = nombre;
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }    

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
