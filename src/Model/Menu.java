/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Diego
 */
public class Menu {
    private int id;
    private int tipoComida;
    private String nombre;
    private int precio;

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(int tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
