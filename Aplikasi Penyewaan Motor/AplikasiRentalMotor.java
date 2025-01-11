import java.util.*;
import java.util.Scanner;

public class AplikasiRentalMotor {
    private List<Motor> daftarMotor = new ArrayList<>();
    private List<TransaksiRental> daftarTransaksi = new ArrayList<>();

    public void tambahMotor(Motor motor) {
        daftarMotor.add(motor);
    }

    public void tampilkanMotorTersedia() {
        for (Motor motor : daftarMotor) {
            if (motor.isTersedia()) {
                System.out.println(motor);
            }
        }
    }

    public Motor cariMotorBerdasarkanRegistrasi(String nomorRegistrasi) {
        for (Motor motor : daftarMotor) {
            if (motor.getNomorRegistrasi().equals(nomorRegistrasi)) {
                return motor;
            }
        }
        return null;
    }

    public void sewaMotor(Pelanggan pelanggan, String nomorRegistrasi, int hari) {
        Motor motor = cariMotorBerdasarkanRegistrasi(nomorRegistrasi);
        if (motor != null && motor.isTersedia()) {
            motor.setTersedia(false);
            TransaksiRental transaksi = new TransaksiRental(pelanggan, motor, hari);
            daftarTransaksi.add(transaksi);
            System.out.println("Rental berhasil: " + transaksi);
        } else {
            System.out.println("Motor tidak tersedia atau tidak ditemukan.");
        }
    }

    public void mulai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Aplikasi Rental Motor");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Motor yang Tersedia");
            System.out.println("2. Sewa Motor");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.println("\nMotor Tersedia:");
                    tampilkanMotorTersedia();
                    break;
                case 2:
                    System.out.print("Masukkan nama Anda: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan kontak Anda: ");
                    String kontak = scanner.nextLine();
                    System.out.print("Masukkan nomor SIM Anda: ");
                    String nomorSIM = scanner.nextLine();
                    Pelanggan pelanggan = new Pelanggan(nama, kontak, nomorSIM);

                    System.out.print("Masukkan nomor registrasi motor: ");
                    String nomorRegistrasi = scanner.nextLine();
                    System.out.print("Masukkan jumlah hari sewa: ");
                    int hari = scanner.nextInt();

                    sewaMotor(pelanggan, nomorRegistrasi, hari);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan Aplikasi Rental Motor!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void main(String[] args) {
        AplikasiRentalMotor app = new AplikasiRentalMotor();

        // Menambahkan motor ke inventaris
        app.tambahMotor(new Matic("S001", "Honda Beat", 110, 50));
        app.tambahMotor(new SportBike("SB001", "Yamaha R15", 155, 150));
        app.tambahMotor(new SuperBike("C001", "Harley Davidson", 883, 300));

        app.mulai();
    }
}
