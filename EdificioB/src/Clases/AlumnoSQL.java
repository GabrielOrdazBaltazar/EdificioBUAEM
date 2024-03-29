package Clases;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlumnoSQL extends ConexionSQL{
    //Atributos
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

    //Buscar Alumno 
    public Alumno buscarAlumno(int no_cuenta){
        Alumno alumno = new Alumno();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from alumno where no_cuenta = '"+no_cuenta+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                alumno.setNo_cuenta(rs.getInt("no_cuenta"));
                alumno.setId_facultad(rs.getInt("id_facultad"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_paterno(rs.getString("apellido_paterno"));
                alumno.setApellido_materno(rs.getString("apellido_materno"));
                alumno.setClave(rs.getString("clave"));
                alumno.setPeriodo_ingreso(rs.getString("periodo_ingreso"));
                alumno.setPeriodo_egreso(rs.getString("periodo_egreso"));
                alumno.setSexo(rs.getString("sexo"));

            }else{
                alumno.setNo_cuenta(rs.getInt(""));
                alumno.setId_facultad(rs.getInt(""));
                alumno.setNombre(rs.getString(""));
                alumno.setApellido_paterno(rs.getString("")); 
                alumno.setApellido_materno(rs.getString("")); 
                alumno.setClave(rs.getString(""));
                alumno.setPeriodo_ingreso(rs.getString(""));
                alumno.setPeriodo_egreso(rs.getString(""));
                alumno.setSexo(rs.getString(""));

                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return alumno;
    } 
    
    //Actulizar Alumno
    public void actualizarAlumno(int no_cuenta,Alumno alumno){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update alumno set id_facultad = '"+alumno.getId_facultad()+"', nombre = '"+alumno.getNombre()+"', apellido_paterno = '"+alumno.getApellido_paterno()+"', apellido_materno = '"+alumno.getApellido_materno()+"', clave = '"+alumno.getClave()+"', periodo_ingreso = '"+alumno.getPeriodo_ingreso()+"', periodo_egreso = '"+alumno.getPeriodo_egreso()+"', sexo = '"+alumno.getSexo()+"' where no_cuenta = '"+no_cuenta+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }  
    
    //Eliminar Facultad
    public void eliminarAlumno(int no_cuenta){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from alumno where no_cuenta = '"+no_cuenta+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }     
}
