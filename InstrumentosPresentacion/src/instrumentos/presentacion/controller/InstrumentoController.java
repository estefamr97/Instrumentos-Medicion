/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.controller;

import instrumentos.logica.Model;
import instrumentos.presentacion.Application;
import instrumentos.presentacion.model.InstrumentoModel;
import instrumentos.presentacion.model.InstrumentosModel;
import instrumentos.presentacion.view.InstrumentoView;
import instrumentosEntidades.Calibracion;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.TipoInstrumento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estef
 */
public class InstrumentoController {
    Model domainModel;
    InstrumentoModel model;
    InstrumentoView view;

    public InstrumentoController(Model domainModel, InstrumentoModel model, InstrumentoView view) {
        model.init();
        this.domainModel = domainModel;
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {
        InstrumentosModel insModel = Application.INS_View.getModel();
        List<Calibracion> cali = new ArrayList<>();

        Instrumento nuevo = new Instrumento();
        model.clearErrors();
         nuevo.setSerie(view.serFld.getText());
        if (view.serFld.getText().length()==0){
            model.getErrores().put("serie", "Serie requeridoa");
        }
        nuevo.setDescripcion(view.descFld.getText());
        if (view.descFld.getText().length()==0){
            model.getErrores().put("descripcion", "Descripcion requerida");
        }
        
        int min = Integer.parseInt(view.minFld.getText());
        nuevo.setMinimo(min);
        if (view.minFld.getText().length()==0){
            model.getErrores().put("minimo", "Establezca un minimo");
        }
        int max = Integer.parseInt(view.maxFld.getText());
         nuevo.setMaximo(max);
        if (view.maxFld.getText().length()==0){
            model.getErrores().put("maximo", "Establezca un minimo");
        }
        int tol = Integer.parseInt(view.tolFld.getText());
         nuevo.setTolerancia(tol);
        if (view.tolFld.getText().length()==0){
            model.getErrores().put("tolerancia", "Establezca una tolerancia");
        }
        
        nuevo.setTipo((TipoInstrumento)view.comboTipos.getSelectedItem());
        
        nuevo.setCalibraciones(cali);
        
        
        List<Instrumento> inst;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.ADD:
                        domainModel.InstrumentoAgregar(nuevo);
                        model.setMensaje("INSTRUMENTO AGREGADO");
                        model.setCurrent(new Instrumento());
                        
                        insModel.clearErrors();
                        inst = domainModel.InstrumentoSearch(insModel.getFilter());
                        insModel.setInstrumentos(inst);                      
                        break;
                    case Application.EDIT:
                        domainModel.InstrumentoActualizar(nuevo);
                        model.setMensaje("INSTRUMENTO MODIFICADO");
                        model.setCurrent(nuevo);

                        inst = domainModel.InstrumentoSearch(insModel.getFilter());
                      insModel.setInstrumentos(inst); 
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("serie", "Instrumento ya existe");
                model.setMensaje("INSTRUMENTO YA EXISTENTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    }
}
