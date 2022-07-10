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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class form_transaksi extends javax.swing.JFrame {
    public String kdhotel, namahotel, hargahotel,alamathotel;
    public String nik, namap, jk, nohp, alamat, tujuan;
    public String kode_w, nama_w, harga_w, alamat_w ;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public String tgl;
    public String tgl1;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public form_transaksi() {
        initComponents();
        tampilpilih();
        String KD = UserID.getUserLogin();
        jLabel3.setText(KD);
        String NM = UserID.getNamaLogin();
        jLabel4.setText(NM);
        aktif();
        autonumber();
        ttanggal.setDateFormatString("yyyy-MM-dd");
        ttanggal1.setDateFormatString("yyyy-MM-dd");
    }
    
        protected void aktif (){
        jtgl.setEditor(new JSpinner.DateEditor (jtgl,"yyyy/MM/dd"));
        Object[] Baris = {"KD Wisata","Nama Wisata","Harga Wisata"};
        tabmode = new DefaultTableModel(null, Baris);
        tblwisata.setModel(tabmode);
    }
        
        protected void autonumber(){
        try{
            String sql = "SELECT id_pembayaran FROM nota order by id_pembayaran asc";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            idtransaksi.setText("IT0001");
            while(rs.next()){
                String id_nota =rs.getString("id_pembayaran").substring(2);
                int AN = Integer.parseInt(id_nota) + 1;
                String Nol = "";
                
                if(AN<10)
                {Nol = "000";}
                else if (AN<100)
                {Nol = "00";}
                else if (AN<1000)
                {Nol = "0";}
                else if (AN<10000)
                {Nol = "";}
                
                idtransaksi.setText("IT"+Nol+AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }
    
        protected void nama() {
           
        try {
            String sql = "SELECT * FROM pegawai WHERE id_pegawai='"+jLabel3.getText()+"' AND  nama_pegawai='"+jLabel4.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
               jLabel3.setText(hasil.getString("id_pegawai"));
               jLabel4.setText(hasil.getString("nama_pegawai"));
            }
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Panggil"+e);
        }
       }

    public void itemTerpilih(){
        Pop_up_hotel Pp = new Pop_up_hotel();
        Pp.hotel = this;
        tidhotel.setText(kdhotel);
        tnamahotel.setText(namahotel);
        thargahotel.setText(hargahotel);
        tlamainap.requestFocus();
    }
    
    public void itemTerpilih_pengunjung(){
        Pop_up_pengunjung_wisata Ppw = new Pop_up_pengunjung_wisata();
        Ppw.pengunjung = this;
        tnik.setText(nik);
        tnama.setText(namap);
        }
    
        public void itemTerpilihh(){
        Pop_up_wisata Pp = new Pop_up_wisata();
        Pp.wisata = this;
        kdwisata.setText(kode_w);
        namawisata.setText(nama_w);
        thargawisata.setText(harga_w);
    }
    
    private void tampilpilih() {
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "SELECT kd_transportasi FROM transportasi WHERE kd_transportasi !=''";
            ResultSet hasil = stat.executeQuery(sql);

            while (hasil.next()) {
                jComboBox1.addItem(hasil.getString("kd_transportasi"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        public void hitung(){
        int total =0;
        for (int i=0; i<tblwisata.getRowCount(); i++){
            int amount = Integer.valueOf(tblwisata.getValueAt(i, 2).toString());
            total+=amount;
        }
        ttotalwisata.setText(Integer.toString(total));
    }
        
        public void biayatotal(){
        if (totalsewa.getText().equals("") || ttotalwisata.getText().equals("") || tlamainap.getText().equals("")) {
        ttotalwisata.setText("0");
        totalsewa.setText("0");
        
        int xtotalhotel=Integer.parseInt(ttotalinap.getText());
        int xtotaltrans=Integer.parseInt(totalsewa.getText());
        int xtotalwisata=Integer.parseInt(ttotalwisata.getText());
        int xtotalbyr=(xtotalhotel+xtotaltrans+xtotalwisata);
        ttotalkeseluruhan.setText(String.valueOf(xtotalbyr));
        
        }
    }
        
        public void biayatotal1(){
        if (totalsewa.getText().equals("") ){
        totalsewa.setText("0");
        
        int xtotalhotel=Integer.parseInt(ttotalinap.getText());
        int xtotaltrans=Integer.parseInt(totalsewa.getText());
        int xtotalwisata=Integer.parseInt(ttotalwisata.getText());
        int xtotalbyr=(xtotalhotel+xtotaltrans+xtotalwisata);
        ttotalkeseluruhan.setText(String.valueOf(xtotalbyr));
        totalsewa.setText("");
        }
        else {
        int xtotalhotel=Integer.parseInt(ttotalinap.getText());
        int xtotaltrans=Integer.parseInt(totalsewa.getText());
        int xtotalwisata=Integer.parseInt(ttotalwisata.getText());
        int xtotalbyr=(xtotalhotel+xtotaltrans+xtotalwisata);
        ttotalkeseluruhan.setText(String.valueOf(xtotalbyr));
        }
        
      
    }

        public void biayatotal2(){
        if (ttotalwisata.getText().equals("")) {
        ttotalwisata.setText("0");
        }
        int xtotalhotel=Integer.parseInt(ttotalinap.getText());
        int xtotaltrans=Integer.parseInt(totalsewa.getText());
        int xtotalwisata=Integer.parseInt(ttotalwisata.getText());
        int xtotalbyr=(xtotalhotel+xtotaltrans+xtotalwisata);
        ttotalkeseluruhan.setText(String.valueOf(xtotalbyr));   
        
    }
        
          public void cetak(){
          try {
              String path="./src/Report/Nota_Paket_Wisata.jasper";
             
              HashMap parameter = new HashMap();
              parameter.put("id_transaksi",idtransaksi.getText());
              JasperPrint print= JasperFillManager.fillReport(path, parameter,conn);
              JasperViewer.viewReport(print,false);
          } catch (Exception ex) {
              
              JOptionPane.showMessageDialog(null, "Dokumen Tidak Ada"+ex);
          }
          
      }
        
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
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
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        idtransaksi = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tnik = new javax.swing.JFormattedTextField();
        tnama = new javax.swing.JFormattedTextField();
        ttanggal = new com.toedter.calendar.JDateChooser();
        ttanggal1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ttotalinap = new javax.swing.JFormattedTextField();
        tlamainap = new javax.swing.JFormattedTextField();
        thargahotel = new javax.swing.JFormattedTextField();
        tnamahotel = new javax.swing.JFormattedTextField();
        tidhotel = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        totalsewa = new javax.swing.JFormattedTextField();
        tlamasewa = new javax.swing.JFormattedTextField();
        thargatrans = new javax.swing.JFormattedTextField();
        tnmtransportasi = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        kdwisata = new javax.swing.JFormattedTextField();
        namawisata = new javax.swing.JFormattedTextField();
        thargawisata = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        ttotalwisata = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwisata = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        ttotalkeseluruhan = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        ttotalbayar = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        kembali = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-beach-52.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("PEMESANAN WISATA DAN AKOMODASI");

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
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Tanggal Pemesanan");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Id Transaksi");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Id Petugas");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Nama Petugas");

        jtgl.setModel(new javax.swing.SpinnerDateModel());
        jtgl.setBorder(null);
        jtgl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        idtransaksi.setBackground(new java.awt.Color(204, 255, 255));
        idtransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 204)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(211, 211, 211))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(idtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Id Pengunjung");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Nama Pengunjung");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Tanggal Check-In");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Tanggal Check-Out");

        tnik.setBackground(new java.awt.Color(204, 255, 255));
        tnik.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tnik.setForeground(new java.awt.Color(0, 0, 204));
        tnik.setCaretColor(new java.awt.Color(0, 0, 153));

        tnama.setBackground(new java.awt.Color(204, 255, 255));
        tnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tnama.setForeground(new java.awt.Color(0, 0, 204));
        tnama.setCaretColor(new java.awt.Color(0, 0, 153));

        ttanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ttanggalPropertyChange(evt);
            }
        });

        ttanggal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ttanggal1PropertyChange(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-search-client-24 (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tnama)
                        .addComponent(ttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addComponent(ttanggal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(ttanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Id Hotel");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("Nama Hotel");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("Harga Hotel");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setText("Lama Hari");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("Total Penginapan");

        ttotalinap.setBackground(new java.awt.Color(204, 255, 255));
        ttotalinap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        ttotalinap.setForeground(new java.awt.Color(0, 0, 204));
        ttotalinap.setCaretColor(new java.awt.Color(0, 0, 153));

        tlamainap.setBackground(new java.awt.Color(204, 255, 255));
        tlamainap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tlamainap.setForeground(new java.awt.Color(0, 0, 204));
        tlamainap.setCaretColor(new java.awt.Color(0, 0, 153));
        tlamainap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tlamainapKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlamainapKeyTyped(evt);
            }
        });

        thargahotel.setBackground(new java.awt.Color(204, 255, 255));
        thargahotel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        thargahotel.setForeground(new java.awt.Color(0, 0, 204));
        thargahotel.setCaretColor(new java.awt.Color(0, 0, 153));

        tnamahotel.setBackground(new java.awt.Color(204, 255, 255));
        tnamahotel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tnamahotel.setForeground(new java.awt.Color(0, 0, 204));
        tnamahotel.setCaretColor(new java.awt.Color(0, 0, 153));

        tidhotel.setBackground(new java.awt.Color(204, 255, 255));
        tidhotel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tidhotel.setForeground(new java.awt.Color(0, 0, 204));
        tidhotel.setCaretColor(new java.awt.Color(0, 0, 153));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-search-location-24.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttotalinap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tnamahotel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thargahotel)
                            .addComponent(tlamainap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tidhotel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tidhotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tnamahotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(thargahotel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tlamainap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(ttotalinap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 153));
        jLabel19.setText("Kd Transportasi");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 153));
        jLabel20.setText("Nama Transportasi");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 153));
        jLabel21.setText("Harga Transportasi");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 153));
        jLabel22.setText("Durasi/Hari");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 153));
        jLabel23.setText("Total Transportasi");

        totalsewa.setBackground(new java.awt.Color(204, 255, 255));
        totalsewa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        totalsewa.setForeground(new java.awt.Color(0, 0, 204));
        totalsewa.setCaretColor(new java.awt.Color(0, 0, 153));

        tlamasewa.setBackground(new java.awt.Color(204, 255, 255));
        tlamasewa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tlamasewa.setForeground(new java.awt.Color(0, 0, 204));
        tlamasewa.setCaretColor(new java.awt.Color(0, 0, 153));
        tlamasewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tlamasewaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlamasewaKeyTyped(evt);
            }
        });

        thargatrans.setBackground(new java.awt.Color(204, 255, 255));
        thargatrans.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        thargatrans.setForeground(new java.awt.Color(0, 0, 204));
        thargatrans.setCaretColor(new java.awt.Color(0, 0, 153));

        tnmtransportasi.setBackground(new java.awt.Color(204, 255, 255));
        tnmtransportasi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        tnmtransportasi.setForeground(new java.awt.Color(0, 0, 204));
        tnmtransportasi.setCaretColor(new java.awt.Color(0, 0, 153));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih kode" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalsewa, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tnmtransportasi)
                            .addComponent(thargatrans)
                            .addComponent(tlamasewa)
                            .addComponent(jComboBox1, 0, 176, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20))
                    .addComponent(tnmtransportasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(thargatrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tlamasewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(totalsewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 153));
        jLabel24.setText("Kode Wisata");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 153));
        jLabel25.setText("Harga Wisata");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 153));
        jLabel26.setText("Nama Wisata");

        kdwisata.setBackground(new java.awt.Color(204, 255, 255));
        kdwisata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        kdwisata.setForeground(new java.awt.Color(0, 0, 204));
        kdwisata.setCaretColor(new java.awt.Color(0, 0, 153));

        namawisata.setBackground(new java.awt.Color(204, 255, 255));
        namawisata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        namawisata.setForeground(new java.awt.Color(0, 0, 204));
        namawisata.setCaretColor(new java.awt.Color(0, 0, 153));

        thargawisata.setBackground(new java.awt.Color(204, 255, 255));
        thargawisata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        thargawisata.setForeground(new java.awt.Color(0, 0, 204));
        thargawisata.setCaretColor(new java.awt.Color(0, 0, 153));

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 153));
        jLabel27.setText("Total Wisata");

        ttotalwisata.setBackground(new java.awt.Color(204, 255, 255));
        ttotalwisata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));
        ttotalwisata.setForeground(new java.awt.Color(0, 0, 204));
        ttotalwisata.setCaretColor(new java.awt.Color(0, 0, 153));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-search-24.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kdwisata)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttotalwisata, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namawisata)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thargawisata, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(kdwisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namawisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thargawisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(ttotalwisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addContainerGap())
        );

        tblwisata.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblwisata);

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Total Keseluruhan");

        ttotalkeseluruhan.setBackground(new java.awt.Color(204, 255, 255));
        ttotalkeseluruhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 102)));
        ttotalkeseluruhan.setForeground(new java.awt.Color(0, 0, 153));
        ttotalkeseluruhan.setCaretColor(new java.awt.Color(0, 0, 153));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 153));
        jLabel28.setText("Total Bayar");

        ttotalbayar.setBackground(new java.awt.Color(204, 255, 255));
        ttotalbayar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 102)));
        ttotalbayar.setForeground(new java.awt.Color(0, 0, 153));
        ttotalbayar.setCaretColor(new java.awt.Color(0, 0, 153));
        ttotalbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttotalbayarKeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 153));
        jLabel29.setText("Kembali");

        kembali.setBackground(new java.awt.Color(204, 255, 255));
        kembali.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 102)));
        kembali.setForeground(new java.awt.Color(0, 0, 153));
        kembali.setCaretColor(new java.awt.Color(0, 0, 153));

        jButton3.setText("SIMPAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(42, 42, 42)
                        .addComponent(ttotalkeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ttotalkeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(ttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1))
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menu_utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String kode = kdwisata.getText();
            String nama = namawisata.getText();
            int hargab = Integer.parseInt(thargawisata.getText());
            
            tabmode.addRow(new Object[]{kode,nama,hargab});
            tblwisata.setModel(tabmode);
        } catch(Exception e)
        {System.out.println("Error : "+e);
        }
        kdwisata.setText("");
        namawisata.setText("");
        thargawisata.setText(""); 
        hitung();
        biayatotal1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pop_up_pengunjung_wisata Pb = new Pop_up_pengunjung_wisata();
        Pb.pengunjung = this;
        Pb.setVisible(true);
        Pb.setResizable(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
            if ("pilih kode".equals(jComboBox1.getSelectedItem())){
            tnmtransportasi.setText("");
            thargatrans.setText("");
            tlamasewa.setText("");
            totalsewa.setText("");
        }else{
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "SELECT nama_transportasi,harga FROM transportasi WHERE kd_transportasi ='" + jComboBox1.getSelectedItem() + "'";
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
            tnmtransportasi.setText(hasil.getString("nama_transportasi"));
            thargatrans.setText(hasil.getString("harga"));
            }
            tlamasewa.requestFocus();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Pop_up_wisata Pb = new Pop_up_wisata();
        Pb.wisata = this;
        Pb.setVisible(true);
        Pb.setResizable(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Pop_up_hotel Pb = new Pop_up_hotel();
        Pb.hotel = this;
        Pb.setVisible(true);
        Pb.setResizable(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tlamainapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlamainapKeyReleased
                 
        if (tlamainap.getText().equals("") || thargahotel.getText().equals("")) {
        ttotalinap.setText("");
        
        } else {
        int xhrg = Integer.parseInt(thargahotel.getText());
        int xqty = Integer.parseInt(tlamainap.getText());
        int jumlah = xhrg*xqty;
       
        ttotalinap.setText(String.valueOf(jumlah));
        biayatotal();
        }  
        ttotalwisata.setText("");
        totalsewa.setText("");
    }//GEN-LAST:event_tlamainapKeyReleased

    private void tlamasewaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlamasewaKeyReleased
        if (tlamasewa.getText().equals("") || thargatrans.getText().equals("") ) {
        totalsewa.setText("");
        } else {
        int xhrgg = Integer.parseInt(thargatrans.getText());
        int xqtyy = Integer.parseInt(tlamasewa.getText());
        int jumlahh = xhrgg*xqtyy;
       
        totalsewa.setText(String.valueOf(jumlahh));
        biayatotal2();
        }
         ttotalwisata.setText("");
    }//GEN-LAST:event_tlamasewaKeyReleased

    private void tlamainapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlamainapKeyTyped
     FilterAngka(evt);
    }//GEN-LAST:event_tlamainapKeyTyped

    private void tlamasewaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlamasewaKeyTyped
    FilterAngka(evt);
    }//GEN-LAST:event_tlamasewaKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fd =sdf.format(jtgl.getValue());
    String sql = "insert into nota values(?,?,?,?)";
    String asql = "insert into isi_akomodasi values (?,?,?,?,?,?,?,?,?,?,?,?)";
    String zsql = "insert into isi_wisata values (?,?,?)";

    try{
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, idtransaksi.getText());
        stat.setString(2, fd);
        stat.setString(3, tnik.getText());
        stat.setString(4, jLabel3.getText());
        
        stat.executeUpdate();
        
                
        PreparedStatement stat3 = conn.prepareStatement(asql);
        stat3.setString(1, idtransaksi.getText());
        stat3.setString(2, tgl);
        stat3.setString(3, tgl1);
        stat3.setString(4, tnamahotel.getText());
        stat3.setString(5, thargahotel.getText());
        stat3.setString(6, tlamainap.getText());
        stat3.setString(7, ttotalinap.getText());
        stat3.setString(8, tnmtransportasi.getText());
        stat3.setString(9, thargatrans.getText());
        stat3.setString(10, tlamasewa.getText());
        stat3.setString(11, totalsewa.getText());
        stat3.setString(12, ttotalwisata.getText());
 
        stat3.executeUpdate(); 
        
        
        int t = tblwisata.getRowCount();
        for(int i=0; i<t; i++)
        {
            String xkd = tblwisata.getValueAt(i,0).toString();
            String xhrg = tblwisata.getValueAt(i,2).toString();

            
        PreparedStatement stat2 = conn.prepareStatement(zsql);
        stat2.setString(1, idtransaksi.getText());
        stat2.setString(2, xkd);
        stat2.setString(3, xhrg);
        
        stat2.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        cetak();
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "data gagal disimpan");
    }
        aktif();
        autonumber();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ttanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ttanggalPropertyChange
    if (ttanggal.getDate() !=null) {
            tgl = format.format(ttanggal.getDate());
        } 
    }//GEN-LAST:event_ttanggalPropertyChange

    private void ttanggal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ttanggal1PropertyChange
        if (ttanggal1.getDate() !=null) {
            tgl1 = format.format(ttanggal1.getDate());
        }  
    }//GEN-LAST:event_ttanggal1PropertyChange

    private void ttotalbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttotalbayarKeyReleased
          if (ttotalbayar.getText().equals("")) {
        kembali.setText("");
        } else {
        int xtotal = Integer.parseInt(ttotalkeseluruhan.getText());
        int xbayar = Integer.parseInt(ttotalbayar.getText());
        int xkembali = xbayar-xtotal;
        
        kembali.setText(String.valueOf(xkembali));
       
        }       // TODO add your handling code here:
    }//GEN-LAST:event_ttotalbayarKeyReleased

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
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField idtransaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JFormattedTextField kdwisata;
    private javax.swing.JFormattedTextField kembali;
    private javax.swing.JFormattedTextField namawisata;
    private javax.swing.JTable tblwisata;
    private javax.swing.JFormattedTextField thargahotel;
    private javax.swing.JFormattedTextField thargatrans;
    private javax.swing.JFormattedTextField thargawisata;
    private javax.swing.JFormattedTextField tidhotel;
    private javax.swing.JFormattedTextField tlamainap;
    private javax.swing.JFormattedTextField tlamasewa;
    private javax.swing.JFormattedTextField tnama;
    private javax.swing.JFormattedTextField tnamahotel;
    private javax.swing.JFormattedTextField tnik;
    private javax.swing.JFormattedTextField tnmtransportasi;
    private javax.swing.JFormattedTextField totalsewa;
    private com.toedter.calendar.JDateChooser ttanggal;
    private com.toedter.calendar.JDateChooser ttanggal1;
    private javax.swing.JFormattedTextField ttotalbayar;
    private javax.swing.JFormattedTextField ttotalinap;
    private javax.swing.JFormattedTextField ttotalkeseluruhan;
    private javax.swing.JFormattedTextField ttotalwisata;
    // End of variables declaration//GEN-END:variables

}
