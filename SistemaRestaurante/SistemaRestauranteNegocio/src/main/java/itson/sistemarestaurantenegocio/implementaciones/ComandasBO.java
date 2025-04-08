package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IComandasBO;
import itson.sistemarestaurantepersistencia.IComandasDAO;

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
    public void entregarComanda(ComandaDTO comandaDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entregarComanda'");
    }

    @Override
    public void cancelarComanda(ComandaDTO comandaDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarComanda'");
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
