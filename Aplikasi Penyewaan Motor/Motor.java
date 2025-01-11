public abstract class Motor {
    private String nomorRegistrasi;
    private String model;
    private double kapasitasMesin;
    private double hargaSewaPerHari;
    private boolean tersedia;

    public Motor(String nomorRegistrasi, String model, double kapasitasMesin, double hargaSewaPerHari) {
        this.nomorRegistrasi = nomorRegistrasi;
        this.model = model;
        this.kapasitasMesin = kapasitasMesin;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.tersedia = true;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public String getModel() {
        return model;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public double hitungHargaSewa(int hari) {
        return hari * hargaSewaPerHari;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "nomorRegistrasi='" + nomorRegistrasi + '\'' +
                ", model='" + model + '\'' +
                ", kapasitasMesin=" + kapasitasMesin +
                ", hargaSewaPerHari=" + hargaSewaPerHari +
                ", tersedia=" + tersedia +
                '}';
    }
}