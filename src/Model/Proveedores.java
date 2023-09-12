
package Model;

public class Proveedores {
   //Atributos 
    private int ida;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String provee;
    private String producto;
    //Constructor vacio
    public Proveedores() {
    }
    //Getters y setters
    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvee() {
        return provee;
    }

    public void setProvee(String provee) {
        this.provee = provee;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
}
