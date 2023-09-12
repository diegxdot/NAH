/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pedido;
import Model.PedidoDAO;
import View.FrmEstatus; 
import View.FrmMisPedidos;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class EstatusController implements ActionListener{
    private Pedido mod = new Pedido(); 
    private PedidoDAO modDAO = new PedidoDAO(); 
    private FrmEstatus frm = new FrmEstatus(); 
    FrmMisPedidos frm2 = new FrmMisPedidos();
    DefaultTableModel modT = new DefaultTableModel();

    public EstatusController(Pedido mod, PedidoDAO modDAO, FrmEstatus frm) {
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
    @Override
    public void actionPerformed (ActionEvent e){
        //funcion boton modificar
        if(e.getSource() == frm.btnModificar){
            PedidoController pc = new PedidoController(mod, modDAO, frm2);
            frm2.setLocationRelativeTo(frm);
            frm2.setVisible(true);
        }
    }
}
