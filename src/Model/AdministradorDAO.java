
package Model;

//@author Diego

//Importaciones
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO extends Conexion{
    //Metodo para ingresar al login
    public boolean login(Administrador admin){
        //SQL
        PreparedStatement statement =null;
        ResultSet resultSet = null;

        Connection connection = (Connection) getConnection();
        //Se declara una lista de objetos para guardar los registros de los productos 

        String sql = "SELECT ID from administrador where Usuario=? and Contrasena=?";
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, admin.getUsuario());
            statement.setString(2, admin.getContrasena());
            resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()){
                admin.setId(Integer.parseInt(resultSet.getString("id")));
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
