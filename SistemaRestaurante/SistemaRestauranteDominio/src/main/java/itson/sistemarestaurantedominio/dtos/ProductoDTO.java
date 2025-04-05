package itson.sistemarestaurantedominio.dtos;
        
import java.math.BigDecimal;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String tipoProducto; // Cambiado a String para simplificar el DTO

    public ProductoDTO(Long id, String nombre, BigDecimal precio, String tipoProducto) {
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

    public String getTipoProducto() {
        return tipoProducto;
    }
}
