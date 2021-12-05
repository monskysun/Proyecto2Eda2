
package Arboles;


public class Recorridos {
    
    public Nodo preorden(Nodo nodo){
        
	if(nodo==null){
            return null;
        }else{
            System.out.print(nodo.valor+"  ");
            preorden(nodo.getIzq());
            preorden(nodo.getDer());
            
            return null;
        }
    }
    
    public Nodo inorden(Nodo nodo){
	if(nodo==null){
            return null;
        }else{
            inorden(nodo.getIzq());
            System.out.print(nodo.valor+"  ");
            inorden(nodo.getDer());
            
            return null;
        }
    }
    
    public Nodo postorden(Nodo nodo){
	if(nodo==null){
            return null;
        }else{
            postorden(nodo.getIzq());
            postorden(nodo.getDer());
            System.out.print(nodo.valor+"  ");
            
            return null;
        }
    }
    
    
    
    
    
}
