public class SportBike extends Motor {
    public SportBike(String nomorRegistrasi, String model, double kapasitasMesin, double hargaSewaPerHari) {
        super(nomorRegistrasi, model, kapasitasMesin, hargaSewaPerHari);
    }

    @Override
    public double hitungHargaSewa(int hari) {
        return super.hitungHargaSewa(hari) * 1.2; // Tambahan biaya untuk motor sport
    }
}