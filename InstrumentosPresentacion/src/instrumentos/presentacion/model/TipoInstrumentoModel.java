/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.TipoInstrumento;
import java.util.HashMap;
import java.util.Observable;

/**
 *
 * @author estef
 */
public class TipoInstrumentoModel extends Observable{
     TipoInstrumento current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public TipoInstrumentoModel() {
    }

    public void init(){
     setCurrent(new TipoInstrumento());
     clearErrors();
    }
    
    public TipoInstrumento getCurrent() {
        return current;
    }

    public void setCurrent(TipoInstrumento current) {
        this.current = current;
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
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
        
    }
     @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
