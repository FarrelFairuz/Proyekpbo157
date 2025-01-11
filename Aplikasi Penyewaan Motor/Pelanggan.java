public class Pelanggan {
    private String nama;
    private String kontak;
    private String nomorSIM;

    public Pelanggan(String nama, String kontak, String nomorSIM) {
        this.nama = nama;
        this.kontak = kontak;
        this.nomorSIM = nomorSIM;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    public String getNomorSIM() {
        return nomorSIM;
    }

    @Override
    public String toString() {
        return "Pelanggan{" +
                "nama='" + nama + '\'' +
                ", kontak='" + kontak + '\'' +
                ", nomorSIM='" + nomorSIM + '\'' +
                '}';
    }
}
