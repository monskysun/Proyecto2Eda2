
package avl;

public class NodoAVL {
    NodoAVL izq;
    NodoAVL der;
    int h; // Nos ayudará a evaluar la condición de equilibrio
    int valor;
    
    //Constructor que solo incializa su atributo valor.
    public NodoAVL(int valor){
        this.valor=valor;
        this.h=0;
        this.der=null;
        this.izq=null;
    }
    public NodoAVL(){ 
    }
    
    //Getters y setters de cada atributo
    public NodoAVL getIzq() {
        return izq;
    }

    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoAVL getDer() {
        return der;
    }

    public void setDer(NodoAVL der) {
        this.der = der;
    }
    
    public int getH() {
        return h;
    }
    

    public void setH(int h) {
        this.h = h;
    }
    
}
