/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Brusi
 */
public class ArbolAVL {
    private NodoAVL root;
    
    public ArbolAVL(){
        root=null;
    }
    public ArbolAVL(NodoAVL root){
        this.root=root;
    }
    
    public NodoAVL rotacionIzq(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getIzq();
        nodo.setIzq(nodo.getDer());
        aux.setDer(nodo);
        if(nodo.getIzq().h >= nodo.getDer().h){
            nodo.setH(nodo.getIzq().h+1);
        }else{
            nodo.setH(nodo.getDer().h+1);
        }
        
        if(aux.getIzq().h >= aux.getDer().h){
            aux.setH(aux.getIzq().h+1);
        }else{
            aux.setH(aux.getDer().h+1);
        }
        
        return aux;
    }
    
    public NodoAVL rotacionDer(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getDer();
        nodo.setDer(nodo.getIzq());
        aux.setIzq(nodo);
        
        if(nodo.getIzq().h >= nodo.getDer().h){
            nodo.setH(nodo.getIzq().h+1);
        }else{
            nodo.setH(nodo.getDer().h+1);
        }
        
        if(aux.getIzq().h >= aux.getDer().h){
            aux.setH(aux.getIzq().h+1);
        }else{
            aux.setH(aux.getDer().h+1);
        }
        
        return aux;
    }
    
    public NodoAVL rotacionDobIzq(NodoAVL nodo){
        nodo.setIzq(rotacionDer(nodo.getIzq()));
        return rotacionIzq(nodo);
    }
    
    public NodoAVL rotacionDobDer(NodoAVL nodo){
        nodo.setDer(rotacionIzq(nodo.getDer()));
        return rotacionDer(nodo);
    }
    
    public NodoAVL add(NodoAVL root, NodoAVL padre, int valor){
        if (this.root==null){
            this.root= new NodoAVL();
            this.root.setValor(valor);
            this.root.setH(0);
            this.root.setDer(null);
            this.root.setIzq(null);
        }else if(valor<padre.getValor()){
            root.setIzq(add(root.getIzq(), padre, valor));
            if(root.getIzq().getH() - root.getDer().getH() == 2 ){ //Altura
                if(valor < root.getIzq().getValor()){
                    root = rotacionIzq(root);
                }else{
                    root= rotacionDobIzq(root);
                }
            }
            
        }else if(valor>padre.getValor()){
            root.setDer(add(root.getDer(), padre, valor));
            if(root.getDer().getH() - root.getIzq().getH() == 2 ){ //Altura
                if(valor < root.getDer().getValor()){
                    root = rotacionDer(root);
                }else{
                    root= rotacionDobDer(root);
                }
            }
        }
        
        if(root.getIzq().h >= root.getDer().h){
            root.setH(root.getIzq().h+1);
        }else{
            root.setH(root.getDer().h+1);
        }
        return root;
    }
    public void breadthFrist(){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    protected void visit(NodoAVL n){
        if(n.valor!=0)
            System.out.println(n.valor+" ");
        else
            System.out.print("");
    }
    
    public boolean busca(int val){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();
		if(r.valor == val){
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

    
}
