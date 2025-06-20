/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

/**
 *
 * @author Juan Gustavo Loyola
 */
///Es la CMovimiento
public class Tramite {
    ///El final es como un read-only, ahorra mas energia
    private final int id;
    private final int prioridad;
    private final Persona interesado;
    private final String asunto;
    //Documento de referencia
    
    private final Fecha inicioTramite;
    private final Fecha finTramite;
    //Documentos, producto del trámite documentario

    public Tramite() {
        this.id = 0;
        this.prioridad = 0;
        this.interesado = null;
        this.asunto = "";
        
        this.inicioTramite = null;
        this.finTramite = null;
    }
    
    
}
