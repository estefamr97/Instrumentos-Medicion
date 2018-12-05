/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.TipoInstrumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estef
 */
public class TipoInstrumentosTableModel extends AbstractTableModel{
     List<TipoInstrumento> rows;
    int[] cols;

    public TipoInstrumentosTableModel(List<TipoInstrumento> rows, int[] cols) {
        this.rows = rows;
        this.cols = cols;
        this.initColNames();
    }
    public TipoInstrumento getRowAt(int r){
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
            case CODIGO: return String.class;
            case NOMBRE: return String.class;
            case UNIDAD: return String.class;
            default: return super.getColumnClass(col);
        }    
    } 

    @Override
    public Object getValueAt(int rowIndex, int col) {
        TipoInstrumento IT= rows.get(rowIndex);
        switch (cols[col]){
            case CODIGO: return IT.getCodigo();
            case NOMBRE: return IT.getNombre();
            case UNIDAD: return IT.getUnidad();
            default: return "";
        }
    }
    @Override
      public String getColumnName(int col){
        return colNames[cols[col]];
    }
       public static final int CODIGO=0;
       public static final int NOMBRE=1;
       public static final int UNIDAD=2;
       
      String[] colNames = new String[3];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[UNIDAD]= "Unidad";
    }
}
