package proyecto2;
//by Monse
/*
 * 3 de diciembre 2021
 * EDA 2
 * Proyecto 2 :Áboles
 * 
 * */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner guarda = new Scanner(System.in);
		Nodo root = new Nodo();
		HeapTree ArbolHeap = new HeapTree();
		int opcion = 0, op2;
		int value = 0,valuePadre = 0,creado = 0;
		do {
			System.out.println("-----------Heap-----------");
		
		    System.out.println(""
		    		+ "1. Agregar clave\n"
		    		+ "2. Eliminar raíz\n"
		    		+ "3. Mostrar árbol\n"
		    		+ "4. Regresar\n");
		    System.out.println("Elige una opción:\n");
		    opcion=guarda.nextInt();
		    System.out.println("--------------------------");
		    switch(opcion){ 
			case 1:
				//Agregar clave
				if(creado == 0) {
					System.out.println("Indique el valor del nodo raíz: ");
					value = guarda.nextInt();
					root.valor = value;
			    	ArbolHeap.HeapTree(root);
			    	creado = 1;
			    	root.printHijos();
		    	}
				else {
			    	do{
			    	 	 System.out.println("Desea insertar un Nodo? \n"
				    	 		+ "1)Si\n"
				    	 		+ "2)No\n");
				    	 op2 = guarda.nextInt();
				    	 switch(op2){ 
						    
							case 1:
								 System.out.println("Ingresa el valor:");
					    	 	 value = guarda.nextInt();
						    	 Nodo newNode = new Nodo(value);
						    	 ArbolHeap.insert(root,newNode);
						    	 ArbolHeap.breadthFrist();
						    	 
								break;
							}
				    	 
				    	 }while(op2!=2);
		    	}
				break;
				
			case 2:
				ArbolHeap.EliminarRaiz();
				System.out.println("Raíz eliminada :)");
				break;
			case 3:
				ArbolHeap.breadthFrist();
				break;
				
			case 4:
				System.out.println("Redireccionando... \n");
				break;
				}
		    
		}while(opcion!=4);
	}
}
