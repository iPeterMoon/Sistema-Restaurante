package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.IngredientesProducto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T02:02:04", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile ListAttribute<Producto, IngredientesProducto> ingredientes;
    public static volatile ListAttribute<Producto, DetallesComanda> comandas;
    public static volatile SingularAttribute<Producto, Long> id;
    public static volatile SingularAttribute<Producto, String> nombre;

}