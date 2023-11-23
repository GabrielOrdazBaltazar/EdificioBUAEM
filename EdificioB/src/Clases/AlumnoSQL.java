package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlumnoSQL extends ConexionSQL{
    //variables
    java.sql.Statement st;
    ResultSet rs;  

    public AlumnoSQL() {
        
    }

    //Ingresar datos nuevo alumno
    public void ingresarAlumno(Alumno alumno){
        try{
            //Guardando los datos en la BD
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into alumno(no_cuenta,id_facultad,nombre,apellido_materno,apellido_paterno,clave,periodo_ingreso,periodo_egreso,sexo) "+"values('" +alumno.getNo_cuenta()+ "','" +alumno.getId_facultad()+ "','"+alumno.getNombre()+"','"+alumno.getApellido_materno()+"','"+alumno.getApellido_paterno()+"','"+alumno.getClave()+"','"+alumno.getPeriodo_ingreso()+"','"+alumno.getPeriodo_egreso()+"','"+alumno.getSexo()+"');";
            
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
