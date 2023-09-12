/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//@author Diego

//Importaciones
import Model.Conexion;
import Model.Cliente;
import Model.ClienteDAO;
import View.FrmRegistrarse;
import View.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RegistrarseController implements ActionListener{
    //Objetos
    private Cliente mod = new Cliente();
    private FrmLogin frm;
    private ClienteDAO modDAO = new ClienteDAO();
    FrmRegistrarse frmR = new FrmRegistrarse();
    //Constructor
    public RegistrarseController(Cliente mod, ClienteDAO modDAO, FrmRegistrarse frmR) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frmR = frmR;
        //Implementamos escuchadores a los botones
        this.frmR.btnCancelar.addActionListener(this);
        this.frmR.btnAceptar.addActionListener(this);
    }
    //Metodo limpiar
    public void limpiar(){
        frmR.txtNombre.setText("");
        frmR.txtApellidoP.setText("");
        frmR.txtApellidoM.setText("");
        frmR.txtDireccion.setText("");
        frmR.txtTelefono.setText("");
        frmR.txtContraseña.setText("");
        frmR.txtUsuario.setText("");
    }
    public void regresar(){
        this.frmR.dispose();
    }
    public void iniciar(){
        System.out.println("a");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Funcion boton aceptar
        if(e.getSource() == frmR.btnAceptar){
            try{
                mod.setNombre(frmR.txtNombre.getText());
                mod.setApellidoP(frmR.txtApellidoP.getText());
                mod.setApellidoM(frmR.txtApellidoM.getText());
                mod.setDireccion(frmR.txtDireccion.getText());
                mod.setTelefono(frmR.txtTelefono.getText());
                mod.setUsuario(frmR.txtUsuario.getText());
                mod.setContrasena(frmR.txtContraseña.getText());
            }catch(Exception a){
                JOptionPane.showMessageDialog(null, "Verifica que los datos sean correctos");
            }
            if(frmR.txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese nombre valido");
            }else if(frmR.txtApellidoP.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese apellido paterno valido");
            }else if(frmR.txtApellidoM.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese apellido materno valido");
            }else if(frmR.txtDireccion.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese direccion valida");
            }else if(frmR.txtTelefono.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese telefono valido");
            }else if(frmR.txtUsuario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese usuario valido");
            }else if(frmR.txtContraseña.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese contraseña valido");
            }else if(modDAO.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Te has registrado exitosamente");
                limpiar();
                regresar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar");
                limpiar();
            }        
        }
        //Funcion boton cancelar
        if(e.getSource() == frmR.btnCancelar){
            regresar();
        }
    }
}
