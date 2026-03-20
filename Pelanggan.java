package SwalayanTiny;

public class Pelanggan {
    private String nama;
    private String nomorPelanggan;
    private String pin;
    private double saldo;
    private boolean diblokir = false;
    private int jumlahSalahPIN = 0;

    //constructor
    public Pelanggan(String nama, String nomorPelanggan, String pin, double saldo) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
        this.pin = pin;
        this.saldo = saldo;
    }

    //getter nama
    public String getNama() {
        return nama;
    }
    
    //getter saldo
    public double lihatSaldo() { 
        return saldo; 
    }

    //cek status blokir
    public boolean isDiblokir() { 
        return diblokir; 
    }

    //menentukan jenis rekening berdasarkan 2 digit awal
    private String jenisRekening() {
        String prefix = nomorPelanggan.substring(0, 2);
        return switch (prefix) {
            case "38" -> "silver";
            case "56" -> "gold";
            case "74" -> "platinum";
            default -> "tidak diketahui";
        };
    }

    // hitung cashback
    private double hitungCashback(double jumlah) {
        String jenis = jenisRekening();

        if (jumlah > 1_000_000) {
            return switch (jenis) {
                case "silver" -> 0.05;
                case "gold" -> 0.07;
                case "platinum" -> 0.10;
                default -> 0;
            };
        } else {
            return switch (jenis) {
                case "gold" -> 0.02;
                case "platinum" -> 0.05;
                default -> 0;
            };
        }
    }

    //autentikasi pelanggan
     public boolean autentikasi(String inputNo, String inputPin) {
        if (diblokir) {
            System.out.println("Akun diblokir!");
            return false;
        }

        if (this.nomorPelanggan.equals(inputNo) && this.pin.equals(inputPin)) {
            jumlahSalahPIN = 0;
            return true;
        } else {
            jumlahSalahPIN++;
            System.out.println("Autentikasi gagal!");

            if (jumlahSalahPIN >= 3) {
                diblokir = true;
                System.out.println("Akun diblokir karena salah PIN sebanyak 3 kali!");
            }
            return false;
        }
    }

    //transaksi pembelian
    public boolean beli(double jumlahPembelian) {
        if (diblokir) {
            System.out.println("Akun diblokir. Tidak dapat transaksi.");
            return false;
        }

        if (jumlahPembelian <= 0) {
            System.out.println("Nominal tidak valid!");
            return false;
        }

        if (saldo - jumlahPembelian < 10000) {
            System.out.println("Transaksi gagal! Saldo minimal Rp10.000.");
            return false;
        }

        saldo -= jumlahPembelian;

        double cashback = jumlahPembelian * hitungCashback(jumlahPembelian);
        saldo += cashback;

        System.out.println("Pembelian berhasil!");
        System.out.println("Cashback: Rp " + cashback);
        System.out.println("Saldo sekarang: Rp " + saldo);

        return true;
    }

    //top up saldo
    public void topUp(double jumlah) {
        if (diblokir) {
            System.out.println("Akun diblokir. Tidak dapat top up.");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Nominal tidak valid!");
            return;
        }

        saldo += jumlah;
        System.out.println("Top up berhasil!");
        System.out.println("Saldo sekarang: Rp " + saldo);
    }
}
