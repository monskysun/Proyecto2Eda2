/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoeda2;
import java.util.Scanner;
/**
 *
 * @author monserratlopez
 */
public class Main {
	public static void main(String[] args) {
	
		Scanner guarda = new Scanner(System.in);
		int opcion = 0, opcion2 = 0;;
		
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
				}while(opcion2!=4);
				break;
		    }
		}while(opcion!=4);
		System.out.println("Ejecución finalizada");
		
	}
}
