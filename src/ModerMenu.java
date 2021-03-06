
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 
 * @author Admin
 */
public class ModerMenu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ModerMenu() {
        initComponents();
        genMessReam();
    }
    public void genMessReam(){  
    try{
        Connection con = BDConn.getBDConn();
        PreparedStatement pst =con.prepareStatement("Select Count(Data) from date where Data=curdate()");
        ResultSet rs = pst.executeQuery() ;
        rs.next();
        int x =rs.getInt("Count(Data)");
        if (x==0){        
            PreparedStatement pst1 =con.prepareStatement("Select curdate()");
            ResultSet rs1 = pst1.executeQuery() ;
            rs1.next();
            String data=rs1.getString("curdate()");
            System.out.println(data);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO date (Data,Reamintire) VALUES ('"+data+"',1);");
            PreparedStatement pst2 =con.prepareStatement("Select Email,Nume,Prenume,Numele_cartii_imprumutate from imprumut where Data_restituirii=(curdate() + interval 1 day) and Restituit=0");
            ResultSet rs2 = pst2.executeQuery() ;
            System.out.println("Mesaj");
            while(rs2.next()){
                String email=rs2.getString("Email");
                String nume=rs2.getString("Nume");
                String prenume=rs2.getString("Prenume");
                String carte=rs2.getString("Numele_cartii_imprumutate");
                String sub="Amintire despre restituirea cartii la BibliotecaVirtuala";
                String content="Bună, "+nume+" "+prenume+", BibliotecaVirtuala iti aminteste ca maine trebuie sa restitui cartea "+carte;
                Mail.SendMess(email, sub, content);
                System.out.println("Mesaj");
            }
        }
    }catch(Exception e){
         System.out.println("Error!");
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

        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        imprumut = new javax.swing.JButton();
        restit = new javax.swing.JButton();
        restante = new javax.swing.JButton();
        search = new javax.swing.JButton();
        restante1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 5));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 423));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 90, -1));

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 90, -1));

        imprumut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        imprumut.setText("Înregistrare împrumut");
        imprumut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprumutActionPerformed(evt);
            }
        });
        jPanel1.add(imprumut, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 210, -1));

        restit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        restit.setText("Înregistrare restituire");
        restit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restitActionPerformed(evt);
            }
        });
        jPanel1.add(restit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 210, -1));

        restante.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        restante.setText("Vizualizare restanțe");
        restante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restanteActionPerformed(evt);
            }
        });
        jPanel1.add(restante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 210, -1));

        search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 210, -1));

        restante1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        restante1.setText("Editare date din biblioteca");
        restante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restante1ActionPerformed(evt);
            }
        });
        jPanel1.add(restante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 210, -1));

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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
                    Main men = new Main();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void imprumutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprumutActionPerformed
                    Imprumut men = new Imprumut();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_imprumutActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
                    ModerSearch men = new ModerSearch();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_searchActionPerformed

    private void restitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restitActionPerformed
                    Restituire men = new Restituire();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_restitActionPerformed

    private void restanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restanteActionPerformed
                    Restante men = new Restante();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_restanteActionPerformed

    private void restante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restante1ActionPerformed
                    Edit men = new Edit();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_restante1ActionPerformed
        
    
    public static void main(String args[]) {
        

        JOptionPane.showMessageDialog(null, "sall");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton exit;
    private javax.swing.JButton imprumut;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton restante;
    private javax.swing.JButton restante1;
    private javax.swing.JButton restit;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
