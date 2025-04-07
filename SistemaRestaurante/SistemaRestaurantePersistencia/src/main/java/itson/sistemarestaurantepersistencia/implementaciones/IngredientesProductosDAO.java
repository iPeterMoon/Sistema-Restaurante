package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantedominio.IngredientesProducto;

public class IngredientesProductosDAO implements IIngredientesProductosDAO {
  /**
   * Metodo para obtener una lista con todos los ingredientes de un producto
   * en especifico
   *
   * @param idProducto Id del producto a buscar
   * @return Lista con todos los ingredientes del producto en formato DTO
   */
  @Override
  public List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto) {
    EntityManager entityManager = ManejadorConexiones.getEntityManager();
    entityManager.getTransaction().begin();
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<IngredienteProductoDTO> criteria = builder.createQuery(IngredienteProductoDTO.class);
    Root<IngredientesProducto> rootIngrediente = criteria.from(IngredientesProducto.class);

    // Join Ingrediente -> IngredienteProducto
    Join<IngredientesProducto, Producto> joinProducto = rootIngrediente.join("producto");


    // Build the query
    criteria.select(
        builder.construct(
            IngredienteProductoDTO.class,
            rootIngrediente.get("ingrediente").get("id"),
            rootIngrediente.get("cantidad")))
        .where(
            builder.equal(joinProducto.get("id"), idProducto));
    TypedQuery<IngredienteProductoDTO> query = entityManager.createQuery(criteria);
    List<IngredienteProductoDTO> ingredientesDTO = query.getResultList();
    entityManager.getTransaction().commit();
    return ingredientesDTO;
  }

    
}
