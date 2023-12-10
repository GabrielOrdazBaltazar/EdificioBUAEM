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

    //Buscar Empleado
    public Empleado buscarEmpleado(int no_cuenta){
        Empleado empleado = new Empleado();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from empleado where no_cuenta = '"+no_cuenta+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                empleado.setId_empleado(rs.getInt("no_cuenta"));
                empleado.setId_facultad(rs.getInt("id_facultad"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_paterno(rs.getString("apellido_paterno"));
                empleado.setApellido_materno(rs.getString("apellido_materno"));
                empleado.setClave(rs.getString("clave"));
                empleado.setPuesto(rs.getString("puesto"));
                     
            }else{
                empleado.setId_empleado(rs.getInt(""));
                empleado.setId_facultad(rs.getInt(""));
                empleado.setNombre(rs.getString(""));
                empleado.setApellido_paterno(rs.getString(""));
                empleado.setApellido_materno(rs.getString(""));
                empleado.setClave(rs.getString(""));
                empleado.setPuesto(rs.getString(""));

                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return empleado;
    }
    
    //Actulizar Empleado
    public void actualizarEmpleado(int no_cuenta,Empleado empleado){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update empleado set id_facultad = '"+empleado.getId_facultad()+"', nombre = '"+empleado.getNombre()+"', apellido_paterno = '"+empleado.getApellido_paterno()+"', apellido_materno = '"+empleado.getApellido_materno()+"', clave = '"+empleado.getClave()+"', puesto = '"+empleado.getPuesto()+"' where no_cuenta = '"+no_cuenta+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }    
 
    //Eliminar Empleado
    public void eliminarEmpleado(int no_cuenta){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from empleado where no_cuenta = '"+no_cuenta+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }    
}
