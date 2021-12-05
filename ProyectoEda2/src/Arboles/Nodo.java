
package Arboles;

public class Nodo {
    String valor;
    Nodo izq = null;
    Nodo der = null;
    
    public Nodo(){
        izq=der=null;
    }
    public Nodo(String data){
        this(data,null,null);
    }
    public Nodo(String data, Nodo lt, Nodo rt){
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
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }

    
}
