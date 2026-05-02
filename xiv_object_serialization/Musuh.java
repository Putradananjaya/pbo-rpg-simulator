package xiv_object_serialization;
import java.io.Serializable;

// 1. Tambahkan kata kunci 'abstract' pada deklarasi kelas
public abstract class Musuh implements Serializable{
    protected String namaMusuh;
    protected int healthPoint;

    // Constructor tetap ada untuk inisialisasi awal variabel subclass
    public Musuh(String nama, int hp) {
        this.namaMusuh = nama;
        this.healthPoint = hp;
    }

    // Metode Konkret (Concrete Method) - Tetap bisa diwariskan utuh
    public void terimaDamage(int damage) {
        this.healthPoint -= damage;
        System.out.println(this.namaMusuh + " terkena serangan! Sisa HP: " + this.healthPoint);
    }

    // 2. METODE ABSTRAK
    // Hanya nama metodenya saja, diakhiri dengan titik koma (;)
    public abstract void serangPemain();

    // JAWABAN TANTANGAN 2: Penambahan Metode Abstrak Baru
    public abstract void suaraKhas();
}