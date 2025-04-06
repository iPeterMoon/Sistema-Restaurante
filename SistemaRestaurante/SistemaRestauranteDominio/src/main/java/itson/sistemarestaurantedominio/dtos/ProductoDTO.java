package itson.sistemarestaurantedominio.dtos;
        
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private TipoProducto tipoProducto;

    public ProductoDTO(Long id, String nombre, BigDecimal precio, TipoProducto tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
}
