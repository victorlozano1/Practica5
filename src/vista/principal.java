/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import modelo.Centro;

/**
 *
 * @author ferna
 */
public class principal extends javax.swing.JFrame implements MenuObserver{



    /**
     * Creates new form principal
     */
    public principal() throws SQLException {
        user =  new Centro(0, usuario, contraseña, "");

        
         

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

        content = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Validar = new javax.swing.JMenu();
        Entrar = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Visualizar = new javax.swing.JMenu();
        Detalle = new javax.swing.JMenuItem();
        Resumen = new javax.swing.JMenuItem();
        acerca_de = new javax.swing.JMenu();
        menuinfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        Validar.setText("Validar");

        Entrar.setText("Entrar");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        Validar.add(Entrar);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Validar.add(Salir);

        jMenuBar1.add(Validar);

        Visualizar.setText("Visualizar");
        Visualizar.setEnabled(false);

        Detalle.setText("Detalle");
        Detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetalleActionPerformed(evt);
            }
        });
        Visualizar.add(Detalle);

        Resumen.setText("Resumen");
        Resumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumenActionPerformed(evt);
            }
        });
        Visualizar.add(Resumen);

        jMenuBar1.add(Visualizar);

        acerca_de.setText("Acerca de");
        acerca_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acerca_deActionPerformed(evt);
            }
        });

        menuinfo.setText("Mostrar info");
        menuinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuinfoActionPerformed(evt);
            }
        });
        acerca_de.add(menuinfo);

        jMenuBar1.add(acerca_de);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        // TODO add your handling code here:
                 panel_entrar=new jpanelEntrar(user,this);
        panel_entrar.setSize(266,150);
        content.removeAll();
        content.setSize(panel_entrar.getSize());
        content.add(panel_entrar,BorderLayout.CENTER);
        this.setSize(panel_entrar.getWidth()+50,panel_entrar.getHeight()+100);
        panel_entrar.setVisible(true);
        revalidate();
        repaint();

    }//GEN-LAST:event_EntrarActionPerformed

    
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(-1);
    }//GEN-LAST:event_SalirActionPerformed

    private void acerca_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acerca_deActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_acerca_deActionPerformed

    private void menuinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuinfoActionPerformed
        // TODO add your handling code here:
        AcercaDe4 v =new AcercaDe4(this,true);
        v.setVisible(true);
    }//GEN-LAST:event_menuinfoActionPerformed

    private void DetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetalleActionPerformed
        try {
            // TODO add your handling code here:
            panel_detalle=new jpanelDetalle(user);
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel_detalle.setSize(570,270);
        content.removeAll();
        content.setSize(panel_detalle.getWidth()+50,panel_detalle.getHeight()+100);
        
        content.add(panel_detalle,BorderLayout.CENTER);
        this.setSize(panel_detalle.getWidth()+50,panel_detalle.getHeight()+100);
        panel_detalle.setVisible(true);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_DetalleActionPerformed

    private void ResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumenActionPerformed
        // TODO add your handling code here:
        panel_lista=new jpanellista(user);
        panel_lista.setSize(400,300);
                content.removeAll();
        content.setSize(panel_lista.getWidth()+50,panel_lista.getHeight()+100);
        
        content.add(panel_lista,BorderLayout.CENTER);
        this.setSize(panel_lista.getWidth()+50,panel_lista.getHeight()+100);
        panel_lista.setVisible(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_ResumenActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Detalle;
    private javax.swing.JMenuItem Entrar;
    private javax.swing.JMenuItem Resumen;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu Validar;
    private javax.swing.JMenu Visualizar;
    private javax.swing.JMenu acerca_de;
    private javax.swing.JPanel content;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuinfo;
    // End of variables declaration//GEN-END:variables
    jpanelEntrar panel_entrar;
    String usuario="";
    String contraseña="";
    Centro user;
    jpanelDetalle panel_detalle;
    jpanellista panel_lista;

    
    @Override
    public void activarMenuVisualizar() {
        // Obtén la referencia al menú "Visualizar"
        JMenu menuVisualizar = jMenuBar1.getMenu(1); // Suponiendo que "Visualizar" es el segundo menú en el JMenuBar

        // Habilita el menú "Visualizar"
        menuVisualizar.setEnabled(true);
    }
    
}
