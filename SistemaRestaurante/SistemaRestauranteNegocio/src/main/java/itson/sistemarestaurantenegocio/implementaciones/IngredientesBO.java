package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

import java.util.List;

/**
 *
 * @author PC
 */
public class IngredientesBO implements IIngredientesBO {

    private IIngredientesDAO ingredientesDAO;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }

    /**
     * Metodo para agregar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a agregar
     * @return Ingrediente que se ha agregado a la base de datos
     * @throws NegocioException Si el ingrediente no se puede agregar debido a
     * un error en la base de datos
     */
    @Override
    public Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente)
            throws NegocioException {
        validarNombreYUnidadMedidaExistente(nuevoIngrediente);
        try {
            Ingrediente ingrediente = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
            return ingrediente;
        } catch (Exception e) {
            throw new NegocioException("No se ha podido agregar el usuario" + e);
        }
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException {
        List<IngredienteDTO> ingredientes = ingredientesDAO.obtenerIngredientesDTO();
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new NegocioException("No se encontraron productos en la base de datos");
        }
        return ingredientes;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes(String filtroBusqueda) throws NegocioException {
        List<IngredienteDTO> ingredientes = ingredientesDAO.obtenerIngredientesDTO(filtroBusqueda);
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new NegocioException("No se encontraron productos con el filtro de busqueda: " + filtroBusqueda);
        }
        return ingredientes;
    }

    /**
     * Metodo para obtener todos los ingredientes de ambos filtros
     *
     * @param filtroNombre Filtro del ingrediente por nombre
     * @param filtroUnidad Filtro del ingrediente por unidad de medida
     * @return Lista con todos los ingredientes que coincidan con ambos filtros
     * @throws NegocioException Si los ingredientes no se pueden obtener por un
     * error en la base de datos
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientes(String filtroNombre, String filtroUnidad) throws NegocioException {
        List<IngredienteDTO> ingredientes = ingredientesDAO.obtenerIngredientesDTO(filtroNombre, filtroUnidad);
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new NegocioException("No se encontraron productos con los filtros de busqueda: "
                    + "\nFiltro Nombre: " + filtroNombre
                    + "\nFiltro Unidad de Medida: " + filtroUnidad);
        }
        return ingredientes;
    }

    /**
     * Metodo que verifica si existe un ingrediente con el mismo nombre y unidad
     * de medida en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a verificar
     * @throws NegocioException Si un ingrediente con el mismo nombre y unidad
     * de medida existe en la base de datos
     */
    public void validarNombreYUnidadMedidaExistente(NuevoIngredienteDTO nuevoIngrediente)
            throws NegocioException {
        if (ingredientesDAO.existeIngredienteYUnidad(nuevoIngrediente)) {
            throw new NegocioException("No puede agregar un ingrediente con el"
                    + " mismo nombre y unidad de medida que uno existente.");
        }
    }

    @Override
    public IngredienteDTO obtenerIngredientePorId(Long idIngrediente) throws NegocioException {
        IngredienteDTO ingrediente = ingredientesDAO.obtenerIngredientePorId(idIngrediente);
        if (ingrediente == null) {
            throw new NegocioException("Error al encontrar el ingrediente");
        }
        return ingrediente;
    }

    /**
     * Agrega stock a un ingrediente
     * @param idIngrediente ID del ingrediente
     * @param stock Stock a agregar
     * @throws NegocioException por validaciones
     */
    @Override
    public void agregarStock(Long idIngrediente, Integer stock) throws NegocioException {
        if(stock<= 0){
            throw new NegocioException("Asegurese de ingresar un numero positivo");
        }
        ingredientesDAO.agregarStock(idIngrediente, stock);
    }

    /**
     * Elimina stock de un ingrediente
     * @param idIngrediente ID del ingrediente
     * @param stock Stock a eliminar
     * @throws NegocioException por validaciones
     */
    @Override
    public void eliminarStock(Long idIngrediente, Integer stock) throws NegocioException {
        if(stock <= 0){
            throw new NegocioException("Asegurese de ingresar un numero positivo");
        }
        try{
            ingredientesDAO.quitarStock(idIngrediente, stock);
        } catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }


}
