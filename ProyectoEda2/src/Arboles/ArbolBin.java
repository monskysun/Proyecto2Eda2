
package Arboles;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBin {
    Nodo root;
    Nodo actual;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(String val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
   
    
    public void ingresarNodo(String nodoIn,int caso){
        Nodo nodo = new Nodo(nodoIn);
        switch(caso){
            case 1 -> {
                addParenAper(nodo);
            }
            case 2 -> {
                addOperandos(nodo);
            }
            case 3 -> {
                addOperadores(nodo);
            }
        }
    }
    
    public void addParenAper(Nodo select) {
        if (root == null) {
            this.root = select;
            actual=select; 
        }else{
            if(actual.getIzq()==null){
                actual.setIzq(select);
                actual=select;
            }else if(actual.getDer()==null){
                actual.setDer(select);
                actual=select;
            }
        }
    }
    public void addOperandos(Nodo select){
        
        if(actual.getIzq()==null){
            actual.setIzq(select);
        }else if(actual.getDer()==null){
            actual.setDer(select);
        }
    }
    public void addOperadores(Nodo select){
        actual.setValor(select.valorExp);
    }
    
    public void actualizadorPadre(){
        if (actual == this.root) { 
        }else{
            Nodo aux=nodoPadre(actual); 
            actual=aux;
        }
    }
    
    
   /*Obtiene el nodo padre de un nodo actual, este se retorna mediante aux*/
    public Nodo nodoPadre(Nodo select){
        Nodo padre=root;
        Nodo aux=root;
        
        Queue<Nodo> queue = new LinkedList();
        queue.clear();
        queue.add(padre);
        while(!queue.isEmpty()){
            padre = (Nodo)queue.poll();
            if(padre.izq!=null && padre.getIzq()!=select){
                queue.add(padre.izq);
                aux=padre.getIzq();
            }
            else if(padre.getIzq()==select)
                return padre;
            
            if(padre.der!=null && padre.getDer()!=select){
                queue.add(padre.der);
                aux=padre.getDer();
            }
            else if(padre.getDer()==select)
                return padre;
        }
        return aux;
    }
    protected void visit(Nodo n){
        if(n.valorExp!=null)
            System.out.println(n.valor+" ");
        else
            System.out.print("");
    }	
    
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    
    /*Método recursivo que realiza el recorrido postOrden, dentro de cada análisis, se almacena el  nodo correspondiente en la lista*/
    LinkedList<String> listaOrd= new LinkedList();
    public Nodo postorden(Nodo nodo){
        
	if(nodo==null){
            return null;
        }else{
            postorden(nodo.getIzq());
            postorden(nodo.getDer());
            listaOrd.add(nodo.valorExp);
            
            return null;
        }
    }
    /*Método que manda llamar al recorrido PostOrden para que esta lista se trate de la notación polaca inversa*/
    public LinkedList<String> generarNotPolInv(){
        listaOrd.clear();
        postorden(this.root);
        return listaOrd; 
    }
}
