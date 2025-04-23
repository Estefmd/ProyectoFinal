package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.builder.UsuarioBuilder;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
   private String idUsuario;
   private String nombreCompleto;
   private String correo;
   private String numeroTelefono;
   private String direccion;
   private double saldo;
   private List<Cuenta> cuentas;
   private List<Transaccion> transacciones;
   private List<Presupuesto> presupuestos;

   public Usuario(String idUsuario, String nombreCompleto, String correo, String numeroTelefono,
                  String direccion, double saldo) {
       this.idUsuario = idUsuario;
       this.nombreCompleto = nombreCompleto;
       this.correo = correo;
       this.numeroTelefono = numeroTelefono;
       this.direccion = direccion;
       this.saldo = saldo;
       this.cuentas = new ArrayList<Cuenta>();
       this.transacciones = new ArrayList<Transaccion>();
       this.presupuestos = new ArrayList<Presupuesto>();
   }
   public String getIdUsuario() {
       return idUsuario;
   }
   public String getNombreCompleto() {
       return nombreCompleto;
   }
   public String getCorreo() {
       return correo;
   }
   public String getNumeroTelefono() {
       return numeroTelefono;
   }
   public String getDireccion() {
       return direccion;
   }
   public double getSaldo() {
       return saldo;
   }
   public List<Cuenta> getCuentas() {
       return cuentas;
   }
   public List<Transaccion> getTransacciones() {
       return transacciones;
   }
   public List<Presupuesto> getPresupuestos() {
       return presupuestos;
   }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    public static UsuarioBuilder builder() {
       return new UsuarioBuilder();
   }
}
