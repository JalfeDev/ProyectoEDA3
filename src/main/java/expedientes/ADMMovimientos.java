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
    private Pila<Movimiento> historialMovimientos;
    
    public ADMMovimientos() {
        historialMovimientos = new Pila<>();
    }

    public ADMMovimientos(String idTramite) {
        this.idTramite = idTramite;
        historialMovimientos = new Pila<>();
    }
    
    public String getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(String idTramite) {
        this.idTramite = idTramite;
    }

    public Pila<Movimiento> getHistorialDependencias() {
        return historialMovimientos;
    }
     
    public void agregarMovimiento(Movimiento move){
        historialMovimientos.apilar(move);
    }
    
    //No usaremos print, pero podemos usarlo luego
    public void mostrarHistorial(){
        System.out.println("Historial del tramite " +idTramite + ":");
        Pila<Movimiento> aux = new Pila<>();
        // Copiamos y mostramos los elementos
        while (!historialMovimientos.esVacia()) {
            Movimiento mov = historialMovimientos.desapilar();
            System.out.print(mov.getLugar() + " <- ");
            aux.apilar(mov);
        }
        System.out.println("INICIO");

        // Restauramos la pila original
        while (!aux.esVacia()) {
            historialMovimientos.apilar(aux.desapilar());
        }
    }

}
    
        
        
    

