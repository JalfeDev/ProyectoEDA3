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
    private final Lista<Dependencia> listaDependencias;

    public ADMDependencias() {
        listaDependencias = new Lista<>();
        listaDependencias.agregar(new Dependencia("Oficina Central","ULima"));
    }

    public Lista<Dependencia> getListaDependencias() {
        return listaDependencias;
    }
    
    // Agrega una nueva dependencia si no existe una con el mismo nombre
    public boolean crearDependencia(Dependencia dependencia) {
        if (buscarDependencia(dependencia.getNombre()) == null) {
            listaDependencias.agregar(dependencia);
            return true;
        }
        return false;
    }
    
    public Dependencia buscarDependencia(String nombre) {
        for (int i = 1; i <= listaDependencias.longitud(); i++) {
            Dependencia dep = listaDependencias.iesimo(i);
            if (dep.getNombre().equalsIgnoreCase(nombre)) {
                return dep; // Se encontró la dependencia
            }
        }
        return null;
    }
    
    public void eliminarDependencia(String nombre) {
        // Buscamos la posición de la dependencia
        for (int i = 1; i <= listaDependencias.longitud(); i++) {
            Dependencia dep = listaDependencias.iesimo(i);
            if (dep.getNombre().equalsIgnoreCase(nombre)) {
                listaDependencias.eliminar(i); 
                System.out.println("Dependencia eliminada: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró la dependencia con nombre: " + nombre);
    }

    public String nombrarDependencias(){
        String temp = "";
        for (int i = 1; i <= listaDependencias.longitud(); i++) {
            Dependencia dep = listaDependencias.iesimo(i);
            temp += dep.getNombre() + " - " + dep.getEncargado() + "\n";
        }
        return temp;
    }
}
