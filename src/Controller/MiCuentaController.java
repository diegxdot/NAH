
package Controller;


//@author Diego

//Importaciones
import Model.Cliente;
import Model.ClienteDAO;
import View.FrmMiCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MiCuentaController implements ActionListener{
    //Objetos a usar
    private Cliente mod = new Cliente();
    private ClienteDAO modDAO = new ClienteDAO();
    FrmMiCuenta frm = new FrmMiCuenta();
    //Constructor
    public MiCuentaController(Cliente mod, ClienteDAO modDAO, FrmMiCuenta frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Implementamos escuchadores
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
    }
    //Metodos
    public void iniciar(){
        frm.setTitle("Mi Cuenta");
        frm.txtID.setText(String.valueOf(mod.getId()));
        frm.txtID.setVisible(false);
        frm.btnGuardar.setEnabled(false);
        desactivar();
        
        //Metodo buscar
        mod.setId(Integer.parseInt(frm.txtID.getText()));
        if(modDAO.buscar(mod)){
            frm.txtNombre.setText(mod.getNombre());
            frm.txtApellidoP.setText(mod.getApellidoP());
            frm.txtApellidoM.setText(mod.getApellidoM());
            frm.txtDireccion.setText(mod.getDireccion());
            frm.txtTelefono.setText(mod.getTelefono());
            frm.txtUsuario.setText(mod.getUsuario());
            frm.txtContrasena.setText(mod.getContrasena());
        }else{
            JOptionPane.showMessageDialog(null, "No pudimos encontrar tus datos\nIntenta de nuevo mas tarde");
            frm.dispose();
        }
    }
    public void desactivar(){
        frm.txtNombre.setEditable(false);
        frm.txtApellidoP.setEditable(false);
        frm.txtApellidoM.setEditable(false);
        frm.txtDireccion.setEditable(false);
        frm.txtTelefono.setEditable(false);
        frm.txtUsuario.setEditable(false);
        frm.txtContrasena.setEditable(false);
    }
    public void activar(){
        frm.txtNombre.setEditable(true);
        frm.txtApellidoP.setEditable(true);
        frm.txtApellidoM.setEditable(true);
        frm.txtDireccion.setEditable(true);
        frm.txtTelefono.setEditable(true);
        frm.txtUsuario.setEditable(true);
        frm.txtContrasena.setEditable(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Accion boton modificar
        if(e.getSource() == frm.btnModificar){
            frm.btnModificar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
            activar();
        }
        //Accion boton guardar
        if(e.getSource() == frm.btnGuardar){
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidoP(frm.txtApellidoP.getText());
            mod.setApellidoM(frm.txtApellidoM.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setTelefono(frm.txtTelefono.getText());
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
        //Accion boton suspender
        if(e.getSource() == frm.btnEliminar){
            if(modDAO.suspender(mod)){
                JOptionPane.showMessageDialog(null, "Se ha dado de baja del sistema correctamente");
                JOptionPane.showMessageDialog(null, "Se cerrara la sesión abierta");
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible darlo de baja");
            }
        }
    }
}
