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
    private final boolean prioritario;
    private final Persona interesado;
    private final String asunto;
    private final Documento documento;
    //Documento de referencia
    
    private final Fecha inicioTramite;
    private final Fecha finTramite;
    //Documentos, producto del trámite documentario

    public Tramite(int id, boolean prioritario, Persona interesado, String asunto, Documento documento, Fecha inicioTramite, Fecha finTramite) {
        this.id = id;
        this.prioritario = prioritario;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documento = documento;
        this.inicioTramite = inicioTramite;
        this.finTramite = finTramite;
    }
    
    
    
    
}
