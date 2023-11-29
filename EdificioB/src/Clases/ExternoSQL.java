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

     
}
