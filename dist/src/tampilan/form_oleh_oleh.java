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
public class form_oleh_oleh extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public form_oleh_oleh() {
        initComponents();
        aktif();
        datatable();
        autonumber();
    }

    protected void aktif() {
        tkd.requestFocus();
    }
    
    private void kosong (){
        tkd.setText("");
        tnama.setText("");
        tharga.setText("");
        tstok.setText("");
        talamat.setText("");
    }  
      protected void autonumber(){
        try{
            String sql = "SELECT kode_barang FROM oleh_oleh order by kode_barang asc";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            tkd.setText("KB0001");
            while(rs.next()){
                String id =rs.getString("kode_barang").substring(2);
                int AN = Integer.parseInt(id) + 1;
                String Nol = "";
                
                if(AN<10)
                {Nol = "000";}
                else if (AN<100)
                {Nol = "00";}
                else if (AN<1000)
                {Nol = "0";}
                else if (AN<10000)
                {Nol = "";}
                
                tkd.setText("KB"+Nol+AN);
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }
      
    protected void datatable(){
        Object[] Baris ={"Kode Barang","Nama Barang","Harga Barang","Stok","Alamat Pabrik"};
        tabmode = new DefaultTableModel(null, Baris);
        tableoleholeh.setModel(tabmode);
        String cariitem =tcari.getText();
        try{
            String sql="select *from oleh_oleh where kode_barang like'%"+cariitem+"%'or nama_barang like"+"'%"+cariitem+"%' or Alamat like"+"'%"+cariitem+"%' order by kode_barang asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("kode_barang");
            String b = hasil.getString("nama_barang");
            String c = hasil.getString("Harga");
            String d = hasil.getString("stok");
            String e = hasil.getString("Alamat");
            String[] data = {a,b,c,d,e};
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tstok = new javax.swing.JTextField();
        tkd = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        talamat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableoleholeh = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Shopping-bag-orange-icon.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("DATA OLEH-OLEH");

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Kode Barang");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Nama Barang");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Stok");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Alamat Asal");

        tstok.setBackground(new java.awt.Color(204, 255, 255));
        tstok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tstok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tstokFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tstokFocusLost(evt);
            }
        });
        tstok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tstokKeyPressed(evt);
            }
        });

        tkd.setBackground(new java.awt.Color(204, 255, 255));
        tkd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tkd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tkdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tkdFocusLost(evt);
            }
        });
        tkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdActionPerformed(evt);
            }
        });
        tkd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkdKeyPressed(evt);
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

        tharga.setBackground(new java.awt.Color(204, 255, 255));
        tharga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tharga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                thargaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                thargaFocusLost(evt);
            }
        });
        tharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thargaKeyPressed(evt);
            }
        });

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

        tableoleholeh.setModel(new javax.swing.table.DefaultTableModel(
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
        tableoleholeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableoleholehMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableoleholeh);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tkd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tstok, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57)
                        .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bedit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
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
                            .addComponent(tkd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tstok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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

    private void tstokFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tstokFocusGained

    }//GEN-LAST:event_tstokFocusGained

    private void tstokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tstokFocusLost

    }//GEN-LAST:event_tstokFocusLost

    private void tstokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tstokKeyPressed

    }//GEN-LAST:event_tstokKeyPressed

    private void tkdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tkdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdFocusGained

    private void tkdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tkdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdFocusLost

    private void tkdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdKeyPressed

    private void tnamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusGained

    private void tnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusLost

    private void tnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaKeyPressed

    private void thargaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thargaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaFocusGained

    private void thargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thargaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaFocusLost

    private void thargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaKeyPressed

    private void talamatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_talamatFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatFocusGained

    private void talamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_talamatFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatFocusLost

    private void talamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talamatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatKeyPressed

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

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
      tabmode.getDataVector().removeAllElements();
        tabmode.fireTableDataChanged();

        try {
            String sql = "select * from oleh_oleh where kode_barang like '%" + tcari.getText() + "%' or nama_barang like'%" + tcari.getText() + "%' or alamat_barang like'%" + tcari.getText() +"%'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("kode_barang");
            String b = hasil.getString("nama_barang");
            String c = hasil.getString("Harga");
            String d = hasil.getString("stok");
            String e = hasil.getString("Alamat");
            String[] data = {a,b,c,d,e};
            tabmode.addRow(data);
        }
         hasil.close();
            stat.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void tkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdActionPerformed

    }//GEN-LAST:event_tkdActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        kosong();
        datatable();
        autonumber();
    }//GEN-LAST:event_bclearActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
     String sql = "Update oleh_oleh set kode_barang=?,nama_barang=?,Harga=?,stok=?,Alamat=? where kode_barang='"+tkd.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tkd.getText());
            stat.setString(2,tnama.getText());
            stat.setString(3,tharga.getText());
            stat.setString(4,tstok.getText());
            stat.setString(5,talamat.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong();
            tkd.requestFocus();
            datatable();
            autonumber();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal ubah"+e);
        } catch (Exception ex) {
            Logger.getLogger(form_oleh_oleh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed

    int ok = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus data?","konfirmasi",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                String sql = "delete from oleh_oleh where kode_barang='"+tkd.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                kosong();
                tkd.requestFocus();
                datatable();
                autonumber();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Data gagal dihapus "+e);
            } catch (Exception ex) {
                Logger.getLogger(form_hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tableoleholehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableoleholehMouseClicked
    int bar = tableoleholeh.getSelectedRow();
        String a =tabmode.getValueAt(bar,0).toString();
        String b =tabmode.getValueAt(bar,1).toString();
        String c =tabmode.getValueAt(bar,2).toString();
        String d =tabmode.getValueAt(bar,3).toString();
        String e =tabmode.getValueAt(bar,4).toString();
        
        tkd.setText(a);
        tnama.setText(b);
        tharga.setText(c);
        tstok.setText(d);
        talamat.setText(e);
    }//GEN-LAST:event_tableoleholehMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menu_utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
    String sql = "insert into oleh_oleh values(?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tkd.getText());
            stat.setString(2,tnama.getText());
            stat.setString(3,tharga.getText());
            stat.setString(4,tstok.getText());
            stat.setString(5,talamat.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Berhasil disimpan");
            kosong();
            tkd.requestFocus();
            datatable();
            autonumber();
       } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan"+e);
        } catch (Exception ex) {
            Logger.getLogger(form_oleh_oleh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsaveActionPerformed

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
            java.util.logging.Logger.getLogger(form_oleh_oleh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_oleh_oleh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_oleh_oleh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_oleh_oleh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_oleh_oleh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableoleholeh;
    private javax.swing.JTextField talamat;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tkd;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tstok;
    // End of variables declaration//GEN-END:variables
}
