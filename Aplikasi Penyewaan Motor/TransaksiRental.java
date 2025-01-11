public class TransaksiRental {
    private Pelanggan pelanggan;
    private Motor motor;
    private int hariRental;
    private double totalBiaya;

    public TransaksiRental(Pelanggan pelanggan, Motor motor, int hariRental) {
        this.pelanggan = pelanggan;
        this.motor = motor;
        this.hariRental = hariRental;
        this.totalBiaya = motor.hitungHargaSewa(hariRental);
    }

    public void selesaikanRental() {
        motor.setTersedia(true);
    }

    @Override
    public String toString() {
        return "TransaksiRental{" +
                "pelanggan=" + pelanggan +
                ", motor=" + motor +
                ", hariRental=" + hariRental +
                ", totalBiaya=" + totalBiaya +
                '}';
    }
}
