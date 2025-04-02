package itson.sistemarestaurantepresentacion.main;

import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;

public class Main {

    public static void main(String[] args) {
        ControlFlujo control = ControlFlujo.getInstance();
        IMesasBO mesasBO = ObjetosNegocioFactory.crearMesasBO();
        IClientesBO clientesBO = ObjetosNegocioFactory.crearClientesBO();
        control.setMesasBO(mesasBO);
        control.setClientesBO(clientesBO);
        control.iniciarFlujo();
    }
}
