/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class Pedido {
    private int id_orden; 
    private String comida; 
    private int cantidad; 
    private String cliente;
    private String estado_entrega;
    
    public Pedido() {
    }

    public int getId_orden() {
        return id_orden;
    }

    public String getComida() {
        return comida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstado_entrega() {
        return estado_entrega;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEstado_entrega(String estado_entrega) {
        this.estado_entrega = estado_entrega;
    }
    
}
