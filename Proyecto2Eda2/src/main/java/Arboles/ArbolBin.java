package Arboles;



import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(String val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    

    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    public Nodo getRoot() {
        return root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        if(n.valor!=null)
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
    
    public void elimina(Nodo e){
        if(e!= null){
            if(e.izq!=null){
                e.valor=e.izq.valor;
                if(e.izq.izq== null && e.izq.der== null){
                    e.izq=null;
                }else{
                    elimina(e.izq);
                }
                
            }else if(e.der!=null){
                e.valor=e.der.valor;
                if(e.der.izq== null && e.der.der== null){
                    e.der=null;
                }else{
                    elimina(e.der);
                }
            }else if(e.izq== null && e.der== null){
                e.valor=null;
                e=null;
            }
        }
    }
    
    public boolean busca(String val){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		if(r.valor.equals(val)){
                    System.out.println("SI EXISTE");
                    return true;
                }
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
            System.out.println("NO EXISTE");
            return false;
	}
        return false;
    }
    public void preOrden(Nodo r){
        
        if(r!= null){
            visit(r);
            if(r.izq!=null){
                preOrden(r.izq);
                preOrden(r.der);
            }else{
                preOrden(r.der);
                preOrden(r.izq);
            }
        }
    }
    public void inOrden(Nodo r){

        if(r!= null){
            if(r.izq!=null){
                inOrden(r.izq);
                visit(r);
                inOrden(r.der);
            }else{
                visit(r);
                inOrden(r.der);
                
            }
        }
    }
    public void postOrden(Nodo r){
        if(r!= null){
            if(r.izq!=null){
                postOrden(r.izq);
                postOrden(r.der);
                visit(r);
            }else{
                postOrden(r.der);
                visit(r);
            }
        }
    }
}
