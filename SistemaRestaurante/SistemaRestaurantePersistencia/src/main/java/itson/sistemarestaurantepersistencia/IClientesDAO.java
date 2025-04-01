package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;

public interface IClientesDAO{
        
        /**
        * Metodo para registrar un cliente en la base de datos
        * @param nuevoCliente cliente a registrar
        */
        public Cliente registrarCliente(NuevoClienteDTO nuevoCliente);
}