/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pedido;
import Model.PedidoDAO;
import View.FrmPedidosVer; 
import java.awt.event.ActionEvent; 
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class PedidosVerController{
    private Pedido mod = new Pedido(); 
    private PedidoDAO modDAO = new PedidoDAO(); 
    private FrmPedidosVer frm = new FrmPedidosVer(); 
    DefaultTableModel modT = new DefaultTableModel();

    public PedidosVerController(Pedido mod, PedidoDAO modDAO, FrmPedidosVer frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Escuchadoores
        //Nohayxd
    }
    
    public void iniciar(){
        listar(frm.tablaPedidos);
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
}
