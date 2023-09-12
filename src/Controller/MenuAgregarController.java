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
import View.FrmMenuAgregar; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class MenuAgregarController implements ActionListener{
    //Atributos
    private Menu mod = new Menu();
    private MenuDAO modDAO = new MenuDAO();
    private FrmMenuAgregar frm = new FrmMenuAgregar();
    DefaultTableModel modT = new DefaultTableModel();
    //Constructor
    public MenuAgregarController(Menu mod, MenuDAO modDAO, FrmMenuAgregar frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Escuchadores
        frm.btnAgregar.addActionListener(this);
        frm.btnEliminar.addActionListener(this);
        frm.btnModificar.addActionListener(this);
        frm.btnConfirmar.addActionListener(this);
    }
    public void iniciar(){
        listar(frm.tablaMenu);
        frm.txtID.setVisible(false);
        frm.txtPrecio.setEditable(false);
        frm.txtNombre.setEditable(false);
        frm.comboTipo.setEditable(false);
        frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);
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
    public void limpiar(){
        frm.comboTipo.setSelectedIndex(0);
        frm.txtNombre.setText("");
        frm.txtPrecio.setText("");
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Fncion btn agregar
        if(e.getSource() == frm.btnAgregar){
            frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);
            frm.txtNombre.setEditable(true);
            frm.txtNombre.setEditable(true);
            frm.comboTipo.setEditable(true);
            try{
                mod.setTipoComida(frm.comboTipo.getSelectedIndex());
                mod.setNombre(frm.txtNombre.getText());
                mod.setPrecio(Integer.parseInt(frm.txtPrecio.getText()));
            }catch (Exception a){
                JOptionPane.showMessageDialog(null, "Verifica que los datos sean correctos");
            }
            if(frm.comboTipo.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Selecciona tipo de comida valido");
            }else if(frm.txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecciona nombre valido");
            }else if(frm.txtPrecio.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecciona precio valido");
            }
            if(modDAO.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Se guardo la comida exitosamente");
                listar(frm.tablaMenu);
                limpiar();
            }
        }
        //btn confirmar
        if(e.getSource() == frm.btnConfirmar){
            frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            if(modDAO.buscar(mod)){
            frm.comboTipo.setSelectedIndex(mod.getTipoComida());
            frm.txtNombre.setText(mod.getNombre());
            frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
            frm.txtPrecio.setEditable(true);
            frm.txtNombre.setEditable(true);
            frm.comboTipo.setEditable(true);
            }else{
                JOptionPane.showMessageDialog(null, "No pudimos encontrar los datos\nIntenta de nuevo mas tarde");
                frm.dispose();
            }
        }
        //btn modificar
        if(e.getSource() == frm.btnModificar){
            if(frm.txtID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecciona una comida valida");
            }
            mod.setTipoComida(frm.comboTipo.getSelectedIndex());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Integer.parseInt(frm.txtPrecio.getText()));
            if(modDAO.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos");
                limpiar();
                listar(frm.tablaMenu);
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible actualizar tus datos");
                limpiar();
            }
        }
        //btn eliminar
        if(e.getSource() == frm.btnEliminar){
            if(frm.txtID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecciona una comida valida");
            }
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            if(modDAO.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
                limpiar();
                modT.setRowCount(0);
                iniciar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
    }
}
