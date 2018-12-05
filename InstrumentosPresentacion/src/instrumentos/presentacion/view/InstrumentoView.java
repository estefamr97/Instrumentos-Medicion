/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.view;

import instrumentos.presentacion.Application;
import instrumentos.presentacion.controller.InstrumentoController;
import instrumentos.presentacion.model.InstrumentoModel;
import instrumentosEntidades.Instrumento;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author estef
 */
public class InstrumentoView extends javax.swing.JInternalFrame implements Observer{
InstrumentoModel model;
InstrumentoController controller;
    /**
     * 
     */
    public InstrumentoView() {
        initComponents();
    }
 public void setModel(InstrumentoModel model) {
        this.model = model; 
        model.addObserver(this);
    }

    public void setController(InstrumentoController controller) {
        this.controller = controller;
    }

    public InstrumentoModel getModel() {
        return model;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serie = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        max = new javax.swing.JLabel();
        tol = new javax.swing.JLabel();
        serFld = new javax.swing.JTextField();
        descFld = new javax.swing.JTextField();
        comboTipos = new javax.swing.JComboBox();
        minFld = new javax.swing.JTextField();
        maxFld = new javax.swing.JTextField();
        tolFld = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        serie.setText("Serie");

        descripcion.setText("Descripcion");

        tipo.setText("Tipo Instrumento");

        min.setText("Minimo");

        max.setText("Maximo");

        tol.setText("Tolerancia");

        comboTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serie)
                            .addComponent(descripcion)
                            .addComponent(tipo)
                            .addComponent(min)
                            .addComponent(max)
                            .addComponent(tol))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serFld, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(descFld)
                            .addComponent(minFld)
                            .addComponent(maxFld)
                            .addComponent(tolFld)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(guardar)
                        .addGap(64, 64, 64)
                        .addComponent(cancelar)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serie)
                    .addComponent(serFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion)
                    .addComponent(descFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo)
                    .addComponent(comboTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min)
                    .addComponent(minFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(max)
                    .addComponent(maxFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tol)
                    .addComponent(tolFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cancelar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
          controller.guardar();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstrumentoView().setVisible(true);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Instrumento current = model.getCurrent();
       
       serFld.setEnabled(model.getModo()==Application.ADD);
       serFld.setText(current.getSerie());
       if(model.getErrores().get("serie")!=null){
           serie.setToolTipText(model.getErrores().get("serie"));
       }
       else{
           serie.setToolTipText("");
       }
       
       descFld.setText(current.getDescripcion());
       if(model.getErrores().get("descripcion")!=null){
           descripcion.setToolTipText(model.getErrores().get("descripcion"));
       }
       else{
           descripcion.setToolTipText("");
       }
       comboTipos.setModel(model.getTipoInstrumento());
       comboTipos.setSelectedItem(current.getTipo());
       
       String mi = String.valueOf(current.getMinimo());
       minFld.setText(mi);
       if(model.getErrores().get("minimo")!=null){
           min.setToolTipText(model.getErrores().get("minimo"));
       }
       else{
           min.setToolTipText("");
       }
       String mA = String.valueOf(current.getMaximo());
       maxFld.setText(mA);
       if(model.getErrores().get("maximo")!=null){
           max.setToolTipText(model.getErrores().get("maximo"));
       }
       else{
           max.setToolTipText("");
       }
       String to = String.valueOf(current.getTolerancia());
       tolFld.setText(to);
       if(model.getErrores().get("tolerancia")!=null){
           tol.setToolTipText(model.getErrores().get("tolerancia"));
       }
       else{
           tol.setToolTipText("");
       }
       
       this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    public javax.swing.JComboBox comboTipos;
    public javax.swing.JTextField descFld;
    private javax.swing.JLabel descripcion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel max;
    public javax.swing.JTextField maxFld;
    private javax.swing.JLabel min;
    public javax.swing.JTextField minFld;
    public javax.swing.JTextField serFld;
    private javax.swing.JLabel serie;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel tol;
    public javax.swing.JTextField tolFld;
    // End of variables declaration//GEN-END:variables
}