
package Clases;
//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class EdificioBSQL extends ConexionSQL{
    //variables
    int id_edifcioB; 
    java.sql.Statement st;
    ResultSet rs;     

    public EdificioBSQL() {
        
    }
    
    //Ingresar datos de una nueva institucion 
    public void ingresarEdificioB(EdificioB edificioB){
        try{
            //Ingresar datos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into edificiob (id_usuario,acervo_bibliografico,area_abierta_vitral,auto_acceso,area_estudio) values('" +edificioB.getId_usuario()+ "','"+edificioB.getAcervo_bibliografico()+"','"+edificioB.getArea_abierta_vitral()+"','"+edificioB.getAuto_acceso()+"','"+edificioB.getArea_estudio()+"');";
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
