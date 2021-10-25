package Exercici1;

import javax.swing.*;

public class Validacio extends javax.swing.JFrame {

private String usuario;
private String password;

private ConnexioBD conn;
/**
 * @param args the command line arguments
 */
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
 */
 /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Validacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Validacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Validacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Validacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Validacio().setVisible(true);
            }
        });
    }
     */

// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JLabel jLabel1;
private javax.swing.JPanel jPanel1;
private javax.swing.JButton jbAccept;
private javax.swing.JButton jbCancel;
private javax.swing.JButton jbNew;
private javax.swing.JPasswordField jpwdPassword;
private javax.swing.JTextField jtxtUser;
private javax.swing.JLabel lblUser;

/**
 * Creates new form Validacio
 */
public Validacio() {
  initComponents();
  conn = new ConnexioBD();
  
  conn.connect();
}

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {
  
  jPanel1 = new javax.swing.JPanel();
  lblUser = new javax.swing.JLabel();
  jtxtUser = new javax.swing.JTextField();
  jLabel1 = new javax.swing.JLabel();
  jpwdPassword = new javax.swing.JPasswordField();
  jbAccept = new javax.swing.JButton();
  jbCancel = new javax.swing.JButton();
  jbNew = new javax.swing.JButton();
  
  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent evt) {
      formWindowClosing(evt);
    }
  });
  
  lblUser.setText("User");
  
  jtxtUser.setToolTipText("type username");
  
  jLabel1.setText("Password");
  
  jbAccept.setText("Acceptar");
  jbAccept.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      jbAcceptActionPerformed(evt);
    }
  });
  
  jbCancel.setText("Cancelar");
  jbCancel.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      jbCancelActionPerformed(evt);
    }
  });
  
  jbNew.setText("Alta nuevo usuario");
  jbNew.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      jbNewActionPerformed(evt);
    }
  });
  
  javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
  jPanel1.setLayout(jPanel1Layout);
  jPanel1Layout.setHorizontalGroup(
  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addGroup(jPanel1Layout.createSequentialGroup()
  .addGap(48, 48, 48)
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addComponent(jbNew, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
  .addComponent(jbAccept)
  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  .addComponent(jbCancel))
  .addGroup(jPanel1Layout.createSequentialGroup()
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addComponent(lblUser)
  .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
  .addGap(26, 26, 26)
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
  .addComponent(jtxtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
  .addComponent(jpwdPassword))))
  .addContainerGap(19, Short.MAX_VALUE))
  );
  jPanel1Layout.setVerticalGroup(
  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addGroup(jPanel1Layout.createSequentialGroup()
  .addGap(28, 28, 28)
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  .addComponent(lblUser)
  .addComponent(jtxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  .addComponent(jLabel1)
  .addComponent(jpwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  .addComponent(jbAccept)
  .addComponent(jbCancel))
  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  .addComponent(jbNew)
  .addContainerGap(18, Short.MAX_VALUE))
  );
  
  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addGroup(layout.createSequentialGroup()
  .addContainerGap()
  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  );
  layout.setVerticalGroup(
  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
  .addContainerGap())
  );
  
  pack();
}// </editor-fold>//GEN-END:initComponents

private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
  // TODO add your handling code here:
  cancelar();
}//GEN-LAST:event_jbCancelActionPerformed

private void jbAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcceptActionPerformed
  // TODO add your handling code here:
  acceptar();
}//GEN-LAST:event_jbAcceptActionPerformed

private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
  // TODO add your handling code here:
  nuevo();
}//GEN-LAST:event_jbNewActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
  // TODO add your handling code here:
}//GEN-LAST:event_formWindowClosing
// End of variables declaration//GEN-END:variables

private void acceptar() {
  usuario = jtxtUser.getText();
  password = new String(jpwdPassword.getPassword());
  
  if ((usuario.equals("")) || (password.equals(""))) {
    JOptionPane.showMessageDialog(null,
    "Debes introducir usuario y contraseña",
    "Login", JOptionPane.ERROR_MESSAGE);
    return;
  }
  
  // JOptionPane.showMessageDialog(null,
  // "User:"+usuario + " and Passowrd:" + password,
  // "Login", JOptionPane.ERROR_MESSAGE);
  int res = conn.validaPass(usuario, password);
  switch (res) {
    case 0:
      JOptionPane.showMessageDialog(null,
      "User:" + usuario + " pot entrar al sistema",
      "Login", JOptionPane.INFORMATION_MESSAGE);
      break;
    case 1:
      JOptionPane.showMessageDialog(null,
      "User:" + usuario + " no existeix a la BBDD",
      "Login", JOptionPane.ERROR_MESSAGE);
      break;
    
    case 2:
      JOptionPane.showMessageDialog(null,
      "User:" + usuario + " no correspon amb el password indicat",
      "Login", JOptionPane.ERROR_MESSAGE);
      break;
    
  }
}

private void nuevo() {
  if ((jtxtUser.getText().equals("")) || (new String(jpwdPassword.getPassword()).equals(""))) {
    JOptionPane.showMessageDialog(null,
    "Debes introducir usuario y contraseña",
    "Login", JOptionPane.ERROR_MESSAGE);
    return;
  }
  
  usuario = jtxtUser.getText();
  password = new String(jpwdPassword.getPassword());
  
  int res = conn.insertUser(usuario, password);
}

private void cancelar() {
  jtxtUser.setText("");
  jpwdPassword.setText("");
}

public String getUsuario() {
  return usuario;
}

public String getPassword() {
  return password;
}
}
