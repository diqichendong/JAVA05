/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.GestionBDComun;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Jefe;

/**
 *
 * @author AndJe
 */
public class FrameMain extends javax.swing.JFrame {
    
    private Connection conexion;
    
    private PanelEntrar panelEntrar;
    private PanelInicio panelInicio;
    private PanelResumen panelResumen;
    private PanelDetalle panelDetalle;
    
    private Jefe jefeValidado;

    /**
     * Creates new form FrameMain
     */
    public FrameMain() {
        initComponents();
        
        try {
            this.conexion = GestionBDComun.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Fallo al conectar a la base de datos.");
        }
        
        panelInicio = new PanelInicio();
        panelEntrar = new PanelEntrar(this, this.conexion);
        panelResumen = new PanelResumen(this, this.conexion);
        panelDetalle = new PanelDetalle(this, this.conexion);
        
        menuVisualizar.setEnabled(false);
        menuItemSalir.setEnabled(false);
        
        cambiarPanelInicio();
    }
    
    /**
     * Cambia al panel inicio
     */
    public void cambiarPanelInicio() {
        this.setContentPane(panelInicio);
        this.pack();
    }
    
    /**
     * Cambia al panel entrar
     */
    public void cambiarPanelEntrar() {
        this.setContentPane(panelEntrar);
        this.pack();
    }
    
    /**
     * Cambia al panel resumen
     */
    public void cambiarPanelResumen() {
        this.setContentPane(panelResumen);
        this.pack();
    }
    
    /**
     * 
     */
    public void cambiarPanelDDetalle(){
        this.setContentPane(panelDetalle);
        this.pack();
    }
    
    /**
     * Activar o desactivar menu item entrar
     * @param b 
     */
    public void activarMenuItemEntrar(boolean b) {
        menuItemEntrar.setEnabled(b);
    }
    
    /**
     * Activar o desactivar menu item salir
     * @param b 
     */
    public void activarMenuItemSalir(boolean b) {
        menuItemSalir.setEnabled(b);
    }
    
    /**
     * Activar o desactivar menu visualizar
     * @param b 
     */
    public void activarMenuVisualizar(boolean b) {
        menuVisualizar.setEnabled(b);
    }
    
    public void setJefeValidado(Jefe j) {
        this.jefeValidado = j;
    }
    
    public Jefe getJefeValidado() {
        return this.jefeValidado;
    }
    
    public PanelResumen getPanelResumen() {
        return this.panelResumen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuValidar = new javax.swing.JMenu();
        menuItemEntrar = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuVisualizar = new javax.swing.JMenu();
        menuItemDetalle = new javax.swing.JMenuItem();
        menuItemResumen = new javax.swing.JMenuItem();
        menuAcercade = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        menuValidar.setText("Validar");

        menuItemEntrar.setText("Entrar");
        menuItemEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEntrarActionPerformed(evt);
            }
        });
        menuValidar.add(menuItemEntrar);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuValidar.add(menuItemSalir);

        jMenuBar1.add(menuValidar);

        menuVisualizar.setText("Visualizar");
        menuVisualizar.setEnabled(false);

        menuItemDetalle.setText("Detalle");
        menuItemDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDetalleActionPerformed(evt);
            }
        });
        menuVisualizar.add(menuItemDetalle);

        menuItemResumen.setText("Resumen");
        menuVisualizar.add(menuItemResumen);

        jMenuBar1.add(menuVisualizar);

        menuAcercade.setText("Acerca de");
        jMenuBar1.add(menuAcercade);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEntrarActionPerformed
        cambiarPanelEntrar();
        
        menuItemEntrar.setEnabled(false);
        menuItemSalir.setEnabled(true);
    }//GEN-LAST:event_menuItemEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GestionBDComun.close(conexion);
    }//GEN-LAST:event_formWindowClosing

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        cambiarPanelInicio();
        
        menuVisualizar.setEnabled(false);
        menuItemSalir.setEnabled(false);
        menuItemEntrar.setEnabled(true);
        
        this.jefeValidado = null;
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDetalleActionPerformed
        cambiarPanelDDetalle();
        panelDetalle.inicializar();
    }//GEN-LAST:event_menuItemDetalleActionPerformed

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
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAcercade;
    private javax.swing.JMenuItem menuItemDetalle;
    private javax.swing.JMenuItem menuItemEntrar;
    private javax.swing.JMenuItem menuItemResumen;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuValidar;
    private javax.swing.JMenu menuVisualizar;
    // End of variables declaration//GEN-END:variables
}
