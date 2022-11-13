package helpwedding;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Pemesanan {
    private String idPesanan;
    private String namaClient;
    private String idOpsi;
    private String tanggalPesanan;
    private String tanggalPesta;
    private String alamat;
   
    
    //Melakukan koneksi ke database
    public Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:F:/Semester 4/PBO/Praktikum/2021-project-02-help-wedding/Layanan.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connect;
    }
    
  //fungsi untuk melihat data dalam database
    public void melihatDaftarpesanan() {
        String query = "Select * from pemesanan";
        try {
            Connection connect = this.connect(); //Memanggil method koneksi yang sebelumnya didefenisikan
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("idPesanan") + "\t\t"
                        + rs.getString("namaClient") + "\t\t\t"
                        + rs.getString("idOpsi") + "\t\t"
                        + rs.getString("tanggalPesanan") + "\t\t"
                        + rs.getString("tanggalPesta") + "\t\t"
                        + rs.getString("alamat"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
  //fungsi untuk menambahkan data ke dalam database
    public void melakukanPemesanan(String idPesanan, String namaClient, String idOpsi, String tanggalPesanan, String tanggalPesta, String alamat) {
        String query = "insert into pemesanan values(?,?,?,?,?,?)";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, idPesanan);
            stmt.setString(2, namaClient);
            stmt.setString(3, idOpsi);
            stmt.setString(4, tanggalPesanan);
            stmt.setString(5, tanggalPesta);
            stmt.setString(6, alamat);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }     
    
   //fungsi untuk mengubah data pemesanan
     public void mengubahPemesanan(String idPesananLama, String idPesananBaru, String namaClient, String idOpsi, String tanggalPesanan, String tanggalPesta, String alamat) {
         String query = "update pemesanan set idPesanan = ?, namaClient = ?, idOpsi =?, tanggalPesanan =?, tanggalPesta =?, alamat =?  where idPesanan = ?";
         try {
             Connection connect = this.connect();
             PreparedStatement stmt = connect.prepareStatement(query);
             stmt.setString(1, idPesananBaru);
             stmt.setString(2, namaClient);
             stmt.setString(3, idOpsi);
             stmt.setString(4, tanggalPesanan);
             stmt.setString(5, tanggalPesta);
             stmt.setString(6, alamat);
             stmt.setString(7, idPesananLama);
             stmt.executeUpdate();
         } catch (Exception e) {
             System.out.println(e);
         }
     }
    
   //fungsi untuk menghapus salah satu data pemesanan berdasarkan idPesanan
     public void menghapusPemesanan(String idPesanan) {
         String query = "delete from pemesanan where idPesanan =?";
         try {
             Connection connect = this.connect();
             PreparedStatement stmt = connect.prepareStatement(query);
             stmt.setString(1, idPesanan);
             stmt.executeUpdate();
         } catch (Exception e) {
             System.out.println(e);
         }
     }
}
