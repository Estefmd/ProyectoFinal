package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.factory;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.mappers.BilleteraVirtualMappersImpl;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.service.IBilleteraVirtualMapping;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.utils.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    public static ModelFactory instance;
    private BilleteraVirtual billetera;
    private IBilleteraVirtualMapping mapper;

    public static ModelFactory getInstancia() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new BilleteraVirtualMappersImpl();
        billetera = DataUtil.inicializarDatos();
    }
    public BilleteraVirtual getBilletera() {
        return billetera;
    }

    public List<UsuarioDto> obtenerUsuarios() {
        List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
        for (Usuario usuario : billetera.getUsuarios()) {
            listaUsuariosDto.add(mapper.usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        Usuario usuarioNuevo = mapper.usuarioDtoToUsuario(usuarioDto);
        if (billetera.obtenerUsuario(usuarioNuevo.getIdUsuario()) != null) {
            return false;  // El usuario ya existe
        }
        billetera.getUsuarios().add(usuarioNuevo);
        return true;
    }

    public boolean eliminarUsuario(String idUsuario) {
        Usuario usuarioEliminado = billetera.obtenerUsuario(idUsuario);
        if (usuarioEliminado != null) {
            billetera.getUsuarios().remove(usuarioEliminado);
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario(String idUsuario, UsuarioDto usarioDtoNuevo) {
        Usuario usuarioExistente = billetera.obtenerUsuario(idUsuario);
        if (usuarioExistente != null) {
            Usuario usuarioActualizado = mapper.usuarioDtoToUsuario(usarioDtoNuevo);
            usuarioExistente.setIdUsuario(usuarioActualizado.getIdUsuario());
            usuarioExistente.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setNumeroTelefono(usuarioActualizado.getNumeroTelefono());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setSaldo(usuarioActualizado.getSaldo());
            return true;
        }
        return false;
    }

    private Usuario obtenerUsuario(String idUsuario) {
        for (Usuario usuario : billetera.getUsuarios()) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }




}
