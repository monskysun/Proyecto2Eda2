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
    
    //Obtiene la altura de un nodo, si el nodo es nulo
    //Se dice que la altura es de -1
    public int obtenerH(NodoAVL nodo) {
        if(nodo==null){
            return -1;
        }else{
        }
        return nodo.getH();
    }
    
    //Realiza la rotación simple izquierda
    public NodoAVL rotacionIzq(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getIzq();
        nodo.setIzq(aux.getDer());
        aux.setDer(nodo);
        
        //Se realiza el cambio de alturas para posteriormente
        //evaluar la condición de equilibrio
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
    
    //Realiza la rotación simple derecha
    public NodoAVL rotacionDer(NodoAVL nodo){
        NodoAVL aux= new NodoAVL();
        aux= nodo.getDer();
        nodo.setDer(aux.getIzq());
        aux.setIzq(nodo);
        
        //Se realiza el cambio de alturas para posteriormente
        //evaluar la condición de equilibrio
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
    //Realiza la rotación doble izquierda
    public NodoAVL rotacionDobIzq(NodoAVL nodo){
        nodo.setIzq(rotacionDer(nodo.getIzq()));
        return rotacionIzq(nodo);
    }
    
    //Realiza la rotacion doble derecha
    public NodoAVL rotacionDobDer(NodoAVL nodo){
        nodo.setDer(rotacionIzq(nodo.getDer()));
        return rotacionDer(nodo);
    }
    public void agregar(int valor){
        //Se crea un nuevo nodo con el valor de este.
        NodoAVL nuevo = new NodoAVL(valor);
        
        //Cuando el árbol esta vació ese nuevo nodo se establece como
        //la raíz del árbol
        if (root==null)
        {
            this.root= new NodoAVL();
            this.root.setValor(valor);
            this.root.setH(0);
            this.root.setDer(null);
            this.root.setIzq(null);
        }else{
        //Se llama al método add que realiza la inserción de forma recursiva
            root= add(nuevo, root);
        }
    }
    
    //Este método va a llamarse recursivamente y agregará un nodo al árbol
    public NodoAVL add(NodoAVL nuevo,  NodoAVL existente){
        //Se guarda la referencia del nuevo nodo en un auxiliar
        NodoAVL aux=existente;
        
        //Siguiendo el principio de un árbol binario de búsqueda si el valor es 
        //menor se va a la izquierda.
        if(nuevo.valor<existente.getValor()){
            if(existente.getIzq()==null){ //Cuando se llega a una hoja se inserta
                existente.setIzq(nuevo);
            }else{
                //Si no es una hoja y es un subárbol, se llama a este mismo método de forma
                //recursiva, hasta que llegue a una hoja. En cada recursividad se manda el nuevo subárbol
                existente.setIzq(add(nuevo,  existente.getIzq()));
                //Va a verificar la condición de equilibrio y si esta desbalanceado, realizará las 
                //rotaciones correspondientes.
                if(obtenerH(existente.getIzq()) - obtenerH(existente.getDer()) == 2 ){ //Altura
                    if(nuevo.valor < existente.getIzq().getValor()){
                        aux = rotacionIzq(existente);
                     }else{
                        aux= rotacionDobIzq(existente);
                    }
                }
            }
            
        //Siguiendo el principio de un árbol binario de búsqueda si el valor es 
        //menor se va a la izquierda.    
        }else if(nuevo.valor>existente.getValor()){
            if(existente.getDer()==null){ //Cuando se llega a una hoja se inserta
                existente.setDer(nuevo);
            }else{
                //Si no es una hoja y es un subárbol, se llama a este mismo método de forma
                //recursiva, hasta que llegue a una hoja. En cada recursividad se manda el nuevo subárbol
                existente.setDer(add(nuevo,  existente.getDer()));
                //Va a verificar la condición de equilibrio y si esta desbalanceado, realizará las 
                //rotaciones correspondientes.
                if(obtenerH(existente.getDer()) - obtenerH(existente.getIzq()) == 2 ){ //Altura
                    if(nuevo.valor > existente.getDer().getValor()){
                        aux = rotacionDer(existente);
                    }else{
                        aux= rotacionDobDer(existente);
                }
            }
            }
            
        }
        //Se ha finalizado la inserción dentro del árbol.
        
        //Ahora se van a modificar las alturas de cada nodo, para así poder obtener
        //la condición de equilibrio y que el árbol la cumpla.
        if((existente.getIzq()==null)&&(existente.getDer()!=null)){
            //Se establece la altura del único nodo existente (derecho)
            existente.setH(obtenerH(existente.getDer()) +1);
        }else if((existente.getDer()==null)&&(existente.getIzq()!=null)){
            //Se establece la altura del único nodo existente (izquierdo)
            existente.setH(obtenerH(existente.getIzq()) +1);
        }else{
            //Se obtiene la máxima altura de los dos nodos hijos
            if( obtenerH(existente.getIzq())> obtenerH(existente.getDer()) ){
                existente.setH(obtenerH(existente.getIzq())+1);
            }else{
                existente.setH(obtenerH(existente.getDer())+1);
        }
        }
        return aux;
    }
    
    //Recorrido BFS, imprimiendo su valor
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
    
    //Visitar a un nodo e imprimir su valor
    protected void visit(NodoAVL n){
        if(n.valor!=0)
            System.out.println(n.valor+" ");
        else
            System.out.print("");
    }
    
    //Busca un valor recorriedno el árbol con BFS
    public boolean busca(int val){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();
                //En lugar de imprimir el valor, se realoza la compaaración
                //cuando el valor es encontrado, retorna true.
		if(r.valor == val){
                    System.out.println("SI EXISTE");
                    return true;
                }
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
                    queue.add(r.der);
            }
            //Si el valor nunca se encontró retorna false.
            System.out.println("NO EXISTE");
            return false;
	}
        //Si el árbol no existe retorna false.
        return false;
    }

    //Debido a las posibles modificaciones que pueden existir, la raíz puede moverse.
    //Cuando se elima un valor, se debe de considerar y por eso se actualiza la raíz.
    public void elimina(int x){
        root= remover(x, root);
    }
    
    //Este método se realizará de forma recursiva
    public NodoAVL remover(int val, NodoAVL nodo){
        int HIzq, HDer, derH, izqH;
        //Es un caso base, donde si ya se busco la clave y nunca se ecnontró
        //el nodo llegará a ser null.
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
