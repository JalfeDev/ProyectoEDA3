/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
import javax.swing.table.DefaultTableModel;
import tda.*;
/**
 *
 * @author maldo
 */
public class ADMMovimientos {
    //El tramite a cambiar
    private Tramite tramiteReg;
    //Esta variable sera para acortar el "tramiteReg.getHistorialMov()"
    private Pila<Movimiento> historialMov;
    
    
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
        Dependencia oficinaCentral = Administrador.admDep.getDependenciaInicial();
        Movimiento mov = new Movimiento(fechaCreacion, oficinaCentral, null);
        historialMov.apilar(mov);
    }
    
    public Movimiento getUltimoMovimiento(){
        Movimiento mov = historialMov.desapilar();
        historialMov.apilar(mov);
        return mov;
    }
    
    public String getSeguimiento(){
        Pila<Movimiento> aux = new Pila<>();
        Movimiento primero = historialMov.desapilar();
        aux.apilar(primero);
        String res = primero.getLugar().getNombre();
        while(!historialMov.esVacia()){
            Movimiento mov = historialMov.desapilar();
            aux.apilar(mov);
            res += " -> " + mov.getLugar().getNombre();
        }
        while(!aux.esVacia()){
            historialMov.apilar(aux.desapilar());
        }
        return res;
    }
    
    public void CrearTablaDeMovimientos(DefaultTableModel model){
        Pila<Movimiento> aux = new Pila<>();
        Pila<Movimiento> inv = new Pila<>();
        while(!historialMov.esVacia()){
            Movimiento mov = historialMov.desapilar();
            aux.apilar(mov);
            inv.apilar(mov);
        }
        while(!inv.esVacia()){
            Movimiento mov = inv.desapilar();
            String fechaIn = mov.getFechaEntrada().toString();
            String fechaOut;
            if (mov.getFechaSalida() == null) fechaOut = "Pendiente";
            else fechaOut = mov.getFechaSalida().toString();
            String lugar = mov.getLugar().getNombre();
            String encargado = mov.getLugar().getEncargado();
            model.addRow(new Object[]{fechaIn,fechaOut,lugar,encargado});
        }
        while(!aux.esVacia()){
            historialMov.apilar(aux.desapilar());
        }
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
    
        
        
    

