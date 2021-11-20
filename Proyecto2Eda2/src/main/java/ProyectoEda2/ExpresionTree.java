/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoEda2;
import Arboles.*;

import java.util.LinkedList;
import java.util.Scanner;

public class ExpresionTree {
    Scanner sc = new Scanner(System.in);
    
    
    public LinkedList<String> leerCad(){
        LinkedList<String> lista= new LinkedList();
        
        String cadena="(((2+3)*(6*3)+(9/3))"; //Sirve de prueba
        /*
        System.out.print("Introduce una frase: ");
        
        cadena=sc.nextLine();
        */
        
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
        convertirArbol(lista);
        return lista;
    }
    
    public void verListaCad(LinkedList<String> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            //System.out.println(lista.poll());     //Si se pone poll se extrae y se elimina
        }
    }
    
    public void convertirArbol(LinkedList<String> lista){
        LinkedList<String> listaAux= new LinkedList<>(); //Lista auxiliar para guardar la cadena sin parentesis
        
        System.out.println("Cadena introducida: ");
        verListaCad(lista);
        System.out.println("\n");
        
        for(int i=0; i<lista.size(); i++){
            /*Evalua que el elemento de nuestra lista de String con los caracteres sea igual a un parentesis cerrado
            o abierto, si esto se cumple no realiza nada, en caso de que sea distinto (no sea parentesis)
            agregará dicho String a nuestra listaAux*/
            if(lista.get(i).equals("(") || lista.get(i).equals(")")  ){
            }else{
                listaAux.add(lista.get(i));
            }
        }
        
        System.out.println("Cadena convertida: ");
        verListaCad(listaAux);
        System.out.println("\n");
        
        Nodo padre= new Nodo(listaAux.remove(0));
        ArbolBin aux = new ArbolBin(padre);
        
        System.out.println("Va a añadir por BFS");
        /*Realiza la conversión de la lista mandada en un árbol binario
        sigue el principio de un recorrido BFS*/
        addBFS(listaAux, padre, true);
        
        
        System.out.println("Va a realizar BFS");
        aux.breadthFrist();

    }
    
    /*Este método, será usado de manera recurisva, recibe el nodo al cual se le desean
    agregar los valores, la lista con los valores y una bandera para indicar si se debe llenar
    el nodo hijo izquierdo o el nodo hijo derecho*/
    public void addBFS(LinkedList<String> lista, Nodo nodo, boolean flag){
        //Se realiza mientras nuestra lista con valores que deseemos agregar no este vacia
        while(lista.isEmpty()!= true){
            /*Si el el nodo hijo izquierdo del subarbol aún no esta definido entonces se le crea
            un nodo hijo izquierdo, para esto se extrae el primer valor de nuestra lista con valores*/
            if(nodo.getIzq()==null){
                nodo.setIzq(new Nodo(lista.remove(0)));
            }
            /*Si el el nodo hijo derecho del subarbol aún no esta definido entonces se le crea
            un nodo hijo derecho, para esto se extrae el primer valor de nuestra lista con valores*/
            else if(nodo.getDer()==null){
                nodo.setDer(new Nodo(lista.remove(0)));
            }
            /*Si el el nodo ya cuenta con dos hijos, dependiendo de la bandera se agregara ahora a su hijo
            izquierdo si es true*/
            else if(flag){
                addBFS(lista, nodo.getIzq(), false);
                //Se cambia el valor de la bandera para indicar que el nodo izquierdo ya ha sido trabajado
            }
            /*Si el el nodo ya cuenta con dos hijos, dependiendo de la bandera se agregara ahora a su hijo
            derecho si es false*/
            else if(flag == false){
                //Se cambia el valor de la bandera para indicar que el nodo derecho ya ha sido trabajado
                addBFS(lista, nodo.getDer(), true);
            }  
        }
            
        
    }
    
}
