package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T13:13:58", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Comanda.class)
public class Comanda_ { 

    public static volatile SingularAttribute<Comanda, Cliente> cliente;
    public static volatile SingularAttribute<Comanda, EstadoComanda> estado;
    public static volatile SingularAttribute<Comanda, Mesa> mesa;
    public static volatile SingularAttribute<Comanda, Calendar> fechaHora;
    public static volatile SingularAttribute<Comanda, Double> totalVenta;
    public static volatile SingularAttribute<Comanda, String> folio;
    public static volatile SingularAttribute<Comanda, Long> id;
    public static volatile SingularAttribute<Comanda, String> nota;
    public static volatile ListAttribute<Comanda, DetallesComanda> productos;

}