package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 * Interfaz que define los métodos para la lógica de negocio de las comandas.
 * Esta interfaz puede ser implementada por diferentes clases que manejen la lógica
 */
public interface IComandasBO {

    
    /**
     * Guarda una nueva comanda en el sistema.
     *
     * @param comandaDTO Objeto que contiene los datos de la nueva comanda.
     */
    public abstract void guardarComanda(NuevaComandaDTO comandaDTO) throws NegocioException;

    /**
     * Marca una comanda como entregada.
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda a entregar.
     */
    public abstract void entregarComanda(ComandaDTO comandaDTO) throws NegocioException;

    /**
     * Cancela una comanda en el sistema.
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda a cancelar.
     */
    public abstract void cancelarComanda(ComandaDTO comandaDTO) throws NegocioException;

    /**
     * Obtiene una lista de todas las comandas registradas en el sistema.
     *
     * @return Lista de objetos ComandaDTO que representan las comandas.
     */
    public abstract List<ComandaDTO> obtenerComandas() throws NegocioException;

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    public abstract ComandaDTO obtenerComandaPorId(Long idComanda);
    
}
