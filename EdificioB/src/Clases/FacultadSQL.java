package Clases;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class FacultadSQL extends ConexionSQL {
    //variables
    private int id_facultad;
    java.sql.Statement st;
    ResultSet rs;

    //Metodos 
    public FacultadSQL(){

    }

    public void ingresarFacultad(Facultad facultad){
        try{
            //Guardando los datos en la BD
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into facultad(id_institucion,nombre) "+"values('" +facultad.getId_institucion()+ "','"+facultad.getNombre()+"');";            
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();           
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }    


}
