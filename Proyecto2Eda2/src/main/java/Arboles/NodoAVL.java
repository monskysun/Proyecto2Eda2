/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Brusi
 */
public class NodoAVL {
    NodoAVL izq;
    NodoAVL der;
    int h;
    int valor;
    
    public NodoAVL(int valor){
        this.valor=valor;
        this.h=0;
        this.der=null;
        this.izq=null;
    }
    public NodoAVL(){
        
    }
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
