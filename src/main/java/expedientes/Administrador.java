/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;
// PROBANDO TOKEN

import javax.swing.JOptionPane;
import javax.swing.Timer;
import tda.Lista;
import tda.ListaCircularSimple;
import tda.ListaDoble;

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
    public static ListaDoble<Tramite> listaTramitesTotales = new ListaDoble<>();
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
    public static int BuscarTramiteDisponible(String id){
        int n = listaTramites.longitud();
        for (int i = 1; i <= n; i++) {
            Tramite tramite = listaTramites.iesimo(i);
            if (tramite.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public static int BuscarTramiteFinalizado(String id){
        int m = listaTramitesFinalizados.longitud();
        for (int i = 1; i <= m; i++) {
            Tramite tramiteF = listaTramitesFinalizados.iesimo(i);
            if (tramiteF.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public static int ExisteTramite(String id){
        int l = listaTramitesTotales.longitud();
        for (int i = 1; i <= l; i++) {
            Tramite tramite = listaTramitesTotales.iesimo(i);
            if (tramite.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
    //Para el Registro de Movimientos
    public static ADMDependencias admDep = new ADMDependencias();
    public static ADMMovimientos admMov = new ADMMovimientos(); 
    public static void FinalizarTramite(int posID){
        //Finalizar el tramite en Admin
        Tramite tramite = listaTramites.iesimo(posID);
        tramite.finalizarExpediente();
        listaTramites.eliminar(posID);
        listaTramitesFinalizados.agregar(tramite);
        admAlertas.EliminarTramite(tramite);
        //Finalizar el tramite en ADMDependencias
        Dependencia ultimoLugar = admDep.getDependenciaFinal(tramite);
        ultimoLugar.finalizarExpediente(tramite.getId());
    }
    
    //Alertas automaticas
    public static ADMAlertas admAlertas = new ADMAlertas();
    
    public static int TryCatchInt(String strVal){
        int value;
        try{
            value = Integer.parseInt(strVal);
        }
        catch (NumberFormatException e){
            value = -1;
        }
        return value;
    }
    public static void AdvertirError(String texto, String titulo){
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
