/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.model;

import instrumentosEntidades.Medida;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estef
 */
public class MedicionesTableModel extends AbstractTableModel{
    List<Medida> rows;
    int[] cols;

    public MedicionesTableModel() {
    }

    public  MedicionesTableModel(List<Medida> rows, int[] cols){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public List<Medida> getRows() {
        return rows;
    }
    

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case 0: case 1: case 2:
                return Integer.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    public int getRowCount() {
        return rows.size();
    }
    
    public Object getValueAt(int row, int col) {
        Medida obj = rows.get(row);
        switch (cols[col]){
            case MEDIDA: return obj.getNumero();
            case REFERENCIA: return obj.getReferencia();
            case LECTURA: return obj.getLectura();
            default: return "";
        }
    }    

    public boolean isCellEditable(int row, int col) {
        switch (cols[col]){
            case 0: return false;
            default: return true;
        }
    }	

    public void setValueAt(Object value, int row, int col) {
        Medida obj = rows.get(row);
        switch (cols[col]){
            case MEDIDA: {obj.setNumero((int)value); break;}
            case REFERENCIA: {obj.setReferencia((int)value); break;}
            case LECTURA: {obj.setLectura( (int) value); break;}
            default: ;
        }        
    }   
    
    public Medida getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int MEDIDA=0;
    public static final int REFERENCIA=1;
    public static final int LECTURA=2;

    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[MEDIDA]= "Numero";
        colNames[REFERENCIA]= "Referencia";
        colNames[LECTURA]= "Lectura";
    }
}
