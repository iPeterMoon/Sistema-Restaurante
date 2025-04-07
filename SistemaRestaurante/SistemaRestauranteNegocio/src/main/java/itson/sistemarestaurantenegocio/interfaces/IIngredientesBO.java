package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IIngredientesBO {

    /**
     * Metodo para agregar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a agregar
     * @return Ingrediente que se ha agregado a la base de datos
     * @throws NegocioException Si el ingrediente no se puede agregar debido a
     * un error en la base de datos
     */
    public abstract Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;

    /**
     * Metodo para obtener ingredientes de la base de datos
     *
     * @return Lista de todos los ingredientes de la base de datos
     * @throws NegocioException Si todos los ingredientes no se puede obtener
     * debido a un error de la base de datos
     */
    public abstract List<IngredienteDTO> obtenerIngredientes() throws NegocioException;

    /**
     * Metodo para obtener ingredientes filtrados de la base de datos
     *
     * @param filtroBusqueda Filtro de busqueda de ingredientes
     * @return Lista con todos los ingredientes filtrados de la base de datos
     * @throws NegocioException Si los ingredientes no se pueden obtener debido
     * a un error de la base de datos
     */
    public abstract List<IngredienteDTO> obtenerIngredientes(String filtroBusqueda) throws NegocioException;
    
    /**
     * Metodo para obtener todos los ingredientes de ambos filtros
     *
     * @param filtroNombre Filtro del ingrediente por nombre
     * @param filtroUnidad Filtro del ingrediente por unidad de medida
     * @return Lista con todos los ingredientes que coincidan con ambos filtros
     * @throws NegocioException Si los ingredientes no se pueden obtener por un
     * error en la base de datos
     */
    public abstract List<IngredienteDTO> obtenerIngredientes(String filtroNombre, String filtroUnidad) throws NegocioException;

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * @param idIngrediente Id del ingrediente a buscar
     * @return IngredienteDTO con el ingrediente encontrado o null si no se
     * @throws NegocioException Si el ingrediente no se puede obtener
     */
    public abstract IngredienteDTO obtenerIngredientePorId(Long idIngrediente) throws NegocioException;

}
