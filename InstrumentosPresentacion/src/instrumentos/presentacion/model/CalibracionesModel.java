/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.Calibracion;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.Medida;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author estef
 */
public class CalibracionesModel extends Observable{
    Instrumento current;
    Calibracion filter;
    CalibracionesTableModel calibraciones;
    MedicionesTableModel medidas;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public CalibracionesModel() {
    }

    public void init(){
        current = new Instrumento();
        filter= new Calibracion();
        List<Calibracion> rows = new ArrayList<>();
        List<Medida> fila = new ArrayList<>();
        this.setCalibraciones(rows);
        this.setMedidas(fila);
        clearErrors();
    } 
    public Instrumento getCurrent() {
        return current;
    }

    public void setCurrent(Instrumento current) {
        this.current = current;
        setChanged();
        notifyObservers();
    }

    public Calibracion getFilter() {
        return filter;
    }

    public void setFilter(Calibracion filter) {
        this.filter = filter;
        setChanged();
       notifyObservers();
    }

    public CalibracionesTableModel getCalibraciones() {
        return calibraciones;
    }

    public void setCalibraciones(List<Calibracion> calibraciones) {
       int [] cols ={CalibracionesTableModel.FECHA, CalibracionesTableModel.MEDICION};
       this.calibraciones= new CalibracionesTableModel(calibraciones,cols);
       setChanged();
       notifyObservers();
    }

    public MedicionesTableModel getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
       int [] cols ={MedicionesTableModel.MEDIDA,MedicionesTableModel.REFERENCIA, MedicionesTableModel.LECTURA};
       this.medidas = new MedicionesTableModel(medidas,cols);
       setChanged();
       notifyObservers();
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public void clearErrors() {
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
    
        @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}
