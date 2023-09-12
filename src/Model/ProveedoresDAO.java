
package Model;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProveedoresDAO extends Conexion{
    public boolean registrar(Proveedores pro){
        //Declaramos objeto para la preparacion del estado
        PreparedStatement statement= null;
        //Establecemos conexion con la base de datos
        Connection connection = (Connection) getConnection();
        //Sentencia sql para el alta de productos
        String sql = "INSERT into proveedor (Nombre, Apellido_Paterno, Apellido_Materno, Telefono, Provee, Producto) VALUES(?,?,?,?,?,?)";
        try{
            //Se establece la consulta para la cadena sql
            statement = (PreparedStatement) connection.prepareStatement(sql);
            //Se van a sustituir los ? por codigo
            statement.setString(1, pro.getNombre());
            statement.setString(2, pro.getApellidoP());
            statement.setString(3, pro.getApellidoM());
            statement.setString(4, pro.getTelefono());
            statement.setString(5, pro.getProvee());
            statement.setString(6, pro.getProducto());
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
        List<Proveedores> datos = new ArrayList<>();

        String sql = "SELECT * from proveedor";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                Proveedores pro = new Proveedores();
                pro.setIda(Integer.parseInt(resultSet.getString("id")));
                pro.setNombre(resultSet.getString("nombre"));
                pro.setApellidoP(resultSet.getString("apellido_paterno"));
                pro.setApellidoM(resultSet.getString("apellido_materno"));
                pro.setTelefono(resultSet.getString("telefono"));
                pro.setProvee(resultSet.getString("provee"));
                pro.setProducto(resultSet.getString("producto"));
                datos.add(pro);
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
    public boolean buscar(Proveedores pro){
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        Connection connection = (Connection) getConnection();
        
        String sql = "SELECT nombre, apellido_paterno, apellido_materno, telefono, provee, producto from proveedor WHERE id=?";
        
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
            statement.setInt(1, pro.getIda());
            resultset = (ResultSet) statement.executeQuery();
            
            if(resultset.next()){
                pro.setNombre(resultset.getString("nombre"));
                pro.setApellidoP(resultset.getString("apellido_paterno"));
                pro.setApellidoM(resultset.getString("apellido_materno"));
                pro.setTelefono(resultset.getString("telefono"));
                pro.setProvee(resultset.getString("provee"));
                pro.setProducto(resultset.getString("producto"));
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
    public boolean modificar(Proveedores pro){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE proveedor SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, provee=?, producto=? WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, pro.getNombre());
            statement.setString(2, pro.getApellidoP());
            statement.setString(3, pro.getApellidoM());
            statement.setString(4, pro.getTelefono());
            statement.setString(5, pro.getProvee());
            statement.setString(6, pro.getProducto());
            statement.setInt(7, pro.getIda());
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
    public boolean eliminar(Proveedores pro){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "DELETE from proveedor WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, pro.getIda());
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
