package xii_exeption_handling;

// Slime kini mengimplementasikan antarmuka BisaLoot
public class Slime extends Musuh implements BisaLoot {
    public Slime() {
        super("Slime Berlendir", 50);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " melompat dan menyiram cairan asam! Pemain kehilangan 15 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Suara: *Blub... blub... blub...*");
    }

    // JAWABAN TANTANGAN 1: Implementasi jatuhkanItem
    @Override
    public void jatuhkanItem() {
        System.out.println("Loot Drop: " + this.namaMusuh + " menjatuhkan 1x Potion Penyembuh!");
    }
}
