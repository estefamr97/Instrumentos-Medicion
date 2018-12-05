/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.Instrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author estef
 */
public class InstrumentosModel extends Observable{
     Instrumento filter;
    InstrumentosTableModel instrumentos;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public InstrumentosModel() {
    }
    public void init(){
        filter= new Instrumento();
        List<Instrumento> rows = new ArrayList<>();
        this.setInstrumentos(rows);
        clearErrors();
    } 
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    public Instrumento getFilter() {
        return filter;
    }

    public void setFilter(Instrumento filter) {
        this.filter = filter;
    }

    public InstrumentosTableModel getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
       int [] cols ={InstrumentosTableModel.SERIE,InstrumentosTableModel.DESCRIPCION,InstrumentosTableModel.MIN,InstrumentosTableModel.MAX,InstrumentosTableModel.TOL};
       this.instrumentos = new InstrumentosTableModel(instrumentos,cols);
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
    
      @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
     public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
}
