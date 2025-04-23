package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtual {
    private List<Administrador> Administradores;
    private List<Categoria> Categorias;
    private List<Cuenta> Cuentas;
    private List<Presupuesto> Presupuestos;
    private List<Transaccion> transacciones;
    private List<Usuario> usuarios;

    public BilleteraVirtual () {
        this.Administradores = new ArrayList<>();
        this.Categorias = new ArrayList<>();
        this.Cuentas = new ArrayList<>();
        this.Presupuestos = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Administrador> getAdministradores() {
        return Administradores;
    }
    public List<Categoria> getCategorias() {
        return Categorias;
    }
    public List<Cuenta> getCuentas() {
        return Cuentas;
    }
    public List<Presupuesto> getPresupuestos() {
        return Presupuestos;
    }
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario registrarUsuario(String idUsuario, String nombreCompleto, String correo,
                                    String numeroTelefono, String direccion, double saldo) {
        Usuario usuario = obtenerUsuario(idUsuario);
        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "El Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return usuario;
        }
        usuario = new Usuario (idUsuario, nombreCompleto, correo, numeroTelefono, direccion, saldo);
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado");
        return usuario;
    }
    public Usuario obtenerUsuario(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(String idUsuario, String nombreCompleto, String correo,
                                     String numeroTelefono, String direccion, double saldo) {
        Usuario usuarioActual = obtenerUsuario(idUsuario);
        if (usuarioActual != null) {
            usuarioActual.setIdUsuario(idUsuario);
            usuarioActual.setNombreCompleto(nombreCompleto);
            usuarioActual.setCorreo(correo);
            usuarioActual.setNumeroTelefono(numeroTelefono);
            usuarioActual.setDireccion(direccion);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(String idUsuario) {
        Usuario usuarioEliminado = obtenerUsuario(idUsuario);
        if (usuarioEliminado != null) {
            usuarios.remove(usuarioEliminado);
            return true;
        }
        return false;
    }



}
