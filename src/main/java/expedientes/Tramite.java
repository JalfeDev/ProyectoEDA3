/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

import tda.Pila;

/**
 *
 * @author Juan Gustavo Loyola
 */
///Es la CMovimiento
public class Tramite {
    ///El final es como un read-only, ahorra mas energia
    private final String id;
    private final boolean prioritario;
    private final Interesado interesado;
    private final String asunto;
    private final Documento documento;
    private boolean finalizado;
    //Documento de referencia
    
    private final Fecha inicioTramite;
    private final Fecha finTramite;
    
    private final Pila<Movimiento> historialMovimientos;

    public Tramite(String id, boolean prioritario, Interesado interesado, String asunto, Documento documento, Fecha inicioTramite, Fecha finTramite) {
        this.id = id;
        this.prioritario = prioritario;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documento = documento;
        this.finalizado = false;
        this.inicioTramite = inicioTramite;
        this.finTramite = finTramite;
        this.historialMovimientos = new Pila<>();
    }

    public String getId() {
        return id;
    }
    public boolean esPrioritario(){
        return prioritario;
    }
    public Interesado getInteresado() {
        return interesado;
    }
    public String getAsunto() {
        return asunto;
    }
    public Documento getDocumento() {
        return documento;
    }
    public boolean esFinalizado() {
        return finalizado;
    }

    public Fecha getInicioTramite() {
        return inicioTramite;
    }
    public Fecha getFinTramite() {
        return finTramite;
    }
    public Pila<Movimiento> getHistorialMov(){
        return historialMovimientos;
    }
    public void finalizarExpediente(){
        this.finalizado = true;
    }
}
