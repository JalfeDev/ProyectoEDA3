package tda;

public class Pila<T> {
    private Nodo<T> cima;
    
    
    public Pila(){
        cima = null;
    }
    
    
    public boolean esVacia(){
        return cima==null;
    }
    
    public void apilar(T item){
        Nodo<T> nuevoNodo = new Nodo<>(item,null);
        if (esVacia()){
            cima = nuevoNodo;
        }else{
            Nodo<T> aux = cima;
            nuevoNodo.setSgteNodo(aux);
            cima = nuevoNodo;
        }
    }
    
    /*
    desapilar: elimina un item de la cima de la pila. Debe devolver
    el item que es eliminado. Elimina el elemento que apunta a la cima.
    */
    public T desapilar(){
        if(esVacia()){
            throw new RuntimeException("La pila está vacia!!!!");
        }else{// la pila tiene elementos
            T item = cima.getItem();
            cima = cima.getSgteNodo();
            return item;
        }
        
    }
}
