package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.utils;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos() {

        BilleteraVirtual billetera = new BilleteraVirtual();

        Usuario usuario1 = Usuario.builder()
                .idUsuario("12345")
                .nombreCompleto("Natalia Martinez")
                .correo("nata@gmail.com")
                .numeroTelefono("3107778446")
                .direccion("Barrio la patria")
                .saldo(1000000)
                .build();

        Usuario usuario2 = Usuario.builder()
                .idUsuario("22222")
                .nombreCompleto("Luis Montoya")
                .correo("l@gmail.com")
                .numeroTelefono("3112220099")
                .direccion("Barrio San Jose")
                .saldo(10000000)
                .build();

        Usuario usuario3 = Usuario.builder()
                .idUsuario("66688")
                .nombreCompleto("Gloria Davila")
                .correo("gloria@gmail.com")
                .numeroTelefono("3107025247")
                .direccion("Barrio Norte")
                .saldo(10000000)
                .build();

        billetera.getUsuarios().add(usuario1);
        billetera.getUsuarios().add(usuario2);
        billetera.getUsuarios().add(usuario3);

        return billetera;
    }

}

