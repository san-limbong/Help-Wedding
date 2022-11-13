# 2021-project-02-help-wedding
# Help-Wedding

Help wedding merupakan sebuah aplikasi yang bertujuan untuk menyediakan keperluan
untuk pesta pernikahan. Dimana aplikasi ini akan membantu menentukan kebutuhan
penyelenggaraan acara pernikahan dengan memperoleh berbagai informasi sekaligus melakukan
pemesanan gedung, tata rias ,makanan,dan dekorasi. Help wedding akan memberikan kebebasan
untuk klien agar dapat memilih beberapa opsi yang disediakan sesuai dengan yang diinginkan oleh
klien agar klien dapat menyesuaikan dengan budget yang dimilikinya.
Aplikasi ini akan menyediakan 4 kategori yaitu :
1. Layanan gedung menyediakan 3 opsi , diantara lain:
• 1000 orang dengan area parkir
• 800 orang dengan area parkir
• 500 orang tanpa area parkir
2. Layanan tata rias disediakan 4 opsi , diantara lain:
• Untuk pengantin dan keluarga, bunga melati, dan bouquet bunga hidup
• Untuk pengantin dan keluarga, bunga melati dan bouquet bunga plastik
• Untuk pengantin, bunga melati full dan bouquet bunga hidup
• Untuk pengantin, bunga melati dan bouquet bunga plastik
3. Layanan penyediaan makanan tersedia 3 opsi , diantara lain:
• 800 tradisional + 200 nasional
• 600 tradisional + 200 nasional
• 300 tradisional + 200 nasional
4. Layanan dekorasi pelaminan menyediakan 2 opsi , diantara lain:
• Pelaminan dengan Full Bunga Hidup
• Pelaminan dengan Full Bunga Plastik

Untuk dapat berinteraksi dengan sistem, Admin harus melakukan login terlebih dahulu dengan menginput 
username: admin
password: login123
Setelah melakukan login , admin dapat memilih menu yang ada pada sistem seperti :

Lihat Daftar Layanan
Menu ini akan menampilkan daftar layanan berupa idOpsi,namaOpsi, nama
layanan, harga opsi, dan stok layanan.
• Edit Data Layanan
Pada menu ini admin dapat melakukan edit data layanan seperti memperbaharui
stok layanan apabila ada yang melakukan pemesanan.
• Lihat Daftar Pemesanan
Menu ini akan menampilkan daftar client yang melakukan pemesanan. Atribut
yang ditampilkan berupa idPesanan, nama klien, idOpsi, tanggal pesanan,tanggal
pesta , dan alamat.
• Input Data Pemesanan
Pada menu ini admin menginput data apabila ada client yang ingin melakukan
pemesanan. Apabila client ingin melakukan pemesanan, maka admin akan terlebih
dahulu menginput tanggal pesanan setelah itu menginput tanggal pesta. Apabila
tanggal pesta ke tanggal pesanan rentang nya kurang dari 2 bulan maka client tidak
dapat melakukan pemesanan , sebaliknya apabila rentang waktunya lebih dari 2
bulan maka client dapat melakukan pemesanan. Atribut yang diminta sistem pada
menu ini berupa idPesanan,nama klien,idOpsi, tanggal pesanan,tanggal pesta dan
alamat.
• Edit Data Pemesanan
Pada menu ini, admin dapat mengganti informasi berupa atribut yang ada pada data
pemesanan dari client dengan menggunakan idPesanan sebagai pengenal masing
masing informasi dari client.
• Menghapus Data Pemesanan
Pada menu ini ,apabila admin salah menginput data pesanan maka admin dapat
memilih menu ini dan melakukan penghapusan data pesanan client dengan
menggunakan idPesanan sebagai pengenal masing masing informasi dari client.
• Form Pembayaran
Pada menu ini, setelah melakukan pemesanan, sistem akan menampilkan total
biaya pemesanan dan akan menghitung 25% dari total harga sebagai uang muka
yang harus dibayar langsung. Pembayaran kedua sebesar 25% dibayarkan 1 bulan
setelah pembayaran uang muka pertama, pelunasan paling lambat 14 hari sebelum
pesta. Admin akan menginput nama client kemudian sistem akan menampilkan
masing-masing idopsi, harga pembayaran, jumlah uang muka , jumlah pembayaran
kedua, dan jumlah pelunasan yang harus dibayar. Form pembayaran ini akan
diberikan kepada client dalam bentuk nota . Dimana isi dari nota berupa nama
client, id pesanan dan subtotal.
• Melakukan Pembayaran
Pada menu ini, apabila client ingin membayar pesanan maka admin akan
memasukkan id pesanan, nama client, subtotal, tanggal pembayaran, dan jenis
pembayaran. Dimana jenis pembayaran ada 3 , pembayaran uang muka,
pembayaran kedua setelah uang muka dibayar, dan terakhir pelunasan.
• Validasi pembayaran
Pada menu ini, setelah client selesai membayar, admin akan mengisi form seperti
struk pembayaran dan struk pembayaran ini akan diberikan kepada client sebagai
bukti bahwa client telah berhasil melakukan pembayaran.
• Riwayat pembayaran
Pada menu ini, sistem akan menampilkan riwayat daftar dari semua pembayaran
yang berupa id pesanan , nama client, subtotal, jenis pembayaran, dan tanggal
pembayaran.
