/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import itson.sistemarestaurantepersistencia.IIngredientesProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author PC
 */
public class IngredientesProductoDAO implements IIngredientesProductoDAO {

    /**
     * Metodo que se encarga de especificar la cantidad de UN ingrediente
     * utilizado en un producto
     *
     * @param producto Producto realizado por el ingrediente
     * @param ingrediente Ingrediente utilizado para realizar el producto
     * @param cantidadIngrediente Cantidad de ingrediente que se usa para el
     * producto
     * @return Relacion de el ingrediente con el producto
     */
    @Override
    public IngredientesProducto relacionarIngredientesProducto(Producto producto,
            Ingrediente ingrediente, Integer cantidadIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        IngredientesProducto relacion = new IngredientesProducto(
                cantidadIngrediente, ingrediente, producto);
        entityManager.persist(relacion);
        entityManager.getTransaction().commit();
        return relacion;
    }

    /**
     * Metodo que se encarga de especificar la cantidad de MUCHOS ingredientes
     * utilizados en un producto
     *
     * @param ingredientesCantidad Lista de cantidad e ingrediente que se
     * utiliza para realizar el producto
     * @param producto Producto a realizar
     * @return
     */
    @Override
    public List<IngredientesProducto> relacionarIngredientesProducto(
            List<ListaIngredientesCantidad> ingredientesCantidad, Producto producto) {
        List<IngredientesProducto> relacion = new ArrayList();
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        for (ListaIngredientesCantidad lic : ingredientesCantidad) {
            IngredientesProducto ip = new IngredientesProducto(
                    lic.getCantidad(), lic.getIngrediente(), producto);
            relacion.add(ip);
            entityManager.persist(ip);
        }
        entityManager.getTransaction().commit();
        return relacion;
    }

    /**
     * Metodo que obtiene las relaciones de ingredientes y productos de la base
     * de dats
     *
     * @return Lista con todas las relaciones de productos e ingredientes de la
     * base de datos
     */
    @Override
    public List<IngredientesProducto> obtenerRelacionIngredientesProducto() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IngredientesProducto> criteria = builder.createQuery(
                IngredientesProducto.class);
        Root<IngredientesProducto> entidadIngredientesProducto
                = criteria.from(IngredientesProducto.class);
        criteria.select(entidadIngredientesProducto);
        TypedQuery<IngredientesProducto> query
                = entityManager.createQuery(criteria);
        List<IngredientesProducto> relacion = query.getResultList();
        return relacion;
    }
    
}
