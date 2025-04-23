package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Cuenta;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Presupuesto;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Transaccion;
import java.util.List;

public record UsuarioDto(
        String idUsuario,
        String nombreCompleto,
        String correo,
        String numeroTelefono,
        String direccion,
        double saldo,
        List<Cuenta>cuentas,
        List<Transaccion> transacciones,
        List<Presupuesto> presupuestos
) {
}
