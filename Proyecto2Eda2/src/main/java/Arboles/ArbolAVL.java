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
    public int obtenerH(NodoAVL nodo) {
        if(nodo==null){
            return -1;
        }else{
        }
        return nodo.getH();
    }
    public NodoAVL rotacionIzq(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getIzq();
        nodo.setIzq(aux.getDer());
        aux.setDer(nodo);
        
        if(obtenerH(nodo.getIzq())> obtenerH(nodo.getDer())){
            nodo.setH(obtenerH(nodo.getIzq())+1);
        }else{
            nodo.setH(obtenerH(nodo.getDer())+1);
        }
        
        if( obtenerH(aux.getIzq())> obtenerH(aux.getDer()) ){
            aux.setH(obtenerH(aux.getIzq())+1);
        }else{
            aux.setH(obtenerH(aux.getDer())+1);
        }
        
        return aux;
    }
    
    public NodoAVL rotacionDer(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getDer();
        nodo.setDer(aux.getIzq());
        aux.setIzq(nodo);
        
        if(obtenerH(nodo.getIzq())> obtenerH(nodo.getDer())){
            nodo.setH(obtenerH(nodo.getIzq())+1);
        }else{
            nodo.setH(obtenerH(nodo.getDer())+1);
        }
        
        if( obtenerH(aux.getIzq())> obtenerH(aux.getDer()) ){
            aux.setH(obtenerH(aux.getIzq())+1);
        }else{
            aux.setH(obtenerH(aux.getDer())+1);
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
    public void agregar(int valor){
        NodoAVL nuevo = new NodoAVL(valor);
        if (root==null)
        {
            this.root= new NodoAVL();
            this.root.setValor(valor);
            this.root.setH(0);
            this.root.setDer(null);
            this.root.setIzq(null);
        }else{
            root= add(nuevo, root);
        }
    }
    
    public NodoAVL add(NodoAVL nuevo,  NodoAVL existente){
        NodoAVL aux=existente;
        if(nuevo.valor<existente.getValor()){
            if(existente.getIzq()==null){
                existente.setIzq(nuevo);
            }else{
                existente.setIzq(add(nuevo,  existente.getIzq()));
                if(obtenerH(existente.getIzq()) - obtenerH(existente.getDer()) == 2 ){ //Altura
                    if(nuevo.valor < existente.getIzq().getValor()){
                        aux = rotacionIzq(existente);
                     }else{
                        aux= rotacionDobIzq(existente);
                    }
                }
            }
            
            
        }else if(nuevo.valor>existente.getValor()){
            if(existente.getDer()==null){
                existente.setDer(nuevo);
            }else{
                existente.setDer(add(nuevo,  existente.getDer()));
            if(obtenerH(existente.getDer()) - obtenerH(existente.getIzq()) == 2 ){ //Altura
                if(nuevo.valor > existente.getDer().getValor()){
                    aux = rotacionDer(existente);
                }else{
                    aux= rotacionDobDer(existente);
                }
            }
            }
            
        }
        
//        if(root.getIzq()!= null && root.getIzq().h >= root.getDer().h){
//            root.setH(root.getIzq().getH()+1);
//        }else if(root.getDer()!= null ){
//            root.setH(root.getDer().getH()+1);
//        }
        
        
        if((existente.getIzq()==null)&&(existente.getDer()!=null)){
            
            existente.setH(obtenerH(existente.getDer()) +1);
        }else if((existente.getDer()==null)&&(existente.getIzq()!=null)){
            
            existente.setH(obtenerH(existente.getIzq()) +1);
        }else{
            if( obtenerH(existente.getIzq())> obtenerH(existente.getDer()) ){
                existente.setH(obtenerH(existente.getIzq())+1);
            }else{
                existente.setH(obtenerH(existente.getDer())+1);
        }
        }
        return aux;
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
//    if (a > b) {
//        max = a;
//    }
//    else {
//        max = b;
//    }
//    max = (a > b) ? a : b;
// int l = t.left != null ? t.left.height : 0;
    public void elimina(int x){
        root= remover(x, root);
    }
    public NodoAVL remover(int val, NodoAVL nodo){
        int HIzq, HDer, derH, izqH;
        if(nodo==null){
            System.out.println("La clave: "+val+ " a eliminar no existe en el árbol");
            return null;
        }
        
        //Cuando el valor se encuentra a la izquierda del subarbol
        if(val<nodo.getValor()){
            nodo.setIzq(remover(val, nodo.getIzq())); 
            if(nodo.getIzq()!=null){
                HIzq = nodo.getIzq().getH();
            }else{
                HIzq=0;
            }
            
            if(nodo.getDer()!=null && (nodo.getDer().getH() - HIzq >= 2)){
                if(nodo.getDer().getDer()!=null){
                    derH= nodo.getDer().getDer().getH();
                }else{
                    derH= 0;
                }
                if(nodo.getDer().getIzq()!=null){
                    izqH= nodo.getDer().getIzq().getH();
                }else{
                    izqH= 0;
                }
                
                if(derH >= izqH){
                    nodo = rotacionIzq(nodo);
                }else{
                    nodo= rotacionDobDer(nodo);
                }
            }
        }
        else if(val>nodo.getValor()){
            nodo.setDer(remover(val, nodo.getDer()));
            if(nodo.getDer()!=null){
                HDer = nodo.getDer().getH();
            }else{
                HDer=0;
            }
            
            if(nodo.getIzq()!=null && (nodo.getIzq().getH() - HDer >= 2)){
                if(nodo.getIzq().getIzq()!=null){
                    izqH= nodo.getIzq().getIzq().getH();
                }else{
                    izqH= 0;
                }
                if(nodo.getIzq().getDer()!=null){
                    derH= nodo.getIzq().getDer().getH();
                }else{
                    derH= 0;
                }
                
                if(izqH >= derH){
                    nodo = rotacionDer(nodo);
                }else{
                    nodo= rotacionDobIzq(nodo);
                }
                
                
            }
        }
        
        else if(nodo.getIzq()!= null){
            nodo.setValor(nodoMax(nodo.getIzq()).getValor());
            remover(nodo.getValor(), nodo.getIzq());
            
            if((nodo.getDer() != null) && (nodo.getDer().getH() - nodo.getIzq().getH() >= 2)){
                if(nodo.getDer().getDer()!=null){
                    derH= nodo.getIzq().getDer().getH();
                }else{
                    derH= 0;
                }
                
                if(nodo.getDer().getIzq()!=null){
                    izqH= nodo.getDer().getIzq().getH();
                }else{
                    izqH= 0;
                }
                
                if(derH >= izqH)
                    nodo = rotacionIzq(nodo);
                else
                    nodo = rotacionDobDer(nodo);
            }
        }
        
        else{
            if(nodo.getIzq()!= null)
                nodo= nodo.getIzq();
            else
                nodo= nodo.getDer();
        }
        
        if(nodo != null){
            if(nodo.getIzq()!= null)
                izqH= nodo.getIzq().getH();
            else
                izqH=0;
            
            if(nodo.getDer()!=null)
                derH=nodo.getDer().getH();
            else
                derH=0;
            
            if( obtenerH(nodo.getIzq())> obtenerH(nodo.getDer()) ){
                    nodo.setH(obtenerH(nodo.getIzq())+1);
                }else{
                    nodo.setH(obtenerH(nodo.getDer())+1);
                }
        }
        
        return nodo;
        
    }

    public NodoAVL nodoMax(NodoAVL nodo){
        if( nodo == null )
            return nodo;

        while( nodo.getDer() != null )
            nodo = nodo.getDer();
        return nodo;
    }
    
}
