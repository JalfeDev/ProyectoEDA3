/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

/**
 *
 * @author Juan Gustavo Loyola
 */

///Los interesados(pueden ser instituciones o personas)
public class Interesado {
    private final String nombres;
    private final int dni;
    private final int telefono;
    private final String email;
    private final String trabajo; //ULima/Externo

    public Interesado(String nombres, int dni, int telefono, String email, String trabajo) {
        this.nombres = nombres;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.trabajo = trabajo;
    }

    public int getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getTrabajo() {
        return trabajo;
    }
    
    
}
