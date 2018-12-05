/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.Calibracion;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estef
 */
public class CalibracionesTableModel extends AbstractTableModel{
    List<Calibracion> rows;
    int[] cols;

    public CalibracionesTableModel(List<Calibracion> rows, int[] cols) {
        this.rows = rows;
        this.cols = cols;
        this.initColNames();
    }
    public Calibracion getRowAt(int r){
        return rows.get(r);
    }
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }
    
public Class<?> getColumnClass(int col){
        switch (cols[col]){
           case FECHA: return Date.class;
            case MEDICION: return Integer.class;
            default: return super.getColumnClass(col);
        }    
    } 

    @Override
    public Object getValueAt(int rowIndex, int col) {
        Calibracion C = rows.get(rowIndex);
        switch (cols[col]){
            case FECHA: return C.getFecha();
            case MEDICION: return C.getMediciones();
            default: return "";
        }
    }
    @Override
      public String getColumnName(int col){
        return colNames[cols[col]];
    }
       public static final int FECHA=0;
       public static final int MEDICION=1;
      String[] colNames = new String[2];
    private void initColNames(){
        colNames[FECHA]= "Fecha";
        colNames[MEDICION]= "Mediciones";
    }
}
