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
public class ADMDependencias {
    private final Lista<Dependencia> ListaDependencias;

    public ADMDependencias() {
        ListaDependencias = new Lista<>();
    }

    public Lista getListaDependencias() {
        return ListaDependencias;
    }
    
    // Agrega una nueva dependencia si no existe una con el mismo nombre
    public boolean crearDependencia(Dependencia dependencia) {
        if (buscarDependencia(dependencia.getNombre()) == null) {
            ListaDependencias.agregar(dependencia);
            return true;
        }
        return false;
    }
    
    public Dependencia buscarDependencia(String nombre) {
        for (int i = 1; i <= ListaDependencias.longitud(); i++) {
            Dependencia dep = ListaDependencias.iesimo(i);
            if (dep.getNombre().equalsIgnoreCase(nombre)) {
                return dep; // Se encontró la dependencia
            }
        }
        return null; // No se encontró
    }
    
    public void eliminarDependencia(String nombre) {
        // Buscamos la posición de la dependencia
        for (int i = 1; i <= ListaDependencias.longitud(); i++) {
            Dependencia dep = ListaDependencias.iesimo(i);
            if (dep.getNombre().equalsIgnoreCase(nombre)) {
                ListaDependencias.eliminar(i); 
                System.out.println("Dependencia eliminada: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró la dependencia con nombre: " + nombre);
    }

    public String nombrarDependencias(){
        String temp = "";
        for (int i = 1; i <= ListaDependencias.longitud(); i++) {
            Dependencia dep = ListaDependencias.iesimo(i);
            temp += dep.getNombre() + " - " + dep.getEncargado() + "\n";
        }
        return temp;
    }
}
