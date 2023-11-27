package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class InstitucionSQL extends ConexionSQL{
    //variables
    int id_institucion; 
    java.sql.Statement st;
    ResultSet rs; 

    public InstitucionSQL() {
        
    }
    
    //Ingresar datos de una nueva institucion 
    public void ingresarInstitucion(Institucion institucion){
        try{
            //Ingresar datos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into institucion(nombre) values('" +institucion.getNombre()+ "');";
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

    //Buscar Institucion
    public Institucion buscarInstitucion(int id_institucion){
        Institucion institucion = new Institucion();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from institucion where id_institucion = '"+id_institucion+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                institucion.setNombre(rs.getString("nombre"));       
            }else{
                institucion.setNombre(rs.getString(""));  
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return institucion;
    }  
}
