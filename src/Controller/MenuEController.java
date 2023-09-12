
package Controller;

//@author Diego

//Importaciones
import Model.Empleado;
import Model.EmpleadoDAO;
import Model.Pedido;
import Model.PedidoDAO;
import Model.Menu;
import Model.MenuDAO;
import View.FrmMenuE;
import View.FrmAbout;
import View.FrmMenuAgregar;
import View.FrmPedidosVer;
import View.FrmEntregar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEController implements ActionListener{
    //Objetos
    private Empleado mod = new Empleado();
    private EmpleadoDAO modDAO = new EmpleadoDAO();
    private FrmMenuE frm = new FrmMenuE();
    private Pedido mod2 = new Pedido();
    private PedidoDAO modDAO2 = new PedidoDAO();
    private Menu mod3 = new Menu();
    private MenuDAO modDAO3 = new MenuDAO();
    FrmMenuAgregar frm1 = new FrmMenuAgregar();
    FrmPedidosVer frm2 = new FrmPedidosVer();
    FrmEntregar frm3 = new FrmEntregar();
    FrmAbout frm4 = new FrmAbout();
    //Constructor
    public MenuEController(Empleado mod, EmpleadoDAO modDAO, FrmMenuE frm) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.frm = frm;
        //Implementamos escuchadores
        this.frm.btnPedidos.addActionListener(this);
        this.frm.btnEntregas.addActionListener(this);
        this.frm.btnMenu.addActionListener(this);
        this.frm.btnAcercaDe.addActionListener(this);
    }
    //Metodos
    public void iniciar(){
        
    }
    public void abirMenu(){
        MenuAgregarController ma = new MenuAgregarController(mod3, modDAO3, frm1);
        ma.iniciar();
        frm1.setLocationRelativeTo(frm);
        frm1.setVisible(true);
    }
    public void abrirEntregas(){
        EntregarController ec = new EntregarController(mod2, modDAO2, frm3);
        ec.iniciar();
        frm3.setLocationRelativeTo(frm);
        frm3.setVisible(true);
    }
    public void abrirPedidos(){
        PedidosVerController pc = new PedidosVerController(mod2, modDAO2, frm2);
        pc.iniciar();
        frm2.setLocationRelativeTo(frm);
        frm2.setVisible(true);
    }
    public void abirAcerca(){
        frm4.setLocationRelativeTo(frm);
        frm4.setVisible(true);
    }
    //Funciones de botones
    @Override
    public void actionPerformed(ActionEvent e){
        //Accion boton menu
        if(e.getSource() == frm.btnMenu){
            abirMenu();
        }
        //Accion boton pedidos
        if(e.getSource() == frm.btnPedidos){
            abrirPedidos();
        }
        //Accion boton entregas
        if(e.getSource() == frm.btnEntregas){
            abrirEntregas();
        }
        //Accion boton acerca
        if(e.getSource() == frm.btnAcercaDe){
            abirAcerca();
        }
    }
}
