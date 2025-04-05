/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author PC
 */
public class ProductosDAO implements IProductosDAO {

    /**
     * Metodo para agregar un nuevo producto a la base de datos
     *
     * @param nuevoProducto Nuevo producto a agregar
     * @return Producto agregado en la base de datos
     */
    @Override
    public Producto agregarProducto(NuevoProductoDTO nuevoProducto) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = new Producto(
                nuevoProducto.getNombre(), nuevoProducto.getPrecio(),
                nuevoProducto.getTipoProducto());
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
        return producto;
    }

    /**
     * Metodo para obtener toda la lista de productos de la base de datos (Hecho
     * con CriteriaQuery)
     *
     * @return Lista con todos los ingredientes de la base de datos
     */
    @Override
    public List<Producto> obtenerProductos() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        Root<Producto> entidadProducto = criteria.from(Producto.class);
        criteria.select(entidadProducto);
        TypedQuery<Producto> query = entityManager.createQuery(criteria);
        List<Producto> productos = query.getResultList();
        return productos;
    }

    

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda
     *
     * @param filtroBusqueda Filtro para buscar los productos
     * @return Lista con los productos coincidentes con el filtro
     */
    @Override
    public List<Producto> obtenerProductos(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        Root<Producto> entidadProducto = criteria.from(Producto.class);

        Predicate busquedaPorTipoProducto = builder.like(entidadProducto.get("tipoProducto"), "%" + filtroBusqueda + "%");
        Predicate busquedaPorNombre = builder.like(entidadProducto.get("nombre"), "%" + filtroBusqueda + "%");

        criteria.select(entidadProducto).where(
                builder.or(busquedaPorNombre, busquedaPorTipoProducto)
        );
        TypedQuery<Producto> query = entityManager.createQuery(criteria);
        List<Producto> productos = query.getResultList();
        return productos;
    }

    @Override
    public List<ProductoDTO> obtenerProductosDTO() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.ProductoDTO(p.id, p.nombre, p.precio, p.tipoProducto) FROM Producto p";
        TypedQuery<ProductoDTO> query = entityManager.createQuery(jpql, ProductoDTO.class);
        List<ProductoDTO> productosDTO = query.getResultList();
        entityManager.getTransaction().commit();
        return productosDTO;
    }

    @Override
    public List<ProductoDTO> obtenerProductosDTO(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.ProductoDTO(p.id, p.nombre, p.precio, p.tipoProducto) FROM Producto p WHERE p.nombre LIKE :filtroBusqueda OR p.tipoProducto LIKE :filtroBusqueda";
        TypedQuery<ProductoDTO> query = entityManager.createQuery(jpql, ProductoDTO.class);
        query.setParameter("filtroBusqueda", "%" + filtroBusqueda + "%");
        List<ProductoDTO> productosDTO = query.getResultList();
        entityManager.getTransaction().commit();
        return productosDTO;
    }

}
