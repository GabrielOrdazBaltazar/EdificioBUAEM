
package Clases;

public class EdificioB {
    //Atributos
    private int id_usuario;
    private int acervo_bibliografico;
    private int area_abierta_vitral;
    private int auto_acceso;
    private int area_estudio;

    //Metodos

    public EdificioB() {
    }

    public EdificioB(int id_usuario, int acervo_bibliografico, int area_abierta_vitral, int auto_acceso, int area_estudio) {
        this.id_usuario = id_usuario;
        this.acervo_bibliografico = acervo_bibliografico;
        this.area_abierta_vitral = area_abierta_vitral;
        this.auto_acceso = auto_acceso;
        this.area_estudio = area_estudio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getAcervo_bibliografico() {
        return acervo_bibliografico;
    }

    public void setAcervo_bibliografico(int acervo_bibliografico) {
        this.acervo_bibliografico = acervo_bibliografico;
    }

    public int getArea_abierta_vitral() {
        return area_abierta_vitral;
    }

    public void setArea_abierta_vitral(int area_abierta_vitral) {
        this.area_abierta_vitral = area_abierta_vitral;
    }

    public int getAuto_acceso() {
        return auto_acceso;
    }

    public void setAuto_acceso(int auto_acceso) {
        this.auto_acceso = auto_acceso;
    }

    public int getArea_estudio() {
        return area_estudio;
    }

    public void setArea_estudio(int area_estudio) {
        this.area_estudio = area_estudio;
    }
    
    
}
