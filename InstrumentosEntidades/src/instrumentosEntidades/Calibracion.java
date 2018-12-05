/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentosEntidades;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author estef
 */
public class Calibracion {
    int numero;
    Instrumento instrumento;
    Date fecha;
    int mediciones;
    List<Medida> medidas;

    public Calibracion() {
    }

    public Calibracion(int numero, Instrumento instrumento, Date fecha, int mediciones, List<Medida> medidas) {
        this.numero = numero;
        this.instrumento = instrumento;
        this.fecha = fecha;
        this.mediciones = mediciones;
        this.medidas = medidas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMediciones() {
        return mediciones;
    }

    public void setMediciones(int mediciones) {
        this.mediciones = mediciones;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }
    public String getFechaMySQL() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        String mysql_date = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH)) + "-" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        return mysql_date;
    }
    
}
