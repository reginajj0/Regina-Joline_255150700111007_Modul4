package SwalayanTiny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pelanggan p = new Pelanggan(
            "Nanaa",               // nama pelanggan
            "749112007",   // nomor pelanggan
            "1234",                 // PIN
            2000000               // saldo awal
        );

        System.out.println("=================================");
        System.out.println("     SISTEM SWALAYAN TINY");
        System.out.println("=================================");
        System.out.println("Selamat datang, " + p.getNama());

        while (true) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Pembelian");
            System.out.println("2. Top Up");
            System.out.println("3. Lihat Saldo");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = input.nextInt();

            if (pilih == 0) {
                System.out.println("Terima kasih telah menggunakan sistem:)");
                break;
            }

            System.out.print("Masukkan nomor pelanggan:");
            String no = input.next();

            System.out.print("Masukkan PIN:");
            String pin = input.next();

            if (!p.autentikasi(no, pin)) continue;

            switch (pilih) {
                case 1 -> {
                    System.out.print("Masukkan nominal pembelian: ");
                    double jumlah = input.nextDouble();
                    p.beli(jumlah);
                }
                case 2 -> {
                    System.out.print("Masukkan nominal top up: ");
                    double jumlah = input.nextDouble();
                    p.topUp(jumlah);
                }
                case 3 -> {
                    System.out.println("\n--- INFO SALDO ---");
                    System.out.println("Nama  : " + p.getNama());
                    System.out.println("Saldo : Rp " + p.lihatSaldo());
                }
                default -> System.out.println("Menu tidak tersedia!");
            }
        }

        input.close();
    }
}
