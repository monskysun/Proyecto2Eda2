
package expresion;

import java.util.LinkedList;

public class Utilerias {
    
    /*Muestra los elementos dentro de una lista de String, recorriendo cada índice de acuerdo a su tamaño*/
    public static void verListaCad(LinkedList<String> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i)+" ");
        }
    }
    
    /* Método que verifica de acuerdo a la longitud de la cadena si se trata de un número, en caso verdadero este valor se retorna*/
    public static boolean verifSiNum(String cadena){
        for (char val : cadena.toCharArray()) { //Si tiene números la cadena
            if (Character.isDigit(val)) {
                return true;   
            }
        }
        return false;    
    }
    
    /*Método que verifica si una cadena es un operador, se tienen 4 tipos de operadores que se trabajaron en este esquema*/
    public static boolean verifSiOperador(String cadena){
        if ("+".equals(cadena) || "-".equals(cadena) || "*".equals(cadena) || "/".equals(cadena)) {  //El condicional || permite evaluar 
                                                                                                    //entre los 4 tipos de operadores que se manejan
            return true;   
        }
        return false;    
    }
    
    
}
