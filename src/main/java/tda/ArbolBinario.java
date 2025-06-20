/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author Juan Gustavo Loyola
 * @param <T>
 */
public class ArbolBinario<T> {
    private NodoAB<T> raiz;
    private int size;

    public ArbolBinario() {
        this.raiz = null;
        this.size = 0;
    }
    
    public NodoAB<T> getRaiz() {
        return raiz;
    }

    public int getSize() {
        return size;
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }
    
    public NodoAB<T> crearRaiz(T item){
        if (!esVacio()){
            throw new RuntimeException("Ya hay una raiz");
        }
        else{
            raiz = new NodoAB<T>(item);
            size++;
        }
        return raiz;
    }
    
    public NodoAB<T> agregarHijoIzq(T item, NodoAB<T> padre){
        if (padre.getHijoIzq() != null){
            throw new RuntimeException("El padre ya tiene un hijo izquierdo");
        }
        if (esVacio()){
            throw new RuntimeException("El arbol esta vacio");
        }
        NodoAB<T> hijo = new NodoAB<>(item, padre, null, null);
        padre.setHijoIzq(hijo);
        size++;
        return raiz.getHijoIzq();
    }
    
    public NodoAB<T> agregarHijoDer(T item, NodoAB<T> padre){
        if (padre.getHijoDer() != null){
            throw new RuntimeException("El padre ya tiene un hijo derecho");
        }
        if (esVacio()){
            throw new RuntimeException("El arbol esta vacio");
        }
        NodoAB<T> hijo = new NodoAB<>(item, padre, null, null);
        padre.setHijoDer(hijo);
        size++;
        return raiz.getHijoDer();
    }
    
    public void preOrden(NodoAB<T> nodo) {
        if (nodo != null){
            System.out.print(nodo.getItem() + " -> ");
            preOrden(nodo.getHijoIzq());
            preOrden(nodo.getHijoDer());
        }
    }
    
    public void postOrden(NodoAB<T> nodo) {
        if (nodo != null){
            postOrden(nodo.getHijoIzq());
            postOrden(nodo.getHijoDer());
            System.out.print(nodo.getItem() + " -> ");
        }
    }
    
    
    public void inOrden(NodoAB<T> nodo) {
        if (nodo != null){
            inOrden(nodo.getHijoIzq());
            System.out.print(nodo.getItem() + " -> ");
            inOrden(nodo.getHijoDer());
        }
    }
}
