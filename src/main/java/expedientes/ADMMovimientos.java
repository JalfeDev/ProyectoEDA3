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
    //El tramite a cambiar
    Tramite tramiteReg;
    //Esta variable sera para acortar el "tramiteReg.getHistorialMov()"
    Pila<Movimiento> historialMov;
    
    
    public ADMMovimientos() {
        this.tramiteReg = null;
        this.historialMov = null;
    }

    public void setTramiteReg(Tramite tramiteARegistrar) {
        this.tramiteReg = tramiteARegistrar;
        this.historialMov = this.tramiteReg.getHistorialMov();
    }
     
    public void agregarMovimiento(Movimiento move){
        if (tramiteReg == null){
            System.out.println("Error ADMMovimientos: tramiteReg es null!");
            return;
        }
        historialMov.apilar(move);
    }
    
    public void agregarMovimientoInicial(Fecha fechaCreacion){
        if (tramiteReg == null){
            System.out.println("Error ADMMovimientos: tramiteReg es null!");
            return;
        }
        Dependencia oficinaCentral = Administrador.admDep.getListaDependencias().iesimo(1);
        Movimiento mov = new Movimiento(fechaCreacion, oficinaCentral, fechaCreacion);
        historialMov.apilar(mov);
    }
    
    
    
    //No usaremos print, pero podemos usarlo luego
    public void mostrarHistorial(){
        System.out.println("Historial del tramite " +tramiteReg.getId() + ":");
        Pila<Movimiento> aux = new Pila<>();
        // Copiamos y mostramos los elementos
        while (!historialMov.esVacia()) {
            Movimiento mov = historialMov.desapilar();
            System.out.print(mov.getLugar() + " <- ");
            aux.apilar(mov);
        }
        System.out.println("INICIO");

        // Restauramos la pila original
        while (!aux.esVacia()) {
            historialMov.apilar(aux.desapilar());
        }
    }
}
    
        
        
    

