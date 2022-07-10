/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class Pop_up_pengunjung_wisata extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public form_transaksi pengunjung = null;

    /**
     * Creates new form Pop_up_pengunjung
     */
    public Pop_up_pengunjung_wisata() {
        initComponents();
        datatable();
        this.setLocationRelativeTo(null);
    }

    protected void datatable(){
        Object[] Baris ={"No Identitas","Nama Lengkap","Jenis Kelamin","Alamat","No HP","Tujuan Wisata"};
        tabmode = new DefaultTableModel(null, Baris);
        tablepengunjung.setModel(tabmode);
        String cariitem =tcari.getText();
        try{
            String sql="select *from pengunjung where nik like'%"+cariitem+"%'or nama_pengunjung like"+"'%"+cariitem+"%'order by nik asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("nik");
            String b = hasil.getString("nama_pengunjung");
            String c = hasil.getString("jenis_kelamin");
            String d = hasil.getString("alamat");
            String e = hasil.getString("no_hp");
            String f = hasil.getString("tujuan_wisata");
            String[] data = {a,b,c,d,e,f};
            tabmode.addRow(data);
        }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Gagal dipanggil"+e);
            }
        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepengunjung = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("CARI");

        tcari.setBackground(new java.awt.Color(204, 255, 255));
        tcari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tcariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        tablepengunjung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablepengunjung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepengunjungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepengunjung);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Pop Up Pelanggan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
    tabmode.getDataVector().removeAllElements();
    tabmode.fireTableDataChanged();
        try {
            String sql = "select * from pengunjung where nik like '%" + tcari.getText() + "%' or nama_pengunjung like'%" + tcari.getText() + "%'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("nik");
            String b = hasil.getString("nama_pengunjung");
            String c = hasil.getString("jenis_kelamin");
            String d = hasil.getString("alamat");
            String e = hasil.getString("no_hp");
            String f = hasil.getString("tujuan_wisata");
            String[] data = {a,b,c,d,e,f};
            tabmode.addRow(data);
        }
         hasil.close();
            stat.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void tcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_tcariKeyPressed

    private void tablepengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepengunjungMouseClicked
    int bar = tablepengunjung.getSelectedRow();
        pengunjung.nik = tablepengunjung.getValueAt(bar, 0).toString();
        pengunjung.namap =tablepengunjung.getValueAt(bar, 1).toString();
        pengunjung.jk = tablepengunjung.getValueAt(bar, 2).toString();
        pengunjung.alamat = tablepengunjung.getValueAt(bar, 3).toString();
        pengunjung.nohp = tablepengunjung.getValueAt(bar, 4).toString();
        pengunjung.tujuan = tablepengunjung.getValueAt(bar, 5).toString();
        pengunjung.itemTerpilih_pengunjung();
        this.dispose();
    }//GEN-LAST:event_tablepengunjungMouseClicked

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
            java.util.logging.Logger.getLogger(Pop_up_pengunjung_wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pop_up_pengunjung_wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pop_up_pengunjung_wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pop_up_pengunjung_wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pop_up_pengunjung_wisata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablepengunjung;
    private javax.swing.JFormattedTextField tcari;
    // End of variables declaration//GEN-END:variables
}
