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
public class ADMMovimientos {
    private String idTramite;
    private Pila<String> HistorialDependencias;
    
    public ADMMovimientos() {
        HistorialDependencias = new Pila<>();
    }

    public ADMMovimientos(String idTramite) {
        this.idTramite = idTramite;
        HistorialDependencias = new Pila<>();
    }
    
    public String getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(String idTramite) {
        this.idTramite = idTramite;
    }

    public Pila<String> getHistorialDependencias() {
        return HistorialDependencias;
    }

    public void setHistorialDependencias(Pila<String> HistorialDependencias) {
        this.HistorialDependencias = HistorialDependencias;
    }

     
    public void agregarMovimiento(String nombreDependencia){
        HistorialDependencias.apilar(nombreDependencia);
    }
    
    public void mostrarHistorial(){
        System.out.println("Historial del tramite " +idTramite + ":");
        Pila<String> aux = new Pila<>();
        // Copiamos y mostramos los elementos
        while (!HistorialDependencias.esVacia()) {
            String dep = HistorialDependencias.desapilar();
            System.out.print(dep + " <- ");
            aux.apilar(dep);
        }
        System.out.println("INICIO");

        // Restauramos la pila original
        while (!aux.esVacia()) {
            HistorialDependencias.apilar(aux.desapilar());
        }
    }

}
    
        
        
    

