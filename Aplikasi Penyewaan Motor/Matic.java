public class Matic extends Motor {
    public Matic(String nomorRegistrasi, String model, double kapasitasMesin, double hargaSewaPerHari) {
        super(nomorRegistrasi, model, kapasitasMesin, hargaSewaPerHari);
    }

    @Override
    public double hitungHargaSewa(int hari) {
        return super.hitungHargaSewa(hari) * 0.9; // Diskon untuk matic
    }
}
