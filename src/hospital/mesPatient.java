/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SBS
 */
public class mesPatient extends javax.swing.JFrame {

    Connection con=null;
    login l;
    /**
     * Creates new form mesPatient
     */
    public mesPatient() {
        initComponents();
        centerFrameOnScreen();
        displayPatients();
        l=new login();
        String nom=l.getDoctor();
        medecinNom.setText(nom);
        System.out.println(nom);
        
    }
private void centerFrameOnScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;

        int setLocationX = centerX - frameWidth / 2;
        int setLocationY = centerY - frameHeight / 2;

        this.setLocation(setLocationX, setLocationY);
    }

private void displayPatients() {
        try {
            l=new login();
            String nom=l.getDoctor();
            System.out.println(nom);
            con = (Connection) connexion.getConnect();
            String sql = "SELECT * FROM patient WHERE mondoc = ?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet resultSet = (ResultSet) statement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
            model.setRowCount(0); // Clear existing rows

            while (resultSet.next()) {
                String Name = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom"); 
                String adresse = resultSet.getString("adresse"); 
                String email = resultSet.getString("email"); 

                // Add the patient information to the table
                model.addRow(new Object[]{Name, prenom,adresse,email});
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
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

        Acceuil = new javax.swing.JButton();
        patients = new javax.swing.JButton();
        consultation = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        medecinNom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Acceuil.setText("Acceuil");
        Acceuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceuilActionPerformed(evt);
            }
        });
        getContentPane().add(Acceuil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        patients.setText("Mes Patients");
        patients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsActionPerformed(evt);
            }
        });
        getContentPane().add(patients, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        consultation.setText("Mon Agenda");
        consultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationActionPerformed(evt);
            }
        });
        getContentPane().add(consultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        jButton1.setText("Quitter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/turn-left.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 30));

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Adresse", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(patientTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 380, 160));

        medecinNom.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        medecinNom.setForeground(new java.awt.Color(51, 51, 255));
        medecinNom.setText("medecin");
        getContentPane().add(medecinNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 120, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/doctorr.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 620, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AcceuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceuilActionPerformed

    }//GEN-LAST:event_AcceuilActionPerformed

    private void patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsActionPerformed
        new mesPatient().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_patientsActionPerformed

    private void consultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationActionPerformed

        new mesAgenda().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        new login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(mesPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mesPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mesPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mesPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mesPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceuil;
    private javax.swing.JButton consultation;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel medecinNom;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton patients;
    // End of variables declaration//GEN-END:variables
}