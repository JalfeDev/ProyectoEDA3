/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
// PROBANDO TOKEN

import javax.swing.JOptionPane;
import tda.Lista;

/**
 *
 * @author juan
 */
public class Administrador {
    //Para Inicio
    public static String userAdm = "admin";
    public static String passwordAdm = "1234";
    
    //Para el Registro de Tramites
    public static Lista<Interesado> listaInteresados = new Lista<>();
    public static Lista<Tramite> listaTramites = new Lista<>();
    public static Lista<Tramite> listaTramitesFinalizados = new Lista<>();
    public static int BuscarDNI(int dni){
        int n = listaInteresados.longitud();
        for (int i = 1; i <= n; i++) {
            Interesado persona = listaInteresados.iesimo(i);
            if (persona.getDni() == dni){
                return i;
            }
        }
        return -1;
    }
    public static int BuscarTramitePorID(String id){
        int n = listaTramites.longitud();
        for (int i = 1; i <= n; i++) {
            Tramite tramite = listaTramites.iesimo(i);
            if (tramite.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
    //Para el Registro de Movimientos
    public static ADMDependencias admDep = new ADMDependencias();
    public static ADMMovimientos admMov = new ADMMovimientos();    
    
    
    public static void AdvertirError(String texto, String titulo){
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.ERROR_MESSAGE);
    }
    //Esto ira en la clase AdminOficinas
    //public static Lista<Dependencia> listaDependencias = new Lista<>();
    
    //a. Registrar ingreso del expediente.
    //b. Registrar el movimiento del expediente.
    //c. Registrar finalización del trámite del expediente. 
    //d. Puede proporcionar al interesado el seguimiento de su trámite.
}
