/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Brusi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        arbol.agregar(4);
        
        arbol.breadthFrist();
        System.out.println("------------------");
        arbol.agregar(2);
        arbol.agregar(7);
        arbol.breadthFrist();
        System.out.println("------------------");
        arbol.agregar(5);
        arbol.agregar(6);
        arbol.breadthFrist();
        System.out.println("------------------");
        arbol.agregar(8);
        
        arbol.breadthFrist();
        System.out.println("------------------");
        arbol.elimina(3);
        arbol.elimina(6);
        arbol.breadthFrist();
    }
    
}
