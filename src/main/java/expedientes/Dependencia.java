/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
import tda.Cola;
import tda.Pila;
/**
 *
 * @author maldo
 */
public class Dependencia {
    //Oficina
    private final String nombre;
    //Dueño de la oficina
    private final String encargado;
    //Cada oficina tiene un monton de tramites
    private final Cola<Tramite> colaTramites;
    //Cada oficina tiene un monton de tramites finalizados
    private final Pila<Tramite> tramitesArchivados;
    //Referencia para el ultimo en la cola
    private Tramite ultimoTramite;

    public Dependencia(String nombre, String encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.colaTramites = new Cola<>();
        this.ultimoTramite = null;
        this.tramitesArchivados = new Pila<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public Tramite getUlitmoTramite() {
        return ultimoTramite;
    }

    public void agregarExpediente(Tramite tramite){
        if(tramite.esPrioritario()){
            agregarConPrioridad(tramite);
        }
        else{
            colaTramites.encolar(tramite);
            ultimoTramite = tramite;
        }

    }

    private void agregarConPrioridad(Tramite tramite){
        Cola<Tramite> aux = new Cola<>();
        Cola<Tramite> auxPriorit = new Cola<>();
        while(!colaTramites.esVacia()) {
            Tramite temp = colaTramites.desencolar();
            if (temp.esPrioritario()){
                auxPriorit.encolar(temp);
            }
            else{
                aux.encolar(temp);
            }
        }
        if(tramite.esPrioritario()){
            auxPriorit.encolar(tramite);
        }
        else{
            aux.encolar(tramite);
        }
        Tramite t = tramite;
        while(!auxPriorit.esVacia()){
            t = auxPriorit.desencolar();
            colaTramites.encolar(t);
        }
        while(!aux.esVacia()){
            t = aux.desencolar();
            colaTramites.encolar(t);
        }
        ultimoTramite = t;
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
        while(!aux.esVacia()){
            colaTramites.encolar(aux.desencolar());
        }
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
        while(!aux.esVacia()){
            colaTramites.encolar(aux.desencolar());
        }
        return encontrado;
    }

    // Finaliza el expediente con el ID dado (cambia su estado interno)
    public void finalizarExpediente(String id) {
        Cola<Tramite> aux = new Cola<>();
        while (!colaTramites.esVacia()) {
            Tramite tramite = colaTramites.desencolar();
            if (tramite.getId().equalsIgnoreCase(id)) {
                tramite.finalizarExpediente(); // Llama al método para finalizar el expediente
                tramitesArchivados.apilar(tramite);
            }
            else{
                aux.encolar(tramite); // Reconstruimos la cola
            }
        }
        while(!aux.esVacia()){
            colaTramites.encolar(aux.desencolar());
        }
    }
    
    @Override
    public String toString() {
        return nombre + " - " + encargado;
    }
}
