
package Controller;

//@author Diego

//Importaciones
import Model.Cliente;
import Model.ClienteDAO;
import View.FrmClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientesController implements ActionListener{
    //Objetos
    private Cliente mod;
    private ClienteDAO modDAO;
    private FrmClientes frm;
    DefaultTableModel modT = new DefaultTableModel();
    //Constructor
    public ClientesController(Cliente mod, ClienteDAO modDAO, FrmClientes frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Incluimos escuchadores
        this.frm.btnListarActivos.addActionListener(this);
        this.frm.btnListarSuspendidos1.addActionListener(this);
        this.frm.btnReactivar.addActionListener(this);
        this.frm.btnSuspender.addActionListener(this);
    }
    //Metodos
    public void iniciar(){
        frm.setTitle("Clientes");
        listar(frm.tablaPedidos);
    }
    ////Este método se va a ejecutar cuando se inicia la aplicación, y va a colocar
    //en la tabla de la vista la información obtenida de la tabla de la base de datos
    public void listar(JTable tabla){
        modT = (DefaultTableModel)tabla.getModel();
        List<Cliente> lista = modDAO.listar();
        Object[] object = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidoP();
            object[3] = lista.get(i).getDireccion();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getUsuario();
            modT.addRow(object);
        }
        frm.tablaPedidos.setModel(modT);
    }
    //Mostrar suspendidos
    public void listarS(JTable tabla){
        modT = (DefaultTableModel)tabla.getModel();
        List<Cliente> lista = modDAO.listarS();
        Object[] object = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidoP();
            object[3] = lista.get(i).getDireccion();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getUsuario();
            modT.addRow(object);
        }
        frm.tablaPedidos.setModel(modT);
    }
    public void listarInv(JTable tabla){
        modT = (DefaultTableModel)tabla.getModel();
        List<Cliente> lista = modDAO.listarS();
        Object[] object = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidoP();
            object[3] = lista.get(i).getDireccion();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getUsuario();
            modT.removeRow(lista.size());
        }
        frm.tablaPedidos.setModel(modT);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Accion boton suspender
        if(e.getSource() == frm.btnSuspender){
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            if(modDAO.suspender(mod)){
                JOptionPane.showMessageDialog(null, "Se ha dado de baja del sistema correctamente");
                JOptionPane.showMessageDialog(null, "Se reiniciara la ventana");
                frm.dispose();
                frm.setLocationRelativeTo(frm);
                frm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible darlo de baja");
            }
        }
        //Accion boton reactivar
        if(e.getSource() == frm.btnReactivar){
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            if(modDAO.reactivar(mod)){
                JOptionPane.showMessageDialog(null, "Se ha reactivado en el sistema correctamente");
                JOptionPane.showMessageDialog(null, "Se reiniciara la ventana");
                frm.dispose();
                frm.setLocationRelativeTo(frm);
                frm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible reactivarlo");
            }
        }
        //Accion boton listar suspendidos
        if(e.getSource() == frm.btnListarSuspendidos1){
            listarInv(frm.tablaPedidos);
            listarS(frm.tablaPedidos);
        }
        //Accion boton listar activos
        if(e.getSource() == frm.btnListarActivos){
            listarInv(frm.tablaPedidos);
            listar(frm.tablaPedidos);
        }
    }
}
