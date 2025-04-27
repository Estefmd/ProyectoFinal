package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.mappers;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.service.IBilleteraVirtualMapping;

import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtualMappersImpl implements IBilleteraVirtualMapping {
    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if(listaUsuarios == null){
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<>(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombreCompleto(),
                usuario.getCorreo(),
                usuario.getNumeroTelefono(),
                usuario.getDireccion(),
                usuario.getSaldo()
        );
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.idUsuario(),
                usuarioDto.nombreCompleto(),
                usuarioDto.correo(),
                usuarioDto.numeroTelefono(),
                usuarioDto.direccion(),
                usuarioDto.saldo()
        );
    }
}
