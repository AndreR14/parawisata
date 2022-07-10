/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.*;

public class koneksi {

    private Connection koneksi;

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil koneksi");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal koneksi" + ex);

        }
        String url = "jdbc:mysql://localhost:3306/pariwisata";
        try {
            koneksi = (Connection) DriverManager.getConnection(url, "root", "");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return koneksi;
    }

}
