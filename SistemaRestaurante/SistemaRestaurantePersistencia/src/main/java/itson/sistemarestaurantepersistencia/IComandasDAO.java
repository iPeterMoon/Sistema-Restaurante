package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;

/**
 * Interfaz que define los métodos para la persistencia de las comandas en el sistema de restaurante.
 */
public interface IComandasDAO {

    /**
     * Guarda una nueva comanda en el sistema.
     *
     * @param comandaDTO Objeto que contiene los datos de la nueva comanda.
     * @return La entidad Comanda que fue guardada.
     */
    public abstract Comanda guardarComanda(NuevaComandaDTO comandaDTO);

    /**
     * Marca una comanda como entregada.
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda a entregar.
     */
    public abstract void entregarComanda(ComandaDTO comandaDTO);

    /**
     * Cancela una comanda en el sistema.
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda a cancelar.
     */
    public abstract void cancelarComanda(ComandaDTO comandaDTO);

    /**
     * Obtiene una lista de todas las comandas registradas en el sistema.
     *
     * @return Lista de objetos ComandaDTO que representan las comandas.
     */
    public abstract List<ComandaDTO> obtenerComandas();

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    public abstract ComandaDTO obtenerComandaPorId(Long idComanda);
}
