package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model;

import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    private int idPresupuesto;
    private String nombrePresupuesto;
    private double montoTotal;
    private double montoGastado;
    private List<Categoria> categorias;

    public Presupuesto(int idPresupuesto, String nombrePresupuesto, double total, double montoTotal) {
        this.idPresupuesto = idPresupuesto;
        this.nombrePresupuesto = nombrePresupuesto;
        this.montoTotal = montoTotal;
        this.montoGastado = montoTotal;
        this.categorias = new ArrayList<>();
    }
    public int getIdPresupuesto() {
        return idPresupuesto;
    }
    public String getNombrePresupuesto() {
        return nombrePresupuesto;
    }
    public double getMontoTotal() {
        return montoTotal;
    }
    public double getMontoGastado() {
        return montoGastado;
    }
    public List<Categoria> getCategorias() {
        return categorias;
    }


}
