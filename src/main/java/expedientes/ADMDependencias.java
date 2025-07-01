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
    
    private Lista<Dependencia> ListaDependencias;

    public ADMDependencias() {
        ListaDependencias = new Lista<>();
    }

    public ADMDependencias(Lista ListaDependencias) {
        this.ListaDependencias = ListaDependencias;
    }

    public Lista getListaDependencias() {
        return ListaDependencias;
    }

    public void setListaDependencias(Lista ListaDependencias) {
        this.ListaDependencias = ListaDependencias;
    }
    
    // Agrega una nueva dependencia si no existe una con el mismo nombre
    public void crearDependencia(Dependencia dependencia) {
        if (buscarDependencia(dependencia.getNombre()) == null) {
            ListaDependencias.agregar(dependencia);
            System.out.println("Dependencia agregada: " + dependencia.getNombre());
        } else {
            System.out.println("Ya existe una dependencia con ese nombre.");
        }
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
    
    
    
    
    
    
    
    
}
