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
    int diferencia;
    int valor;

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
    public int getH(NodoAVL root) {
        if(root==null){
            return -99;
        }else{
        }
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }
    
   
}
