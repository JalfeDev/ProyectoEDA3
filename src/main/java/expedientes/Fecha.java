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
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hora = 0;
        this.minuto = 0;
    }
    
    public Fecha(int day, int month, int year, int hora, int minuto) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hora = hora;
        this.minuto = minuto;
    }

    public static Fecha GetFechaActual(int minuteVariation){
        LocalDateTime now = LocalDateTime.now();
        now = now.minusMinutes(-minuteVariation);
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();
        int hora = now.getHour();
        int minuto = now.getMinute();
        Fecha fecha = new Fecha(day, month, year, hora, minuto);
        return fecha;
    }
    
    private String enDosDigitos(int valor){
        String value = "" + valor;
        if (valor < 10){
            value = "0" + value;
        }
        return value;
    }
    
    @Override
    public String toString() {
        return enDosDigitos(day) + "/" + enDosDigitos(month) + "/" + this.year + " " + enDosDigitos(hora) + ":" + enDosDigitos(minuto);
    }
}
