
package Controller;

//@author Diego

//Importaciones
import Model.Administrador;
import Model.AdministradorDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.Empleado;
import Model.EmpleadoDAO;
import Model.Proveedores;
import Model.ProveedoresDAO;
import Model.Pedido;
import Model.PedidoDAO;
import Model.Menu;
import Model.MenuDAO;
import View.FrmMenuA;
import View.FrmAbout;
import View.FrmMenuAgregar;
import View.FrmClientes;
import View.FrmEmpleados;
import View.FrmPedidosVer;
import View.FrmProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuAController implements ActionListener{
    //Objetos
    private Administrador mod = new Administrador();
    private AdministradorDAO modDAO = new AdministradorDAO();
    private Cliente mod2 = new Cliente();
    private ClienteDAO modDAO2 = new ClienteDAO();
    private Empleado mod3 = new Empleado();
    private EmpleadoDAO modDAO3 = new EmpleadoDAO();
    private ProveedoresDAO modDAO4 = new ProveedoresDAO();
    private Proveedores mod4 = new Proveedores();
    private Pedido mod5 = new Pedido();
    private PedidoDAO modDAO5 = new PedidoDAO();
    private Menu mod6 = new Menu();
    private MenuDAO modDAO6 = new MenuDAO();
    private FrmMenuA frm = new FrmMenuA();
    FrmClientes frm1 = new FrmClientes();
    FrmEmpleados frm2 = new FrmEmpleados();
    FrmMenuAgregar frm3 = new FrmMenuAgregar();
    FrmProveedores frm4 = new FrmProveedores();
    FrmPedidosVer frm5 = new FrmPedidosVer();
    FrmAbout frm6 = new FrmAbout();
    //Constructor
    public MenuAController(Administrador mod, AdministradorDAO modDAO, FrmMenuA frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Implementar escuchadores
        this.frm.btnEmpleados.addActionListener(this);
        this.frm.btnClientes.addActionListener(this);
        this.frm.btnMenu.addActionListener(this);
        this.frm.btnProveedores.addActionListener(this);
        this.frm.btnPedidos.addActionListener(this);
        this.frm.btnAcercaDe.addActionListener(this);
    }
    //Metodos
    public void abrirEmpleados(){
        EmpleadosController ec = new EmpleadosController(mod3, modDAO3, frm2);
        ec.iniciar();
        frm2.setLocationRelativeTo(frm);
        frm2.setVisible(true);
    }
    public void iniciar(){
        
    }
    public void abrirClientes(){
        ClientesController cc = new ClientesController(mod2, modDAO2, frm1);
        cc.iniciar();
        frm1.setLocationRelativeTo(frm);
        frm1.setVisible(true);
    }
    public void abrirMenu(){
        MenuAgregarController ma = new MenuAgregarController(mod6, modDAO6, frm3);
        ma.iniciar();
        frm3.setLocationRelativeTo(frm);
        frm3.setVisible(true);
    }
    public void abrirProveedores(){
        ProveedoresController pc = new ProveedoresController(mod4, modDAO4, frm4);
        pc.iniciar();
        frm4.setLocationRelativeTo(frm);
        frm4.setVisible(true);
    }
    public void abrirPedidos(){
        PedidosVerController pC = new PedidosVerController(mod5, modDAO5, frm5);
        pC.iniciar();
        frm5.setLocationRelativeTo(frm);
        frm5.setVisible(true);
    }
    public void abrirAcerca(){
        frm6.setLocationRelativeTo(frm);
        frm6.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        //Accion boton empleados
        if(e.getSource() == frm.btnEmpleados){
            abrirEmpleados();
        }
        if(e.getSource() == frm.btnClientes){
            abrirClientes();
        }
        if(e.getSource() == frm.btnMenu){
            abrirMenu();
        }
        if(e.getSource() == frm.btnProveedores){
            abrirProveedores();
        }
        if(e.getSource() == frm.btnPedidos){
            abrirPedidos();
        }
        if(e.getSource() == frm.btnAcercaDe){
            abrirAcerca();
        }
    }
}
