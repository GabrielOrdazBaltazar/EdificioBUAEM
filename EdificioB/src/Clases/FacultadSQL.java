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
    
    //Ingresar Datos
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

    //Buscar Facultad
    public Facultad buscarFacultad(int id_facultad){
        Facultad facultad = new Facultad();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from facultad where id_facultad = '"+id_facultad+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                facultad.setNombre(rs.getString("nombre"));
                facultad.setId_institucion(rs.getInt("id_institucion"));
            }else{
                facultad.setNombre(rs.getString(""));
                facultad.setId_institucion(rs.getInt(""));
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return facultad;
    }

    //Actulizar Facultad
    public void actualizarInstitucion(int id_facultad,Facultad facultad){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update facultad set id_institucion = '"+facultad.getId_institucion()+"', nombre = '"+facultad.getNombre()+"' where id_facultad = '"+id_facultad+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    } 
}
