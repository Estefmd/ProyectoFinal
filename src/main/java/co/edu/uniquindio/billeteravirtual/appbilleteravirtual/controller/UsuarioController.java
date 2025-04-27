package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.controller;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.factory.ModelFactory;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<UsuarioDto> listaUsuarios = new ArrayList<>();

    public UsuarioController() {
        // Agregar algunos usuarios predeterminados
        listaUsuarios.add(new UsuarioDto("12345", "Natalia Martinez", "nata@gmail.com", "3107778446", "Barrio la patria", 1000000));
        listaUsuarios.add(new UsuarioDto("22222", "Luis Montoya", "l@gmail.com", "3112220099", "Barrio San Jose", 10000000));
        listaUsuarios.add(new UsuarioDto("66688", "Gloria Davila", "gloria@gmail.com", "3107025247", "Barrio Norte", 10000000));
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return listaUsuarios;
    }

    public boolean agregarUsuario(UsuarioDto usuario) {
        return listaUsuarios.add(usuario);
    }

    public boolean actualizarUsuario(String id, UsuarioDto nuevoUsuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).idUsuario().equals(id)) {
                listaUsuarios.set(i, nuevoUsuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(String id) {
        return listaUsuarios.removeIf(usuario -> usuario.idUsuario().equals(id));
    }


}
