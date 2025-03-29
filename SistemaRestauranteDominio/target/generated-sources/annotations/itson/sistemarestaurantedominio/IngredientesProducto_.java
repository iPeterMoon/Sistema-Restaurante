package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T13:24:08", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(IngredientesProducto.class)
public class IngredientesProducto_ { 

    public static volatile SingularAttribute<IngredientesProducto, Long> id;
    public static volatile SingularAttribute<IngredientesProducto, Integer> cantidad;
    public static volatile SingularAttribute<IngredientesProducto, Producto> producto;
    public static volatile SingularAttribute<IngredientesProducto, Ingrediente> ingrediente;

}