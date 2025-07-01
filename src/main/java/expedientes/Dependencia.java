/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
import tda.Cola;
/**
 *
 * @author maldo
 */
public class Dependencia {
    //Oficina
    private String nombre;
    //Dueño de la oficina
    private String encargado;
    //Cada 
    private Cola<Tramite> colaTramites;
    
    //Referencia para el ultimo en la cola
    private Tramite ulitmoTramite;

    public Dependencia() {
        this.colaTramites = new Cola<>();
    }

    public Dependencia(String nombre, String encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.colaTramites = new Cola<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Cola<Tramite> getColaTramites() {
        return colaTramites;
    }

    //No sera necesario
    public void setColaTramites(Cola<Tramite> colaTramites) {
        this.colaTramites = colaTramites;
    }

    public Tramite getUlitmoTramite() {
        return ulitmoTramite;
    }

    public void setUlitmoTramite(Tramite ulitmoTramite) {
        this.ulitmoTramite = ulitmoTramite;
    }
     
    //Agregar un expediente a la cola
    public void agregarExpediente(Tramite tramite){
        if(tramite.esPrioritario()){
            colocarAlFrente(tramite);
        }
        else{
            colaTramites.encolar(tramite);
            this.ulitmoTramite = tramite; //Se actualiza el ultimo tramite
        }
    }
    
    // Coloca el expediente al principio de la cola
    private void colocarAlFrente(Tramite tramite) {
        Cola<Tramite> Cola = new Cola<>();
        Cola.encolar(tramite); // Se coloca primero el expediente prioritario
        while (!colaTramites.esVacia()) {
            Cola.encolar(colaTramites.desencolar()); // Los demás
        }
        colaTramites = Cola; // Se reemplaza la cola original
    }

    // Devuelve el primer expediente (FIFO), o null si está vacía
    public Tramite entregarTramite() {
        if(!colaTramites.esVacia()){
            return colaTramites.desencolar();
        }
        return null;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return colaTramites.esVacia();
    }

    // Muestra todos los expedientes en la cola
    public void mostrarCola() {
        Cola<Tramite> aux = new Cola<>();
        System.out.println("Dependencia: " + nombre);
        System.out.print("Cola: ");
        while (!colaTramites.esVacia()) {
            Tramite tramite = colaTramites.desencolar();
            System.out.println(tramite.getId() + "\t");
            aux.encolar(tramite); //Preservamos el elemento;
        }
        //Restauramos la cola original
        while(!aux.esVacia()){
            colaTramites.encolar(aux.desencolar());
        }
        System.out.println("");
    }

    // Busca y elimina un expediente por ID
    public Tramite eliminarExpediente(String id) {
        Cola<Tramite> aux = new Cola<>();
        Tramite encontrado = null;
        
        while (!colaTramites.esVacia()) {
            Tramite tramite = colaTramites.desencolar();
            if (tramite.getId().equalsIgnoreCase(id)) {
                encontrado = tramite; // Si es el que buscamos, lo guardamos y no se reencola
            } else {
                aux.encolar(tramite); // Si no, lo volvemos a meter en la cola
            }
        }

        colaTramites = aux; // Restauramos la cola sin el expediente extraído
        return encontrado;
    }

    // Verifica si un expediente con un ID específico está en la cola
    public boolean buscarExpediente(String id) {
        Cola<Tramite> aux = new Cola<>();
        boolean encontrado = false;

        while (!colaTramites.esVacia()) {
            Tramite tramite = colaTramites.desencolar();
            if (tramite.getId().equalsIgnoreCase(id)) {
                encontrado = true;
            }
            aux.encolar(tramite); // Se mantiene la cola original intacta
        }

        colaTramites = aux;
        return encontrado;
    }

    // Finaliza el expediente con el ID dado (cambia su estado interno)
    public void finalizarExpediente(String id) {
        Cola<Tramite> aux = new Cola<>();

        while (!colaTramites.esVacia()) {
            Tramite tramite = colaTramites.desencolar();
            if (tramite.getId().equalsIgnoreCase(id)) {
                tramite.finExpediente(); // Llama al método para finalizar el expediente
            }
            aux.encolar(tramite); // Reconstruimos la cola
        }

        colaTramites = aux;
    }
}
