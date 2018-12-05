/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.Instrumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estef
 */
public class InstrumentosTableModel extends AbstractTableModel{
     List<Instrumento> rows;
    int[] cols;

    public InstrumentosTableModel(List<Instrumento> rows, int[] cols) {
        this.rows = rows;
        this.cols = cols;
        this.initColNames();
    }
    public Instrumento getRowAt(int r){
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
           case SERIE: return String.class;
            case DESCRIPCION: return String.class;
            case MIN: return Integer.class;
            case MAX: return Integer.class;
            case TOL: return Integer.class;
            default: return super.getColumnClass(col);
        }    
    } 

    @Override
    public Object getValueAt(int rowIndex, int col) {
        Instrumento T= rows.get(rowIndex);
        switch (cols[col]){
            case SERIE: return T.getSerie();
            case DESCRIPCION: return T.getDescripcion();
            case MIN: return T.getMinimo();
            case MAX: return T.getMaximo();
            case TOL: return T.getTolerancia();
            default: return "";
        }
    }
    @Override
      public String getColumnName(int col){
        return colNames[cols[col]];
    }
       public static final int SERIE=0;
       public static final int DESCRIPCION=1;
       public static final int MIN=2;
       public static final int MAX=3;
       public static final int TOL=4;
      String[] colNames = new String[5];
    private void initColNames(){
        colNames[SERIE]= "Serie";
        colNames[DESCRIPCION]= "Descripcion";
        colNames[MIN]= "Min";
        colNames[MAX]= "Max";
        colNames[TOL]= "Tol";
    }
}
