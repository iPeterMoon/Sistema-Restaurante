package itson.sistemarestaurantepersistencia.implementaciones;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoDetalleComandaDTO;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

public class ComandasDAO implements IComandasDAO {

    /**
     * Guarda una nueva comanda en el sistema.
     *
     * @param comandaDTO Objeto que contiene los datos de la nueva comanda.
     * @return La entidad Comanda que fue guardada.
     */
    @Override
    public Comanda guardarComanda(NuevaComandaDTO comandaDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Comanda comanda = new Comanda();
        String folio = generarFolio(entityManager);
        comanda.setFolio(folio);
        comanda.setFechaHora(Calendar.getInstance());
        comanda.setEstado(EstadoComanda.ABIERTA);
        Mesa mesa = entityManager.find(Mesa.class, comandaDTO.getIdMesa());
        comanda.setMesa(mesa);
        if (comandaDTO.getIdCliente() != null) {
            Cliente cliente = entityManager.find(Cliente.class, comandaDTO.getIdCliente());
            if (cliente == null) {
                throw new IllegalArgumentException("El cliente con ID " + comandaDTO.getIdCliente() + " no existe.");
            }
            comanda.setCliente(cliente);
        } else {
            comanda.setCliente(null);
        }
        BigDecimal totalVenta = BigDecimal.ZERO;
        List<NuevoDetalleComandaDTO> detallesComanda = comandaDTO.getDetallesComanda();
        if (detallesComanda != null && !detallesComanda.isEmpty()) {
            List<DetallesComanda> productos = new LinkedList<>();
            for (NuevoDetalleComandaDTO detalle : detallesComanda) {
                Producto producto = entityManager.find(Producto.class, detalle.getIdProducto());
                if (producto == null) {
                    throw new IllegalArgumentException("El producto con ID " + detalle.getIdProducto() + " no existe.");
                } else {
                    DetallesComanda detalleComanda = new DetallesComanda();
                    detalleComanda.setCantidad(detalle.getCantidad());
                    String comentario = detalle.getComentario();
                    if (comentario != null) {
                        detalleComanda.setComentario(comentario);
                    }
                    detalleComanda.setProducto(producto);
                    detalleComanda.setComanda(comanda);
                    detalleComanda.setPrecioUnitario(detalle.getPrecioUnitario());
                    BigDecimal totalPorProducto = detalle.getTotalPorProducto();
                    detalleComanda.setTotalPorProducto(totalPorProducto);
                    totalVenta = totalVenta.add(totalPorProducto);
                    productos.add(detalleComanda);
                }
            }
            comanda.setProductos(productos);
            comanda.setTotalVenta(totalVenta);
        } else {
            throw new IllegalArgumentException("La lista de detalles de la comanda no puede estar vacía.");
        }
        entityManager.persist(comanda);

        entityManager.getTransaction().commit();
        return comanda;
    }

    /**
     * Obtiene una lista de todas las comandas registradas en el sistema.
     *
     * @return Lista de objetos ComandaDTO que representan las comandas.
     */
    @Override
    public List<ComandaDTO> obtenerComandasAbiertas() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "SELECT c From Comanda c WHERE c.estado = :estado";
        TypedQuery<Comanda> query = entityManager.createQuery(jpql, Comanda.class);
        query.setParameter("estado", EstadoComanda.ABIERTA);
        List<Comanda> comandas = query.getResultList();
        entityManager.getTransaction().commit();

        List<ComandaDTO> comandasDTO = new LinkedList<>();
        for (Comanda comanda : comandas) {
            Long idCliente;
            if (comanda.getCliente() == null) {
                idCliente = null;
            } else {
                idCliente = comanda.getCliente().getId();
            }
            ComandaDTO comandaDTO = new ComandaDTO(
                    comanda.getId(),
                    comanda.getFolio(),
                    comanda.getFechaHora(),
                    comanda.getEstado(),
                    comanda.getTotalVenta(),
                    comanda.getMesa().getId(),
                    idCliente
            );
            comandasDTO.add(comandaDTO);
        }

