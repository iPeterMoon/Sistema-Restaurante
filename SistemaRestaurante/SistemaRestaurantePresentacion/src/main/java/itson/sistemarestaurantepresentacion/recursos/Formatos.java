package itson.sistemarestaurantepresentacion.recursos;

import java.util.Calendar;

/**
 *
 * @author pc
 */
public class Formatos {
    
    
    public static String cargarFecha(Calendar fecha){
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int year = fecha.get(Calendar.YEAR);
        String strMes = obtenerMes(mes);
        String strFecha = dia + " de "+ strMes +" de "+year;
        
        return strFecha;
    }
    
    private static String obtenerMes(int mes){
        switch (mes) {
            case 1:
                return "enero";
            case 2:
                return "febrero";
            case 3: 
                return "marzo";
            case 4:
                return "abril";
            case 5:
                return "mayo";
            case 6:
                return "junio";
            case 7: 
                return "julio";
            case 8:
                return "agosto";
            case 9:
                return "septiembre";
            case 10:
                return "octubre";
            case 11:
                return "noviembre";
            case 12:
                return "diciembre";
            default:
                return String.valueOf(mes);
        }
    }
}
