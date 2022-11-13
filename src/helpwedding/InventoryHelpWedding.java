package helpwedding;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;

public class InventoryHelpWedding{
	public static void main(String[] args) {
		
		System.out.println("=====================================================");
		System.out.println("Selamat Datang Di Help Wedding");
		DateFormat formatTanggal = new SimpleDateFormat(" E, dd-MMM-yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatTanggal.format(date));
		System.out.println("=====================================================");
        System.out.println("\n");
        
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        
        Main:while(true){
            System.out.println("==++ Selamat Datang Di HelpWedding ++==");
            System.out.println("1.Masuk Sebagai Admin");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan : ");
            int pilihan = input.nextInt();
            
            if(pilihan == 1){
                System.out.println("Silahkan masukkan username dan password");
                System.out.print("Masukkan username : ");              
                String username = input.next();      
                
                System.out.print("Masukkan password : ");
                String password = input.next();
                if(admin.login(username, password) == 1){
                    while(true){

                        pilihan = 0;
                        System.out.println("\n\n |||=== Selamat Datang Admin HelpWedding  ===|||");
                        System.out.println("1.Lihat Daftar Layanan");
                        System.out.println("2.Edit Data Layanan");
                        System.out.println("3.Lihat Daftar Pemesanan");
                        System.out.println("4.Input Data Pemesanan");
                        System.out.println("5.Edit Data Pemesanan");
                        System.out.println("6.Hapus Data Pemesanan");
                        System.out.println("7.Form Pembayaran");
                        System.out.println("8.Melakukan Pembayaran");
                        System.out.println("9.Validasi Pembayaran");
                        System.out.println("10.Riwayat Pembayaran");
                        System.out.println("11.Kembali ke menu utama");
                        
                        System.out.print("Masukkan pilihan : ");
                        pilihan = input.nextInt();
                        
                        if(pilihan == 1){
                            System.out.println("==================================================== Daftar Layanan ===============================================");
                            System.out.println("id Opsi \tNama Layanan \t\tNama Opsi \t\t\t\t\tHarga Opsi \tStok Layanan");
                        	System.out.println("=====================================================================================================================");
                            (new DataLayanan()).getAllLayanan();
                        }
                        
                        else if(pilihan == 2){
                        	(new DataLayanan()).updateLayanan("G001","G001","Gedung","Kapasitas 1000 orang yang dilengkapi  area  parkir\t",50000000,4);
                        }
                        
                        else if(pilihan == 3){
                        	System.out.println("==================================================== Daftar Pemesanan ===============================================");
                        	System.out.println("id Pesanan \tNama Client \t\tid Opsi \tTanggal Pesanan \tTanggal Pesta\t\tAlamat");
                        	System.out.println("=====================================================================================================================");
                        	(new Pemesanan()).melihatDaftarpesanan();
                        }
                        
                        else if(pilihan == 4){
                        	System.out.println("Menu Input pemesanan");

                        	Scanner sc = new Scanner(System.in);

                        	System.out.print("Masukkan Tanggal Pemesanan(Format yyyy-MM-dd): ");
                        	String tanggalPesanan = sc.next();

                        	System.out.print("Masukkan Tanggal Pesta(Format yyyy-MM-dd): ");
                        	String tanggalPesta = sc.next();

                        	LocalDate awal = LocalDate.parse(tanggalPesanan);
                        	LocalDate akhir = LocalDate.parse(tanggalPesta);


                        	System.out.println(awal);
                        	System.out.println(akhir);

                        	Period jumlahHari = Period.between(awal, akhir);

                        	System.out.printf("\nRentang waktu = %d tahun, %d bulan dan %d hari \n\n", 
                        	jumlahHari.getYears(), jumlahHari.getMonths(), jumlahHari.getDays());
                        	    
                        	    if( jumlahHari.getMonths() > 1 ) {
                        	        System.out.println("Pemesanan dapat dilanjutkan");
                        	        
                        	        System.out.print("Masukkan ID Pesanan: ");
                        	        String idPesanan = sc.next();

                        	        System.out.print("Masukkan Nama Client: ");
                        	        String namaClient = sc.next();
                        	        
                        	          System.out.print("Masukkan ID Opsi: ");
                        	        String idOpsi = sc.next();

                        	        System.out.print("Masukkan Alamat: ");
                        	        String alamat = sc.next();
                        	         
                        	        
                        	        (new Pemesanan()).melakukanPemesanan(idPesanan,namaClient,idOpsi,tanggalPesanan,tanggalPesta,alamat);     
                        	        
                        	    }
                        	    else if (jumlahHari.getYears() >= 1){
                        	        System.out.println("Pemesanan dapat dilanjutkan");
                        	        
                        	        System.out.print("Masukkan ID Pesanan: ");
                        	        String idPesanan = sc.next();

                        	        System.out.print("Masukkan Nama Client: ");
                        	        String namaClient = sc.next();
                        	        
                        	         System.out.print("Masukkan ID Opsi: ");
                        	        String idOpsi = sc.next();

                        	        System.out.print("Masukkan Alamat: ");
                        	        String alamat = sc.next();
                        	       

                        	        (new Pemesanan()).melakukanPemesanan(idPesanan,namaClient,idOpsi,tanggalPesanan,tanggalPesta,alamat);
                        	    }
                        	    
                        	    else {
                        	        System.out.println("Maaf, Pemesanan paling lama dilakukan 2 bulan sebelum pesta dilakukan");
                        	    }    	
                        }
                        
                        else if(pilihan == 5){
                        	  System.out.println("Menu Edit pemesanan");

                              Scanner sc = new Scanner(System.in);

                              System.out.print("Masukkan ID PesananLama: ");
                              String idPesananLama = sc.next();

                              System.out.print("Masukkan ID PesananBaru: ");
                              String idPesananBaru = sc.next();

                              System.out.print("Masukkan Nama Client: ");
                              String namaClient = sc.next();
                              
                              System.out.print("Masukkan ID Opsi: ");
                              String idOpsi = sc.next();
                              
                              System.out.print("Masukkan Tanggal Pemesanan: ");
                              String tanggalPesanan = sc.next();

                              System.out.print("Masukkan Tanggal Pesta: ");
                              String tanggalPesta = sc.next();

                              System.out.print("Masukkan Alamat: ");
                              String alamat = sc.next();
                              
                              (new Pemesanan()).mengubahPemesanan(idPesananLama,idPesananBaru,namaClient,idOpsi,tanggalPesanan,tanggalPesta,alamat);     	
                        }
                        
                        else if(pilihan == 6){
                        	System.out.println("Menu Hapus Pemesanan");
                            Scanner sc = new Scanner(System.in);

                            System.out.print("Masukkan ID Pesanan yang akan dihapus: ");
                            String idPesanan = sc.next();
                            
                            (new Pemesanan()).menghapusPemesanan(idPesanan);     	
                        }
                        
                        else if(pilihan == 7){
                        	Scanner sc = new Scanner(System.in);
                        	System.out.println("Masukkan nama client: ");
                        	String namaClient = sc.next();
                        	System.out.println("============================");
                        	System.out.println("id Opsi \tHarga Opsi ");
                        	System.out.println("============================");
                        	(new Pembayaran()).melihatHargaPesananClient(namaClient);
                    		(new Pembayaran()).totalpembayaran(namaClient);
                    		(new Pembayaran()).PembayaranUangMuka(namaClient);
                    		(new Pembayaran()).PembayaranKedua(namaClient);
                    		(new Pembayaran()).Pelunasan(namaClient);
                        	       	
                        }
                        
                        else if(pilihan == 8){
                        	Scanner sc = new Scanner(System.in);
                        	System.out.print("Masukkan ID Pesanan: ");
                	        String idPesanan = sc.next();

                	        System.out.print("Masukkan Nama Client: ");
                	        String namaClient = sc.next();
                	        
                	          System.out.print("Masukkan Subtotal: ");
                	        int subtotal = sc.nextInt();

                	        System.out.print("Masukkan Jenis Pembayaran: ");
                	        String jenis_pembayaran = sc.next();
                	        
                	        System.out.print("Masukkan tanggal_pembayaran: ");
                	        String tanggal_pembayaran = sc.next();
                	        
                	        (new Pembayaran()).melakukanPembayaran(idPesanan,namaClient,subtotal,jenis_pembayaran,tanggal_pembayaran);
                        	
                        	
                        }
                        
                        else if(pilihan == 9){
                        	Pembayaran pembayaran = new Pembayaran();
                    		pembayaran.validasiPembayaran(pembayaran);
                        	
                        } 
                        
                        else if(pilihan == 10){
                        	System.out.println("==================================================== Riwayat Pembayaran ===============================================");
                        	System.out.println("id Pesanan \tNama Client \t\tSubtotal \tJenis Pembayaran \tTanggal Pembayaran");
                        	System.out.println("=======================================================================================================================");
                        	(new Pembayaran()).melihatRiwayatPembayaran();
                        }
                        
                        else if(pilihan == 11){
                        	continue Main;
                        }
            
                        
                    }
                } 
                
            }
            
            else if (pilihan == 0) {
            System.out.println("Terimakasih sudah berkunjung ");
            System.exit(0);
        }
            else {
            	System.out.println("Pilihan Anda Salah!!");
            }
	}
	
}
}