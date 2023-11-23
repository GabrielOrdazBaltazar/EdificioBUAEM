
package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class InstitucionSQL extends ConexionSQL{
    //variables
    private int id_institucion; 
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
    
}
