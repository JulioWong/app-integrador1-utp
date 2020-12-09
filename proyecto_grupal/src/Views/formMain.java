/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.Dependencia;
import Classes.Facultad;
import Views.Dependencias.jPanelNewDependencia;
import Views.Equipos.jPanelListEquipo;
import Views.Equipos.jPanelNewEquipo;
import Views.Equipos.jPanelSearchEquipo;
import Views.Transferencias.jPanelRegisterTransferencias;
import Views.Usuarios.jPanelChangePwd;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class formMain extends javax.swing.JFrame {

    // Constantes
    private String NOMBRE_SISTEMA= "Sistema Inventario";
    private Facultad facultad;
    private ArrayList<Dependencia> dependencias;
    private int userId;
    
    public formMain(int userId, Facultad facu) {
        
        this.userId = userId;
        facultad = facu;
        
        initComponents();
        setLocationRelativeTo(null);  
        setLayout(new FlowLayout());
        this.setTitle(NOMBRE_SISTEMA);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuInventario = new javax.swing.JMenuBar();
        jMenuEquipos = new javax.swing.JMenu();
        JMenuNewEquipo = new javax.swing.JMenuItem();
        jMenuListarEquipo = new javax.swing.JMenuItem();
        jMenuBusquedaEquipo = new javax.swing.JMenuItem();
        jMenuDependencias = new javax.swing.JMenu();
        JMenuTransferencia = new javax.swing.JMenu();
        jmiTranferenciaRegistrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmiChangePwd = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuEquipos.setText("Equipos");

        JMenuNewEquipo.setText("Nuevo");
        JMenuNewEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuNewEquipoActionPerformed(evt);
            }
        });
        jMenuEquipos.add(JMenuNewEquipo);

        jMenuListarEquipo.setText("Listar");
        jMenuListarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarEquipoActionPerformed(evt);
            }
        });
        jMenuEquipos.add(jMenuListarEquipo);

        jMenuBusquedaEquipo.setText("Busqueda");
        jMenuBusquedaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBusquedaEquipoActionPerformed(evt);
            }
        });
        jMenuEquipos.add(jMenuBusquedaEquipo);

        jMenuInventario.add(jMenuEquipos);

        jMenuDependencias.setText("Dependencias");
        jMenuDependencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuDependenciasMouseClicked(evt);
            }
        });
        jMenuInventario.add(jMenuDependencias);

        JMenuTransferencia.setText("Transferencia");

        jmiTranferenciaRegistrar.setText("Registrar");
        jmiTranferenciaRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTranferenciaRegistrarActionPerformed(evt);
            }
        });
        JMenuTransferencia.add(jmiTranferenciaRegistrar);

        jMenuInventario.add(JMenuTransferencia);

        jMenu1.setText("Mi usuario");

        jmiChangePwd.setText("Cambiar Contraseña");
        jmiChangePwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiChangePwdActionPerformed(evt);
            }
        });
        jMenu1.add(jmiChangePwd);

        jMenuInventario.add(jMenu1);

        setJMenuBar(jMenuInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuListarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarEquipoActionPerformed
        getPanel(new jPanelListEquipo(facultad), "Listado de equipos");
    }//GEN-LAST:event_jMenuListarEquipoActionPerformed

    private void JMenuNewEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuNewEquipoActionPerformed
        getPanel(new jPanelNewEquipo(facultad), "Nuevo Equipo");
    }//GEN-LAST:event_JMenuNewEquipoActionPerformed

    private void jMenuBusquedaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBusquedaEquipoActionPerformed
        getPanel(new jPanelSearchEquipo(), "Busqueda de Equipos");
    }//GEN-LAST:event_jMenuBusquedaEquipoActionPerformed

    private void jMenuDependenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuDependenciasMouseClicked
        getPanel(new jPanelNewDependencia(facultad), "Dependencias");
    }//GEN-LAST:event_jMenuDependenciasMouseClicked

    private void jmiChangePwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiChangePwdActionPerformed
        // TODO add your handling code here:
        getPanel(new jPanelChangePwd(this.userId),"Cambio de contraseña");
    }//GEN-LAST:event_jmiChangePwdActionPerformed

    private void jmiTranferenciaRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTranferenciaRegistrarActionPerformed
        // TODO add your handling code here:
        getPanel(new jPanelRegisterTransferencias(facultad),"Registro de transferencias");
    }//GEN-LAST:event_jmiTranferenciaRegistrarActionPerformed
    
    private void closeAllPanels(){
        try{
            this.getContentPane().removeAll();
        }
        catch(Exception e){
        }
    }
    
    public void getPanel(JPanel panel, String title) {
        closeAllPanels();
        this.setTitle(title + " | " + NOMBRE_SISTEMA);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();
        /*this.setSize(660, 500);*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuNewEquipo;
    private javax.swing.JMenu JMenuTransferencia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuBusquedaEquipo;
    private javax.swing.JMenu jMenuDependencias;
    private javax.swing.JMenu jMenuEquipos;
    private javax.swing.JMenuBar jMenuInventario;
    private javax.swing.JMenuItem jMenuListarEquipo;
    private javax.swing.JMenuItem jmiChangePwd;
    private javax.swing.JMenuItem jmiTranferenciaRegistrar;
    // End of variables declaration//GEN-END:variables
}
