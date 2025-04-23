package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.builder;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Cuenta;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Presupuesto;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Transaccion;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;

import java.util.List;

public class UsuarioBuilder {
    protected String idUsuario;
    protected String nombreCompleto;
    protected String correo;
    protected String numeroTelefono;
    protected String direccion;
    protected double saldo;
    protected List<Cuenta> cuentas;
    protected List<Transaccion> transacciones;
    protected List<Presupuesto> presupuestos;

    public UsuarioBuilder(){
    }
    public UsuarioBuilder idUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public UsuarioBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }
    public UsuarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }
    public UsuarioBuilder numeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        return this;
    }
    public UsuarioBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
    public UsuarioBuilder saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }
    public UsuarioBuilder cuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
        return this;
    }
    public UsuarioBuilder transacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
        return this;
    }
    public UsuarioBuilder presupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
        return this;
    }
    public Usuario build() {
        return new Usuario(idUsuario,nombreCompleto,correo,numeroTelefono,
                direccion,saldo);
    }



}
