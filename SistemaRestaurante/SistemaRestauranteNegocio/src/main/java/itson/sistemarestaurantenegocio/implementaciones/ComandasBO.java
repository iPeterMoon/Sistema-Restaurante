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

/**
 * Implementación de la interfaz IComandasBO que define los métodos para la lógica de negocio de las comandas.
 * Esta clase utiliza un objeto IComandasDAO para interactuar con la capa de persistencia.
 */
public class ComandasBO implements IComandasBO {

    private IComandasDAO comandasDAO;

    /**
     * Constructor que inicializa el objeto IComandasDAO.
     * @param comandasDAO Objeto de acceso a datos para las comandas.
     */
    public ComandasBO(IComandasDAO comandasDAO) {
        this.comandasDAO = comandasDAO;
    }

    @Override
    public void guardarComanda(NuevaComandaDTO comandaDTO) throws NegocioException {
        if(comandaDTO == null) {
            throw new NegocioException("La comanda no puede ser nula");
        }
        if(comandaDTO.getDetallesComanda() == null || comandaDTO.getDetallesComanda().isEmpty()) {
            throw new NegocioException("La comanda debe tener al menos un producto");
        }
        if(comandaDTO.getIdMesa() == null) {
            throw new NegocioException("La comanda debe tener una mesa asignada");
        }
        Comanda comandaGuardada = comandasDAO.guardarComanda(comandaDTO);
        if(comandaGuardada == null) {
            throw new NegocioException("Error al guardar la comanda");
        }

    }

    @Override
    public void entregarComanda(ComandaDTO comandaDTO) throws NegocioException{
        try{
            IDetallesComandaBO detallesComandaBO = ObjetosNegocioFactory.crearDetallesComandaBO();
            IIngredientesProductoBO ingredientesProductoBO = ObjetosNegocioFactory.crearIngredientesProductoBO();
            IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
            List<DetallesComandaDTO> detallesComanda = detallesComandaBO.obtenerDetallesComanda(comandaDTO.getIdComanda());
            for(DetallesComandaDTO detalle : detallesComanda){
                List<IngredienteProductoDTO> ingredientesProducto = 
                ingredientesProductoBO.obtenerIngredientesProductoPorIdProducto(detalle.getIdProducto());
                for(int i = 1; i <= detalle.getCantidad(); i++){
                   for(IngredienteProductoDTO ingrediente : ingredientesProducto){
                    ingredientesBO.eliminarStock(ingrediente.getIdIngrediente(), ingrediente.getCantidad());
                   } 
                }
            }
            if(comandaDTO.getIdCliente()!= null){
                final double CONVERSION = 20.0;
                Integer puntos = comandaDTO.getTotal().divide(BigDecimal.valueOf(CONVERSION)).intValue();
                IClientesBO clientesBO = ObjetosNegocioFactory.crearClientesBO();
                clientesBO.agregarPuntos(comandaDTO.getIdCliente(), puntos);
            }
            comandasDAO.cambiarEstadoComanda(comandaDTO.getIdComanda(), EstadoComanda.ENTREGADA);
        } catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        
    }

    @Override
    public void cancelarComanda(ComandaDTO comandaDTO) throws NegocioException{
        try{
            comandasDAO.cambiarEstadoComanda(comandaDTO.getIdComanda(), EstadoComanda.CANCELADA);
        } catch (PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        List<ComandaDTO> comandas = comandasDAO.obtenerComandasAbiertas();
        if(comandas == null || comandas.isEmpty()) {
            throw new NegocioException("No se encontraron comandas abiertas en el sistema");
        }
        return comandas;
    }

    @Override
    public ComandaDTO obtenerComandaPorId(Long idComanda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerComandaPorId'");
    }

}
