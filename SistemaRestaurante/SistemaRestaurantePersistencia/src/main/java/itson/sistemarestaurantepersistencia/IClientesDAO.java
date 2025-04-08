package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;

/**
 * Interfaz que define los métodos para la persistencia de los clientes en el sistema de restaurante.
 */
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
        public List<ClienteDTO> obtenerClientesFrecuentes();

        /**
         * Metodo para buscar clientes por nombre
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorNombre(String nombre);

        /**
         * Metodo para buscar clientes por telefono
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorTelefono(String telefono);

        /**
         * Metodo para buscar clientes por correo
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorCorreo(String correo);
        
        /**
         * Metodo para buscar clientes por nombre y telefono
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono);

        /**
         * Metodo para buscar clientes por telefono y correo
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo);

        /**
         * Metodo para buscar clientes por telefono y correo
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo);

        /**
         * Metodo para buscar clientes por nombre, telefono y correo
         * @return lista de clientes encontrados
         */
        public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo);

}