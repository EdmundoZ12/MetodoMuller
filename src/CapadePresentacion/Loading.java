/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadePresentacion;

import java.awt.Graphics;
import java.awt.Image;
import static java.lang.System.load;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Loading extends javax.swing.JFrame {
FondoPanel fondo=new FondoPanel();
    /**
     * Creates new form Loading
     */
    
    public Loading() {
        this.setContentPane(fondo);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(661, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       Loading load=new Loading();
        load.setVisible(true);
        DemoMetodoMuller1 FormMuller=new DemoMetodoMuller1();
        try {
            for (int i = 0; i < 100; i++) {
              Thread.sleep(40);
              load.jProgressBar1.setValue(i);
            }
        } catch (Exception e) {
        }   
        load.setVisible(false);
        FormMuller.setVisible(true);
        load.dispose();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

class FondoPanel extends JPanel{
    
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon(getClass().getResource("/Imagenes/FondoLoading.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);
        setOpaque(false);
        super.paint(g);
        
    }
    
    
}


}
