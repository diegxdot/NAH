
package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO extends Conexion{
    public boolean registrar(Menu menu){
        //Declaramos objeto para la preparacion del estado
        PreparedStatement statement= null;
        //Establecemos conexion con la base de datos
        Connection connection = (Connection) getConnection();
        //Sentencia sql para el alta de productos
        String sql = "INSERT into menu (tipoComida, nombre, precio) VALUES(?,?,?)";
        try{
            //Se establece la consulta para la cadena sql
            statement = (PreparedStatement) connection.prepareStatement(sql);
            //Se van a sustituir los ? por codigo
            statement.setInt(1, menu.getTipoComida());
            statement.setString(2, menu.getNombre());
            statement.setInt(3, menu.getPrecio());
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
        List<Menu> datos = new ArrayList<>();

        String sql = "SELECT * from menu";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setId(Integer.parseInt(resultSet.getString("id")));
                menu.setTipoComida(Integer.parseInt(resultSet.getString("tipoComida")));
                menu.setNombre(resultSet.getString("nombre"));
                menu.setPrecio(Integer.parseInt(resultSet.getString("precio")));
                datos.add(menu);
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
    public boolean buscar(Menu menu){
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        Connection connection = (Connection) getConnection();
        
        String sql = "SELECT tipoComida, nombre, precio from menu WHERE id=?";
        
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
            statement.setInt(1, menu.getId());
            resultset = (ResultSet) statement.executeQuery();
            
            if(resultset.next()){
                menu.setTipoComida(Integer.parseInt(resultset.getString("tipoComida")));
                menu.setNombre(resultset.getString("nombre"));
                menu.setPrecio(Integer.parseInt(resultset.getString("precio")));
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
    public boolean modificar(Menu menu){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "UPDATE menu SET tipoComida=?, nombre=?, precio=? WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, menu.getTipoComida());
            statement.setString(2, menu.getNombre());
            statement.setInt(3, menu.getPrecio());
            statement.setInt(4, menu.getId());
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
    public boolean eliminar(Menu menu){
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();

        String sql = "DELETE from menu WHERE id=?";

        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, menu.getId());
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
