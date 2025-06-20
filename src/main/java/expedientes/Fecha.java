/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

/**
 *
 * @author Juan Gustavo Loyola
 */
public class Fecha {
    private int day;
    private int month;
    private int year;
    private int hora;
    private int minuto;

    public Fecha(int day, int month, int year, int hora, int minuto) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hora = hora;
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return String.format(this.day + "/" + this.month + "/" + this.year + "\t" + this.hora + ":" + this.minuto);
    }
}
