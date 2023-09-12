/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Menu;
import Model.MenuDAO;
import Model.Pedido;
import Model.PedidoDAO;
import View.FrmMisPedidos; 
import View.FrmMenuCl;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class MenuCLController implements ActionListener{
    //Atributos
    private Menu mod = new Menu();
    private MenuDAO modDAO = new MenuDAO();
    private Pedido mod2 = new Pedido(); 
    private PedidoDAO modDAO2 = new PedidoDAO(); 
    private FrmMenuCl frm = new FrmMenuCl();
    FrmMisPedidos frm2 = new FrmMisPedidos();
    DefaultTableModel modT = new DefaultTableModel();
    //Constructor
    public MenuCLController(Menu mod, MenuDAO modDAO, FrmMenuCl frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Escuchadores
        frm.btnAgregar.addActionListener(this);
    }
    public void iniciar(){
        listar(frm.tablaMenu);
    }
    public void listar(JTable tabla){ 
        modT = (DefaultTableModel)tabla.getModel(); 
        List<Menu> lista = modDAO.listar(); 
        Object[] object = new Object[4]; 
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getTipoComida();
            object[2] = lista.get(i).getNombre();
            object[3] = lista.get(i).getPrecio();
            modT.addRow(object); 
        }
        frm.tablaMenu.setModel(modT);
    }
    public void abrirMisPedidos(){
        PedidoController pc = new PedidoController(mod2, modDAO2, frm2);
        frm2.setLocationRelativeTo(frm);
        frm2.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Fncion btn agregar
        if(e.getSource() == frm.btnAgregar){
            abrirMisPedidos();
        }
    }
}
