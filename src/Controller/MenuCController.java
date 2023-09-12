
package Controller;


//@author Diego

//Importaciones
import Model.Cliente;
import Model.ClienteDAO;
import Model.Pedido;
import Model.PedidoDAO;
import Model.Menu;
import Model.MenuDAO;
import View.FrmMenuC;
import View.FrmAbout;
import View.FrmMenuCl;
import View.FrmMiCuenta;
import View.FrmMisPedidos;
import View.FrmEstatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MenuCController implements ActionListener{
    //Objetos a usar
    private Cliente mod = new Cliente();
    FrmMenuC frmM = new FrmMenuC();
    private ClienteDAO modDAO = new ClienteDAO();
    private Pedido mod2 = new Pedido();
    private PedidoDAO modDAO2 = new PedidoDAO();
    private Menu mod3 = new Menu();
    private MenuDAO modDAO3 = new MenuDAO();
    FrmMenuCl frm1 = new FrmMenuCl();
    FrmMisPedidos frm2 = new FrmMisPedidos();
    FrmEstatus frm3 = new FrmEstatus();
    FrmMiCuenta frm4 = new FrmMiCuenta();
    FrmAbout frm5 = new FrmAbout();
    //Constructor
    public MenuCController(Cliente mod, ClienteDAO modDAO, FrmMenuC frmM) {
        //Inicializamos
        this.mod = mod;
        this.modDAO = modDAO;
        this.frmM = frmM;
        //Implementamos escuchadores
        this.frmM.btnMenu.addActionListener(this);
        this.frmM.btnCuenta.addActionListener(this);
        this.frmM.btnEntrega.addActionListener(this);
        this.frmM.btnPedidos.addActionListener(this);
        this.frmM.btnAcercaDe.addActionListener(this);
    }
    public void iniciar(){
        frmM.txtID.setVisible(false);
    }
    public void abrirMenu(){
        MenuCLController mCL = new MenuCLController(mod3, modDAO3, frm1);
        mCL.iniciar();
        this.frm1.setLocationRelativeTo(frmM);
        this.frm1.setVisible(true);
    }
    public void abrirDatos(){
        MiCuentaController mc = new MiCuentaController(mod, modDAO, frm4);
        mc.iniciar();
        this.frm4.setLocationRelativeTo(frmM);
        this.frm4.setVisible(true);
        frm4.txtID.setText(frmM.txtID.getText());
    }
    public void abrirEstatus(){
        EstatusController ec = new EstatusController(mod2, modDAO2, frm3);
        ec.iniciar();
        this.frm3.setLocationRelativeTo(frmM);
        this.frm3.setVisible(true);
    }
    public void abrirPedidos(){
        PedidoController pc = new PedidoController(mod2, modDAO2, frm2);
        pc.iniciar();
        this.frm2.setLocationRelativeTo(frmM);
        this.frm2.setVisible(true);
    }
    public void abrirAcerca(){
        this.frm5.setLocationRelativeTo(frmM);
        this.frm5.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //Accion boton abrir menu
        if(e.getSource() == frmM.btnMenu){
            abrirMenu();
        }
        if(e.getSource() == frmM.btnCuenta){
            abrirDatos();
        }
        if(e.getSource() == frmM.btnEntrega){
            abrirEstatus();
        }
        if(e.getSource() == frmM.btnPedidos){
            abrirPedidos();
        }
        if(e.getSource() == frmM.btnAcercaDe){
            abrirAcerca();
        }
    }
}
