package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.IngredientesProducto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T02:02:04", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Ingrediente.class)
public class Ingrediente_ { 

    public static volatile SingularAttribute<Ingrediente, Long> id;
    public static volatile SingularAttribute<Ingrediente, String> nombre;
    public static volatile ListAttribute<Ingrediente, IngredientesProducto> productos;

}