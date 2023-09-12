
package Controller;


//@author Diego

//Imports
import Model.Cliente;
import Model.ClienteDAO;
import Model.Administrador;
import Model.AdministradorDAO;
import Model.Empleado;
import Model.EmpleadoDAO;
import View.FrmRegistrarse;
import View.FrmMenuC;
import View.FrmMenuE;
import View.FrmMenuA;
import View.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener{
    //Atributos
    private Cliente mod = new Cliente();
    private Administrador mod2 = new Administrador();
    private AdministradorDAO modDAO2 = new AdministradorDAO();
    private Empleado mod3 = new Empleado();
    private EmpleadoDAO modDAO3 = new EmpleadoDAO();
    private FrmLogin frm;
    FrmMenuC frmM = new FrmMenuC();
    FrmMenuA frmA = new FrmMenuA();
    FrmMenuE frmE = new FrmMenuE();
    private String modo;
    private ClienteDAO modDAO = new ClienteDAO();
    FrmRegistrarse frmR = new FrmRegistrarse();
    //Constructor
    public LoginController(Cliente mod, ClienteDAO modDao, Administrador mod2, AdministradorDAO modDAO2, Empleado mod3, EmpleadoDAO modDAO3, FrmLogin frm) {
        this.mod = mod;
        this.mod2 = mod2;
        this.mod3 = mod3;
        this.modDAO = modDAO;
        this.modDAO2 = modDAO2;
        this.modDAO3 = modDAO3;
        this.frm = frm;
        //Insertamos escuchadores
        this.frm.btnIngresar.addActionListener(this);
        this.frm.btnRegistrate.addActionListener(this);
        this.frm.btnEmp.addActionListener(this);
        this.frm.btnAdmin.addActionListener(this);
        this.frm.lblVersion1.addActionListener(this);
    }
    //Metodo de inicio de aplicacion
    public void iniciar(){
        frm.setTitle("Ingresa a NAH");
        frm.setLocationRelativeTo(frm);
        frm.txtModo.setVisible(false);
        frm.txtModo.setText("cliente");
        frm.btnEmp.setVisible(false);
        frm.btnAdmin.setVisible(false);
        modo = frm.txtModo.getText();
    }
    public void mostrarModos(){
        frm.btnEmp.setVisible(true);
        frm.btnAdmin.setVisible(true);
        frm.txtModo.setVisible(true);
    }
    public void limpiar(){
        frm.txtUsuario.setText("");
        frm.txtContrasena.setText("");
    }
    public void abrirRegistro(){
        RegistrarseController rC = new RegistrarseController(mod, modDAO, frmR);
        rC.iniciar();
        this.frmR.setVisible(true);
        this.frmR.setLocationRelativeTo(frm);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Accion boton empleado
        if(e.getSource() == frm.btnEmp){
            frm.txtModo.setText("empleado");
        }
        //Accion boton administrador
        if(e.getSource() == frm.btnAdmin){
            frm.txtModo.setText("administrador");
        }
        //Accion boton ingresar
        if(e.getSource() == frm.btnIngresar){
            if(frm.txtModo.getText().equals("cliente")){
                mod.setUsuario(frm.txtUsuario.getText());
                mod.setContrasena(frm.txtContrasena.getText());
                if(modDAO.login(mod)){
                    this.frm.dispose();
                    MenuCController mC = new MenuCController(mod, modDAO, frmM);
                    mC.iniciar();
                    this.frmM.setLocationRelativeTo(frmM);
                    this.frmM.setVisible(true);
                    this.frmM.txtID.setText(String.valueOf(mod.getId()));
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario no valido");
                    limpiar();
                }
            }else if(frm.txtModo.getText().equals("administrador")){
                mod2.setUsuario(frm.txtUsuario.getText());
                mod2.setContrasena(frm.txtContrasena.getText());
                if(modDAO2.login(mod2)){
                    this.frm.dispose();
                    MenuAController mA = new MenuAController(mod2, modDAO2, frmA);
                    mA.iniciar();
                    this.frmA.setLocationRelativeTo(frmA);
                    this.frmA.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario no valido");
                    limpiar();
                }
            }else if(frm.txtModo.getText().equals("empleado")){
                mod3.setUsuario(frm.txtUsuario.getText());
                mod3.setContrasena(frm.txtContrasena.getText());
                if(modDAO3.login(mod3)){
                    this.frm.dispose();
                    MenuEController mE = new MenuEController(mod3, modDAO3, frmE);
                    mE.iniciar();
                    this.frmE.setLocationRelativeTo(frmA);
                    this.frmE.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario no valido");
                    limpiar();
                }
            }
        }
        //Accion boton registrarse
        JButton button = (JButton)e.getSource();
        if (button.equals(frm.btnRegistrate)){
            abrirRegistro();
        }
        //Accion label version
        if(e.getSource() == frm.lblVersion1){
            mostrarModos();
        }
    }
}
