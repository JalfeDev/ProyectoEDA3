/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

/**
 *
 * @author Juan Gustavo Loyola
 */
public class Movimiento {
    private Fecha fechaEntrada;
    private Dependencia lugar;
    private Fecha fechaSalida;

    public Movimiento(Fecha fechaEntrada, Dependencia lugar, Fecha fechaSalida) {
        this.fechaEntrada = fechaEntrada;
        this.lugar = lugar;
        this.fechaSalida = fechaSalida;
    }

    public Fecha getFechaEntrada() {
        return fechaEntrada;
    }

    public Dependencia getLugar() {
        return lugar;
    }

    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Fecha fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
