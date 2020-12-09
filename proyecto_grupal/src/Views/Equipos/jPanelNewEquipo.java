package Views.Equipos;

import Classes.Dependencia;
import Classes.Equipo;
import Classes.Facultad;
import Classes.Impresora;
import Classes.Monitor;
import Classes.PC;
import Classes.Proyector;
import Classes.Teclado;
import Utils.FactoryEquipos;
import java.util.List;
import javax.swing.JOptionPane;

public class jPanelNewEquipo extends javax.swing.JPanel {

    private boolean isImpresora= false;
    private boolean isMonitor = false;
    private boolean isPC = false;
    private boolean isProyector = false;
    private boolean isTeclado = false;
    private final Facultad oFacultad;
    private Equipo oEquipo;
    private List<Dependencia> lstDependencias;

    public jPanelNewEquipo(Facultad facultad) {
        this.oFacultad=facultad;
        initComponents();
        LlenarDependencias();
        setAttributes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigoPatrimonial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        cboEquipo = new javax.swing.JComboBox<>();
        txtMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboImpresionColor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboDependencia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        lblTipoImpresora = new javax.swing.JLabel();
        cboTipoImpresora = new javax.swing.JComboBox<>();
        lblImpresoraAColor = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        lblTipoPantalla = new javax.swing.JLabel();
        cboTipoPantalla = new javax.swing.JComboBox<>();
        lblResolucionPantalla = new javax.swing.JLabel();
        txtResolucionPantalla = new javax.swing.JTextField();
        lblProcesador = new javax.swing.JLabel();
        txtProcesador = new javax.swing.JTextField();
        txtDiscoDuro = new javax.swing.JTextField();
        lblDiscoDuro = new javax.swing.JLabel();
        lblMemoriaRam = new javax.swing.JLabel();
        txtMemoriaRam = new javax.swing.JTextField();
        lblTecnologia = new javax.swing.JLabel();
        cboTecnologia = new javax.swing.JComboBox<>();
        lblContraste = new javax.swing.JLabel();
        cboContraste = new javax.swing.JComboBox<>();
        lblResolucion = new javax.swing.JLabel();
        cboResolucion = new javax.swing.JComboBox<>();
        lblTipoTeclado = new javax.swing.JLabel();
        cboTipoTeclado = new javax.swing.JComboBox<>();
        lblConexion = new javax.swing.JLabel();
        cboConexion = new javax.swing.JComboBox<>();
        lblDistribucion = new javax.swing.JLabel();
        cboDistribucion = new javax.swing.JComboBox<>();

        jLabel1.setText("Código patrimonial");

        jLabel7.setText("Equipo");

        jLabel3.setText("Modelo");

        cboEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"[SELECCIONE EQUIPO]","IMPRESORA","MONITOR", "PC","PROYECTOR", "TECLADO"}));
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

        jLabel2.setText("Marca");

        jLabel5.setText("Estado");

        cboImpresionColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO"}));

        jLabel4.setText("Ubicación");

        cboDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDependenciaActionPerformed(evt);
            }
        });

        jLabel6.setText("Observaciones");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTipoImpresora.setText("Tipo Impresora");

        cboTipoImpresora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LÁSER", "INYECCIÓN"}));

        lblImpresoraAColor.setText("Impresión a color");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HABILITADO", "INHABILITADO"}));

        lblTipoPantalla.setText("Tipo pantalla");

        cboTipoPantalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LCD", "LED"}));

        lblResolucionPantalla.setText("Resolución pantalla");

        lblProcesador.setText("Procesador");

        lblDiscoDuro.setText("Disco Duro (gb)");

        lblMemoriaRam.setText("Memoria RAM (gb)");

        lblTecnologia.setText("Tecnología");

        cboTecnologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DLP", "LED"}));

        lblContraste.setText("Contraste");

        cboContraste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATIVO", "DINÁMICO"}));

        lblResolucion.setText("Resolución");

        cboResolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALTA", "BAJA"}));

        lblTipoTeclado.setText("Tipo teclado");

        cboTipoTeclado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERGONÓMICO", "MULTIMEDIA","MEMBRANA","MECÁNICO"}));

        lblConexion.setText("Conexión");

        cboConexion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CABLE USB", "INALÁMBRICO"}));

        lblDistribucion.setText("Distribución");

        cboDistribucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NUMÉRICO", "ALFANUMÉRICO"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTecnologia)
                            .addComponent(cboTecnologia, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContraste)
                            .addComponent(cboContraste, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoTeclado)
                            .addComponent(cboTipoTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConexion)
                            .addComponent(cboConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigoPatrimonial)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblTipoImpresora))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblImpresoraAColor)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(cboDependencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cboTipoImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboImpresionColor, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTipoPantalla)
                                        .addComponent(cboTipoPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiscoDuro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDiscoDuro))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblResolucionPantalla)
                                        .addComponent(txtResolucionPantalla)
                                        .addComponent(lblProcesador)
                                        .addComponent(txtProcesador))))
                            .addComponent(txtMemoriaRam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMemoriaRam)
                            .addComponent(lblResolucion)
                            .addComponent(cboResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistribucion)
                            .addComponent(cboDistribucion, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoPatrimonial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoImpresora)
                    .addComponent(lblImpresoraAColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboImpresionColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoPantalla)
                    .addComponent(lblResolucionPantalla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResolucionPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProcesador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDiscoDuro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiscoDuro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMemoriaRam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMemoriaRam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTecnologia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTecnologia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContraste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboContraste, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResolucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoTeclado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDistribucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboDistribucion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnGuardar.enable(false);
     
        String rsAction = null;
        
        Dependencia dependencia = (Dependencia) this.cboDependencia.getSelectedItem();
        this.oEquipo.setClaseEquipo(this.cboEquipo.getSelectedItem().toString());
        this.oEquipo.setCodigoPatrimonial(this.txtCodigoPatrimonial.getText());
        this.oEquipo.setModelo(this.txtModelo.getText());
        this.oEquipo.setMarca(this.txtMarca.getText());
        this.oEquipo.setObservaciones(this.txtObservacion.getText());
        this.oEquipo.setEstado(
                this.cboEstado.getSelectedItem().toString()
                        .equalsIgnoreCase("Habilitado"));
        this.oEquipo.setDependencia(dependencia);
        this.oEquipo.setTipo(this.cboTipoImpresora.getSelectedItem().toString());
        this.oEquipo.setImpresionColor(this.cboImpresionColor.getSelectedItem().toString().equalsIgnoreCase("SI"));
        this.oEquipo.setResolucion(this.txtResolucionPantalla.getText());
        this.oEquipo.setTipoPantalla(this.cboTipoPantalla.getSelectedItem().toString());
        this.oEquipo.setProcesador(this.txtProcesador.getText());
        this.oEquipo.setDiscoDuro(this.txtDiscoDuro.getText());
        this.oEquipo.setRam(this.txtMemoriaRam.getText());
        this.oEquipo.setContraste(this.cboContraste.getSelectedItem().toString());
        this.oEquipo.setTecnologia(this.cboTecnologia.getSelectedItem().toString());
        this.oEquipo.setResolucion(this.cboResolucion.getSelectedItem().toString());
        this.oEquipo.setConexion(this.cboConexion.getSelectedItem().toString());
        this.oEquipo.setTipoTeclado(this.cboTipoTeclado.getSelectedItem().toString());
        this.oEquipo.setDistribucion(this.cboDistribucion.getSelectedItem().toString());
         
        rsAction = oEquipo.guardar();
        
        if(rsAction!=null){
            JOptionPane.showMessageDialog(this, rsAction);
        }else{
            JOptionPane.showMessageDialog(this, "Equipo guardado correctamente.");
            cboEquipo.setSelectedIndex(0);
            txtMarca.setText("");
            txtModelo.setText("");
            txtCodigoPatrimonial.setText("");
            txtObservacion.setText("");
            cboDependencia.setSelectedIndex(0);
        }
        btnGuardar.enable(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEquipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEquipoItemStateChanged

    private void cboDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDependenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDependenciaActionPerformed

    private void cboEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEquipoActionPerformed
        this.oEquipo = FactoryEquipos.getInstancia(
                    this.cboEquipo.getSelectedItem().toString());

        this.reloadCbo();
        
        if (this.oEquipo instanceof Impresora) {
            this.isImpresora= true;
        } else if (this.oEquipo instanceof Monitor) {
            this.isMonitor = true;
        } else if (this.oEquipo instanceof PC) {
            this.isPC = true;
        } else if (this.oEquipo instanceof Proyector) {
            this.isProyector = true;
        } else if (this.oEquipo instanceof Teclado) {
            this.isTeclado = true;
        }
        this.setAttributes();
    }//GEN-LAST:event_cboEquipoActionPerformed
  
    private void setAttributes(){
        // TITULOS VISIBILIDAD
        this.lblTipoImpresora.setVisible(this.isImpresora);
        this.lblImpresoraAColor.setVisible(this.isImpresora);
        this.lblTipoPantalla.setVisible(this.isMonitor);
        this.lblResolucionPantalla.setVisible(this.isMonitor);
        this.lblDiscoDuro.setVisible(this.isPC);
        this.lblProcesador.setVisible(this.isPC);
        this.lblMemoriaRam.setVisible(this.isPC);
        this.lblTecnologia.setVisible(this.isProyector);
        this.lblContraste.setVisible(this.isProyector);
        this.lblResolucion.setVisible(this.isProyector);
        this.lblTipoTeclado.setVisible(this.isTeclado);
        this.lblConexion.setVisible(this.isTeclado);
        this.lblDistribucion.setVisible(this.isTeclado);
        // CAMPOS VISIBILIDAD
        this.cboTipoImpresora.setVisible(this.isImpresora);
        this.cboImpresionColor.setVisible(this.isImpresora);
        this.cboTipoPantalla.setVisible(this.isMonitor);
        this.txtResolucionPantalla.setVisible(this.isMonitor);
        this.txtDiscoDuro.setVisible(this.isPC);
        this.txtProcesador.setVisible(this.isPC);
        this.txtMemoriaRam.setVisible(this.isPC);
        this.cboTecnologia.setVisible(this.isProyector);
        this.cboContraste.setVisible(this.isProyector);
        this.cboResolucion.setVisible(this.isProyector);
        this.cboTipoTeclado.setVisible(this.isTeclado);
        this.cboConexion.setVisible(this.isTeclado);
        this.cboDistribucion.setVisible(this.isTeclado);
        // CAMPOS VALOR
        this.cboTipoImpresora.setSelectedIndex(0);
        this.cboImpresionColor.setSelectedIndex(0);
        this.cboTipoPantalla.setSelectedIndex(0);
        this.txtResolucionPantalla.setText("");
        this.txtDiscoDuro.setText("");
        this.txtProcesador.setText("");
        this.txtMemoriaRam.setText("");
        this.cboTecnologia.setSelectedIndex(0);
        this.cboContraste.setSelectedIndex(0);
        this.cboResolucion.setSelectedIndex(0);
        this.cboTipoTeclado.setSelectedIndex(0);
        this.cboConexion.setSelectedIndex(0);
        this.cboDistribucion.setSelectedIndex(0);
        
    }
    
    private void reloadCbo() {
        this.isImpresora= false;
        this.isMonitor = false;
        this.isPC = false;
        this.isProyector = false;
        this.isTeclado = false;
    }
    
    private void LlenarDependencias(){
        this.cboDependencia.removeAllItems();
        lstDependencias = oFacultad.getDependencias();
        for(int i=0; i<lstDependencias.size(); i++){
            cboDependencia.addItem(lstDependencias.get(i));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboConexion;
    private javax.swing.JComboBox<String> cboContraste;
    private javax.swing.JComboBox<Dependencia> cboDependencia;
    private javax.swing.JComboBox<String> cboDistribucion;
    private javax.swing.JComboBox<String> cboEquipo;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboImpresionColor;
    private javax.swing.JComboBox<String> cboResolucion;
    private javax.swing.JComboBox<String> cboTecnologia;
    private javax.swing.JComboBox<String> cboTipoImpresora;
    private javax.swing.JComboBox<String> cboTipoPantalla;
    private javax.swing.JComboBox<String> cboTipoTeclado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConexion;
    private javax.swing.JLabel lblContraste;
    private javax.swing.JLabel lblDiscoDuro;
    private javax.swing.JLabel lblDistribucion;
    private javax.swing.JLabel lblImpresoraAColor;
    private javax.swing.JLabel lblMemoriaRam;
    private javax.swing.JLabel lblProcesador;
    private javax.swing.JLabel lblResolucion;
    private javax.swing.JLabel lblResolucionPantalla;
    private javax.swing.JLabel lblTecnologia;
    private javax.swing.JLabel lblTipoImpresora;
    private javax.swing.JLabel lblTipoPantalla;
    private javax.swing.JLabel lblTipoTeclado;
    private javax.swing.JTextField txtCodigoPatrimonial;
    private javax.swing.JTextField txtDiscoDuro;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMemoriaRam;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtProcesador;
    private javax.swing.JTextField txtResolucionPantalla;
    // End of variables declaration//GEN-END:variables
}
