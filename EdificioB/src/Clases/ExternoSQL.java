package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExternoSQL extends ConexionSQL{
    //Atributos
    int id_externo;
    java.sql.Statement st;
    ResultSet rs;    
    
    //Metodos 
    public ExternoSQL(){

    }

    //Ingresar usuario externo
    public void ingresarExterno(Externo externo){
        try{
            //Ingresar datos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into externo(id_institucion,sexo,nivel_educativo) values('" +externo.getId_institucion()+ "','"+externo.getSexo()+"','"+externo.getNivel_educativo()+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();
                      
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);        
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    //Buscar Externo
    public Externo buscarExterno(int id_externo){
        Externo externo = new Externo();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from externo where id_externo = '"+id_externo+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                externo.setId_institucion(rs.getInt("id_institucion"));
                externo.setSexo(rs.getString("sexo"));
                externo.setNivel_educativo(rs.getString("nivel_educativo"));
                     
            }else{
                externo.setSexo(rs.getString(""));
                externo.setNivel_educativo(rs.getString(""));

                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return externo;
    }
     
    //Actulizar Externo
    public void actualizarExterno(int id_externo,Externo externo){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update externo set id_institucion = '"+externo.getId_institucion()+"', sexo = '"+externo.getSexo()+"', nivel_educativo = '"+externo.getNivel_educativo()+"' where id_externo = '"+id_externo+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }
    
    //Eliminar Externo
    public void eliminarExterno(int id_externo){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from externo where id_externo = '"+id_externo+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }    
}
