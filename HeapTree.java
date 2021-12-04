package proyecto2;

import java.util.LinkedList;
import java.util.Queue;

//1-dic-2021
//BY MONSE
// Es un max-Heap
public class HeapTree {
	 Nodo root;
	   //Para inicializar la raiz en null
	 
	   // Para inicializar la raíz con un nodo existente
	   public void HeapTree(Nodo root){
	        this.root=root;
	    }
	  //Para saber si el nuevo hijo es mayor que el padre
	   public int comparacionUp(Nodo hijo) {
		   Nodo aux = new Nodo();
		   if( hijo.padre != null) {
			   Nodo padre =  hijo.padre;
			   if(hijo.valor > padre.valor) {
				   aux.valor = padre.valor;
				   padre.valor= hijo.valor;
				   hijo.valor = aux.valor;
				   comparacionUp(hijo.padre);
			   }
			   return 1;
		   }
		   else 
			   return 0;
			   
	   }
	   //Para insertar A la izquierda
	   public void insertarIzq(Nodo padre, Nodo hijo) {
		   padre.setIzq(hijo);
		   hijo.setPadre(padre);
		   comparacionUp(hijo);

	   }
	   //Para insertar a la derecha
	   public void insertarDer(Nodo padre, Nodo hijo) {
		   padre.setDer(hijo);
		   //padre.der = hijo;
		   hijo.setPadre(padre);
		   comparacionUp(hijo);
		   
	   }
	
	   //RETORNA EL ÚLTIMO
	   public Nodo BuscarUltimo(){
	        Nodo r = root;
		Queue<Nodo> queue = new LinkedList();
		if(r!=null){
	        queue.add(r);
	        
	        while(!queue.isEmpty()){
	        	r = (Nodo)queue.poll();
		       
				if(r.izq!=null) {
		            queue.add(r.izq);
		           
		            }
				else {
					
					return r;
				}
				
				if(r.der!=null) {
					queue.add(r.der);
					
					}
				else {
					
					return r;
				}
	        }
	       
		}
		
		 return r;
   }
	   
	   public Nodo FindLast(Nodo seleccionado){
			Queue<Nodo> queue = new LinkedList();
			if(seleccionado!=null){
		            queue.add(seleccionado);
		            while(!queue.isEmpty()){
		                seleccionado = (Nodo)queue.poll();
				if(seleccionado.izq!=null)
		                    queue.add(seleccionado.izq);
				if(seleccionado.der!=null)
		                    queue.add(seleccionado.der);
		            }
		            return seleccionado;
			}
		        return seleccionado;
		    }
	   //insertar 
	   public int insert(Nodo root, Nodo NodoHijo){
		   	int insertado = 0;
		   	if(root.izq == null) {
		   		insertarIzq(root, NodoHijo);
		   		return 1;
		   		
		   	}
		   	else if(root.der == null) {
		   		insertarDer(root, NodoHijo);
		   		return 1;
		   		
		   	// Hasta aquí ya se insertaron los primeros 3 nodos
		   	}
		   	else if(root.izq != null && root.der != null) {
		   		Nodo padre = new Nodo();
		   		System.out.println("Ultimo padre: ");
		   		padre = BuscarUltimo();
		   		
		   		insert(padre,NodoHijo);
		   	}
		   	return 0;
		}
	   //Buscar nodo Mayor
	   public int buscarMayor(Nodo nodo) {
		   if(nodo.izq != null && nodo.der != null) {
			   if(nodo.izq.valor > nodo.der.valor )
				   return 0;
			   else
				   return 1;
		   }
		   return -1; 
	   }
	   
	   //Para saber si el nuevo hijo es mayor que el padre
	   public int comparacionDown(Nodo root) {
		   Nodo aux = new Nodo();
		   Nodo hijo = new Nodo();
		   
		   int lado = buscarMayor(root);
		   
		   if(lado == 0) {
			   hijo = root.izq;
			   }
			   
		   else if(lado == 1) {
			   hijo = root.der;
			   }
		   
		   if(hijo != null) {
			   if(root.valor< hijo.valor) {
				   aux.valor = root.valor;
				   root.valor = hijo.valor;
				   hijo.valor = aux.valor;
				   comparacionDown(hijo);  
			   }
			   return 1;
		   }
		   else
			   return 0;
	   }
	   //Eliminar
	   public void EliminarRaiz(){
		  
		   Nodo ultimo = new Nodo();
		   
		   ultimo = FindLast(root);
		   root.valor = ultimo.valor;
		   ultimo.valor = 0;
		   Nodo padre =  ultimo.getPadre();
		   
		   int lado = buscarMayor(root);
		   
		   if(lado == 0) {
			   padre.izq = null;
			   }
			   
		   else if(lado == 1) {
			   padre.der = null;
			   }
		   comparacionDown(root);
			   
		   
	   }
	  // ------------BreadthFirts---------------
	   protected void visit(Nodo n){
	        System.out.println(n.valor+" ");
	    }	
	    
	    public void breadthFrist(){
		        Nodo r = root;
			Queue<Nodo> queue = new LinkedList();
			if(r!=null){
		        queue.add(r);
		        
		        while(!queue.isEmpty()){
			        r = (Nodo)queue.poll();
			        visit(r);
					if(r.izq!=null) {
			            queue.add(r.izq);
			           
			            }
					
					if(r.der!=null) {
						queue.add(r.der);
						
						}
		        }
			}
	    }
	 // ------------BreadthFirts---------------\n
	  

	    
	   
}
