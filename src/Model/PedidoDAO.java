package Model;
import com.mysql.jdbc.Connection; 
import com.mysql.jdbc.PreparedStatement; 
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;
/**
 *
 * @author dell
 */
public class PedidoDAO extends Conexion{
    public boolean registrar(Pedido pedido){ 
        PreparedStatement statement =null;
        Connection connection = (Connection) getConnection();
        String sql = "INSERT into pedido (id_orden, comida, cantidad, cliente, estado_entrega) " + "VALUES (?,?,?,?,'en proceso')";
        try{ 
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, pedido.getId_orden()); 
            statement.setString(2, pedido.getComida());
            statement.setInt(3, pedido.getCantidad());
            statement.setString(4, pedido.getCliente()); 
            statement.execute(); 
            return true; 
        }catch(SQLException e){
            System.err.println(e); return false; 
        }finally{ 
            try { 
                connection.close(); 
            } catch (SQLException e){ 
                 System.err.println(e); } }
        }
    public List listar(){ 
        PreparedStatement statement =null;
     ResultSet resultSet = null; 
    Connection connection = (Connection) getConnection();
    List<Pedido> datos = new ArrayList<>();
    String sql = "SELECT id_orden, comida, cliente, cliente, cantidad, estado_entrega from pedido";
    try{
        statement = (PreparedStatement) connection.prepareStatement(sql);
        resultSet = (ResultSet) statement.executeQuery();
        
        while(resultSet.next()){
        Pedido pedido = new Pedido(); 
        pedido.setId_orden(Integer.parseInt(resultSet.getString("id_orden"))); 
        pedido.setComida(resultSet.getString("comida")); 
        pedido.setCliente(resultSet.getString("cliente"));
        pedido.setCantidad(resultSet.getInt("cantidad"));
        pedido.setEstado_entrega(resultSet.getString("estado_entrega"));
        
    datos.add(pedido); 
        }
    }catch(SQLException e){
        System.err.println(e); 
    }finally{
             
          try { connection.close();
    } catch (SQLException e) { 
        System.err.println(e); 
    } 
    }
    return datos; }
    
    public boolean buscar(Pedido pedido){
       PreparedStatement statement =null; 
       ResultSet resultSet = null; 
       Connection connection = (Connection) getConnection(); 
       String sql = "SELECT id_orden, comida, cliente, cantidad, estado_entrega from pedido WHERE comida=?";
       try{
           statement = (PreparedStatement) connection.prepareStatement(sql);
           statement.setString(1, pedido.getComida()); 
           resultSet = (ResultSet) statement.executeQuery();
           if(resultSet.next()){
               pedido.setId_orden(Integer.parseInt(resultSet.getString("id_orden"))); 
               pedido.setComida(resultSet.getString("comida")); 
               pedido.setCliente(resultSet.getString("cliente")); 
               pedido.setCantidad(Integer.parseInt(resultSet.getString("cantidad")));
               pedido.setEstado_entrega(resultSet.getString("estado_entrega")); 
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
    public boolean eliminar(Pedido pedido){
        PreparedStatement statement =null;
      
     Connection connection = (Connection) getConnection(); 
    String sql = "DELETE from pedido WHERE id_orden=?"; 
    try{
    statement = (PreparedStatement) connection.prepareStatement(sql);
    
    statement.setInt(1, pedido.getId_orden()); 
    
    statement.execute(); 
    return true; 
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
    
    public boolean modificar(Pedido pedido){
     
    PreparedStatement statement =null; 
    Connection connection = (Connection) getConnection();
    String sql = "UPDATE pedido SET comida=?, cliente=?, cantidad=? estado_entrega=?, " + "cantidad=? WHERE id_orden=?";
    try{ statement = (PreparedStatement) connection.prepareStatement(sql);
    statement.setString(1, pedido.getComida()); 
    statement.setString(2, pedido.getCliente()); 
    statement.setInt(4, pedido.getCantidad());
    statement.setString(5, pedido.getEstado_entrega());
    statement.setInt(6, pedido.getId_orden());
    statement.execute(); 
    return true;
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
    public boolean entregar(Pedido pedido){
     
    PreparedStatement statement =null; 
    Connection connection = (Connection) getConnection();
    String sql = "UPDATE pedido SET estado_entrega='entregado' WHERE id_orden=?";
    try{ statement = (PreparedStatement) connection.prepareStatement(sql);
    statement.setInt(1, pedido.getId_orden());
    statement.execute(); 
    return true;
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

    

    

