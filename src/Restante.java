
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 
 * @author Admin
 */
public class Restante extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Restante() {
        initComponents();
        showTableData();
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
        jButton2 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 5));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 423));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Reminder message");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 150, -1));

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 90, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cartea", "Numele", "Prenumele", "CNP", "Email", "Data_restituirii"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 590, 200));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setText("Vizualizare restanțieri :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 350, 40));

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
public void showTableData(){
        try{
        Connection con=BDConn.getBDConn();
        PreparedStatement pst =con.prepareStatement("Select Numele_cartii_imprumutate,Nume,Prenume,Cnp,Email,Data_restituirii from imprumut where Data_restituirii<=curdate()and Restituit=0;");
        ResultSet rs = pst.executeQuery() ;
        int x,y;
        ResultSetMetaData data = rs.getMetaData();
        y = data.getColumnCount();
        
        DefaultTableModel tableRecords = (DefaultTableModel)jTable1.getModel();
        tableRecords.setRowCount(0);
        
        while(rs.next()){
            Vector columnData = new Vector();
            for(x=1; x<=y; x++){
                columnData.add(rs.getString("Numele_cartii_imprumutate"));
                columnData.add(rs.getString("Nume"));
                columnData.add(rs.getString("Prenume"));
                columnData.add(rs.getString("Cnp"));
                columnData.add(rs.getString("Email"));
                columnData.add(rs.getString("Data_restituirii"));
                }
            
            tableRecords.addRow(columnData);
        }
        }catch(Exception e){
         
        }
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
                    ModerMenu men = new ModerMenu();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
        Connection con=BDConn.getBDConn();
        PreparedStatement pst =con.prepareStatement("Select count(Restante) from date where data=curdate()and Restante=0;");
        ResultSet rs = pst.executeQuery() ;
        rs.next();
        int x=rs.getInt("Count(Restante)");  
           System.out.println(x);
        if (x==1){
        pst =con.prepareStatement("Select Email,Nume,Prenume,Numele_cartii_imprumutate,Data_restituirii from imprumut where Data_restituirii<=curdate()and Restituit=0;");
        rs = pst.executeQuery() ;
        while(rs.next()){
                String email=rs.getString("Email");
                String nume=rs.getString("Nume");
                String prenume=rs.getString("Prenume");
                String carte=rs.getString("Numele_cartii_imprumutate");
                String data=rs.getString("Data_restituirii");
                String sub="ATENTIE! Amintire despre restituirea cartii la BibliotecaVirtuala";
                String content="Bună, "+nume+" "+prenume+", BibliotecaVirtuala iti aminteste ca trebuie sa restitui urgent cartea "+carte+" intrucat data limita a fost la "+data;
                Mail.SendMess(email, sub, content);
        }
        Statement stmt = con.createStatement();
        stmt.execute("UPDATE date SET Restante= '1' WHERE (Data = curdate());");
        JOptionPane.showMessageDialog(null, "Mesajele au fost trimise cu succes!");}
        else{
        JOptionPane.showMessageDialog(null, "Astazi s-au generat mesaje!");
        }
       }catch(Exception e){
           System.out.println("Error");
       }
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
