/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentosEntidades;

/**
 *
 * @author estef
 */
public class Medida {
     int numero;
    int referencia;
    int lectura;
    Calibracion calibracion;

    public Medida(int numero, int referencia, int lectura, Calibracion calibracion) {
        this.numero = numero;
        this.referencia = referencia;
        this.lectura = lectura;
        this.calibracion = calibracion;
    }

    public Medida() {
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public Calibracion getCalibracion() {
        return calibracion;
    }

    public void setCalibracion(Calibracion calibracion) {
        this.calibracion = calibracion;
    }
    
    
}
