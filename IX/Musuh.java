package IX;

public class Musuh {
    protected String namaMusuh;
    protected int healthPoint;

    // Constructor default
    public Musuh() {
        this.namaMusuh = "Monster Dasar";
        this.healthPoint = 100;
    }

    // 1. DEMO OVERLOADING
    // Method serang tanpa parameter (serangan fisik standar)
    public void serang() {
        System.out.println(this.namaMusuh + " melakukan serangan fisik! Pemain kehilangan 10 HP.");
    }

    // Method serang dengan parameter tipe String (serangan elemen/sihir)
    // Nama method sama, tetapi parameternya berbeda
    public void serang(String elemenSihir) {
        System.out.println(this.namaMusuh + " mengeluarkan sihir " + elemenSihir + "! Pemain kehilangan 30 HP.");
    }

    // 2. PERSIAPAN OVERRIDING
    // Method ini akan dimodifikasi oleh subclass
    public void terimaDamage(int damage) {
        this.healthPoint -= damage;
        System.out.println(this.namaMusuh + " terkena serangan biasa. Sisa HP: " + this.healthPoint);
    }
}
