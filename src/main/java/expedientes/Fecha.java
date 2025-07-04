/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedientes;

/**
 *
 * @author Juan Gustavo Loyola
 */
import java.time.LocalDateTime;

public class Fecha {
    private int day;
    private int month;
    private int year;
    private int hora;
    private int minuto;

    public Fecha(){
        
    }
    
    public Fecha(int day, int month, int year, int hora, int minuto) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hora = hora;
        this.minuto = minuto;
    }

    public void GetFechaActual(){
        LocalDateTime now = LocalDateTime.now();
        this.day = now.getDayOfMonth();
        this.month = now.getMonthValue();
        this.year = now.getYear();
        this.hora = now.getHour();
        this.minuto = now.getMinute();
    }
    
    @Override
    public String toString() {
        return String.format(this.day + "/" + this.month + "/" + this.year + "\t" + this.hora + ":" + this.minuto);
    }
}
