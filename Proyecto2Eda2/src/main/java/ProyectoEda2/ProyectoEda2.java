/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoEda2;

/**
 *
 * @author Brusi
 */
import java.util.LinkedList;
import java.util.Scanner;

public class ProyectoEda2 {

    public static void main(String[] args) {
        LinkedList<String> p = new LinkedList<>();
        Scanner guarda = new Scanner(System.in);
        ExpresionTree expArit = new ExpresionTree();
        
        int opcion = 0, opcion2 = 0;
	p = expArit.leerCad();	
        /*do {

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
                    }while(opcion2!=5);

                    break;
                case 2:
                    do {
                        System.out.println("-----------Heap-----------");

                        System.out.println(""
                            + "1. Agregar clave\n"
                            + "2. Eliminar raíz\n"
                            + "3. Mostrar árbol\n"
                            + "4. Regresar\n");
                        System.out.println("Elige una opción:\n");
                        opcion2=guarda.nextInt();
                        System.out.println("--------------------------");
                    }while(opcion2!=4);
                    break;
                case 3:
                    do {
                        System.out.println("- Árbol de Expresión Arit-");

                        System.out.println(""
                            + "1. Ingresar expresión\n"
                            + "2. Mostrar árbol\n"
                            + "3. Resolver\n"
                            + "4. Regresar\n");
                        System.out.println("Elige una opción:\n");
                        opcion2=guarda.nextInt();
                        System.out.println("--------------------------");
                        submenuArbExp(opcion2,expArit);
                    }while(opcion2!=4);
                    break;
            }
        }while(opcion!=4);
        */
        
        System.out.println("Ejecución finalizada");
    }
    
    public static void submenuArbExp(int opc,ExpresionTree expArit){
        switch(opc){
            case 1: //Ingresar
                expArit.verListaCad(expArit.leerCad());
                break;
            case 2: //Mostrar
                break;
            case 3: //Resolver
                break;
            case 4: //Regresar
                break;
        }    
    }
    
}
