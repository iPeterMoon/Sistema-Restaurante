package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class DetallesComandaTest {

    public DetallesComandaTest() {
    }

    private Mesa mesaCreada;
    private Cliente clienteCreado;
    private Comanda comandaCreada;
    private DetallesComanda detallesComandaCreado;
    private Producto productoCreado;
    
    @AfterEach
    public void limpiar(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        DetallesComanda detallesComanda = em.find(DetallesComanda.class, detallesComandaCreado.getId());
        if(detallesComanda != null){
            em.remove(detallesComanda);
        }
        Producto producto = em.find(Producto.class, productoCreado.getId());
        if(producto != null){
            em.remove(producto);
        }
        Comanda comanda = em.find(Comanda.class, comandaCreada.getId());
        if(comanda != null){
            em.remove(comanda);
        }
        
        Cliente cliente = em.find(Cliente.class, clienteCreado.getId());
        if(cliente != null){
            em.remove(cliente);
        }
        Mesa mesa = em.find(Mesa.class, mesaCreada.getId());
        if(mesa != null){
            em.remove(mesa);
        }
        em.getTransaction().commit();
    }
    
    @Test
    public void testCrearComandaConProductos() {
        final int CANTIDAD_DE_PRODUCTO = 3;
        final int NUMERO_MESA = 3;
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(100.00);
        final BigDecimal TOTAL_VENTA_COMANDA = BigDecimal.valueOf(300.00);
        final int PUNTOS_CLIENTE = 1;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        productoCreado = new Producto("Rollo California", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        mesaCreada = new Mesa(NUMERO_MESA);
        Calendar ahora = Calendar.getInstance();
        clienteCreado = new Cliente("Patricio", "O'ward", "Junco", PUNTOS_CLIENTE,
                "pato@gmail.com", "6441098765", ahora);
        comandaCreada = new Comanda("OB-20250329-111", ahora,
                EstadoComanda.CANCELADA, TOTAL_VENTA_COMANDA, clienteCreado, mesaCreada);
        detallesComandaCreado = new DetallesComanda(CANTIDAD_DE_PRODUCTO,
                "Comentario de PRUEBA", productoCreado.getPrecio(),
                productoCreado.getPrecio().multiply(BigDecimal.valueOf(CANTIDAD_DE_PRODUCTO)), comandaCreada, productoCreado);

        em.persist(productoCreado);
        em.persist(clienteCreado);
        em.persist(mesaCreada);
        em.persist(comandaCreada);
        em.persist(detallesComandaCreado);

        em.getTransaction().commit();
    }

}
