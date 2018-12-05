/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentos.presentacion.Application;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.TipoInstrumento;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author estef
 */
public class InstrumentoModel extends Observable{
     Instrumento current;
    HashMap<String,String> errores;
    ComboBoxModel<TipoInstrumento> tipos;
    String mensaje;
    int modo;

    public InstrumentoModel() {
    }

    public void init(){
     setTiposInstrumento(Application.Model_TI.tipoInstrumentoSearch(new TipoInstrumento("","","")));
     setCurrent(new Instrumento());
     clearErrors();
    }
    
    public void setTiposInstrumento(List<TipoInstrumento> tipos){
        this.tipos = new DefaultComboBoxModel(tipos.toArray());
        setChanged();
        notifyObservers();  
    }
    
    public ComboBoxModel<TipoInstrumento> getTipoInstrumento() {
        return tipos;
    }
    
    public Instrumento getCurrent() {
        return current;
    }

    public void setCurrent(Instrumento current) {
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
