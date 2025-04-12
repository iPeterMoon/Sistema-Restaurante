package itson.sistemarestaurantepersistencia;

import java.math.BigDecimal;
import java.util.List;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.Calendar;

/**
 * Interfaz que define los métodos para la persistencia de las comandas en el
 * sistema de restaurante.
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
     * Obtiene una lista de todas las comandas registradas en el sistema.
     *
     * @return Lista de objetos ComandaDTO que representan las comandas.
     */
    public abstract List<ComandaDTO> obtenerComandasAbiertas();

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    public abstract ComandaDTO obtenerComandaPorId(Long idComanda);

    /**
     * Metodo para cambiar el estado de una comanda
     *
     * @param idComanda Id de la comanda a cambiar
     * @param nuevoEstado Nuevo estado de la comanda
     * @throws PersistenciaException Si ocurre una excepcion al cambiar el
     * estado de la comanda en la base de datos
     */
    public abstract void cambiarEstadoComanda(Long idComanda, EstadoComanda nuevoEstado) throws PersistenciaException;

    /**
     * Metodo para modificar el total de una comanda
     *
     * @param idComanda Id de la comanda a modificar
     * @param nuevoTotal Nuevo Total de la comanda
     */
    public abstract void modificarTotal(Long idComanda, BigDecimal nuevoTotal);

    /**
     * Metodo para obtener comandas dentro de un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Lista con todas las comandas realizadas dentro del periodo
     */
    public abstract List<Comanda> obtenerComandasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal);

    /**
     * Metodo para calcular el total de ventas en un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Total de venta realizada en el periodo
     */
    public abstract BigDecimal calcularTotalVentasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal);
}
