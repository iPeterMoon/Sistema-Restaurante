/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author PC
 */
public interface IProductosBO {
    
    public abstract void agregarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
}
