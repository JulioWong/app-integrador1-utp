package Views.Usuarios;

import Classes.Usuario;
import javax.swing.JOptionPane;

public class jPanelChangePwd extends javax.swing.JPanel {

    private int userId;
    
    public jPanelChangePwd(int userId) {
        initComponents();
        this.userId = userId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtNuevaPwd = new javax.swing.JPasswordField();
        txtAntiguaPwd = new javax.swing.JPasswordField();
        txtNuevaPwdRepetida = new javax.swing.JPasswordField();

        jLabel1.setText("Contraseña antigua");

        jLabel2.setText("Contraseña nueva");

        jLabel3.setText("Repita contraseña nueva");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNuevaPwd)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 208, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNuevaPwdRepetida)
                    .addComponent(txtAntiguaPwd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAntiguaPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuevaPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuevaPwdRepetida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if(this.txtAntiguaPwd.getText().isEmpty()|| this.txtNuevaPwd.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Complete correctamente los campos.");
           return; 
        }
        if (!this.txtNuevaPwd.getText().equals(this.txtNuevaPwdRepetida.getText())){
           JOptionPane.showMessageDialog(this, "Nueva contraseña no coincide al repetirla.");
           return;
        }
       Usuario oUsuario = new Usuario(userId,txtAntiguaPwd.getText().toString());
       String resultCambioContrasena = oUsuario.cambiarContrasena(this.txtNuevaPwd.getText().toString());
       if(resultCambioContrasena !=null){
           JOptionPane.showMessageDialog(this, resultCambioContrasena);
           return;
       }
       JOptionPane.showMessageDialog(this, "Contraseña modificada.");
       txtAntiguaPwd.setText("");
       txtNuevaPwd.setText("");
       txtNuevaPwdRepetida.setText("");
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtAntiguaPwd;
    private javax.swing.JPasswordField txtNuevaPwd;
    private javax.swing.JPasswordField txtNuevaPwdRepetida;
    // End of variables declaration//GEN-END:variables
}
