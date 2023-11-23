package Clases;

public class Externo {
    //Atributos
    private int id_institucion;
    private String sexo;
    private String nivel_educativo;

    //Metodos
    public Externo(){

    }

    public Externo(int id_institucion, String sexo, String nivel_educativo) {
        this.id_institucion = id_institucion;
        this.sexo = sexo;
        this.nivel_educativo = nivel_educativo;
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNivel_educativo() {
        return nivel_educativo;
    }

    public void setNivel_educativo(String nivel_educativo) {
        this.nivel_educativo = nivel_educativo;
    }

}
