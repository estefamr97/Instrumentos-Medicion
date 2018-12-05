/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.controller;

import instrumentos.logica.Model;
import instrumentos.presentacion.Application;
import instrumentos.presentacion.model.TipoInstrumentoModel;
import instrumentos.presentacion.model.TipoInstrumentosModel;
import instrumentos.presentacion.view.TipoInstrumentoView;
import instrumentosEntidades.TipoInstrumento;
import java.util.List;

/**
 *
 * @author estef
 */
public class TipoInstrumentoController {
    Model domainModel;
    TipoInstrumentoModel model;
    TipoInstrumentoView view;

    public TipoInstrumentoController(Model domainModel, TipoInstrumentoModel model, TipoInstrumentoView view) {
        model.init();
        this.domainModel = domainModel;
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
    
    public void guardar(){
        TipoInstrumentosModel tiposModel = Application.TIPOIS_VIEW.getModel();

        TipoInstrumento nuevo = new TipoInstrumento();
        model.clearErrors();
        
        nuevo.setCodigo(view.codFld.getText());
        if (view.codFld.getText().length()==0){
            model.getErrores().put("cod", "Codigo requerido");
        }
        
        nuevo.setNombre(view.nomFld.getText());
        if (view.nomFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
         nuevo.setUnidad(view.uniFld.getText());
        if (view.uniFld.getText().length()==0){
            model.getErrores().put("unidad", "Unidad requerida");
        }

        List<TipoInstrumento> tipo;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.ADD:
                        domainModel.tipoInstrumentoAgregar(nuevo);
                        model.setMensaje("TIPO INSTRUMENTO AGREGADO");
                        model.setCurrent(new TipoInstrumento());
                        
                        tiposModel.clearErrors();
                        tipo = domainModel.tipoInstrumentoSearch(tiposModel.getFilter());
                        tiposModel.setInstrumentos(tipo);                      
                        break;
                    case Application.EDIT:
                        domainModel.tipoInstrumentoActualizar(nuevo);
                        model.setMensaje("TIPO INSTRUMENTO MODIFICADO");
                        model.setCurrent(nuevo);

                        tipo = domainModel.tipoInstrumentoSearch(tiposModel.getFilter());
                      tiposModel.setInstrumentos(tipo); 
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("cod", "Tipo Instrumento ya existe");
                model.setMensaje("TIPO INSTRUMENTO YA EXISTENTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    } 
}
