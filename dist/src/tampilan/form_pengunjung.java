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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class form_pengunjung extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form menu_utama
     */
    public form_pengunjung() {
        initComponents();
        aktif();
        datatable();
    }
    
    protected void aktif() {
        tnik.requestFocus();
    }
    private void kosong (){
        tnik.setText("");
        tnama.setText("");
        cbjk.setSelectedItem("");
        talamat.setText("");
        thp.setText("");
        ttujuan.setText("");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        talamat = new javax.swing.JTextField();
        tnik = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        thp = new javax.swing.JTextField();
        ttujuan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepengunjung = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        cbjk = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-myspace-app-52.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("DATA PENGUNJUNG");

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("No Identitas/NIK");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Nama Lengkap");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Alamat");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("No. Telpon");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Tujuan Wisata");

        talamat.setBackground(new java.awt.Color(204, 255, 255));
        talamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        talamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                talamatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                talamatFocusLost(evt);
            }
        });
        talamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                talamatKeyPressed(evt);
            }
        });

        tnik.setBackground(new java.awt.Color(204, 255, 255));
        tnik.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tnik.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tnikFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tnikFocusLost(evt);
            }
        });
        tnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikKeyPressed(evt);
            }
        });

        tnama.setBackground(new java.awt.Color(204, 255, 255));
        tnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tnama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tnamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tnamaFocusLost(evt);
            }
        });
        tnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnamaKeyPressed(evt);
            }
        });

        thp.setBackground(new java.awt.Color(204, 255, 255));
        thp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        thp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                thpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                thpFocusLost(evt);
            }
        });
        thp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thpKeyPressed(evt);
            }
        });

        ttujuan.setBackground(new java.awt.Color(204, 255, 255));
        ttujuan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        ttujuan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ttujuanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ttujuanFocusLost(evt);
            }
        });
        ttujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttujuanActionPerformed(evt);
            }
        });
        ttujuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttujuanKeyPressed(evt);
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

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("CARI");

        tcari.setBackground(new java.awt.Color(204, 255, 255));
        tcari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tcari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tcariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tcariFocusLost(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tcariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        bedit.setBackground(new java.awt.Color(102, 153, 255));
        bedit.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bclear.setBackground(new java.awt.Color(102, 153, 255));
        bclear.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bclear.setText("CLEAR");
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });

        bsave.setBackground(new java.awt.Color(102, 153, 255));
        bsave.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bsave.setText("SAVE");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        bdelete.setBackground(new java.awt.Color(102, 153, 255));
        bdelete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bdelete.setText("DELETE");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        cbjk.setBackground(new java.awt.Color(204, 255, 255));
        cbjk.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perempuan", "Laki-Laki" }));
        cbjk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(204, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(thp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(57, 57, 57)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ttujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(talamat, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(cbjk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(thp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ttujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
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

    private void talamatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_talamatFocusGained

    }//GEN-LAST:event_talamatFocusGained

    private void talamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_talamatFocusLost

    }//GEN-LAST:event_talamatFocusLost

    private void talamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talamatKeyPressed

    }//GEN-LAST:event_talamatKeyPressed

    private void tnikFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnikFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikFocusGained

    private void tnikFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnikFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikFocusLost

    private void tnikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikKeyPressed

    private void tnamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusGained

    private void tnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusLost

    private void tnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaKeyPressed

    private void thpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_thpFocusGained

    private void thpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_thpFocusLost

    private void thpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_thpKeyPressed

    private void ttujuanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ttujuanFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ttujuanFocusGained

    private void ttujuanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ttujuanFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ttujuanFocusLost

    private void ttujuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttujuanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttujuanKeyPressed

    private void ttujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttujuanActionPerformed

    private void tcariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tcariFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariFocusGained

    private void tcariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tcariFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariFocusLost

    private void tcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_tcariKeyPressed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        String sql = "insert into pengunjung values(?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tnik.getText());
            stat.setString(2,tnama.getText());
            stat.setString(3, (String) cbjk.getSelectedItem());
            stat.setString(4,talamat.getText());
            stat.setString(5,thp.getText());
            stat.setString(6,ttujuan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Berhasil disimpan");
            kosong();
            tnik.requestFocus();
            datatable();
       } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan"+e);
        } catch (Exception ex) {
            Logger.getLogger(form_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsaveActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        kosong();
        datatable();
    }//GEN-LAST:event_bclearActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
    String sql = "Update pengunjung set nik=?,nama_pengunjung=?,jenis_kelamin=?,alamat=?,no_hp=?,tujuan_wisata=? where nik='"+tnik.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);stat.setString(1,tnik.getText());
            stat.setString(2,tnama.getText());
            stat.setString(3, (String) cbjk.getSelectedItem());
            stat.setString(4,talamat.getText());
            stat.setString(5,thp.getText());
            stat.setString(6,ttujuan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Berhasil disimpan");
            kosong();
            tnik.requestFocus();
            datatable();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal ubah"+e);
        } catch (Exception ex) {
            Logger.getLogger(form_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_beditActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
    int ok = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus data?","konfirmasi",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                String sql = "delete from pengunjung where nik='"+tnik.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                kosong();
                tnik.requestFocus();
                datatable();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Data gagal dihapus "+e);
            } catch (Exception ex) {
                Logger.getLogger(form_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
       tabmode.getDataVector().removeAllElements();
        tabmode.fireTableDataChanged();

        try {
            String sql = "select * from pengunjung where nik like '%" + tcari.getText() + "%' or nama_pengunjung like'%" + tcari.getText() + "%' or no_hp like'%" + tcari.getText() + "%'";
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

    private void tablepengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepengunjungMouseClicked
        int bar = tablepengunjung.getSelectedRow();
        String a =tabmode.getValueAt(bar,0).toString();
        String b =tabmode.getValueAt(bar,1).toString();
        String c =tabmode.getValueAt(bar,2).toString();
        String d =tabmode.getValueAt(bar,3).toString();
        String e =tabmode.getValueAt(bar,4).toString();
        String f =tabmode.getValueAt(bar,4).toString();
        
       tnik.setText(a);
        tnama.setText(b);
        cbjk.setSelectedItem(c);
        talamat.setText(d);
        thp.setText(e);
        ttujuan.setText(f);
    }//GEN-LAST:event_tablepengunjungMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new menu_utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(form_pengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pengunjung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsave;
    private javax.swing.JComboBox<String> cbjk;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablepengunjung;
    private javax.swing.JTextField talamat;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField thp;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnik;
    private javax.swing.JTextField ttujuan;
    // End of variables declaration//GEN-END:variables
}
