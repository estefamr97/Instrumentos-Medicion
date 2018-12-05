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
import instrumentos.presentacion.view.TipoInstrumentosView;
import instrumentosEntidades.TipoInstrumento;
import java.util.List;

/**
 *
 * @author estef
 */
public class TipoInstrumentosController {
     Model domainModel;
     TipoInstrumentosModel model;
     TipoInstrumentosView view;

    public TipoInstrumentosController(Model domainModel, TipoInstrumentosModel model, TipoInstrumentosView view) {
        model.init();
        this.domainModel = domainModel;
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
    public void search(){
        model.getFilter().setNombre(view.nomFld.getText());
        model.clearErrors();
        List<TipoInstrumento> rows = domainModel.tipoInstrumentoSearch(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("nom", "No coincide ningun registro");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setInstrumentos(rows);
        
    }
   
    public void add(){
       TipoInstrumentoModel modelillo = Application.TIPOI_VIEW.getModel();
         modelillo.clearErrors();
         modelillo.setModo(Application.ADD);
         modelillo.setCurrent(new TipoInstrumento());
         Application.TIPOI_VIEW.setVisible(true);
         Application.TIPOI_VIEW.toFront();
    }
     public void edit(int row){
         TipoInstrumentoModel modelillo = Application.TIPOI_VIEW.getModel();
         modelillo.clearErrors();
         TipoInstrumento ti = model.getInstrumentos().getRowAt(row);
         modelillo.setModo(Application.EDIT);
         modelillo.setCurrent(ti);
         Application.TIPOI_VIEW.setVisible(true);
         Application.TIPOI_VIEW.toFront();
     }
     public void delete(int row){
      TipoInstrumento seleccionado = model.getInstrumentos().getRowAt(row);
        try {
            domainModel.tipoInstrumentoBorrar(seleccionado);
        } catch (Exception ex) { }
        this.search();}
}
