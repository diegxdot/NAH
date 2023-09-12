/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.LoginController;
import Model.Cliente;
import Model.ClienteDAO;
import Model.Administrador;
import Model.AdministradorDAO;
import Model.Empleado;
import Model.EmpleadoDAO;
import View.FrmLogin;
        
public class TestProyecto {
    public static void main(String[] args) {
        //Se crean objetos
        //Modelo
        Cliente mod = new Cliente();
        Administrador mod2 = new Administrador();
        Empleado mod3 = new Empleado();
        //La que hace operaciones
        ClienteDAO modDao = new ClienteDAO();
        AdministradorDAO modDAO2 = new AdministradorDAO();
        EmpleadoDAO modDAO3 = new EmpleadoDAO();
        //La ventana
        FrmLogin frm = new FrmLogin();
        //Objeto para mandar todo atras
        LoginController loginC = new LoginController(mod, modDao, mod2, modDAO2, mod3, modDAO3, frm);
        
        loginC.iniciar();
        frm.setVisible(true);
    }
}
