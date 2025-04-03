package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;

public interface IClientesDAO{
        
        /**
        * Metodo para registrar un cliente en la base de datos
        * @param nuevoCliente cliente a registrar
        */
        public Cliente registrarCliente(NuevoClienteDTO nuevoCliente);

        /**
         * Metodo para obtener los clientes registrados en la bd
         * @return lista de clientes registrados
         */
        public List<Cliente> obtenerClientesFrecuentes();

        /**
         * Metodo para buscar clientes por nombre
         * @return lista de clientes encontrados
         */
        public List<Cliente> buscarClientesPorNombre(String nombre);

        /**
         * Metodo para buscar clientes por telefono
         * @return lista de clientes encontrados
         */
        public List<Cliente> buscarClientesPorTelefono(String telefono);

        /**
         * Metodo para buscar clientes por correo
         * @return lista de clientes encontrados
         */
        public List<Cliente> buscarClientesPorCorreo(String correo);

}