package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.factory;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.BilleteraVirtual;

import java.util.ArrayList;

public class ModelFactory {
    public static ModelFactory instance;
    private BilleteraVirtual billetera;

    private ModelFactory() {
        billetera = new BilleteraVirtual();
        inicializarDatos();
    }
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    private void inicializarDatos() {





    }
    public BilleteraVirtual getBilletera() {
        return billetera;
    }

}
