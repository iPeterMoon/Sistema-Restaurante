package itson.sistemarestaurantenegocio.implementaciones;

import java.math.BigDecimal;
import java.util.List;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IComandasBO;
import itson.sistemarestaurantenegocio.interfaces.IDetallesComandaBO;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesProductoBO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.Calendar;

/**
 * Implementación de la interfaz IComandasBO que define los métodos para la
 * lógica de negocio de las comandas. Esta clase utiliza un objeto IComandasDAO
 * para interactuar con la capa de persistencia.
 */
public class ComandasBO implements IComandasBO {

    private IComandasDAO comandasDAO;

    /**
     * Constructor que inicializa el objeto IComandasDAO.
     *
     * @param comandasDAO Objeto de acceso a datos para las comandas.
     */
    public ComandasBO(IComandasDAO comandasDAO) {
        this.comandasDAO = comandasDAO;
    }

    /**
     * Metodo que se encarga de guardar una nueva comanda en la base de datos
     *
     * @param comandaDTO Objeto que contiene los datos de la comanda
     * @throws NegocioException Si ocurre alguna excepcion de negocio al guardar
     * la comanda
     */
    @Override
    public void guardarComanda(NuevaComandaDTO comandaDTO) throws NegocioException {
        if (comandaDTO == null) {
            throw new NegocioException("La comanda no puede ser nula");
        }
        if (comandaDTO.getDetallesComanda() == null || comandaDTO.getDetallesComanda().isEmpty()) {
            throw new NegocioException("La comanda debe tener al menos un producto");
        }
        if (comandaDTO.getIdMesa() == null) {
            throw new NegocioException("La comanda debe tener una mesa asignada");
        }
        Comanda comandaGuardada = comandasDAO.guardarComanda(comandaDTO);
        if (comandaGuardada == null) {
            throw new NegocioException("Error al guardar la comanda");
        }

    }

