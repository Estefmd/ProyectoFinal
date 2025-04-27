package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.service;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;

import java.util.List;

public interface IBilleteraVirtualMapping {
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
