/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantepersistencia.implementaciones.ListaIngredientesCantidad;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IIngredientesProductoDAO {

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
    public abstract IngredientesProducto relacionarIngredientesProducto(
            Producto producto, Ingrediente ingrediente, Integer cantidadIngrediente);

    /**
     * Metodo que se encarga de especificar la cantidad de MUCHOS ingredientes
     * utilizados en un producto
     *
     * @param ingredientesCantidad Lista de cantidad e ingrediente que se
     * utiliza para realizar el producto
     * @param producto Producto a realizar
     * @return
     */
    public abstract List<IngredientesProducto> relacionarIngredientesProducto(
            List<ListaIngredientesCantidad> ingredientesCantidad, Producto producto);

    /**
     * Metodo que obtiene las relaciones de ingredientes y productos de la base
     * de dats
     *
     * @return Lista con todas las relaciones de productos e ingredientes de la
     * base de datos
     */
    public abstract List<IngredientesProducto> obtenerRelacionIngredientesProducto();

}
