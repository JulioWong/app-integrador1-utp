package Views.Equipos;

import Classes.DocumentoTransferencia;
import Classes.Equipo;
import Utils.FactoryEquipos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jPanelSearchEquipo extends javax.swing.JPanel {

    private Equipo oEquipo;
    private DefaultTableModel tblmodel;
    
    public jPanelSearchEquipo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblInformacion = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMovimientos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoPatrimonial = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cboEquipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        lblInformacion.setEditable(false);
        jScrollPane1.setViewportView(lblInformacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Información", jPanel1);

        jTableMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableMovimientos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Movimientos", jPanel2);

        jLabel1.setText("Código Patrimonial");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cboEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"[SELECCIONE EQUIPO]", "PC","MONITOR","IMPRESORA","PROYECTOR", "TECLADO", "MOUSE" }));
        cboEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEquipoItemStateChanged(evt);
            }
        });
        cboEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEquipoActionPerformed(evt);
            }
        });

        jLabel3.setText("Equipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigoPatrimonial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoPatrimonial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        btnBuscar.setEnabled(false);
        this.lblInformacion.setText("");
        
        if (this.cboEquipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                    "Seleccione que clase de equipo desea buscar");
            btnBuscar.setEnabled(true);
            
        } else if(this.txtCodigoPatrimonial.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Ingrese el código patrimonial");
            btnBuscar.setEnabled(true);
        } else {
            this.oEquipo = FactoryEquipos.getInstancia(
                    this.cboEquipo.getSelectedItem().toString());
                    
            this.oEquipo.setCodigoPatrimonial(txtCodigoPatrimonial.getText());
            this.oEquipo.setClaseEquipo(cboEquipo.getSelectedItem().toString());
            this.oEquipo.obtenerInformacion();

            if (this.oEquipo.getCodigoPatrimonial().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                        "No se encontró información del equipo.");
                btnBuscar.setEnabled(true);
            } else {
                this.lblInformacion.setText(this.oEquipo.imprimirInformacion());
                btnBuscar.setEnabled(true);
                this.renderTable();
                
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void renderTable() {
        String[] titles = {"Origen", "Destino", "Motivo"};
        this.tblmodel = new DefaultTableModel(null, titles);
        this.tblmodel.setRowCount(0);
        String[] registers = new String[3];
        ArrayList<DocumentoTransferencia> transfers = this.oEquipo.getTransferencias();
        for (int i = 0; i < transfers.size(); i++) {
            registers[0] = transfers.get(i).getDependenciaOrigen().getDescripcion();
            registers[1] = transfers.get(i).getDependenciaDestino().getDescripcion();
            registers[2] = transfers.get(i).getMotivo();
            tblmodel.addRow(registers);
        }
        jTableMovimientos.setModel(tblmodel);
    }
    
    private void cboEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEquipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEquipoItemStateChanged

    private void cboEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEquipoActionPerformed

    }//GEN-LAST:event_cboEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMovimientos;
    private javax.swing.JTextPane lblInformacion;
    private javax.swing.JTextField txtCodigoPatrimonial;
    // End of variables declaration//GEN-END:variables
}
