
package main;

import java.util.LinkedList;
import java.util.Scanner;
import expresion.*;
import heap.*;
import avl.*;

public class main {
    public static void main(String[] args) {
        LinkedList<String> p = new LinkedList<>();
        Scanner guarda = new Scanner(System.in);
        ExpresionTree expArit = new ExpresionTree();
        Heap heap=new Heap();
        ArbolAVL arbolAvl = new ArbolAVL();
        
        int opcion = 0, opcion2 = 0;
        do {
            System.out.println("--------------------------");
            System.out.println("Elige una opción:\n");
            System.out.println(""
                + "1. Árbol AVL\n"
                + "2. Heap\n"
                + "3. Árbol de Expresión Aritmética\n"
                + "4. Salir");
            opcion = guarda.nextInt();
            System.out.println("--------------------------");
            switch(opcion){ 
                case 1:
                    do {
                        System.out.println("--------Árbol AVL---------");
                        System.out.println(""
                            + "1. Agregar clave\n"
                            + "2. Buscar un valor\n"
                            + "3. Eliminar clave\n"
                            + "4. Mostrar árbol\n"
                            + "5. Regresar");
                        System.out.println("Elige una opción:\n");
                        opcion2=guarda.nextInt();
                        System.out.println("--------------------------");
                    switch(opcion2){
                        case 1:
                            System.out.println("Valor del nodo a ingresar ");
                            int val=guarda.nextInt();
                            arbolAvl.agregar(val);
                            break;
                        case 2:
                            System.out.println("Buscar un nodo ");
                            int valBus=guarda.nextInt();
                            arbolAvl.busca(valBus);
                            break;
                        case 3:
                            System.out.println("Nodo a eliminar ");
                            int valElim=guarda.nextInt();
                            arbolAvl.elimina(valElim);
                            break;
                        case 4:
                            System.out.println("La impresión del árbol de acuerdo a su recorrido BFS es: \n");
                            arbolAvl.breadthFrist();
                            break;
                        case 5:
                            System.out.println("Redireccionando... \n");
                            break;
                        default:
                            System.out.println("Opción inválida");
                        }    
                    }while(opcion2!=5);
                    
                    break;
                case 2:
                    heap.submenu();
                    break;
                case 3:
                    do {
                        System.out.println("- Árbol de Expresión Aritméticas");
                        System.out.println(""
                            + "1. Ingresar expresión\n"
                            + "2. Mostrar árbol\n"
                            + "3. Resolver\n"
                            + "4. Regresar\n");
                        System.out.println("Elige una opción:\n");
                        opcion2=guarda.nextInt();
        
                        System.out.println("--------------------------");
                        switch(opcion2){
                            case 1:
                                p.clear();
                                p=expArit.leerCad();
                                break;
                            case 2:
                                expArit.verArb(p);
                                break;
                            case 3:
                                expArit.resolver(p);
                                break;
                            case 4:
                                System.out.println("Redireccionando... \n");
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }while(opcion2!=4);
                    
                    break;
            }
        }while(opcion!=4);
        System.out.println("Ejecución finalizada");
    }
}
