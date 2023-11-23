package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadoSQL extends ConexionSQL{
    //Atributos
    java.sql.Statement st;
    ResultSet rs;
    
    //Metodos 
    public EmpleadoSQL(){

    }

    //Ingresar datos de un nuevo empleado 
    public void ingresarEmpleado(Empleado empleado){
        try{
            //Ingresar datos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into empleado(no_cuenta,id_facultad,nombre,apellido_materno,apellido_paterno,clave,puesto) values('" +empleado.getId_empleado()+ "','"+empleado.getId_facultad()+"','"+empleado.getNombre()+"','"+empleado.getApellido_materno()+"','"+empleado.getApellido_paterno()+"','"+empleado.getClave()+"','"+empleado.getPuesto()+"');";
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
