
package proyecto2edaii;

import java.util.LinkedList;
import java.util.Scanner;

public class ExpresionTree {
    Scanner sc = new Scanner(System.in);
    
    
    public LinkedList leerCad(){
        LinkedList lista= new LinkedList();
        
        String cadena;
        System.out.print("Introduce una frase: ");
        cadena=sc.next();
        
        for (int i = 0; i < cadena.length(); i++) {
            lista.add(cadena.charAt(i));
        }
        return lista;
    }
    
    public void verListaCad(LinkedList lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i)+"   ");
            //System.out.println(lista.poll());     //Si se pone poll se extrae y se elimina
        }
    
    }
}
