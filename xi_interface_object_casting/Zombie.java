package xi_interface_object_casting;

// JAWABAN TANTANGAN 1: Membuat Subclass Baru
public class Zombie extends Musuh {

    // Inisialisasi Constructor sesuai instruksi
    public Zombie() {
        super("Zombie Merangkak", 150);
    }

    // Implementasi serangan spesifik Zombie
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menerkam dan menggigit! Pemain kehilangan 20 HP.");
    }

    // JAWABAN TANTANGAN 2: Implementasi suaraKhas() untuk Zombie
    @Override
    public void suaraKhas() {
        System.out.println("Suara: *Groaaarrr... brainsss...*");
    }
}