
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 
 * @author Admin
 */
public class UserMenu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public UserMenu() {
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
        searchText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 5));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 423));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 423));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchText.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });
        jPanel1.add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 280, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Search text :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 160, 22));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setText("Cautare ??n BibliotecaVirtual?? : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 460, 40));

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 110, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titlu", "Autor", "Genul", "Nr_disponibile", "Data disponibilitatii"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 590, 200));

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
        PreparedStatement pst =con.prepareStatement("Select nume_carte,autor_carte,genul,nr_carti_disponibile from bibl;");
        ResultSet rs = pst.executeQuery() ;
        int x,y;
        ResultSetMetaData data = rs.getMetaData();
        y = data.getColumnCount();
        
        DefaultTableModel tableRecords = (DefaultTableModel)jTable1.getModel();
        tableRecords.setRowCount(0);
        
        while(rs.next()){
            Vector columnData = new Vector();
            for(x=1; x<=y; x++){
                String nume=rs.getString("nume_carte");
                columnData.add(nume);
                columnData.add(rs.getString("autor_carte"));
                columnData.add(rs.getString("genul"));
                int z =rs.getInt("nr_carti_disponibile");
                if (z!=0){columnData.add(z);
                columnData.add("Disponibil!");
                }else{columnData.add(z);
                PreparedStatement pst1 =con.prepareStatement("Select Min(Data_restituirii) from imprumut where Numele_cartii_imprumutate=? and Restituit=0;");
                pst1.setString(1, nume);
                ResultSet rs1 = pst1.executeQuery() ;
                rs1.next();
                columnData.add(rs1.getString("Min(Data_restituirii)"));    
                }
            }
            tableRecords.addRow(columnData);
        }
        }catch(Exception e){
         
        }
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
                    Main men = new Main();
                    men.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        String search = searchText.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextKeyReleased
        
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
