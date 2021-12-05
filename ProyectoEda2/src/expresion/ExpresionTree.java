
package expresion;

import java.util.LinkedList;
import java.util.Scanner;
import Arboles.*;

public class ExpresionTree {
    Scanner sc = new Scanner(System.in);
    ArbolBin arb = new ArbolBin();
    ReversePolishNotation revs = new ReversePolishNotation();
    
    public LinkedList<String> leerCad(){
        arb= new ArbolBin();
        LinkedList<String> lista= new LinkedList();
        //String cadena="(((2+3)*(6*3))+(5/1))"; //Sirve de prueba
        
        System.out.print("Introduce una expresión aritmética: ");
        String cadena=sc.nextLine();
        lista.clear();
        //Convierte la cadena mandada a una lista de String
        //caracter por caracter
        for (int i = 0; i < cadena.length(); i++) {
            /*<charat> devuelve un tipo de datos char, pero nuestra lista almacenara
            String por lo que debemos convertir cada caracter en un String para poder agregarlo
            a nuestra lista*/
            lista.add(Character.toString(cadena.charAt(i)));
        }
        //Se va a convertir a Arbol binario la lista mandada
        //para realizar la conversión sigue un "recorrido" BFS
        lista=convertirArbol(lista);
        
        return lista;
    }
    
    /*Método que convierte la lista en árbol, observando que trabaja con la lista original y inma segunda que  retornará la notación polaca inversa.
    se tienen 3 casos para ingresar el valor a un nodo, cuando se tiene un paréntesis de apertura, cuando se trata de un operador o de un valor númerico.
    El´cuarto caso actualiza el apuntador del nodo actual a su padre de este mismo*/
    public LinkedList<String> convertirArbol(LinkedList<String> lista){
        LinkedList<String> listaConver= new LinkedList();
        System.out.println("Cadena introducida: ");
        Utilerias.verListaCad(lista);
        System.out.println("\n");
        
        for (int i = 0; i < lista.size(); i++) {            
            boolean existeNum=Utilerias.verifSiNum(lista.get(i));           //En esta variable se verifica si el indice actual es un número
            boolean existeOperador=Utilerias.verifSiOperador(lista.get(i)); //Aquí será almacenado el booleano dependiendo si el índice actual es un operador
            
            if("(".equals(lista.get(i))){           //Verificación para paréntesis de apertura
                arb.ingresarNodo(lista.get(i),1);
                
            }else if(existeNum){                    //Verificación para números
                arb.ingresarNodo(lista.get(i),2);
                
            }else if(existeOperador){               //Verificación para operadores aritméticos
                arb.ingresarNodo(lista.get(i),3);
                
            }else if(")".equals(lista.get(i))){     //Cuando encuentra un paréntesis de cierre actualiza el nodo actual al nodo padre de este
                arb.actualizadorPadre();
            }
        }
        System.out.println("");
        
        //Generación de la notación polaca inversa al llamar al método que contiene el recorrido postorden
        listaConver=arb.generarNotPolInv();
        
        
        return listaConver;
    }
    
    /*Este método muestra mediante el parámetro listaConver, la lista que fue retornada para apreciar el cómo está conformada,
    observando que se imprime de forma cómun dentro de un print, por otra parte, para mostrar el árbol se opta por su recorrido BFS*/
    public void verArb(LinkedList<String> listaConver){
        System.out.println("La notación polaca inversa obtenida es: ");
        System.out.println(listaConver);
        
        System.out.println("El recorrido BFS es :");
        arb.breadthFrist();
    }
    
    /*El método manda llamar al método evaluación quien trabaja con una pila y resuelve la expresión Polaca inversa, 
    antes verifica si el árbol tiene elementos mediante su lista de integrantes*/
    public void resolver(LinkedList<String> listaConver){
        if(listaConver.isEmpty()){
            System.out.println("La lista está vacía");
        }else{
            System.out.print("El resultado de tu operación es:  ");
            revs.evaluacion(listaConver);
            System.out.println("");
        }
    }
    
    
}
