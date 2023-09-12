
package Controller;
import Model.Proveedores;
import Model.ProveedoresDAO;
import View.FrmProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProveedoresController implements ActionListener{
    private Proveedores mod = new Proveedores();
    private ProveedoresDAO modDAO = new ProveedoresDAO();
    private FrmProveedores frm = new FrmProveedores();
    DefaultTableModel modT = new DefaultTableModel();

    public ProveedoresController(Proveedores mod, ProveedoresDAO modDAO, FrmProveedores frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Escuchadores
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnActualizar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        listar(frm.tablaProveedores);
        frm.setTitle("Empleados");
        desactivar();
        frm.btnAgregar.setEnabled(true);
        frm.btnActualizar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);
        frm.btnGuardar.setEnabled(false);
        frm.btnModificar.setEnabled(false);
        
    }
    ////Este método se va a ejecutar cuando se inicia la aplicación, y va a colocar
    //en la tabla de la vista la información obtenida de la tabla de la base de datos
    public void listar(JTable tabla){
        modT = (DefaultTableModel)tabla.getModel();
        List<Proveedores> lista = modDAO.listar();
        Object[] object = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIda();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidoP();
            object[3] = lista.get(i).getApellidoM();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getProvee();
            object[6] = lista.get(i).getProducto();
            modT.addRow(object);
        }
        frm.tablaProveedores.setModel(modT);
    }
    public void desactivar(){
        frm.txtNombre.setEditable(false);
        frm.txtApellidoP.setEditable(false);
        frm.txtApellidoM.setEditable(false);
        frm.txtTelefono.setEditable(false);
        frm.txtProvee.setEditable(false);
        frm.txtProducto.setEditable(false);
    }
    public void activar(){
        frm.txtNombre.setEditable(true);
        frm.txtApellidoP.setEditable(true);
        frm.txtApellidoM.setEditable(true);
        frm.txtTelefono.setEditable(true);
        frm.txtProvee.setEditable(true);
        frm.txtProducto.setEditable(true);
    }
    public void limpiar(){
        frm.txtNombre.setText("");
        frm.txtApellidoP.setText("");
        frm.txtApellidoM.setText("");
        frm.txtTelefono.setText("");
        frm.txtProvee.setText("");
        frm.txtProducto.setText("");
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Accion boton buscar
        if(e.getSource() == frm.btnBuscar){
            mod.setIda(Integer.parseInt(frm.txtID.getText()));
            frm.btnEliminar.setEnabled(true);
            frm.btnModificar.setEnabled(true);
            if(modDAO.buscar(mod)){
            frm.txtNombre.setText(mod.getNombre());
            frm.txtApellidoP.setText(mod.getApellidoP());
            frm.txtApellidoM.setText(mod.getApellidoM());
            frm.txtTelefono.setText(mod.getTelefono());
            frm.txtProvee.setText(mod.getProvee());
            frm.txtProducto.setText(mod.getProducto());
            }else{
                JOptionPane.showMessageDialog(null, "No pudimos encontrar los datos\nIntenta de nuevo mas tarde");
                frm.dispose();
            }
        }
        //Accion boton agregar
        if(e.getSource() == frm.btnAgregar){
            frm.btnAgregar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
            activar();
        }
        //Accion boton modificar
        if(e.getSource() == frm.btnModificar){
            frm.btnModificar.setEnabled(false);
            frm.btnActualizar.setEnabled(true);
            activar();
        }
        //Accion boton eliminar
        if(e.getSource() == frm.btnEliminar){
            mod.setIda(Integer.parseInt(frm.txtID.getText()));
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
        //Accion boton guardar
        if(e.getSource() == frm.btnGuardar){
            try{
                mod.setNombre(frm.txtNombre.getText());
                mod.setApellidoP(frm.txtApellidoP.getText());
                mod.setApellidoM(frm.txtApellidoM.getText());
                mod.setTelefono(frm.txtTelefono.getText());
                mod.setProvee(frm.txtProvee.getText());
                mod.setProducto(frm.txtProducto.getText());
            }catch(Exception a){
                JOptionPane.showMessageDialog(null, "Verifica que los datos sean correctos");
            }
            if(frm.txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese nombre valido");
            }else if(frm.txtApellidoP.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese apellido paterno valido");
            }else if(frm.txtApellidoM.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese apellido materno valido");
            }else if(frm.txtTelefono.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese direccion valida");
            }else if(frm.txtProvee.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese telefono valido");
            }else if(frm.txtProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese usuario valido");
            }else if(modDAO.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Te has registrado exitosamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar");
                limpiar();
                iniciar();
            } 
        }
        //Accion boton actualizar
        if(e.getSource() == frm.btnActualizar){
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidoP(frm.txtApellidoP.getText());
            mod.setApellidoM(frm.txtApellidoM.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setProvee(frm.txtProvee.getText());
            mod.setProducto(frm.txtProducto.getText());
            
            if(modDAO.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Se han actualizado tus datos");
                JOptionPane.showMessageDialog(null, "Esta ventana se cerrara");
                desactivar();
                frm.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible actualizar tus datos");
                desactivar();
            }
        }
    }
}
