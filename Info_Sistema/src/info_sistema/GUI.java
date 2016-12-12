package info_sistema;

import org.hyperic.sigar.SigarException;

/**
 *
 * @author ejerzain
 */
public class GUI extends javax.swing.JFrame {

    Info_Sistema infoSistema=new Info_Sistema();
    String opcion;
     public GUI() {
        initComponents();
        opcion="sistema";
        this.setTitle("Informacion del sistema");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInfo = new javax.swing.JTextArea();
        etiqueta = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mostrarEnPantalla = new javax.swing.JMenuItem();
        generarArchivo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuInfoSistema = new javax.swing.JMenuItem();
        jMenuInfoMemoria = new javax.swing.JMenuItem();
        jMenuInfoCPU = new javax.swing.JMenuItem();
        jMenuInfoDiscos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBGenerar.setText("Generar");
        jBGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarActionPerformed(evt);
            }
        });

        jTInfo.setEditable(false);
        jTInfo.setColumns(20);
        jTInfo.setRows(5);
        jScrollPane1.setViewportView(jTInfo);

        etiqueta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiqueta.setText("Información del sistema:");

        jMenu1.setText("Modo");

        mostrarEnPantalla.setText("Mostrar en pantalla");
        mostrarEnPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEnPantallaActionPerformed(evt);
            }
        });
        jMenu1.add(mostrarEnPantalla);

        generarArchivo.setText("Generar archivo");
        generarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(generarArchivo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Informacion");

        jMenuInfoSistema.setText("Informacion del sistema");
        jMenuInfoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInfoSistemaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuInfoSistema);

        jMenuInfoMemoria.setText("Informacion de la memoria");
        jMenuInfoMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInfoMemoriaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuInfoMemoria);

        jMenuInfoCPU.setText("Informacion de la CPU");
        jMenuInfoCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInfoCPUActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuInfoCPU);

        jMenuInfoDiscos.setText("Informacion de discos duros");
        jMenuInfoDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInfoDiscosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuInfoDiscos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBGenerar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiqueta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBGenerar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarEnPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEnPantallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarEnPantallaActionPerformed

    private void jBGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarActionPerformed
        if(opcion=="sistema"){
        try{jTInfo.setText(infoSistema.obtenerInfoSistema());}
        catch(SigarException e){e.printStackTrace();}
        }
        else if(opcion=="memoria"){
        try{jTInfo.setText(infoSistema.obtenerInfoMemoria());}
        catch(SigarException e){e.printStackTrace();}
        }
        else if(opcion=="cpu"){
        try{jTInfo.setText(infoSistema.obtenerInfoCPU());}
        catch(SigarException e){e.printStackTrace();}
        }
         else if(opcion=="discos"){
        try{jTInfo.setText(infoSistema.obtenerInfoDiscos());}
        catch(SigarException e){e.printStackTrace();}
        }
    }//GEN-LAST:event_jBGenerarActionPerformed

    private void jMenuInfoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInfoSistemaActionPerformed
        etiqueta.setText("Información del sistema:");
        opcion="sistema";
        jTInfo.setText("");
    }//GEN-LAST:event_jMenuInfoSistemaActionPerformed

    private void jMenuInfoDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInfoDiscosActionPerformed
        etiqueta.setText("Información de discos duros:");
        opcion="discos";
        jTInfo.setText("");
    }//GEN-LAST:event_jMenuInfoDiscosActionPerformed

    private void generarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarArchivoActionPerformed
        if(opcion=="sistema"){
        try{infoSistema.guardarEnArchivo(infoSistema.obtenerInfoSistema());}
        catch(SigarException e){e.printStackTrace();}
        }
        else if(opcion=="memoria"){
        try{infoSistema.guardarEnArchivo(infoSistema.obtenerInfoMemoria());}
        catch(SigarException e){e.printStackTrace();}
        }
        else if(opcion=="cpu"){
        try{infoSistema.guardarEnArchivo(infoSistema.obtenerInfoCPU());}
        catch(SigarException e){e.printStackTrace();}
        }
        else if(opcion=="discos"){
        try{infoSistema.guardarEnArchivo(infoSistema.obtenerInfoDiscos());}
        catch(SigarException e){e.printStackTrace();}
        }
    }//GEN-LAST:event_generarArchivoActionPerformed

    private void jMenuInfoMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInfoMemoriaActionPerformed
        etiqueta.setText("Información de la memoria:");
        opcion="memoria";
        jTInfo.setText("");
    }//GEN-LAST:event_jMenuInfoMemoriaActionPerformed

    private void jMenuInfoCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInfoCPUActionPerformed
        etiqueta.setText("Información de la CPU:");
        opcion="cpu";
        jTInfo.setText("");
    }//GEN-LAST:event_jMenuInfoCPUActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiqueta;
    private javax.swing.JMenuItem generarArchivo;
    private javax.swing.JButton jBGenerar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuInfoCPU;
    private javax.swing.JMenuItem jMenuInfoDiscos;
    private javax.swing.JMenuItem jMenuInfoMemoria;
    private javax.swing.JMenuItem jMenuInfoSistema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTInfo;
    private javax.swing.JMenuItem mostrarEnPantalla;
    // End of variables declaration//GEN-END:variables
}
