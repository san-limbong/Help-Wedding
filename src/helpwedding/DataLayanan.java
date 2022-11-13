package helpwedding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DataLayanan {

    private String namaLayanan;
    private String idOpsi; 
    private String namaOpsi;
    private Double hargaOpsi;
    private Integer stokLayanan;

  
    // Constructor with a parameter
    public DataLayanan (){
        this.namaLayanan = namaLayanan;
        this.idOpsi = idOpsi;
        this.namaOpsi = namaOpsi;
        this.hargaOpsi = hargaOpsi;
        this.stokLayanan = stokLayanan;

    }

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
     

    //fungsi untuk melihat semua DaftarLayanan ke dalam database
    public void getAllLayanan(){ 
        String query = "Select * From Layanan";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println( rs.getString("idOpsi") + "\t\t"
                        + rs.getString("namaLayanan") + "  " + "\t"
                        + rs.getString("namaOpsi") + "   " + " " + "\t" 
                        + rs.getInt("hargaOpsi") + "  "+ "\t"
                        + rs.getInt("stokLayanan"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    
     //fungsi untuk memperbaharui data Layanan setelah dilakukan pemesanan

    public void updateLayanan(String idOpsiLama, String idOpsiBaru, String namaLayanan, String namaOpsi, double hargaOpsi, int stokLayanan) {
        String query = "update Layanan set idOpsi = ?, namaLayanan = ?, namaOpsi =?, hargaOpsi =?, stokLayanan = ?  where idOpsi = ?";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, idOpsiBaru);
            stmt.setString(2, namaLayanan);
            stmt.setString(3, namaOpsi);
            stmt.setDouble(4, hargaOpsi);
            stmt.setInt(5, stokLayanan);
            stmt.setString(6, idOpsiLama);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}