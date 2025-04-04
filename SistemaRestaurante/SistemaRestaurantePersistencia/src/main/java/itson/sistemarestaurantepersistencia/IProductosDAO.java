/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IProductosDAO {

    /**
     * Metodo para agregar un nuevo producto a la base de datos
     *
     * @param nuevoProducto Nuevo producto a agregar
     * @return Producto agregado en la base de datos
     */
    public abstract Producto agregarProducto(NuevoProductoDTO nuevoProducto);

    /**
     * Metodo para obtener toda la lista de productos de la base de datos (Hecho
     * con CriteriaQuery)
     *
     * @return Lista con todos los ingredientes de la base de datos
     */
    public abstract List<Producto> obtenerProductos();

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda
     *
     * @param filtroBusqueda Filtro para buscar los productos
     * @return Lista con los productos coincidentes con el filtro
     */
    public abstract List<Producto> obtenerProductos(String filtroBusqueda);

}