        return comandasDTO;
    }

    /**
     * Obtiene una comanda específica por su identificador único.
     *
     * @param idComanda Identificador único de la comanda.
     * @return Objeto ComandaDTO que representa la comanda encontrada.
     */
    @Override
    public ComandaDTO obtenerComandaPorId(Long idComanda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        Comanda comanda = entityManager.find(Comanda.class, idComanda);

        Long idCliente;
        if (comanda.getCliente() == null) {
            idCliente = null;
        } else {
            idCliente = comanda.getCliente().getId();
        }
        ComandaDTO comandaDTO = new ComandaDTO(
                comanda.getId(),
                comanda.getFolio(),
                comanda.getFechaHora(),
                comanda.getEstado(),
                comanda.getTotalVenta(),
                comanda.getMesa().getId(),
                idCliente
        );
        return comandaDTO;
    }

    /**
     * Genera un folio para la comanda en el formato 'OB-YYYYMMDD-NNN'. donde
     * YYYYMMDD es la fecha actual y NNN es el número de la comanda del día.
     *
     * @param entityManager
     * @return
     */
    private String generarFolio(EntityManager entityManager) {
        // Obtener la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        int anio = fechaActual.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) + 1; // Los meses empiezan en 0
        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);

        // Formatear la fecha como YYYYMMDD
        String fecha = String.format("%04d%02d%02d", anio, mes, dia);

        // Contar el número de comandas registradas en el día
        String jpql = "SELECT COUNT(c) FROM Comanda c WHERE FUNCTION('DATE', c.fechaHora) = FUNCTION('DATE', CURRENT_DATE)";
        Long numeroComandas = entityManager.createQuery(jpql, Long.class).getSingleResult();

        // Incrementar el número de comandas para obtener el número actual
        int numeroActual = numeroComandas.intValue() + 1;

        // Formatear el número como NNN
        String numeroFormateado = String.format("%03d", numeroActual);

        // Construir el folio
        return "OB-" + fecha + "-" + numeroFormateado;
    }

    /**
     * Metodo para cambiar el estado de una comanda
     *
     * @param idComanda Id de la comanda a cambiar
     * @param nuevoEstado Nuevo estado de la comanda
     * @throws PersistenciaException Si ocurre una excepcion al cambiar el
     * estado de la comanda en la base de datos
     */
    @Override
    public void cambiarEstadoComanda(Long idComanda, EstadoComanda nuevoEstado) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        Comanda comanda = entityManager.find(Comanda.class, idComanda);
        if (comanda == null) {
            throw new PersistenciaException("No se pudo encontrar la comanda en el sistema");
        }
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Comanda> criteria = builder.createCriteriaUpdate(Comanda.class);
        Root<Comanda> root = criteria.from(Comanda.class);
        criteria.set("estado", nuevoEstado);
        criteria.where(builder.equal(root.get("id"), idComanda));
        Query update = entityManager.createQuery(criteria);
        update.executeUpdate();
        entityManager.getTransaction().commit();
    }

    /**
     * Metodo para modificar el total de una comanda
     *
     * @param idComanda Id de la comanda a modificar
     * @param nuevoTotal Nuevo Total de la comanda
     */
    @Override
    public void modificarTotal(Long idComanda, BigDecimal nuevoTotal) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Comanda comanda = entityManager.find(Comanda.class, idComanda);
        if (comanda != null) {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Comanda> criteria = builder.createCriteriaUpdate(Comanda.class);
            Root<Comanda> root = criteria.from(Comanda.class);
            criteria.set("totalVenta", nuevoTotal);
            criteria.where(builder.equal(root.get("id"), idComanda));
            Query update = entityManager.createQuery(criteria);
            update.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    /**
     * Metodo para obtener comandas dentro de un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Lista con todas las comandas realizadas dentro del periodo
     */
    @Override
    public List<Comanda> obtenerComandasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comanda> criteria = builder.createQuery(Comanda.class);
        Root<Comanda> root = criteria.from(Comanda.class);

        Predicate rangoFechas = builder.between(root.get("fechaHora"), fechaInicial, fechaFinal);
        criteria.select(root).where(rangoFechas);

        List<Comanda> comandas = entityManager.createQuery(criteria).getResultList();

        return comandas;
    }

    /**
     * Metodo para calcular el total de ventas en un rango de fechas
     *
     * @param fechaInicial Fecha de inicio del rango
     * @param fechaFinal Fecha de fin del rango
     * @return Total de venta realizada en el periodo
     */
    @Override
    public BigDecimal calcularTotalVentasPorPeriodo(Calendar fechaInicial, Calendar fechaFinal) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> criteria = builder.createQuery(BigDecimal.class);
        Root<Comanda> root = criteria.from(Comanda.class);

        criteria.select(builder.coalesce(builder.sum(root.get("totalVenta")), BigDecimal.ZERO));
        criteria.where(builder.between(root.get("fechaHora"), fechaInicial, fechaFinal));

        BigDecimal totalVenta = entityManager.createQuery(criteria).getSingleResult();

        return totalVenta;
    }
}
