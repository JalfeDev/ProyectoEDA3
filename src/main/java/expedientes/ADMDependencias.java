/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
import tda.*;

/**
 *
 * @author maldo
 */
public class ADMDependencias {
    private final ArbolBinario<Dependencia> arbolDependencias;

    public ADMDependencias() {
        arbolDependencias = new ArbolBinario<>();
        arbolDependencias.crearRaiz(new Dependencia("Oficina Central","ULima"));
    }
    
    // Agrega una nueva dependencia si no existe una con el mismo nombre
    //Es un recorrido por niveles (BFS)
    public boolean crearDependencia(Dependencia dependencia) {
        if (buscarDependencia(dependencia.getNombre()) != null) {
            return false;
        }
        NodoAB<Dependencia> nuevo = new NodoAB<>(dependencia);
        Cola<NodoAB<Dependencia>> cola = new Cola<>();
        cola.encolar(arbolDependencias.getRaiz());

        while (!cola.esVacia()) {
            NodoAB<Dependencia> nodo = cola.desencolar();
            if (nodo.getHijoIzq() == null) {
                nodo.setHijoIzq(nuevo);
                return true;
            } else {
                cola.encolar(nodo.getHijoIzq());
            }

            if (nodo.getHijoDer() == null) {
                nodo.setHijoDer(nuevo);
                return true;
            } else {
                cola.encolar(nodo.getHijoDer());
            }
        }
        return true;
    }
    
    public Dependencia getDependenciaInicial(){
        return arbolDependencias.getRaiz().getItem();
    }
    
    public Dependencia buscarDependencia(String nombre) {
        if (getDependenciaInicial().getNombre().equalsIgnoreCase(nombre)){
            return getDependenciaInicial();
        }
        
        Dependencia izq = buscarDependencia(arbolDependencias.getRaiz().getHijoIzq(), nombre);
        Dependencia der = buscarDependencia(arbolDependencias.getRaiz().getHijoDer(), nombre);;
        
        if (izq != null) return izq;
        if (der != null) return der;
        return null;
    }
    
    public Dependencia buscarDependencia(NodoAB<Dependencia> nodo, String nombre) {
        if (nodo == null){
            return null;
        }
        
        if (nodo.getItem().getNombre().equalsIgnoreCase(nombre)){
            return nodo.getItem();
        }
        
        Dependencia izq = buscarDependencia(nodo.getHijoIzq(), nombre);
        Dependencia der = buscarDependencia(nodo.getHijoDer(), nombre);
        
        if (izq != null) return izq;
        if (der != null) return der;
        return null;
    }

    //Recorrido por profundida (DFS)
    public String nombrarDependencias(){
        String temp = "";
        Pila<NodoAB<Dependencia>> pila = new Pila<>();
        pila.apilar(arbolDependencias.getRaiz());
        while(!pila.esVacia()){
            NodoAB<Dependencia> nodo = pila.desapilar();
            temp += nodo.getItem().toString() + "\n";
            //Preorden
            if (nodo.getHijoDer() != null)
                pila.apilar(nodo.getHijoDer());
            if (nodo.getHijoIzq() != null)
                pila.apilar(nodo.getHijoIzq());
        }
        return temp;
    }
}
