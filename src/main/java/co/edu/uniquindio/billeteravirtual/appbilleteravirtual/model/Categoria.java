package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;

    public Categoria(int idCategoria, String nombreCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

}
