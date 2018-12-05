/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.controller;

import instrumentos.logica.Model;
import instrumentos.presentacion.model.CalibracionesModel;
import instrumentos.presentacion.view.CalibracionesView;
import instrumentosEntidades.Calibracion;
import instrumentosEntidades.Medida;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author estef
 */
public class CalibracionesController {
    Model domainModel;
    CalibracionesModel model;
    CalibracionesView view;

    public CalibracionesController(Model domainModel, CalibracionesModel model, CalibracionesView view) {
        model.init();
        this.domainModel = domainModel;
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
    
    public void BuscarCalibraciones(){
        List<Calibracion> rows = domainModel.CalibracionesSearch(model.getCurrent());
        model.setCalibraciones(rows);
    }
    
    //Solamente habilita los campos para crear una nueva calibracion
    public void agregar(){
        view.fechaFld.setText("");
        //view.medicionesFld.setText("");
        view.fechaFld.setEnabled(true);
        view.medicionesFld.setEnabled(true);
        view.tablamedidas.setEnabled(true);
        view.guardar.setEnabled(true);
    }
    //
    public void verCalibracion(int r){
        Calibracion c = model.getCalibraciones().getRowAt(r);
        model.setFilter(c);
        view.fechaFld.setText(c.getFecha().toString());
        view.medicionesFld.setText(String.valueOf(c.getMediciones()));
        view.fechaFld.setEnabled(false);
        view.medicionesFld.setEnabled(false);
        view.guardar.setEnabled(false);
        view.tablamedidas.setEnabled(false);
        try{
            List<Medida> m = domainModel.MedidasSearch(model.getFilter());
            model.setMedidas(m);
        }catch(Exception ex){
        }
    }
    public void guardar() throws Exception{
        Calibracion calib = new Calibracion();
         model.clearErrors();
         calib.setInstrumento(model.getCurrent());
        try{
            Date fecha = new SimpleDateFormat("yyyy/mm/dd").parse(view.fechaFld.getText());
            calib.setFecha(fecha);
        }                               
        catch(ParseException e){
            model.getErrores().put("fecha", "Error con la fecha");
            model.setMensaje("ERROR CON LA FECHA");
        }
        if(view.fechaFld.getText().length()==0){
            model.getErrores().put("fecha2", "Fecha es requerida");
        }
        int med = Integer.parseInt(view.medicionesFld.getText());
        calib.setMediciones(med);
        if(view.medicionesFld.getText().length()==0){
            model.getErrores().put("mediciones", "El numero de mediciones es requerido");
        }
        List<Medida> meds = model.getMedidas().getRows();
        //calib.setMedidas(meds);
        domainModel.AgregarCalibracion(calib);
        List<Calibracion> lista = domainModel.CalibracionesSearch(model.getCurrent());
        calib = lista.get(lista.size()-1);
        System.out.println(calib.getNumero());
        for(int i=0;i<meds.size();i++){
           model.getMedidas().getRowAt(i).setCalibracion(calib);
           domainModel.AgregarMedida(model.getMedidas().getRowAt(i));
        }
        model.setFilter(calib);
        this.BuscarCalibraciones();
    }

    public void eliminar(int row){
         Calibracion seleccionada = model.getCalibraciones().getRowAt(row);
        try {
            domainModel.BorrarCalibracion(seleccionada);
        } catch (Exception ex) { } 
        this.BuscarCalibraciones();
    }

    public void crearMedidas(int num) {
        List<Medida> meds = new ArrayList<>();
        Medida m;
        for(int i=0;i<num;i++){
            m = new Medida();
            m.setNumero(i+1);
            meds.add(m);
        }
        model.setMedidas(meds);

    }
}
