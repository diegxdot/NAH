
package Model;

//@author Diego
//Imports
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends Conexion{
    public boolean registrar(Cliente cliente){
        //Declaramos objeto para la preparacion del estado
        PreparedStatement statement= null;
        //Establecemos conexion con la base de datos
        Connection connection = (Connection) getConnection();
        //Sentencia sql para el alta de productos
        String sql = "INSERT into cliente (Nombre, Apellido_Paterno, Apellido_Materno, Direccion, Telefono, Usuario, Contrasena, estado) VALUES(?,?,?,?,?,?,?,1)";
        try{
            //Se establece la consulta para la cadena sql
            statement = (PreparedStatement) connection.prepareStatement(sql);
            //Se van a sustituir los ? por codigo
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellidoP());
            statement.setString(3, cliente.getApellidoM());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getUsuario());
            statement.setString(7, cliente.getContrasena());
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
        List<Cliente> datos = new ArrayList<>();

        String sql = "SELECT * from cliente where estado = 1";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(resultSet.getString("id")));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidoP(resultSet.getString("apellido_paterno"));
                cliente.setApellidoM(resultSet.getString("apellido_materno"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setUsuario(resultSet.getString("usuario"));
                cliente.setContrasena(resultSet.getString("contrasena"));
                datos.add(cliente);
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
    public List listarS(){
        PreparedStatement statement =null;
        ResultSet resultSet = null;

        Connection connection = (Connection) getConnection();
        //Se declara una lista de objetos para guardar los registros de los productos 
        List<Cliente> datos = new ArrayList<>();

        String sql = "SELECT * from cliente where estado = 2";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(resultSet.getString("id")));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidoP(resultSet.getString("apellido_paterno"));
                cliente.setApellidoM(resultSet.getString("apellido_materno"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setUsuario(resultSet.getString("usuario"));
                cliente.setContrasena(resultSet.getString("contrasena"));
                datos.add(cliente);
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
    public boolean buscar(Cliente cliente){
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        Connection connection = (Connection) getConnection();
        
        String sql = "SELECT nombre, apellido_paterno, apellido_materno, direccion, telefono, usuario, contrasena from cliente WHERE id=?";
        
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
            statement.setInt(1, cliente.getId());
            resultset = (ResultSet) statement.executeQuery();
            
            if(resultset.next()){
                cliente.setNombre(resultset.getString("nombre"));
                cliente.setApellidoP(resultset.getString("apellido_paterno"));
                cliente.setApellidoM(resultset.getString("apellido_materno"));
                cliente.setDireccion(resultset.getString("direccion"));
                cliente.setTelefono(resultset.getString("telefono"));
                cliente.setUsuario(resultset.getString("usuario"));
                cliente.setContrasena(resultset.getString("contrasena"));
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
    public boolean suspender(Cliente cliente){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE cliente SET estado=2 WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, cliente.getId());
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
    public boolean reactivar(Cliente cliente){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE cliente SET estado=1 WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, cliente.getId());
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
    public boolean modificar(Cliente cliente){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE cliente SET nombre=?, apellido_paterno=?, apellido_materno=?, direccion=?, telefono=?, usuario=?, contrasena=? WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellidoP());
            statement.setString(3, cliente.getApellidoM());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getUsuario());
            statement.setString(7, cliente.getContrasena());
            statement.setInt(8, cliente.getId());
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
    public boolean login(Cliente cliente){
        //SQL
        PreparedStatement statement =null;
        ResultSet resultSet = null;

        Connection connection = (Connection) getConnection();
        //Se declara una lista de objetos para guardar los registros de los productos 

        String sql = "SELECT ID from cliente where Usuario=? and Contrasena=? and estado=1";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, cliente.getUsuario());
            statement.setString(2, cliente.getContrasena());
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                cliente.setId(Integer.parseInt(resultSet.getString("id")));
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
}
