/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import tda.ListaCircularSimple;

/**
 *
 * @author Juan Gustavo Loyola
 */
public class ADMAlertas {
    private final ListaCircularSimple<Tramite> listaAlertas;
    private int numTramComun;
    private int numTramPrioridad;
    //El mas antiguo y/o que tenga prioridad
    private Tramite tramiteUrgente;
    
    public ADMAlertas() {
        listaAlertas = new ListaCircularSimple<>();
        numTramComun = 0;
        numTramPrioridad = 0;
        tramiteUrgente = null;
    }

    public void EmpezarTimer(){
        //Se repite hasta el infinito cada 30 segundos
        int segundos = 30;
        Timer timer = new Timer(segundos*1000, e -> {
            AlertarTramitesPendientes();
        });
        timer.start();
    }
    private void AlertarTramitesPendientes(){
        int total = numTramComun+numTramPrioridad;
        if (total > 0){
            String contenido = "Numero de tramites pendientes comunes: "+numTramComun + "\nNumero de tramites pendientes prioritarios: "+numTramPrioridad;
            if (numTramComun > 0 && numTramPrioridad > 0) contenido += "\nCantidad total de tramites pendientes: "+total;
            JOptionPane.showMessageDialog(null, "Tienes tramites pendientes\n"+contenido, "", JOptionPane.WARNING_MESSAGE);
            
            String esPrioritario;
            if (tramiteUrgente.esPrioritario()) esPrioritario = "Tiene prioridad";
            else esPrioritario = "No tiene prioridad";
            contenido = "ID: "+tramiteUrgente.getId() + "\n"+esPrioritario + "\nAsunto: "+tramiteUrgente.getAsunto() + "\nDNI del interesado: "+tramiteUrgente.getInteresado().getDni();
            JOptionPane.showMessageDialog(null, "Tramite pendiente mas antiguo\n"+contenido, "", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void AgregarTramite(Tramite tram){
        listaAlertas.agregar(tram);
        if (tram.esPrioritario()) {
            numTramPrioridad++;
            if (tramiteUrgente == null || !tramiteUrgente.esPrioritario()){
                tramiteUrgente = tram;
            }
        }
        else {
            numTramComun++;
            if (tramiteUrgente == null){
                tramiteUrgente = tram;
            }
        }
    }
    
    public void EliminarTramite(Tramite tram){
        if (tram.esPrioritario()) numTramPrioridad--;
        else numTramComun--;

        int posTramite = listaAlertas.ubicacion(tram);
        listaAlertas.eliminar(posTramite);
        
        if (tram.getId().equalsIgnoreCase(tramiteUrgente.getId())){
            tramiteUrgente = null;
            BuscarTramiteUrgente();
        }
    }
    
    private void BuscarTramiteUrgente(){
        if (listaAlertas.esVacia()) return;
        for (int i = 1; i <= listaAlertas.longitud(); i++) {
            Tramite tram = listaAlertas.iesimo(i);
            if (tram.esPrioritario()) {
                if (tramiteUrgente == null || !tramiteUrgente.esPrioritario()){
                    tramiteUrgente = tram;
                    return;
                }
            }
            else if (tramiteUrgente == null){
                tramiteUrgente = tram;
            }
        }
    }
}