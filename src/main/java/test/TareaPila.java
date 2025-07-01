package test;
import tda.Pila;
public class TareaPila {
    public static void mostrarPila(Pila<Integer> pila){
        Pila<Integer> aux = new Pila<>(); // pila vacia
        while(!pila.esVacia()){
            int item = pila.desapilar();
            System.out.print(item + "  ->  ");
            aux.apilar(item);
        }
        while (!aux.esVacia()){
            pila.apilar(aux.desapilar());            
        }
    }
    
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>();
        pila1.apilar(12);
        pila1.apilar(58);
        pila1.apilar(69);
        pila1.apilar(32);
        pila1.apilar(45);
        pila1.apilar(4);
    }
    
    public static int contarPila1(Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();
        int count = 0;
        while (!pila.esVacia()) {
            int item = pila.desapilar();
            aux.apilar(item);
            count++;
        }
        while (!aux.esVacia()) {
            pila.apilar(aux.desapilar());
        }
        return count;
    }
    
    public static boolean seEncuentra2(int val, Pila<Integer> pila ){
        Pila<Integer> aux = new Pila<>();
        while(!pila.esVacia()){
            Integer item = pila.desapilar();
            aux.apilar(item);
        }
        boolean flag = false;
        while(!aux.esVacia()){
            int item = aux.desapilar();
            if (item == val){
                flag = true;
            }
            pila.apilar(item);
        }
        return flag;
    }
    
    public static void invertirPila3(Pila<Integer> pila){
        Pila<Integer> aux1 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();
        while (!pila.esVacia()) {
            aux1.apilar(pila.desapilar());
        }
        while (!aux1.esVacia()) {
            aux2.apilar(aux1.desapilar());
        }
        while (!aux2.esVacia()) {
            pila.apilar(aux1.desapilar());
        }
    }
    
    public static void mostrarInvertido4(Pila<Integer> pila){
        Pila<Integer> aux = new Pila<>(); // pila vacia
        while(!pila.esVacia()){
            aux.apilar(pila.desapilar());
        }
        while (!aux.esVacia()){
            int item = aux.desapilar();
            System.out.print(item + "  ->  ");
            pila.apilar(item);
        }
    }

    public static void insertarAlFondo5(Pila<Integer> pila, int nuevo){
        Pila<Integer> aux = new Pila<>();
        while (!pila.esVacia()) {
            aux.apilar(pila.desapilar());
        }
        pila.apilar(nuevo);
        while (!aux.esVacia()) {
            Integer item = aux.desapilar();
            pila.apilar(item);
        }
    }
    
    public static boolean esPositivo6(Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();
        boolean isPositive = true;
        while (!pila.esVacia()) {
            int item = pila.desapilar();
            if (item < 0) {
                isPositive = false;
            }
            aux.apilar(item);
        }
        while (!aux.esVacia()) {
            pila.apilar(aux.desapilar());
        }
        return isPositive;
    }

    public static void reemplazarItem7(Pila<Integer> pila, Integer viejo, Integer nuevo){
        Pila<Integer> aux = new Pila<>();
        while (!pila.esVacia()) {
            Integer item = pila.desapilar();
            if (item.equals(viejo)) {
                item = nuevo;
            }
            aux.apilar(item);
        }
        while (!aux.esVacia()) {
            pila.apilar(aux.desapilar());
        }
    }
    
    public static boolean sonIguales8(Pila<Integer> P1, Pila<Integer> P2) {
        Pila<Integer> aux1 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();
        boolean esIgual = true;
        while (!P1.esVacia() && !P2.esVacia()) {
            int item1 = P1.desapilar();
            int item2 = P2.desapilar();
            if (item1 != item2){
                esIgual = false;
            }
            aux1.apilar(item1);
            aux2.apilar(item2);
        }
        
        if (P1.esVacia() ^ P2.esVacia()){
            esIgual = false;
        }
        while (!P1.esVacia()) {
            aux1.apilar(P1.desapilar());
        }
        while (!P2.esVacia()) {
            aux2.apilar(P2.desapilar());
        }
        
        while (!aux1.esVacia()) {
            P1.apilar(aux1.desapilar());
        }
        while (!aux2.esVacia()) {
            P2.apilar(aux2.desapilar());
        }
        
        return esIgual;
    }
    
    public static Pila<Integer> copiarPila9(Pila<Integer> P){
        Pila<Integer> aux = new Pila<>();
        Pila<Integer> copy = new Pila<>();
        while (!P.esVacia()) {
            int item = P.desapilar();
            aux.apilar(item);
        }
        while (!aux.esVacia()) {
            Integer item = aux.desapilar();
            copy.apilar(item);
            P.apilar(item);
        }
        return copy;
    }
    
    public static void eliminarMinimo10(Pila<Integer> P){
        if(P.esVacia()){
            System.out.println("Lista vacia");
        }
        int minimo = P.desapilar();
        Pila<Integer> temp = new Pila<>();
        temp.apilar(minimo);
        
        while(!P.esVacia()){
            int numero = P.desapilar();
            if(numero<minimo){
                temp.apilar(minimo);
                minimo = numero;
            }else{
                temp.apilar(numero);
            }
        }
        
        while(!temp.esVacia()){
            int numero = temp.desapilar();
            if(numero!=minimo){
                P.apilar(numero);
            }
        }
    }
    
    public static Pila<Integer> ordenarPilas11(Pila<Integer> pila1,Pila<Integer> pila2){
        Pila<Integer> copia1= new Pila<>();
        Pila<Integer> aux1 = new Pila<>();
        while (!pila1.esVacia()) {
            int elemento = pila1.desapilar();
            aux1.apilar(elemento);
        }
        while (!aux1.esVacia()) {
            int elemento = aux1.desapilar();
            pila1.apilar(elemento);       
            copia1.apilar(elemento);  
        }

        Pila<Integer> copia2 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();
        while (!pila2.esVacia()) {
            int elemento = pila2.desapilar();
            aux2.apilar(elemento);
        }
        while (!aux2.esVacia()) {
            int elemento = aux2.desapilar();
            pila2.apilar(elemento);       
            copia2.apilar(elemento);  
        }

        Pila<Integer> pila3Inversa = new Pila<>();

        while (!copia1.esVacia() || !copia2.esVacia()) {
            if (copia1.esVacia()) {
                pila3Inversa.apilar(copia2.desapilar());
            } else if (copia2.esVacia()) {
                pila3Inversa.apilar(copia1.desapilar());
            } else {
                int cima1 = copia1.desapilar();
                int cima2 = copia2.desapilar();

                if (cima1 >= cima2) {
                    pila3Inversa.apilar(cima1);
                    copia2.apilar(cima2); 
                } else {
                    pila3Inversa.apilar(cima2);
                    copia1.apilar(cima1); 
                }
            }
        }
    
        Pila<Integer> pila3 = new Pila<>();
        while (!pila3Inversa.esVacia()) {
            pila3.apilar(pila3Inversa.desapilar());
        }

        return pila3;
    }
    
    public static boolean esPalindromo12(Pila<Character> cadena){
        Pila<Character> copia = new Pila<>();
        Pila<Character> aux = new Pila<>();
        boolean esPalindromo = true;

        while (!cadena.esVacia()) {
            Character a = cadena.desapilar();
            copia.apilar(a); 
            aux.apilar(a);     
        }
        while (!copia.esVacia()) {
            cadena.apilar(copia.desapilar());
        }

        Pila<Character> copiaOriginal = new Pila<>();
        while (!cadena.esVacia()) {
            Character original = cadena.desapilar();
            Character invertido = aux.desapilar();
            if (!original.equals(invertido)) {
                esPalindromo = false;
            }
            copiaOriginal.apilar(original); 
        }

        while (!copiaOriginal.esVacia()) {
            cadena.apilar(copiaOriginal.desapilar());
        }
        return esPalindromo;
    }
}
