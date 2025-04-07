package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;

import java.math.BigDecimal;
import java.util.LinkedList;
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
public class ProductosDAO implements IProductosDAO {

    /**
     * Metodo para agregar un nuevo producto a la base de datos
     *
     * @param nuevoProducto Nuevo producto a agregar
     * @return Producto agregado en la base de datos
     */
    @Override
    public Producto agregarProducto(NuevoProductoDTO nuevoProducto) throws IllegalArgumentException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        entityManager.getTransaction().begin();
        
        String nombre = nuevoProducto.getNombre();
        BigDecimal precio = nuevoProducto.getPrecio();
        TipoProducto tipoProducto = nuevoProducto.getTipoProducto();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setTipoProducto(tipoProducto);
        List<IngredienteProductoDTO> ingredientes = nuevoProducto.getIngredientes();
        // Verifica si la lista de ingredientes no es nula y no está vacía antes de agregar los ingredientes
        if(ingredientes != null && !ingredientes.isEmpty()){
            List<IngredientesProducto> ingredientesGuardados = new LinkedList<>();
            for (IngredienteProductoDTO ingrediente : ingredientes) {
                Ingrediente ingredienteGuardado = entityManager.find(Ingrediente.class, ingrediente.getIdIngrediente());
                if (ingredienteGuardado != null) {
                    IngredientesProducto ingredientesProducto = new IngredientesProducto();
                    ingredientesProducto.setIngrediente(ingredienteGuardado);
                    ingredientesProducto.setCantidad(ingrediente.getCantidad());
                    ingredientesProducto.setProducto(producto);
                    ingredientesGuardados.add(ingredientesProducto);
                } else {
                    // Si el ingrediente no existe
                    throw new IllegalArgumentException("Ingrediente no encontrado: " + ingrediente.getIdIngrediente());
                }
            }
            producto.setIngredientes(ingredientesGuardados);
        } else {
            // Si la lista de ingredientes es nula o vacía
            throw new IllegalArgumentException("La lista de ingredientes no puede ser nula o vacía.");
        }
        entityManager.persist(producto);
        
        entityManager.getTransaction().commit();
        return producto;
    }


    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * y convertirlos a DTO
     *
     * @return Lista con todos los productos en formato DTO
     */
    @Override
    public List<ProductoDTO> obtenerProductosDTO() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.ProductoDTO(p.id, p.nombre, p.precio, p.tipoProducto) FROM Producto p";
        TypedQuery<ProductoDTO> query = entityManager.createQuery(jpql, ProductoDTO.class);
        List<ProductoDTO> productosDTO = query.getResultList();
        return productosDTO;
    }

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda y convertirlos a DTO
     *
     * @param filtroBusqueda Filtro para buscar los productos
     * @return Lista con los productos coincidentes con el filtro en formato DTO
     */
    @Override
    public List<ProductoDTO> obtenerProductosDTO(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.ProductoDTO(p.id, p.nombre, p.precio, p.tipoProducto) FROM Producto p WHERE p.nombre LIKE :filtroBusqueda OR p.tipoProducto LIKE :filtroBusqueda";
        TypedQuery<ProductoDTO> query = entityManager.createQuery(jpql, ProductoDTO.class);
        query.setParameter("filtroBusqueda", "%" + filtroBusqueda + "%");
        List<ProductoDTO> productosDTO = query.getResultList();
        return productosDTO;
    }

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda y el tipo de producto.
     */
    @Override
    public List<ProductoDTO> obtenerProductosDTO(String filtroBusqueda, String tipoProducto) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductoDTO> criteria = builder.createQuery(ProductoDTO.class);
        Root<Producto> entidadProducto = criteria.from(Producto.class);
        criteria.select(
            builder.construct(
                ProductoDTO.class,
                entidadProducto.get("id"),
                entidadProducto.get("nombre"),
                entidadProducto.get("precio"), 
                entidadProducto.get("tipoProducto")
            )
        ).where(builder.and(
            builder.like(entidadProducto.get("nombre"), "%" + filtroBusqueda + "%"),
            builder.like(entidadProducto.get("tipoProducto"), "%"+tipoProducto+"%")
        ));
        TypedQuery<ProductoDTO> query = entityManager.createQuery(criteria);
        List<ProductoDTO> productosDTO = query.getResultList();
        return productosDTO;
    }


    @Override
    public ProductoDTO obtenerProductoPorNombre(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.ProductoDTO(p.id, p.nombre, p.precio, p.tipoProducto) FROM Producto p WHERE p.nombre = :nombre";
        TypedQuery<ProductoDTO> query = entityManager.createQuery(jpql, ProductoDTO.class);
        query.setParameter("nombre", nombre);
        List<ProductoDTO> productosDTO = query.getResultList();
        return productosDTO.isEmpty() ? null : productosDTO.get(0);
    }

    

}
