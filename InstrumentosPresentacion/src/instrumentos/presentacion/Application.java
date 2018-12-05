/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion;

import instrumentos.logica.Model;
import instrumentos.presentacion.controller.CalibracionesController;
import instrumentos.presentacion.controller.InstrumentoController;
import instrumentos.presentacion.controller.InstrumentosController;
import instrumentos.presentacion.controller.TipoInstrumentoController;
import instrumentos.presentacion.controller.TipoInstrumentosController;
import instrumentos.presentacion.model.CalibracionesModel;
import instrumentos.presentacion.model.InstrumentoModel;
import instrumentos.presentacion.model.InstrumentosModel;
import instrumentos.presentacion.model.TipoInstrumentoModel;
import instrumentos.presentacion.model.TipoInstrumentosModel;
import instrumentos.presentacion.view.AppView;
import instrumentos.presentacion.view.CalibracionesView;
import instrumentos.presentacion.view.InstrumentoView;
import instrumentos.presentacion.view.InstrumentosView;
import instrumentos.presentacion.view.TipoInstrumentoView;
import instrumentos.presentacion.view.TipoInstrumentosView;

/**
 *
 * @author estef
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Model domainModel = Model.instance();
       AppView app = new AppView();
       Model_TI=domainModel;
       
       TipoInstrumentosModel model = new TipoInstrumentosModel();
       TipoInstrumentosView tisView = new TipoInstrumentosView();
       TIPOIS_VIEW=tisView;
       TipoInstrumentosController controller = new TipoInstrumentosController(domainModel,model,tisView);
       app.addInternalFrame(tisView);
       
       TipoInstrumentoModel modelti = new TipoInstrumentoModel();
       TipoInstrumentoView tiView = new TipoInstrumentoView();
       TIPOI_VIEW=tiView;
       TipoInstrumentoController controllerti = new TipoInstrumentoController(domainModel,modelti,tiView);
       app.addInternalFrame(tiView);
       
       
       InstrumentosModel modelIs = new InstrumentosModel();
       InstrumentosView insView = new InstrumentosView();
       INS_View = insView;
       InstrumentosController contIs = new InstrumentosController(domainModel,modelIs,insView);
       app.addInternalFrame(insView);
       
       InstrumentoModel modelI = new InstrumentoModel();
       InstrumentoView inView = new InstrumentoView();
       IN_View = inView;
       InstrumentoController contI = new InstrumentoController(domainModel,modelI,inView);
       app.addInternalFrame(inView);
       
       CalibracionesModel modelC = new CalibracionesModel();
       CalibracionesView viewC = new CalibracionesView();
       CALI_VIEW = viewC;
       CalibracionesController contC = new CalibracionesController(domainModel,modelC,viewC);
       CONT=contC;
       app.addInternalFrame(viewC);
       
       app.setVisible(true);
    }
    public static Model Model_TI;
    public static CalibracionesView CALI_VIEW;
    public static InstrumentosView INS_View;
    public static InstrumentoView IN_View;
    public static TipoInstrumentoView TIPOI_VIEW;
    public static TipoInstrumentosView TIPOIS_VIEW;
    public static  CalibracionesController CONT;
    public static final int ADD=0;
    public static final int EDIT=1;
}
