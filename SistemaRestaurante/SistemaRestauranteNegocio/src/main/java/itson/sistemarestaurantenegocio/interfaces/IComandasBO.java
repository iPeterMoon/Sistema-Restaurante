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
     */
    public abstract List<Comanda> obtenerComandasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException;

    /**
     * Metodo para calcular el total de ventas en un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Total de venta realizada en el periodo
     */
    public abstract BigDecimal calcularTotalVentasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException;
}
