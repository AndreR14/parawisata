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
public class Transportasi extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

 
    public Transportasi() {
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
        tjenis.setText("");
        tnama.setText("");
        tharga.setText("");
    }
        
      protected void autonumber(){
        try{
            String sql = "SELECT kd_transportasi FROM transportasi order by kd_transportasi asc";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            tkd.setText("KT0001");
            while(rs.next()){
                String id =rs.getString("kd_transportasi").substring(2);
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
                
                tkd.setText("KT"+Nol+AN);
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }

    protected void datatable(){
        Object[] Baris ={"Kode Transportasi","Jenis Transportasi","Nama Transportasi","Harga Sewa"};
        tabmode = new DefaultTableModel(null, Baris);
        tabletransportasi.setModel(tabmode);
        String cariitem =tcari.getText();
        try{
            String sql="select *from transportasi where kd_transportasi like'%"+cariitem+"%'or nama_transportasi like"+"'%"+cariitem+"%'order by kd_transportasi asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("kd_transportasi");
            String b = hasil.getString("jenis_transportasi");
            String c = hasil.getString("nama_transportasi");
            String d = hasil.getString("harga");
            String[] data = {a,b,c,d};
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
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletransportasi = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tkd = new javax.swing.JTextField();
        tjenis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Car-icon.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("DATA TRANSPORTASI");

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
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabletransportasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabletransportasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletransportasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabletransportasi);

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

        panel.setBackground(new java.awt.Color(204, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Kode Transportasi");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Jenis Transportasi");

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
        tkd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkdKeyPressed(evt);
            }
        });

        tjenis.setBackground(new java.awt.Color(204, 255, 255));
        tjenis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tjenis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tjenisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tjenisFocusLost(evt);
            }
        });
        tjenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjenisKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Nama Transportasi");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Harga Sewa/Hari");

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
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });
        tharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thargaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45))
                    .addComponent(jLabel8)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(tkd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_tcariKeyPressed

    private void tcariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tcariFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariFocusLost

    private void tcariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tcariFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariFocusGained

    private void thargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaKeyPressed

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaActionPerformed

    private void thargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thargaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaFocusLost

    private void thargaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thargaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaFocusGained

    private void tnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaKeyPressed

    private void tnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusLost

    private void tnamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnamaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaFocusGained

    private void tkdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdKeyPressed

    private void tkdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tkdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdFocusLost

    private void tkdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tkdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdFocusGained

    private void tjenisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjenisKeyPressed

    }//GEN-LAST:event_tjenisKeyPressed

    private void tjenisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tjenisFocusLost

    }//GEN-LAST:event_tjenisFocusLost

    private void tjenisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tjenisFocusGained

    }//GEN-LAST:event_tjenisFocusGained

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
    String sql = "insert into transportasi values(?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tkd.getText());
            stat.setString(2,tjenis.getText());
            stat.setString(3,tnama.getText());
            stat.setString(4,tharga.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Berhasil disimpan");
            kosong();
            tkd.requestFocus();
            datatable();
            autonumber();
       } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan"+e);
        } catch (Exception ex) {
            Logger.getLogger(Transportasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsaveActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        kosong();
        datatable();
        autonumber();
    }//GEN-LAST:event_bclearActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
     String sql = "Update transportasi set kd_transportasi=?,jenis_transportasi=?,nama_transportasi=?,harga=? where kd_transportasi='"+tkd.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tkd.getText());
            stat.setString(2,tjenis.getText());
            stat.setString(3,tnama.getText());
            stat.setString(4,tharga.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong();
            tkd.requestFocus();
            datatable();
            autonumber();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal ubah"+e);
        } catch (Exception ex) {
            Logger.getLogger(Transportasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
    int ok = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus data?","konfirmasi",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                String sql = "delete from transportasi where kd_transportasi='"+tkd.getText()+"'";
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
                Logger.getLogger(Transportasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
      tabmode.getDataVector().removeAllElements();
        tabmode.fireTableDataChanged();

        try {
            String sql = "select * from transportasi where kd_transportasi like '%" + tcari.getText() + "%' or nama_transportasi like'%" + tcari.getText() + "%'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
            String a = hasil.getString("kd_transportasi");
            String b = hasil.getString("jenis_transportasi");
            String c = hasil.getString("nama_transportasi");
            String d = hasil.getString("harga");
            String[] data = {a,b,c,d};
            tabmode.addRow(data);
        }
         hasil.close();
            stat.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void tabletransportasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletransportasiMouseClicked
        int bar = tabletransportasi.getSelectedRow();
        String a =tabmode.getValueAt(bar,0).toString();
        String b =tabmode.getValueAt(bar,1).toString();
        String c =tabmode.getValueAt(bar,2).toString();
        String d =tabmode.getValueAt(bar,3).toString();
        
        tkd.setText(a);
        tjenis.setText(b);
        tnama.setText(c);
        tharga.setText(d);
    }//GEN-LAST:event_tabletransportasiMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MenuUtama().setVisible(true);
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
            java.util.logging.Logger.getLogger(Transportasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transportasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transportasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transportasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transportasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsave;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabletransportasi;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tjenis;
    private javax.swing.JTextField tkd;
    private javax.swing.JTextField tnama;
    // End of variables declaration//GEN-END:variables
}
