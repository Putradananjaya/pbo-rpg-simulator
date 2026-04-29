package X_Challanges;

public class Slime extends Musuh {

    public Slime() {
        // Memanggil constructor dari kelas induk abstrak
        super("Slime Asam", 50);
    }

    // WAJIB ADA: Slime dipaksa oleh Java untuk meng-override metode ini
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " melompat dan menyiram cairan asam! Player -15 HP");
    }

    // JAWABAN TANTANGAN 2: Implementasi Wajib suaraKhas()
    @Override
    public void suaraKhas() {
        System.out.println("Suara: *Blub... blub... blub...*");
    }

    
}