    /**
     * Metodo que se encarga de entregar una comanda en la base de datos
     *
     * @param comandaDTO Objeto que tiene los datos de la comanda
     * @throws NegocioException Si ocurre alguna excepcion de negocio al
     * entregar la comanda
     */
    @Override
    public void entregarComanda(ComandaDTO comandaDTO) throws NegocioException {
        try {
            IDetallesComandaBO detallesComandaBO = ObjetosNegocioFactory.crearDetallesComandaBO();
            IIngredientesProductoBO ingredientesProductoBO = ObjetosNegocioFactory.crearIngredientesProductoBO();
            IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
            List<DetallesComandaDTO> detallesComanda = detallesComandaBO.obtenerDetallesComanda(comandaDTO.getIdComanda());
            for (DetallesComandaDTO detalle : detallesComanda) {
                List<IngredienteProductoDTO> ingredientesProducto
                        = ingredientesProductoBO.obtenerIngredientesProductoPorIdProducto(detalle.getIdProducto());
                for (int i = 1; i <= detalle.getCantidad(); i++) {
                    for (IngredienteProductoDTO ingrediente : ingredientesProducto) {
                        ingredientesBO.eliminarStock(ingrediente.getIdIngrediente(), ingrediente.getCantidad());
                    }
                }
            }
            if (comandaDTO.getIdCliente() != null) {
                final double CONVERSION = 20.0;
                Integer puntos = comandaDTO.getTotal().divide(BigDecimal.valueOf(CONVERSION)).intValue();
                IClientesBO clientesBO = ObjetosNegocioFactory.crearClientesBO();
                clientesBO.agregarPuntos(comandaDTO.getIdCliente(), puntos);
            }
            comandasDAO.cambiarEstadoComanda(comandaDTO.getIdComanda(), EstadoComanda.ENTREGADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    /**
     * Metodo que se encarga de cancelar una comanda en la base de datos
     *
     * @param comandaDTO Objeto que tiene los datos de la comanda
     * @throws NegocioException Si ocurre alguan excepcion de negocio al
     * cancelar una comanda
     */
    @Override
    public void cancelarComanda(ComandaDTO comandaDTO) throws NegocioException {
        try {
            comandasDAO.cambiarEstadoComanda(comandaDTO.getIdComanda(), EstadoComanda.CANCELADA);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Metodo que se encarga de obtener las comandas de la base de datos
     *
     * @return Lista de comandas obtenidas en la base de datos
     * @throws NegocioException Si ocurre una exccepcion de negocio al obtener
     * las comandas
     */
    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        List<ComandaDTO> comandas = comandasDAO.obtenerComandasAbiertas();
        if (comandas == null || comandas.isEmpty()) {
            throw new NegocioException("No se encontraron comandas abiertas en el sistema");
        }
        return comandas;
    }

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    @Override
    public ComandaDTO obtenerComandaPorId(Long idComanda) {
        return comandasDAO.obtenerComandaPorId(idComanda);
    }

    /**
     * Modifica una comanda
     *
     * @param comanda Comanda a modificar
     * @param nuevosDetalles Los detalles modificados de la comanda
     * @throws NegocioException
     */
    @Override
    public void modificarComanda(ComandaDTO comanda, List<DetallesComandaDTO> nuevosDetalles) throws NegocioException {
        IDetallesComandaBO detallesComandaBO = ObjetosNegocioFactory.crearDetallesComandaBO();
        List<DetallesComandaDTO> antiguosDetalles = detallesComandaBO.obtenerDetallesComanda(comanda.getIdComanda());
        for (DetallesComandaDTO detalle : antiguosDetalles) {
            detallesComandaBO.eliminarDetallesComanda(detalle.getId());
        }
        BigDecimal total = new BigDecimal(0);
        for (DetallesComandaDTO nuevoDetalle : nuevosDetalles) {
            total = total.add(nuevoDetalle.getTotalPorProducto());
            detallesComandaBO.guardarDetallesComanda(nuevoDetalle);
        }
        comanda.setTotal(total);
        modificarTotal(comanda.getIdComanda(), total);
    }

    /**
     * Metodo para modificar el total de una comanda
     *
     * @param idComanda Id de la comanda a modificar
     * @param nuevoTotal Nuevo Total de la comanda
     */
    @Override
    public void modificarTotal(Long idComanda, BigDecimal nuevoTotal) {
        comandasDAO.modificarTotal(idComanda, nuevoTotal);
    }

    /**
     * Metodo para obtener comandas dentro de un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Lista con todas las comandas realizadas dentro del periodo
     * @throws NegocioException si ocurre alguna excepcion al obtener las
     * comandas por periodo
     */
    @Override
    public List<Comanda> obtenerComandasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException {
        validarRangoFechas(fechaInicial, fechaFinal);

        List<Comanda> comandas;

        try {
            comandas = comandasDAO.obtenerComandasPorPeriodo(fechaInicial, fechaFinal);
        } catch (Exception e) {
            throw new NegocioException("Ha ocurrido un error al obtener las comandas con el periodo: " + e.getMessage());
        }

        return comandas;
    }

    /**
     * Metodo para calcular el total de ventas en un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Total de venta realizada en el periodo
     * @throws NegocioException si ocurre alguna excepcion al calcular el tortal
     * de ventas por periodo
     */
    @Override
    public BigDecimal calcularTotalVentasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException {
        validarRangoFechas(fechaInicial, fechaFinal);

        BigDecimal totalVentas;

        try {
            totalVentas = comandasDAO.calcularTotalVentasPorPeriodo(fechaInicial, fechaFinal);
        } catch (Exception e) {
            throw new NegocioException("Ha ocurrido un error al obtener el total de ventas del periodo: " + e.getMessage());
        }

        return totalVentas;
    }

    /**
     * Metodo que valida el rango de las fechas del periodo
     *
     * @param fechaInicial Fecha inicial del periodo
     * @param fechaFinal Fecha final del periodo
     * @throws NegocioException Si hay algun problema con el formato
     */
    public void validarRangoFechas(Calendar fechaInicial, Calendar fechaFinal) throws NegocioException {
        if (fechaInicial == null || fechaFinal == null) {
            throw new NegocioException("Ambas fechas deben estar definidas.");
        }

        if (fechaInicial.after(fechaFinal)) {
            throw new NegocioException("La fecha de inicio no puede ser posterior a la fecha final.");
        }
    }

}
