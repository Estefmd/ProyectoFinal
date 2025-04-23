package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model;

public class Cuenta {
    private int idCuenta;
    private String nombreBanco;
    private int numeroCuenta;
    private String tipoCuenta;

    public Cuenta(int idCuenta, String nombreBanco, int numeroCuenta, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    public int getIdCuenta() {
        return idCuenta;
    }
    public String getNombreBanco() {
        return nombreBanco;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }

}
