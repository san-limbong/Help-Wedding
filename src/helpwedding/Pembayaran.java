package helpwedding;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Pembayaran {
	private String idPesanan;
    private String namaKlien;
    private Integer subtotal;
    private String jenis_pembayaran;
    private String tanggal_pembayaran;

    
    //mengkoneksikan ke database
    public Connection connect() {
       
        Connection connect = null;
        try { 
            connect = DriverManager.getConnection("jdbc:sqlite:F:/Semester 4/PBO/Praktikum/2021-project-02-help-wedding/Layanan.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connect;
    }

    //fungsi untuk mendapatkan semua id Opsi dan harga Opsi yang dipesan oleh client dengan nama client = ...
    public void melihatHargaPesananClient(String namaClient) {
        String query = "SELECT * FROM  pemesanan  NATURAL JOIN layanan WHERE namaClient = ?";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, namaClient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("idOpsi") + "\t\t"
                		          +rs.getInt("hargaOpsi"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //fungsi untuk mendapatkan total harga yang harus dibayar oleh client
    public void totalpembayaran(String namaClient){
    	String query = "SELECT sum(hargaOpsi) FROM  pemesanan  NATURAL JOIN layanan WHERE namaClient = ? ";
    	int sum = 0;
        try { 
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, namaClient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int c = rs.getInt(1);
                sum = sum + c;
              }
              System.out.println("Total Pembayaran = " + sum);
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
  //fungsi untuk mendapatkan jumlah uang muka sebesar 25% dari total yang harus dibayar oleh client setelah melakukan pemesanan
    public void PembayaranUangMuka(String namaClient){
        String query = "SELECT sum(hargaOpsi) FROM  pemesanan  NATURAL JOIN layanan WHERE namaClient = ?";
        int sum = 0;
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, namaClient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int c = rs.getInt(1);
                sum = sum + c;
              }
              System.out.println("Uang muka yang harus dibayar : " + (sum*25)/100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //fungsi untuk mendapatkan jumlah uang pembayaran kedua sebesar 25% setelah 1 bulan membayar uang muka.
    public void PembayaranKedua(String namaClient){
    	String query = "SELECT sum(hargaOpsi) FROM  pemesanan  NATURAL JOIN layanan WHERE namaClient = ?";
        int sum = 0;
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, namaClient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int c = rs.getInt(1);
                sum = sum + c;
              }
              System.out.println("Cicilan yang harus dibayar setelah 1 bulan pembayaran uangmuka = " + ((sum-(sum*25)/100)*25)/100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //fungsi untuk mendapatkan jumlah uang yang harus dilunaskan 14 hari sebelum pesta berlangsung.
    public void Pelunasan(String namaClient){
    	String query = "SELECT sum(hargaOpsi) FROM  pemesanan  NATURAL JOIN layanan WHERE namaClient = ?";
        int sum = 0;
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, namaClient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int c = rs.getInt(1);
                sum = sum + c;
              }
              System.out.println("Sisa dari uang muka dan cicilan kedua yang harus dilunaskan 14 hari sebelum pesta = " 
              + (sum - ((sum*25)/100 + ((sum-(sum*25)/100)*25)/100)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    //fungsi untuk melakukan validasi pembayaran, hasilnya akan berupa struk pembayaran yang akan diberikan kepada client.
    public void validasiPembayaran(Pembayaran date){
    
        Scanner scan = new Scanner (System.in);
        System.out.print("Masukkan nama klien  : ");
        String namaClient = scan.next();  
        System.out.print("Masukkan id Pesanan : ");
        String idPesanan = scan.next();   
        System.out.print("Masukkan subtotal  : ");
        Integer subtotal = scan.nextInt(); 
        System.out.print("Masukkan jenis pembayaran :");
        String jenis_pembayaran = scan.next();
        System.out.println("Nama klien		    : "+namaClient);  
        System.out.println("Id Pesanan		    : "+idPesanan);  
        System.out.println("Subtotal		    : "+subtotal);  
        System.out.println("Jenis pembayaran    : "+jenis_pembayaran);
        System.out.println("Tanggal Pembayaran	: "+date.getTanggal()); 
}
    
   
  //fungsi untuk menambahkan pembayaran
    public void melakukanPembayaran(String idPesanan, String namaClient, int subtotal, String jenis_pembayaran, String tanggal_pembayaran) {
        String query = "insert into pembayaran values(?,?,?,?,?)";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, idPesanan);
            stmt.setString(2, namaClient);
            stmt.setInt(3, subtotal);
            stmt.setString(4, jenis_pembayaran);
            stmt.setString(5, tanggal_pembayaran);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //fungsi untuk melihat riwayat pembayaran
    public void melihatRiwayatPembayaran() {
        String query = "Select * from pembayaran";
        try {
            Connection connect = this.connect(); //Memanggil method koneksi yang sebelumnya didefenisikan
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("idPesanan") + "\t\t"
                        + rs.getString("namaClient") + "\t\t\t"
                        + rs.getInt("subtotal") + "\t\t"
                        + rs.getString("jenis_pembayaran") + "\t\t"
                        + rs.getString("tanggal_pembayaran"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    String getTanggal(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
          Date date = new Date();  
          return dateFormat.format(date);
     }   
      
    }