package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

import java.util.List;

/**
 * Interfaz que define los métodos para la persistencia de los ingredientes
 * en el sistema de restaurante.
 * @author PC
 */
public interface IIngredientesDAO {

    /**
     * Metodo para registrar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Nuevo ingrediente a agregar
     * @return Ingrediente agregado en la base de datos
     */
    public abstract Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente);

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos
     *
     * @return Lista con todos los ingredientes
     */
    public abstract List<Ingrediente> obtenerIngredientes();

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con el filtro de buscqueda
     *
     * @param filtroBusqueda Filtro para buscar los ingredientes
     * @return Lista con los ingredientes coincidentes con el filtro
     */
    public abstract List<Ingrediente> obtenerIngrediente(String filtroBusqueda);

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coinciden con ambos filtros de busqueda
     *
     * @param filtroNombre Filtro que busca el ingrediente por nombre
     * @param filtroUnidad Filtro que busca el ingrediente por unidad de medida
     * @return Lista con los ingredientes que coinciden con ambos filtros
     */
    public abstract List<Ingrediente> obtenerIngrediente(String filtroNombre, String filtroUnidad);

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos y convertirlos a DTO
     *
     * @return Lista con todos los ingredientes en formato DTO
     */
    public abstract List<IngredienteDTO> obtenerIngredientesDTO();

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con el filtro de busqueda y convertirlos a DTO
     *
     * @param filtroBusqueda Filtro para buscar los ingredientes
     * @return Lista con los ingredientes coincidentes con el filtro en formato
     * DTO
     */
    public abstract List<IngredienteDTO> obtenerIngredientesDTO(String filtroBusqueda);

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con ambos filtros de busqueda y convertirlos a DTO
     *
     * @param filtroNombre Filtro que busca el ingrediente por nombre
     * @param filtroUnidad Filtro que busca el ingrediente por unidad de medida
     * @return Lista con todos los ingredientes coincidentes con ambos filtros
     * en formato DTO
     */
    public List<IngredienteDTO> obtenerIngredientesDTO(String filtroNombre, String filtroUnidad);

    /**
     * Metodo para obtener un ingrediente de la base de datos por su id y
     * convertirlo a DTO
     *
     * @param idIngrediente Id del ingrediente a buscar
     * @return IngredienteDTO con el ingrediente encontrado o null si no se
     * encuentra
     */
    public abstract IngredienteDTO obtenerIngredientePorId(Long idIngrediente);

    /**
     * Metodo que verifica si existe un ingrediente con el mismo nombre y unidad
     * de medida
     *
     * @param nuevoIngrediente Ingrediente a verificar
     * @return True o False dependiendo si existe un ingrediente con el mismo
     * nombre y unidad de medida o no
     */
    public abstract boolean existeIngredienteYUnidad(NuevoIngredienteDTO nuevoIngrediente);

    /**
     * Metodo para agregar al stock de un ingrediente
     * @param idIngrediente ID del ingrediente a modificar
     * @param stock Stock a agregar
     */
    public abstract void agregarStock(Long idIngrediente, Integer stock);

    /**
     * Metodo para quitarle al stock de un ingrediente
     * @param idIngrediente ID del ingrediente a modificar
     * @param stock Stock a eliminar
     */
    public abstract void quitarStock(Long idIngrediente, Integer stock) throws PersistenciaException;

}
