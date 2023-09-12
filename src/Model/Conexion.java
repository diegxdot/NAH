
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Esta clase inicializa una conexion con la base de datos

public class Conexion {
    //Atributos
    private final String DB_DATABASE = "nah";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/"+DB_DATABASE;
    
    private Connection connection = null;
    //Metodo para obtener conexion
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(this.URL, this.DB_USER, this.DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}