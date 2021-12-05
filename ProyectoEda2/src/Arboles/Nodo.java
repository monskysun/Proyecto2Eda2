
package Arboles;

public class Nodo {
    public Nodo padre = null;
    public int valor = -1;
    String valorExp;
    public Nodo izq = null;
    public Nodo der = null;
    
    public Nodo(){
        izq=der=padre=null;
    }
    //Heap
    public Nodo(int data){
        this(data,null,null);
    }
    //Expresiones
    public Nodo(String data){
        this(data,null,null);
    }
    
    //Expresiones
    public Nodo(String data, Nodo lt, Nodo rt){
        valorExp=data;
        izq = lt;
        der = rt;
    }   
    //Heap
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    } 

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public String getValor() {
        return valorExp;
    }

    public void setValor(String valorExp) {
        this.valorExp = valorExp;
    }
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }
    
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    public Nodo getPadre() {
        return this.padre;
    }
    
    void printNode( Nodo node) {
        for(int var = 0; var< 2; var++) {

        }
    }
     
    public void printHijos( ) {
        System.out.println("\nNodo "+ this.valor+":\n");
        System.out.println("     "+ this.valor);
        if(this.izq!= null && this.der == null) {
                System.out.println("   "+ this.izq.valor);
        }
        else if(this.der != null && this.izq == null )
                System.out.println("      "+ this.der.valor);

        else if ( this.izq!= null  && this.der != null) {
                System.out.print("   "+ this.izq.valor);
                System.out.println("   "+ this.der.valor);
        }
    }
}
