/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author Juan Gustavo Loyola
 */
public class NodoAB<T> {
    private T item;
    private NodoAB<T> padre;
    private NodoAB<T> hijoIzq;
    private NodoAB<T> hijoDer;

    public NodoAB(T item) {
        this.item = item;
        this.padre = null;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
    public NodoAB(T item, NodoAB<T> padre, NodoAB<T> hijoIzq, NodoAB<T> hijoDer) {
        this.item = item;
        this.padre = padre;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public NodoAB<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoAB<T> padre) {
        this.padre = padre;
    }

    public NodoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAB<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAB<T> hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
}
