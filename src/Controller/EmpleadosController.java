
package Controller;

import Model.Empleado;
import Model.EmpleadoDAO;
import View.FrmEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpleadosController implements ActionListener{
    private Empleado mod = new Empleado();
    private EmpleadoDAO modDAO = new EmpleadoDAO();
    private FrmEmpleados frm = new FrmEmpleados();
    DefaultTableModel modT = new DefaultTableModel();

    public EmpleadosController(Empleado mod, EmpleadoDAO modDAO, FrmEmpleados frm) {
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
        listar(frm.tablaEmpleados);
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
        List<Empleado> lista = modDAO.listar();
        Object[] object = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidoP();
            object[3] = lista.get(i).getApellidoM();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getSueldo();
            object[6] = lista.get(i).getUsuario();
            modT.addRow(object);
        }
        frm.tablaEmpleados.setModel(modT);
    }
    public void desactivar(){
        frm.txtNombre.setEditable(false);
        frm.txtApellidoP.setEditable(false);
        frm.txtApellidoM.setEditable(false);
        frm.txtSueldo.setEditable(false);
        frm.txtTelefono.setEditable(false);
        frm.txtUsuario.setEditable(false);
        frm.txtContrasena.setEditable(false);
    }
    public void activar(){
        frm.txtNombre.setEditable(true);
        frm.txtApellidoP.setEditable(true);
        frm.txtApellidoM.setEditable(true);
        frm.txtSueldo.setEditable(true);
        frm.txtTelefono.setEditable(true);
        frm.txtUsuario.setEditable(true);
        frm.txtContrasena.setEditable(true);
    }
    public void limpiar(){
        frm.txtNombre.setText("");
        frm.txtApellidoP.setText("");
        frm.txtApellidoM.setText("");
        frm.txtSueldo.setText("");
        frm.txtTelefono.setText("");
        frm.txtUsuario.setText("");
        frm.txtContrasena.setText("");
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        //Accion boton buscar
        if(e.getSource() == frm.btnBuscar){
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            frm.btnEliminar.setEnabled(true);
            frm.btnModificar.setEnabled(true);
            if(modDAO.buscar(mod)){
            frm.txtNombre.setText(mod.getNombre());
            frm.txtApellidoP.setText(mod.getApellidoP());
            frm.txtApellidoM.setText(mod.getApellidoM());
            frm.txtTelefono.setText(mod.getTelefono());
            frm.txtSueldo.setText(String.valueOf(mod.getSueldo()));
            frm.txtUsuario.setText(mod.getUsuario());
            frm.txtContrasena.setText(mod.getContrasena());
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
        //Accion boton guardar
        if(e.getSource() == frm.btnGuardar){
            try{
                mod.setNombre(frm.txtNombre.getText());
                mod.setApellidoP(frm.txtApellidoP.getText());
                mod.setApellidoM(frm.txtApellidoM.getText());
                mod.setTelefono(frm.txtTelefono.getText());
                mod.setSueldo(Integer.parseInt(frm.txtSueldo.getText()));
                mod.setUsuario(frm.txtUsuario.getText());
                mod.setContrasena(frm.txtContrasena.getText());
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
            }else if(frm.txtSueldo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese telefono valido");
            }else if(frm.txtUsuario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese usuario valido");
            }else if(frm.txtContrasena.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese contraseña valido");
            }else if(modDAO.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Te has registrado exitosamente");
                limpiar();
                iniciar();
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
            mod.setSueldo(Integer.parseInt(frm.txtSueldo.getText()));
            mod.setUsuario(frm.txtUsuario.getText());
            mod.setContrasena(frm.txtContrasena.getText());
            
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
