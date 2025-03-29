package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T13:24:08", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DetallesComanda.class)
public class DetallesComanda_ { 

    public static volatile SingularAttribute<DetallesComanda, Long> id;
    public static volatile SingularAttribute<DetallesComanda, Integer> cantidad;
    public static volatile SingularAttribute<DetallesComanda, Comanda> comanda;
    public static volatile SingularAttribute<DetallesComanda, Producto> producto;

}