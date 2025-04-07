/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
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
     * Metodo para obtener una lista con todos los productos de la base de datos
     * y convertirlos a DTO
     *
     * @return Lista con todos los productos en formato DTO
     */
    public abstract List<ProductoDTO> obtenerProductosDTO();

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda y convertirlos a DTO
     *
     * @param filtroBusqueda Filtro para buscar los productos
     * @return Lista con los productos coincidentes con el filtro en formato DTO
     */
    public abstract List<ProductoDTO> obtenerProductosDTO(String filtroBusqueda);

    /**
     * Metodo para obtener una lista con todos los productos de la base de datos
     * que coincidan con el filtro de busqueda y el tipo de producto y
     * convertirlos a DTO
     *
     * @param filtroBusqueda Filtro para buscar los productos
     * @param tipoProducto Tipo de producto a filtrar
     * @return Lista con los productos coincidentes con el filtro en formato DTO
     */
    public abstract List<ProductoDTO> obtenerProductosDTO(String filtroBusqueda, String tipoProducto);

    /**
     * Metodo para obtener un producto de la base de datos por su nombre y
     * convertirlo a DTO
     *
     * @param nombre Nombre del producto a buscar
     * @return ProductoDTO con el producto encontrado o null si no se encuentra
     */
    public abstract ProductoDTO obtenerProductoPorNombre(String nombre);
}
