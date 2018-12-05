/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.logica;

import instrumentos.data.Dao;
import instrumentosEntidades.Calibracion;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.Medida;
import instrumentosEntidades.TipoInstrumento;
import java.util.List;

/**
 *
 * @author estef
 */
public class Model {
    private Dao dao;
    private static Model uniqueInstance;
     
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
     private Model(){
        dao = new Dao();
    }
      public List<TipoInstrumento> tipoInstrumentoSearch(TipoInstrumento filtro){
        return dao.TipoInstrumentoSearch(filtro);
    } 
    
    public void tipoInstrumentoAgregar(TipoInstrumento ti) throws Exception{
        dao.TipoInstrumentoAgregar(ti);
    }
    
    public void tipoInstrumentoActualizar(TipoInstrumento ti) throws Exception{
        dao.TipoInstrumentoActualizar(ti);
    }

    public void tipoInstrumentoBorrar(TipoInstrumento ti) throws Exception {
       dao.TipoInstrumentoBorrar(ti);
    }    
    
    public List<Instrumento> InstrumentoSearch(Instrumento filtro){
       return dao.InstrumentoSearch(filtro);
    } 
    
    public void InstrumentoAgregar(Instrumento i) throws Exception{
       dao.InstrumentoAgregar(i);
    }
    
    public void InstrumentoActualizar(Instrumento i) throws Exception{
        dao.InstrumentoActualizar(i);
    }

    public void InstrumentoBorrar(Instrumento i) throws Exception{
        dao.InstrumentoBorrar(i);
    }  
    
    public List<Calibracion> CalibracionesSearch(Instrumento filtro){
        return dao.CalibracionSearch(filtro);
    } 
    
    public void AgregarCalibracion(Calibracion c) throws Exception{
        dao.AgregarCalibracion(c);
    }
    
//    public void ActualizarCalibracion(Calibracion c) throws Exception{
//        
//    }

    public void BorrarCalibracion(Calibracion c) throws Exception{
        //this.BorrarMedida(c);
        dao.BorrarCalibracion(c);
    }  
    
    public List<Medida> MedidasSearch(Calibracion filtro){
        return dao.MedidaSearch(filtro);
    } 
    
    public void AgregarMedida(Medida m) throws Exception{
        dao.AgregarMedida(m);
    }
    
    public void ActualizarMedida(Medida m) throws Exception{
        dao.MedidaActualizar(m);
    }

    public void BorrarMedida(Calibracion c) throws Exception{
        dao.MedidaBorrar(c);
    }  
    
}
