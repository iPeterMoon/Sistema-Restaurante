package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.Comanda;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-29T12:49:15", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> apellidoPaterno;
    public static volatile SingularAttribute<Cliente, Calendar> fechaRegistro;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile ListAttribute<Cliente, Comanda> comandas;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, Integer> puntos;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, String> apellidoMaterno;

}