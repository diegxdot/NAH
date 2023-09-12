
package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO extends Conexion{
    //Metodo para ingresar al login
    public boolean login(Empleado empleado){
        //SQL
        PreparedStatement statement =null;
        ResultSet resultSet = null;

        Connection connection = (Connection) getConnection();
        //Se declara una lista de objetos para guardar los registros de los productos 

        String sql = "SELECT ID from empleado where Usuario=? and Contrasena=?";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, empleado.getUsuario());
            statement.setString(2, empleado.getContrasena());
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                empleado.setId(Integer.parseInt(resultSet.getString("id")));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean registrar(Empleado emp){
        //Declaramos objeto para la preparacion del estado
        PreparedStatement statement= null;
        //Establecemos conexion con la base de datos
        Connection connection = (Connection) getConnection();
        //Sentencia sql para el alta de productos
        String sql = "INSERT into empleado (Nombre, Apellido_Paterno, Apellido_Materno, Telefono, Sueldo, usuario, contrasena) VALUES(?,?,?,?,?,?,?)";
        try{
            //Se establece la consulta para la cadena sql
            statement = (PreparedStatement) connection.prepareStatement(sql);
            //Se van a sustituir los ? por codigo
            statement.setString(1, emp.getNombre());
            statement.setString(2, emp.getApellidoP());
            statement.setString(3, emp.getApellidoM());
            statement.setString(4, emp.getTelefono());
            statement.setInt(5, emp.getSueldo());
            statement.setString(6, emp.getUsuario());
            statement.setString(7, emp.getContrasena());
            //Se ejecuta la consola
            statement.execute();
            //En caso de que la consulta se realice se muestra un true
            return true;
        }catch(SQLException e){
            //Si se presenta algun error se atrapa y se imprime
            System.err.println(e);
            return false;
        }finally{
            try{
                connection.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    public List listar(){
        PreparedStatement statement =null;
        ResultSet resultSet = null;

        Connection connection = (Connection) getConnection();
        //Se declara una lista de objetos para guardar los registros de los productos 
        List<Empleado> datos = new ArrayList<>();

        String sql = "SELECT * from empleado";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                Empleado emp = new Empleado();
                emp.setId(Integer.parseInt(resultSet.getString("id")));
                emp.setNombre(resultSet.getString("nombre"));
                emp.setApellidoP(resultSet.getString("apellido_paterno"));
                emp.setApellidoM(resultSet.getString("apellido_materno"));
                emp.setTelefono(resultSet.getString("telefono"));
                emp.setSueldo(Integer.parseInt((resultSet.getString("sueldo"))));
                emp.setUsuario(resultSet.getString("usuario"));
                emp.setContrasena(resultSet.getString("contrasena"));
                datos.add(emp);
            }

        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }
    public boolean buscar(Empleado emp){
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        Connection connection = (Connection) getConnection();
        
        String sql = "SELECT nombre, apellido_paterno, apellido_materno, telefono, sueldo, usuario, contrasena from empleado WHERE id=?";
        
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
            statement.setInt(1, emp.getId());
            resultset = (ResultSet) statement.executeQuery();
            
            if(resultset.next()){
                emp.setNombre(resultset.getString("nombre"));
                emp.setApellidoP(resultset.getString("apellido_paterno"));
                emp.setApellidoM(resultset.getString("apellido_materno"));
                emp.setTelefono(resultset.getString("telefono"));
                emp.setSueldo(Integer.parseInt((resultset.getString("sueldo"))));
                emp.setUsuario(resultset.getString("usuario"));
                emp.setContrasena(resultset.getString("contrasena"));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                connection.close();
            }catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean modificar(Empleado emp){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE proveedor SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, sueldo=?, usuario=?, contrasena=? WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, emp.getNombre());
            statement.setString(2, emp.getApellidoP());
            statement.setString(3, emp.getApellidoM());
            statement.setString(4, emp.getTelefono());
            statement.setInt(5, emp.getSueldo());
            statement.setString(6, emp.getUsuario());
            statement.setString(7, emp.getContrasena());
            statement.setInt(8, emp.getId());
            statement.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try {
                connection.close();
            }catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean eliminar(Empleado emp){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "DELETE from empleado WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, emp.getId());
            statement.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                connection.close();
            }catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
