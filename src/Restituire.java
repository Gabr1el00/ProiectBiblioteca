
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 
 * @author Admin
 */
public class Restituire extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Restituire() {
        initComponents();
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
        ret = new javax.swing.JButton();
        ncf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        cnpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 5));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 423));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ret.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ret.setText("RETURN");
        ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retActionPerformed(evt);
            }
        });
        jPanel1.add(ret, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 200, -1));

        ncf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel1.add(ncf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 170, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Numele c??r??ii");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 140, 22));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("CNP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 20));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setText("Restituire carte:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 270, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 90, -1));

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 90, -1));

        cnpf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel1.add(cnpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 170, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Biblioteca\\interior-biblioteca-sala-vacia-leer-libros-estantes-madera_33099-1722.jpg")); // NOI18N
        jLabel4.setAlignmentY(0.0F);
        jLabel4.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 620, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retActionPerformed
       
	try {
		Connection con = BDConn.getBDConn();
                String sql ="Select Count(cnp) from imprumut where CNP=? and Numele_cartii_imprumutate=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, cnpf.getText());
                pst.setString(2, ncf.getText());
                ResultSet rs = pst.executeQuery();
                rs.next();
                int x=rs.getInt("Count(cnp)");
                System.out.println(x);
                if(x>0){
                    sql="Select nr_carti_disponibile from bibl where nume_carte=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, ncf.getText());
                    rs = pst.executeQuery();
                    rs.next();
                    int a=rs.getInt("nr_carti_disponibile");
                    a=a+1;
                    sql="update bibl set nr_carti_disponibile="+a+" where nume_carte=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, ncf.getText());
                    pst.executeUpdate();
                    sql="update imprumut set restituit=1 where numele_cartii_imprumutate=? and cnp=?" ;
                    pst = con.prepareStatement(sql);
                    pst.setString(1, ncf.getText());
                    pst.setString(2, cnpf.getText());
                    pst.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Restituire cu Succes!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ati introdus date gresite");
                   
                }
                
                
		}
	catch (Exception exc) {
		exc.printStackTrace();
        }
    }//GEN-LAST:event_retActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
                    ModerMenu men = new ModerMenu();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ncf.setText("");
        cnpf.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed
        
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField cnpf;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ncf;
    private javax.swing.JButton ret;
    // End of variables declaration//GEN-END:variables
}
