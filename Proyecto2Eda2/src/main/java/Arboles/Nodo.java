package Arboles;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
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
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }
   
    
}
