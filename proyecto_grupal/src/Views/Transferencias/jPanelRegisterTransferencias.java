package Views.Transferencias;

import Classes.Dependencia;
import Classes.DocumentoTransferencia;
import Classes.Equipo;
import Classes.Facultad;
import Utils.FactoryEquipos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jPanelRegisterTransferencias extends javax.swing.JPanel {

    private final Facultad oFacultad;
    private ArrayList<Dependencia> listDependencias;
    // private Dependencia oDependencia;
    private Equipo oEquipo;
    private DefaultTableModel tblmodel;
    private final DocumentoTransferencia oDocumentoTransferencia;

    public jPanelRegisterTransferencias(Facultad facultad) {
        this.oFacultad=facultad;
        this.oDocumentoTransferencia = new DocumentoTransferencia();
        initComponents();
        renderDependencias();
        renderTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboDependenciasDestino = new javax.swing.JComboBox<>();
        cboDependenciasOrigen = new javax.swing.JComboBox<>();
        btnTransferir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipos = new javax.swing.JTable();
        txtCodigoPatrimonial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboEquipo = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();

        jLabel2.setText("Origen");

        jLabel3.setText("Destino");

        cboDependenciasOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDependenciasOrigenActionPerformed(evt);
            }
        });

        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        jLabel1.setText("Código patrimonial");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jTableEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableEquipos);

        jLabel5.setText("Equipo");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCodigoPatrimonial))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoPatrimonial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Códigos a transferir", jPanel1);

        jLabel4.setText("Documento de autorización");

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cboDependenciasOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboDependenciasDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDependenciasOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboDependenciasDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboDependenciasOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDependenciasOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDependenciasOrigenActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        Dependencia depOrigen = (Dependencia) this.cboDependenciasOrigen.
                                                            getSelectedItem();
        Dependencia depDestino = (Dependencia) this.cboDependenciasDestino.
                                                            getSelectedItem();
        if (txtDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                 "Ingrese el documento de autorización");
            
        } else if (depOrigen.getDependenciaId().equals(depDestino.getDependenciaId())) {
            JOptionPane.showMessageDialog(this, 
                 "Las dependencias deben ser diferentes");
            
        } else if (this.oDocumentoTransferencia.getEquipos().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                 "Ingrese por lo menos 1 equipo");
            
        } else {
            this.oDocumentoTransferencia.setDependenciaOrigen(depOrigen);
            this.oDocumentoTransferencia.setDependenciaDestino(depDestino);
            this.oDocumentoTransferencia.setDocumentoAutorizacion(
                    txtDocumento.getText());
            this.oDocumentoTransferencia.setMotivo(txtMotivo.getText());
            this.oDocumentoTransferencia.guardar();
            
            this.txtDocumento.setText("");
            this.txtMotivo.setText("");
            this.cboDependenciasDestino.setSelectedIndex(0);
            this.cboDependenciasOrigen.setSelectedIndex(0);
            this.cboEquipo.setSelectedIndex(0);
            this.tblmodel.setRowCount(0);
            JOptionPane.showMessageDialog(this, 
                 "Transferencia realizada correctamente"); 
        }
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (this.cboEquipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                    "Seleccione el equipo a buscar");
        } else if(this.txtCodigoPatrimonial.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Ingrese el código patrimonial");            
        } else {
            this.oEquipo = FactoryEquipos.getInstancia(
                    this.cboEquipo.getSelectedItem().toString());
            
            this.oEquipo.setCodigoPatrimonial(txtCodigoPatrimonial.getText());
            this.oEquipo.setClaseEquipo(cboEquipo.getSelectedItem().toString());
            this.oEquipo.obtenerInformacion();
            
            if (!oEquipo.getCodigoPatrimonial().isEmpty()) {
               this.oDocumentoTransferencia.agregarEquipo(this.oEquipo);
               this.addDataToModel();
               this.txtCodigoPatrimonial.setText("");
            }
            else JOptionPane.showMessageDialog(this, 
                    "Código no encontrado");
        }      
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void renderTable() {
        String[] titles = {"Codigo Patrimonial", "Equipo", "Modelo"};
        this.tblmodel = new DefaultTableModel(null, titles);       
        jTableEquipos.setModel(tblmodel);
    }
    
    private void addDataToModel() {
        this.tblmodel.setRowCount(0);
        String[] adds = new String[3];
        ArrayList<Equipo> eq = this.oDocumentoTransferencia.getEquipos();
        for (int i = 0; i < eq.size(); i++) {
            adds[0] = eq.get(i).getCodigoPatrimonial();
            adds[1] = eq.get(i).getClaseEquipo();
            adds[2] = eq.get(i).getModelo();
            tblmodel.addRow(adds);
        }
    }
    
    private void cboEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEquipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEquipoItemStateChanged

    private void cboEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEquipoActionPerformed
        
    }//GEN-LAST:event_cboEquipoActionPerformed

    private void renderDependencias() {
        listDependencias = oFacultad.getDependencias();
        for(int i=0; i<listDependencias.size(); i++){
            cboDependenciasOrigen.addItem(listDependencias.get(i));
            cboDependenciasDestino.addItem(listDependencias.get(i));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<Dependencia> cboDependenciasDestino;
    private javax.swing.JComboBox<Dependencia> cboDependenciasOrigen;
    private javax.swing.JComboBox<String> cboEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEquipos;
    private javax.swing.JTextField txtCodigoPatrimonial;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}