/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.TipoInstrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author estef
 */
public class TipoInstrumentosModel extends Observable{
    TipoInstrumento filter;
    TipoInstrumentosTableModel instrumentos;
    HashMap<String,String> errores;
    String mensaje;

    public TipoInstrumentosModel() {
    }

    public TipoInstrumento getFilter() {
        return filter;
    }

    public void setFilter(TipoInstrumento filter) {
        this.filter = filter;
    }

    public TipoInstrumentosTableModel getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<TipoInstrumento> inst) {
        int []cols={TipoInstrumentosTableModel.CODIGO,TipoInstrumentosTableModel.NOMBRE,TipoInstrumentosTableModel.UNIDAD};
        instrumentos= new TipoInstrumentosTableModel(inst,cols);  
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
      public void init(){ 
        filter = new TipoInstrumento();
        List<TipoInstrumento> rows = new ArrayList<>();
        this.setInstrumentos(rows);
        clearErrors();
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
