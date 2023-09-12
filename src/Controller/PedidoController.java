package Controller;
 
import Model.Pedido;
import Model.PedidoDAO;
import View.FrmMisPedidos; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author dell
 */
public class PedidoController implements ActionListener{
    private Pedido mod = new Pedido(); 
    private PedidoDAO modDAO = new PedidoDAO(); 
    private FrmMisPedidos frm = new FrmMisPedidos(); 
    DefaultTableModel modT = new DefaultTableModel();
  
    
    public PedidoController(Pedido mod, PedidoDAO modDAO, FrmMisPedidos frm) 
    {
        this.mod = mod;
        this.modDAO = modDAO; 
        this.frm = frm; 
     this.frm.btnAgregar.addActionListener(this); 
     this.frm.btnModificar.addActionListener(this);
     this.frm.btnEliminar.addActionListener(this);
    
    }
    public void iniciar(){ 
        frm.setTitle("Pedidos"); 
        frm.setLocationRelativeTo(frm);  
        
        listar(frm.tablaPedidos); 
    }
    public void limpiar(){ 
        frm.comboComida.setSelectedIndex(0);
        frm.txtId_orden.setText(""); 
        frm.txtCantidad.setText(""); 
        frm.btnAgregar.setEnabled(true);
        frm.btnModificar.setEnabled(false); 
        frm.btnEliminar.setEnabled(false); 
    }
    public void listar(JTable tabla){ 
        modT = (DefaultTableModel)tabla.getModel(); 
        List<Pedido> lista = modDAO.listar(); 
        Object[] object = new Object[5]; 
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_orden();
            object[1] = lista.get(i).getComida();
            object[2] = lista.get(i).getCliente();
            object[3] = lista.get(i).getCantidad();
            object[4] = lista.get(i).getEstado_entrega();
            modT.addRow(object); 
        }
        frm.tablaPedidos.setModel(modT);
    }
    @Override
     public void actionPerformed(ActionEvent e) {
         //Btn Agregar
     if(e.getSource() == frm.btnAgregar){
         try {
             mod.setId_orden(parseInt(frm.txtId_orden.getText())); 
             mod.setComida((String) frm.comboComida.getSelectedItem()); 
             mod.setCantidad(parseInt(frm.txtCantidad.getText())); 
             mod.setCliente((String) frm.txtCantidad.getText()); 
         } catch (Exception a) {
             JOptionPane.showMessageDialog(null, "Verifica que los datos introducidos sean correctos"); 
         } if(modDAO.registrar(mod)){ 
             JOptionPane.showMessageDialog(null, "Registro guardado con éxito"); 
             limpiar(); 
             modT.setRowCount(0); 
         }else{ JOptionPane.showMessageDialog(null, "Error al registrar"); limpiar(); 
         } 
     }
     //Btn modificar
     
if(e.getSource() == frm.btnModificar){ 
    mod.setId_orden(Integer.parseInt(frm.txtId_orden.getText()));

    mod.setId_orden((frm.txtId_orden.getText()));
    mod.setComida((String) frm.comboComida.getSelectedItem()); 
    mod.setCantidad(parseInt(frm.txtCantidad.getText())); 
    mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText())); 
    if(modDAO.modificar(mod)){
    JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
    limpiar();
    }else{
        JOptionPane.showMessageDialog(null, "Error al modificar"); 
    limpiar(); 
    modT.setRowCount(0); 
    
}
}
     
     //Btn eliminar
     if(e.getSource() == frm.btnEliminar){
         mod.setId_orden(Integer.parseInt(frm.txtId_orden.getText())); 
         if(modDAO.eliminar(mod)){
             JOptionPane.showMessageDialog(null, "Registro eliminado con éxito"); 
             limpiar(); modT.setRowCount(0); 
         }else{
             JOptionPane.showMessageDialog(null, "Error al eliminar"); limpiar(); } }
     //Btn buscar
     if(e.getSource() == frm.btnBuscar){ 
         mod.setId_orden(parseInt(frm.txtId_orden.getText()));
         if(modDAO.buscar(mod)){
         frm.txtId_orden.setText(String.valueOf(mod.getId_orden()));
     frm.comboComida.setSelectedItem(mod.getComida());
     frm.txtCliente.setText(mod.getCliente()); 
     frm.txtCantidad.setText(String.valueOf(mod.getCantidad())); 
     frm.btnAgregar.setEnabled(false); 
     frm.btnModificar.setEnabled(true); 
     frm.btnEliminar.setEnabled(true); 
     }else{
    JOptionPane.showMessageDialog(null, "Registro no encontrado"); limpiar();
     }
     } 
     
     //Btnlimpiar
     if(e.getSource() == frm.btnLimpiar){ limpiar(); }
     }
     
    }
     
     

   
    

     

