package proyecto2;

import java.util.Scanner;

public class Pruebas2 {
	 public static void main(String args[]){
		 
	    	Scanner guarda = new Scanner(System.in);
	    	HeapTree ArbolHeap = new HeapTree();
	    	//introduce el valor de la raíz
	    	Nodo root = new Nodo(10);
	    	ArbolHeap.HeapTree(root);
	    	//root.printHijos();//prueba
	    	
	    	Nodo izq = new Nodo(7);
	    	Nodo der = new Nodo(15);
	    	ArbolHeap.insert(root,izq);
	    	
	    	//root.printHijos();//prueba
	    	ArbolHeap.insert(root,der);
	    	
	    	Nodo nuevo4 = new Nodo(16);
	    	Nodo nuevo5 = new Nodo(9);
	    	Nodo nuevo6 = new Nodo(12);
	    	Nodo nuevo7 = new Nodo(21);
	    	
	    	Nodo nuevo8 = new Nodo(5);
	    	Nodo nuevo9 = new Nodo(6);
	    	
	    	root.printHijos();
	    	
	    	ArbolHeap.insert(root, nuevo4);
	    	ArbolHeap.insert(root, nuevo5);
	    	ArbolHeap.insert(root, nuevo6);
	    	ArbolHeap.insert(root, nuevo7);
	    	ArbolHeap.insert(root, nuevo8);
	    	ArbolHeap.insert(root, nuevo9);
	    	
	    	root.printHijos();
	    	izq.printHijos();
	    	der.printHijos();
	    	nuevo4.printHijos();
	    	//System.out.println(ArbolHeap.FindLast(root).valor);
	    	
	    	
	    	ArbolHeap.EliminarRaiz();
	    	System.out.println("Después de la eliminación:");
	    	root.printHijos();
	    	izq.printHijos();
	    	der.printHijos();
	    	nuevo4.printHijos();
	    	
	    	ArbolHeap.EliminarRaiz();
	    	System.out.println("Después de la eliminación 2:");
	    	root.printHijos();
	    	izq.printHijos();
	    	der.printHijos();
	    	nuevo4.printHijos();
	    	
	    	
	   
	    	
	    	
	       
	 }
}
