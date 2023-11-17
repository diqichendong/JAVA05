/*
 * Panel Resumen
 */
package vista;

import controlador.GestionBDResumen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Jefe;

/**
 *
 * @author Di Qi
 */
public class PanelResumen extends javax.swing.JPanel {

    private FrameMain padre;
    private Connection conexion;
    private GestionBDResumen g;
    private Jefe jefeValidado;
    private List<Empleado> listaEmpleados;

    /**
     * Creates new form PanelResumen
     */
    public PanelResumen(FrameMain padre, Connection c) {
        initComponents();

        this.padre = padre;
        this.conexion = c;
    }

    /**
     * Mostrar datos del jefe
     */
    public void mostrarDatosJefe() {
        jefeValidado = padre.getJefeValidado();
        infoUsuario.setText(jefeValidado.getUsuario());
        infoNombre.setText(jefeValidado.getNombre());
        infoSueldoAPagar.setText(jefeValidado.getSueldoAPagar() + "");

        ImageIcon imageIcon = new ImageIcon("./src/images/" + jefeValidado.getFoto());
        imageIcon = new ImageIcon(imageIcon.getImage()
                .getScaledInstance(imagenBox.getWidth(), imagenBox.getHeight(), Image.SCALE_SMOOTH));
        imagenBox.setIcon(imageIcon);
    }

    /**
     * Mostrar los empleados en la lista
     */
    public void mostrarEmpleados() {
        g = new GestionBDResumen(conexion, jefeValidado);
        try {
            listaEmpleados = g.getListaEmpleados();
            DefaultListModel model = new DefaultListModel<>();

            for (Empleado e : listaEmpleados) {
                model.addElement(e);
            }

            jListEmpleados.setModel(model);
            infoTotalEmpleados.setText(listaEmpleados.size() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error de conexión con la base de datos.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenBox = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTotalEmpleados = new javax.swing.JLabel();
        lblSueldoAPagar = new javax.swing.JLabel();
        infoUsuario = new javax.swing.JLabel();
        infoNombre = new javax.swing.JLabel();
        infoTotalEmpleados = new javax.swing.JLabel();
        infoSueldoAPagar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEmpleados = new javax.swing.JList<>();
        btnCalcular = new javax.swing.JButton();

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTotalEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalEmpleados.setText("Total de empleados:");

        lblSueldoAPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSueldoAPagar.setText("Sueldo a pagar:");

        infoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoUsuario.setText("Usuario");

        infoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoNombre.setText("Nombre");

        infoTotalEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoTotalEmpleados.setText("0");

        infoSueldoAPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoSueldoAPagar.setText("0");

        jListEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jListEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListEmpleados);

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCalcular.setText("Calcular sueldo a pagar");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblUsuario)
                                        .addGap(18, 18, 18)
                                        .addComponent(infoUsuario))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(infoNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalEmpleados)
                                        .addGap(18, 18, 18)
                                        .addComponent(infoTotalEmpleados))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSueldoAPagar)
                                        .addGap(18, 18, 18)
                                        .addComponent(infoSueldoAPagar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnCalcular)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(infoUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(infoNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalEmpleados)
                            .addComponent(infoTotalEmpleados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSueldoAPagar)
                            .addComponent(infoSueldoAPagar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            double sueldoAPagar = g.actualizarSueldoAPagar(listaEmpleados);

            infoSueldoAPagar.setText(sueldoAPagar + "");

            JOptionPane.showMessageDialog(this, "El sueldo a pagar es de " + sueldoAPagar + " €.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error de conexión con la base de datos.");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel imagenBox;
    private javax.swing.JLabel infoNombre;
    private javax.swing.JLabel infoSueldoAPagar;
    private javax.swing.JLabel infoTotalEmpleados;
    private javax.swing.JLabel infoUsuario;
    private javax.swing.JList<String> jListEmpleados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSueldoAPagar;
    private javax.swing.JLabel lblTotalEmpleados;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
