package Views.Equipos;

import Classes.Dependencia;
import Classes.Equipo;
import Classes.Facultad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class jPanelListEquipo extends javax.swing.JPanel {

    private final Facultad oFacultad;
    private List<Dependencia> lstDependencias;
    private DefaultTableModel tblmodel;
    private Dependencia oDependencia;
    /**
     * Creates new form jPanelListEquipo
     * @param facultad
     */
    public jPanelListEquipo(Facultad facultad) {
        this.oFacultad = facultad;
        initComponents();
        LlenarDependencias();
        renderTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEquipos = new javax.swing.JTable();
        cboDependencia = new javax.swing.JComboBox<>();

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Dependencia");

        jtEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EQUIPO", "CODIGO PATRIMONIAL", "ESTADO"
            }
        ));
        jtEquipos.setEditingColumn(0);
        jtEquipos.setEditingRow(0);
        jScrollPane1.setViewportView(jtEquipos);

        cboDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDependenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboDependencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        renderTable();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDependenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDependenciaActionPerformed
    
// TODO - METODOS DE LLENADO DE COMBOS
    private void LlenarDependencias(){
        this.cboDependencia.removeAllItems();
        lstDependencias = oFacultad.getDependencias();
        for(int i=0; i<lstDependencias.size(); i++){
            cboDependencia.addItem(lstDependencias.get(i));
        }
    }
    private void renderTable() {
        String[] titles = {"C. Patrimonial", "Clase","Estado","U. Actual"};
        this.tblmodel = new DefaultTableModel(null, titles);
        addDataToModel();        
        jtEquipos.setModel(tblmodel);
    }
    
    private void addDataToModel() {
        this.oDependencia = (Dependencia) this.cboDependencia.getSelectedItem();
        ArrayList<Equipo> oEquipos = this.oDependencia.getEquipos();
        this.tblmodel.setRowCount(0);
        String[] registers = new String[4];
        for (int i = 0; i < oEquipos.size(); i++) {
            registers[0] = oEquipos.get(i).getCodigoPatrimonial();
            registers[1] = oEquipos.get(i).getClaseEquipo();
            registers[2] = oEquipos.get(i).getEstado()?"Habilitado":"Inhabilitado";
            registers[3] = oEquipos.get(i).getDependencia().getDescripcion();
            tblmodel.addRow(registers);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Dependencia> cboDependencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtEquipos;
    // End of variables declaration//GEN-END:variables
}
