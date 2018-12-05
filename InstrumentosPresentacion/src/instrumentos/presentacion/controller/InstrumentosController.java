/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.controller;

import instrumentos.logica.Model;
import instrumentos.presentacion.Application;
import instrumentos.presentacion.model.CalibracionesModel;
import instrumentos.presentacion.model.InstrumentoModel;
import instrumentos.presentacion.model.InstrumentosModel;
import instrumentos.presentacion.view.InstrumentosView;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.TipoInstrumento;
import java.util.List;

/**
 *
 * @author estef
 */
public class InstrumentosController {
     Model domainModel;
       InstrumentosModel model;
       InstrumentosView view;

    public InstrumentosController(Model domainModel,InstrumentosModel model, InstrumentosView view) {
        model.init();
        this.domainModel = domainModel;
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
       
        public void search(){
        model.getFilter().setDescripcion(view.descFld.getText());
        model.clearErrors();
        List<Instrumento> rows = domainModel.InstrumentoSearch(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("descripcion", "No coincide ningun registro");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setInstrumentos(rows);
        
    }
        public void add(){
       InstrumentoModel modelillo = Application.IN_View.getModel();
         modelillo.clearErrors();
         modelillo.setModo(Application.ADD);
         modelillo.setCurrent(new Instrumento());
         modelillo.setTiposInstrumento(Application.Model_TI.tipoInstrumentoSearch(new TipoInstrumento("","","")));
         Application.IN_View.setVisible(true);
         Application.IN_View.toFront();
    }
        public void addCali(int row){
        Instrumento ti = model.getInstrumentos().getRowAt(row);
        CalibracionesModel modelsillo = Application.CALI_VIEW.getModel();
        modelsillo.setCurrent(ti);
        Application.CONT.BuscarCalibraciones();
        Application.CALI_VIEW.setVisible(true);
        Application.CALI_VIEW.toFront();
        }
     public void edit(int row){
         InstrumentoModel modelillo = Application.IN_View.getModel();
         modelillo.clearErrors();
         Instrumento ti = model.getInstrumentos().getRowAt(row);
         modelillo.setModo(Application.EDIT);
         modelillo.setCurrent(ti);
         modelillo.setTiposInstrumento(Application.Model_TI.tipoInstrumentoSearch(new TipoInstrumento("","","")));
         Application.IN_View.setVisible(true);
         Application.IN_View.toFront();
     }
     public void delete(int row){
      Instrumento seleccionado = model.getInstrumentos().getRowAt(row);
        try {
            domainModel.InstrumentoBorrar(seleccionado);
        } catch (Exception ex) { }
        this.search();
}
}
