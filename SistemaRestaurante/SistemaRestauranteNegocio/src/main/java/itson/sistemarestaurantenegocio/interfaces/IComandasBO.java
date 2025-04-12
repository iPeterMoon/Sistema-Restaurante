package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.Comanda;
import java.math.BigDecimal;
import java.util.List;

import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.Calendar;

/**
 * Interfaz que define los métodos para la lógica de negocio de las comandas.
 * Esta interfaz puede ser implementada por diferentes clases que manejen la
 * lógica
 */
public interface IComandasBO {

    /**
     * Metodo que se encarga de guardar una nueva comanda en la base de datos
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda
     * @throws NegocioException Si ocurre alguna excepcion de negocio al guardar
     * la comanda
     */
    public abstract void guardarComanda(NuevaComandaDTO comandaDTO) throws NegocioException;

    /**
     * Metodo que se encarga de entregar una comanda en la base de datos
     *
     * @param comandaDTO Objeto que tiene los datos de la comanda
     * @throws NegocioException Si ocurre alguna excepcion de negocio al
     * entregar la comanda
     */
    public abstract void entregarComanda(ComandaDTO comandaDTO) throws NegocioException;

     /**
     * Metodo que se encarga de cancelar una comanda en la base de datos
     *
     * @param comandaDTO Objeto que tiene los datos de la comanda
     * @throws NegocioException Si ocurre alguan excepcion de negocio al
     * cancelar una comanda
     */
    public abstract void cancelarComanda(ComandaDTO comandaDTO) throws NegocioException;

    /**
     * Metodo que se encarga de obtener las comandas de la base de datos
     *
     * @return Lista de comandas obtenidas en la base de datos
     * @throws NegocioException Si ocurre una exccepcion de negocio al obtener
     * las comandas
     */
    public abstract List<ComandaDTO> obtenerComandas() throws NegocioException;

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    public abstract ComandaDTO obtenerComandaPorId(Long idComanda);

    /**
     * Modifica una comanda
     *
     * @param comanda Comanda a modificar
     * @param nuevosDetalles Los detalles modificados de la comanda
     * @throws NegocioException
     */
    public abstract void modificarComanda(ComandaDTO comanda, List<DetallesComandaDTO> nuevosDetalles) throws NegocioException;

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
     * @throws NegocioException si ocurre alguna excepcion al obtener las comandas por periodo
     */
    public abstract List<Comanda> obtenerComandasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException;

    /**
     * Metodo para calcular el total de ventas en un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Total de venta realizada en el periodo
     * @throws NegocioException si ocurre alguna excepcion al calcular el tortal
     * de ventas por periodo
     */
    public abstract BigDecimal calcularTotalVentasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException;
}
