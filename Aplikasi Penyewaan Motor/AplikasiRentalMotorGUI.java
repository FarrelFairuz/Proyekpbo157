// File: AplikasiRentalMotorGUI.java

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AplikasiRentalMotorGUI {
    private List<Motor> daftarMotor = new ArrayList<>();
    private JFrame frame;
    private JTable tableMatic, tableSportBike, tableSuperBike;
    private DefaultTableModel modelMatic, modelSportBike, modelSuperBike;

    public AplikasiRentalMotorGUI() {
        // Setup GUI
        frame = new JFrame("Aplikasi Rental Motor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel atas untuk tombol
        JPanel panelAtas = new JPanel();
        JButton btnTampilkanMotor = new JButton("Tampilkan Semua Motor");
        JButton btnSewaMotor = new JButton("Sewa Motor");
        JButton btnKeluar = new JButton("Keluar");
        panelAtas.add(btnTampilkanMotor);
        panelAtas.add(btnSewaMotor);
        panelAtas.add(btnKeluar);

        // JTabbedPane untuk tabel
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tabel Matic
        modelMatic = new DefaultTableModel(new String[]{"Nomor Registrasi", "Model", "Kapasitas Mesin", "Harga Sewa", "Tersedia"}, 0);
        tableMatic = new JTable(modelMatic);
        tabbedPane.addTab("Matic", new JScrollPane(tableMatic));

        // Tabel SportBike
        modelSportBike = new DefaultTableModel(new String[]{"Nomor Registrasi", "Model", "Kapasitas Mesin", "Harga Sewa", "Tersedia"}, 0);
        tableSportBike = new JTable(modelSportBike);
        tabbedPane.addTab("SportBike", new JScrollPane(tableSportBike));

        // Tabel SuperBike
        modelSuperBike = new DefaultTableModel(new String[]{"Nomor Registrasi", "Model", "Kapasitas Mesin", "Harga Sewa", "Tersedia"}, 0);
        tableSuperBike = new JTable(modelSuperBike);
        tabbedPane.addTab("SuperBike", new JScrollPane(tableSuperBike));

        // Tambahkan panel dan tabbed pane ke frame
        frame.add(panelAtas, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Action listeners
        btnTampilkanMotor.addActionListener(e -> updateTabelMotor());
        btnSewaMotor.addActionListener(e -> bukaDialogSewaMotor());
        btnKeluar.addActionListener(e -> System.exit(0));

        // Tambahkan data motor
        tambahMotor(new Matic("S001", "Honda Beat", 110, 50000));
        tambahMotor(new Matic("S002", "Yamaha Mio", 125, 55000));
        tambahMotor(new Matic("S003", "Suzuki Nex II", 115, 52000));
        tambahMotor(new Matic("S004", "Vespa LX", 150, 60000));
        tambahMotor(new Matic("S005", "Honda Vario", 125, 57000));
        tambahMotor(new Matic("S006", "Yamaha NMax", 155, 62000));
        tambahMotor(new Matic("S007", "Suzuki Address", 110, 50000));
        tambahMotor(new Matic("S008", "Yamaha Aerox", 155, 65000));

        tambahMotor(new SportBike("SB001", "Yamaha R15", 155, 150000));
        tambahMotor(new SportBike("SB002", "Kawasaki Ninja", 200, 180000));
        tambahMotor(new SportBike("SB003", "Honda CBR150R", 150, 145000));
        tambahMotor(new SportBike("SB004", "Suzuki GSX-R150", 150, 148000));
        tambahMotor(new SportBike("SB005", "Kawasaki Z250", 250, 170000));
        tambahMotor(new SportBike("SB006", "Honda CBR250RR", 250, 160000));
        tambahMotor(new SportBike("SB007", "Yamaha MT-25", 250, 155000));
        tambahMotor(new SportBike("SB008", "Suzuki Gixxer SF 250", 250, 165000));

        tambahMotor(new SuperBike("C001", "Harley Davidson", 883, 300000));
        tambahMotor(new SuperBike("C002", "Ducati Panigale", 1100, 320000));
        tambahMotor(new SuperBike("C003", "BMW S1000RR", 999, 330000));
        tambahMotor(new SuperBike("C004", "Kawasaki Ninja H2R", 998, 400000));
        tambahMotor(new SuperBike("C005", "Yamaha YZF-R1", 998, 299000));
        tambahMotor(new SuperBike("C006", "Suzuki Hayabusa", 1340, 312000));
        tambahMotor(new SuperBike("C007", "Aprilia RSV4", 1100, 305000));
        tambahMotor(new SuperBike("C008", "MV Agusta F4", 998, 310000));

        frame.setVisible(true);
    }

    public void tambahMotor(Motor motor) {
        daftarMotor.add(motor);
        updateTabelMotor();
    }

    public void updateTabelMotor() {
        modelMatic.setRowCount(0);
        modelSportBike.setRowCount(0);
        modelSuperBike.setRowCount(0);

        for (Motor motor : daftarMotor) {
            DefaultTableModel targetModel = null;
            if (motor instanceof Matic) {
                targetModel = modelMatic;
            } else if (motor instanceof SportBike) {
                targetModel = modelSportBike;
            } else if (motor instanceof SuperBike) {
                targetModel = modelSuperBike;
            }

            if (targetModel != null) {
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                targetModel.addRow(new Object[]{
                        motor.getNomorRegistrasi(),
                        motor.getModel(),
                        motor.getKapasitasMesin(),
                        formatRupiah.format(motor.getHargaSewaPerHari()),
                        motor.isTersedia() ? "Ya" : "Tidak"
                });
            }
        }
    }

    public void bukaDialogSewaMotor() {
        JPanel panel = new JPanel(new GridLayout(7, 2));
        JTextField fieldNama = new JTextField();
        JTextField fieldKontak = new JTextField();
        JTextField fieldNomorSIM = new JTextField();
        JTextField fieldNomorRegistrasi = new JTextField();
        JTextField fieldHariSewa = new JTextField();
        JTextField fieldPembayaran = new JTextField();
        JLabel labelTotalHarga = new JLabel("Rp 0");

        panel.add(new JLabel("Nama: "));
        panel.add(fieldNama);
        panel.add(new JLabel("Kontak: "));
        panel.add(fieldKontak);
        panel.add(new JLabel("Nomor SIM: "));
        panel.add(fieldNomorSIM);
        panel.add(new JLabel("Nomor Registrasi Motor: "));
        panel.add(fieldNomorRegistrasi);
        panel.add(new JLabel("Jumlah Hari Sewa: "));
        panel.add(fieldHariSewa);
        panel.add(new JLabel("Total Harga Sewa: "));
        panel.add(labelTotalHarga);
        panel.add(new JLabel("Jumlah Pembayaran: "));
        panel.add(fieldPembayaran);

        fieldHariSewa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int hari = Integer.parseInt(fieldHariSewa.getText());
                    String nomorRegistrasi = fieldNomorRegistrasi.getText();
                    Motor motor = cariMotorBerdasarkanRegistrasi(nomorRegistrasi);

                    if (motor != null) {
                        double totalBiaya = motor.hitungHargaSewa(hari);
                        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                        labelTotalHarga.setText(formatRupiah.format(totalBiaya));
                    } else {
                        labelTotalHarga.setText("Rp 0");
                    }
                } catch (NumberFormatException ex) {
                    labelTotalHarga.setText("Rp 0");
                }
            }
        });

        int result = JOptionPane.showConfirmDialog(frame, panel, "Sewa Motor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nama = fieldNama.getText();
            String kontak = fieldKontak.getText();
            String nomorSIM = fieldNomorSIM.getText();
            String nomorRegistrasi = fieldNomorRegistrasi.getText();
            int hari;
            double pembayaran;

            try {
                hari = Integer.parseInt(fieldHariSewa.getText());
                pembayaran = Double.parseDouble(fieldPembayaran.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Jumlah hari dan pembayaran harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Motor motor = cariMotorBerdasarkanRegistrasi(nomorRegistrasi);
            if (motor != null && motor.isTersedia()) {
                double totalBiaya = motor.hitungHargaSewa(hari);
                if (pembayaran >= totalBiaya) {
                    motor.setTersedia(false);
                    JOptionPane.showMessageDialog(frame, "Rental berhasil!\nKembalian: Rp " + (pembayaran - totalBiaya), "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    updateTabelMotor();
                } else {
                    JOptionPane.showMessageDialog(frame, "Pembayaran kurang!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Motor tidak tersedia atau tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void main(String[] args) {
        new AplikasiRentalMotorGUI();
    }
}
