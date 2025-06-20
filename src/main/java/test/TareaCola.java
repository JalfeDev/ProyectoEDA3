package test;
import tda.Cola;
public class TareaCola {
    public static void mostrarCola(Cola<Integer> cola){
        if (cola.esVacia()){
            System.out.println("La cola esta vacia");
            return;
        }
        Cola<Integer> colaAux = new Cola<>(); // cola vacia
        while(!cola.esVacia()){
            int x = cola.desencolar();
            System.out.print(x+"\t");
            colaAux.encolar(x);
        }
        // devolver los elmentos de la colaAux a la cola original
        while (!colaAux.esVacia()){
            cola.encolar(colaAux.desencolar());            
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // Crear una cola vacia
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[]{5,2,6,9,12,6};
        Cola<Integer> cola1 = debug(arr1);
        Cola<Integer> cola2 = debug(arr2);
        
        /*mostrarCola(cola1);
        count1(cola1);
        insertarFrente3(cola1, 33);
        System.out.println(esPositivo2(cola1));
        mostrarCola(cola1);
        reemplazarItems4(cola1, 4, 6);
        mostrarCola(cola1);
        System.out.println(sonIguales5(cola1, cola2));
        cola2 = copia6(cola1);
        System.out.println(sonIguales5(cola1, cola2));*/
        
        /*mostrarCola(cola1);
        mostrarCola(cola2);
        Cola<Integer> cola3 = mergeSort7(cola1, cola2);
        mostrarCola(cola3);
        eliminarFinal8(cola3);
        eliminarFinal8(cola3);
        mostrarCola(cola3);*/
        
        /*mostrarCola(cola1);
        mostrarCola(cola2);
        //concatenar9(cola1, cola2);
        barajar9(cola1,cola2);
        mostrarCola(cola1);
        mostrarCola(cola2);*/
        
        /*eliminarPos10(cola1, 0);
        mostrarCola(cola1);
        eliminarPos10(cola1, 4);
        mostrarCola(cola1);
        eliminarPos10(cola1, 1);
        mostrarCola(cola1);*/
        
        /*Cola<Integer> cola3 = colaInterseccion11(cola1, cola2);
        mostrarCola(cola3);
        cola3 = debug(new int[]{18,22,60,66,32,15,59,61,30,90});
        mostrarCola(cola3);
        banco12(cola3);
        mostrarCola(cola3);*/
    }
    
    public static Cola<Integer> debug(int[] nums){
        Cola<Integer> cola = new Cola<>();
        for(int i=0; i < nums.length; i++){
            cola.encolar(nums[i]);
        }
        return cola;
    }
   
    public static void count1(Cola<Integer> cola){
        Cola<Integer> aux = new Cola<>();
        int count = 0;
        while (!cola.esVacia()) {
            aux.encolar(cola.desencolar());
            count++;
        }
        while (!aux.esVacia()) {
            cola.encolar(aux.desencolar());
        }
        System.out.println("Hay " + count + " elementos");
    }

    public static boolean esPositivo2(Cola<Integer> cola){
        Cola<Integer> aux = new Cola<>();
        boolean hayNega = false;
        while(!cola.esVacia()){
            Integer val = cola.desencolar();
            aux.encolar(val);
            
            if (val < 0) hayNega = true;
        }
        //NO ES ESTO POSIBLE?, O NO ES POSIBLE PORQUE SON PARAMETROS
        //cola = aux;
        while(!aux.esVacia()){
            Integer val = aux.desencolar();
            cola.encolar(val);
        }
        return (!hayNega);
    }
            
    public static void insertarFrente3(Cola<Integer> cola, Integer item){
        Cola<Integer> aux = new Cola<>();
        aux.encolar(item);
        while(!cola.esVacia()){
            Integer val = cola.desencolar();
            aux.encolar(val);
        }
        while(!aux.esVacia()){
            Integer val = aux.desencolar();
            cola.encolar(val);
        }
    }
    
    public static void reemplazarItems4(Cola<Integer> cola, Integer viejo, Integer nuevo){
        Cola<Integer> aux = new Cola<>();
        while(!cola.esVacia()){
            Integer val = cola.desencolar();
            //if (val.equals(viejo)) val = nuevo;
            if ((int)val == (int)viejo) val = nuevo;
            aux.encolar(val);
        }
        while(!aux.esVacia()){
            Integer val = aux.desencolar();
            cola.encolar(val);
        }
    }
    
    public static boolean sonIguales5(Cola<Integer> C1, Cola<Integer> C2){
        Cola<Integer> aux1 = new Cola<>();
        Cola<Integer> aux2 = new Cola<>();
        boolean sonIguales = true;
        
        //Agregarlos a colas auxiliares
        while(!C1.esVacia() && !C2.esVacia()){
            Integer val1 = C1.desencolar();
            Integer val2 = C2.desencolar();
            aux1.encolar(val1);
            aux2.encolar(val2);
            //Chequear is los elementos son iguales
            if ((int)val1 != (int)val2) sonIguales = false;
        }
        
        //Si la cola tiene un tamaño distinto, son distintas
        if (!C1.esVacia() || !C2.esVacia()) sonIguales = false;
        
        //Esto es para desencolar la C1 y C2
        //Luego devolvemos los items de las auxiliares a las colas
        while(!C1.esVacia()){
            Integer val = C1.desencolar();
            aux1.encolar(val);
        }
        while(!C2.esVacia()){
            Integer val = C2.desencolar();
            aux2.encolar(val);
        }
        
        while(!aux1.esVacia()){
            Integer val = aux1.desencolar();
            C1.encolar(val);
        }
        while(!aux2.esVacia()){
            Integer val = aux2.desencolar();
            C2.encolar(val);
        }
        
        return sonIguales;
    }
    
    public static Cola<Integer> copia6(Cola<Integer> cola){
        Cola<Integer> aux = new Cola<>();
        Cola<Integer> copia = new Cola<>();
        while(!cola.esVacia()){
            Integer val = cola.desencolar();
            aux.encolar(val);
            copia.encolar(val);
        }
        while(!aux.esVacia()){
            Integer val = aux.desencolar();
            cola.encolar(val);
        }
        return copia;
    }
    
    public static Cola<Integer> mergeSort7(Cola<Integer> C1, Cola<Integer> C2){
        Cola<Integer> C3 = new Cola<>();
        int indResto = -1; //El resto es el frente, si lo piensas bien
        int rest = -1;
        
        Integer val1;
        Integer val2;
        while(!C1.esVacia() && !C2.esVacia()){
            if (indResto == -1){
                val1 = C1.desencolar();
                val2 = C2.desencolar();
                if (val1 < val2){
                    C3.encolar(val1);
                    indResto = 2;
                    rest = val2;
                }
                else {
                    C3.encolar(val2);
                    indResto = 1;
                    rest = val1;
                }
            }
            //Si sacamos el frente de C2 y lo guardamos en el resto
            else if (indResto == 2){
                val1 = C1.desencolar(); //Para que sacarias C2, si el frente lo tienes en el resto
                if (val1 < rest){
                    C3.encolar(val1);
                }
                else{
                    C3.encolar(rest);
                    rest = val1;
                    indResto = 1;
                }
            }
            //Si sacamos el frente de C1 y lo guardamos en el resto
            else if (indResto == 1){
                val2 = C2.desencolar(); //Para que sacarias C1, si el frente lo tienes en el resto
                if (val2 < rest){
                    C3.encolar(val2);
                }
                else{
                    C3.encolar(rest);
                    rest = val2;
                    indResto = 2;
                }
            }
            
        }
        //Se encola el resto
        C3.encolar(rest);
        //Se encola el resto de la cola, si son de diferente longitud
        while(!C1.esVacia()){
            C3.encolar(C1.desencolar());
        }
        while(!C2.esVacia()){
            C3.encolar(C2.desencolar());
        }
        return C3;
    }
    
    public static void eliminarFinal8(Cola<Integer> cola){
        Cola<Integer> aux = new Cola<>();
        int count = 0;
        while (!cola.esVacia()) {
            int item = cola.desencolar();
            aux.encolar(item);
            count++;
        }
        while (count > 1) {
            cola.encolar(aux.desencolar());
            count--;
        }
    }
    
    public static void concatenar9(Cola<Integer> C1, Cola<Integer> C2){
        while (!C2.esVacia()) {
            C1.encolar(C2.desencolar());
        }
    }
    
    public static void barajar9(Cola<Integer> C1, Cola<Integer> C2){
        Cola<Integer> aux1 = new Cola<>();
        Cola<Integer> aux2 = new Cola<>();
        while (!C1.esVacia()) {
            aux1.encolar(C1.desencolar());
        }
        while (!C2.esVacia()) {
            aux2.encolar(C2.desencolar());
        }
        boolean par = false;
        while(!aux1.esVacia() || !aux2.esVacia()){
            int val;
            if (!par && !aux1.esVacia()) val = aux1.desencolar();
            else if (par && !aux2.esVacia()) val = aux2.desencolar();
            else val = 0;
            C1.encolar(val);
            par = !par;
        }
    }
    
    public static void eliminarPos10(Cola<Integer> cola, int pos){
        if (pos < 1){
            System.out.println("No hay un indice menor a 1");
            return;
        }
        Cola<Integer> aux = new Cola<>();
        int count = 1;
        while (!cola.esVacia()) {
            int item = cola.desencolar();
            aux.encolar(item);
        }
        while (!aux.esVacia()) {
            Integer val = aux.desencolar();
            if (count != pos){
                cola.encolar(val);
                //////////System.out.print("_" + val + "_");
            }
            count++;
        }
    }
    
    public static Cola<Integer> colaInterseccion11(Cola<Integer> C1, Cola<Integer> C2){
        Cola<Integer> aux1 = new Cola<>();
        Cola<Integer> aux2 = new Cola<>();
        Cola<Integer> C3 = new Cola<>();
        while(!C1.esVacia() && !C2.esVacia()){
            Integer val1 = C1.desencolar();
            Integer val2 = C2.desencolar();
            aux1.encolar(val1);
            aux2.encolar(val2);
            if ((int)val1 == (int)val2){
                C3.encolar(val1);
            }
        }
        
        while(!C1.esVacia()){
            Integer val = C1.desencolar();
            aux1.encolar(val);
        }
        while(!C2.esVacia()){
            Integer val = C2.desencolar();
            aux2.encolar(val);
        }

        while(!aux1.esVacia()){
            Integer val = aux1.desencolar();
            C1.encolar(val);
        }
        while(!aux2.esVacia()){
            Integer val = aux2.desencolar();
            C2.encolar(val);
        }
        
        return C3;
    }

    public static void banco12(Cola<Integer> cola){
        Cola<Integer> comun = new Cola<>();
        Cola<Integer> pref = new Cola<>();
        while(!cola.esVacia()){
            Integer val = cola.desencolar();
            if ((int)val >= 60) pref.encolar(val);
            else comun.encolar(val);
        }
        while(!pref.esVacia()){
            Integer val = pref.desencolar();
            cola.encolar(val);
        }
        while(!comun.esVacia()){
            Integer val = comun.desencolar();
            cola.encolar(val);
        }
    }

}