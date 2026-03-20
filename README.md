# Sistem Transaksi Swalayan Tiny

## Deskripsi Program

Program ini merupakan implementasi sistem transaksi sederhana pada sebuah swalayan bernama **Tiny** yang dibuat menggunakan bahasa pemrograman Java. Program ini dirancang untuk memenuhi kebutuhan transaksi pelanggan seperti pembelian dan top up saldo dengan menerapkan konsep **Object-Oriented Programming (OOP)**, khususnya **enkapsulasi (encapsulation)**.

## Tujuan
* Memahami konsep enkapsulasi dalam OOP
* Mengimplementasikan pembatasan akses data menggunakan atribut `private`
* Membuat sistem autentikasi sederhana menggunakan nomor pelanggan dan PIN
* Mengelola transaksi pembelian dan top up saldo

## Struktur Program

Program terdiri dari dua class utama:
### 1. `Pelanggan`
Class ini merupakan inti dari program yang menyimpan dan mengelola data pelanggan.
**Atribut:**
* `nama` → nama pelanggan
* `nomorPelanggan` → ID pelanggan (10 digit)
* `pin` → PIN untuk autentikasi
* `saldo` → saldo pelanggan
* `diblokir` → status akun (true/false)
* `jumlahSalahPIN` → jumlah kesalahan input PIN

**Method:**
* `autentikasi()` → validasi nomor pelanggan dan PIN
* `beli()` → melakukan transaksi pembelian
* `topUp()` → menambah saldo
* `lihatSaldo()` → menampilkan saldo
* `hitungCashback()` → menghitung cashback (private)
* `jenisRekening()` → menentukan jenis pelanggan (private)

### 2. `Main`
Class ini digunakan untuk menjalankan program dan menyediakan menu interaktif bagi pengguna.
## Fitur Utama

###  1. Enkapsulasi
Semua atribut pada class `Pelanggan` dibuat `private` sehingga tidak dapat diakses langsung dari luar class.
###  2. Autentikasi
Setiap transaksi memerlukan:
* Nomor pelanggan
* PIN
Jika terjadi kesalahan sebanyak 3 kali, akun akan diblokir.

### 3. Jenis Pelanggan & Cashback

| Kode | Jenis    | Cashback > 1jt | Cashback ≤ 1jt |
| ---- | -------- | -------------- | -------------- |
| 38   | Silver   | 5%             | 0%             |
| 56   | Gold     | 7%             | 2%             |
| 74   | Platinum | 10%            | 5%             |

###  4. Validasi Saldo
* Saldo minimal setelah transaksi: **Rp10.000**
* Jika kurang dari batas tersebut → transaksi gagal

###  5. Fitur Transaksi
* Pembelian barang
* Top up saldo
* Lihat saldo

## Cara Menjalankan Program

1. Compile semua file:

   ```
   javac Pelanggan.java Main.java
   ```

2. Jalankan program:

   ```
   java Main
   ```


## 🖥️ Contoh Output

 ```
=================================
     SISTEM SWALAYAN TINY
=================================
Selamat datang, Nanaa

----------- MENU -----------
1. Pembelian
2. Top Up
3. Lihat Saldo
0. Keluar
----------------------------
```

## Konsep yang Digunakan

* Enkapsulasi (Encapsulation)
* Class dan Object
* Method
* Conditional (if-else, switch)
* Validasi input--

## Kesimpulan

Program ini menunjukkan penerapan konsep enkapsulasi dalam OOP dengan membatasi akses langsung ke data dan menyediakan method sebagai penghubung untuk berinteraksi dengan objek. Sistem ini juga dilengkapi dengan fitur autentikasi, validasi saldo, serta perhitungan cashback sehingga dapat mensimulasikan transaksi sederhana pada swalayan.

