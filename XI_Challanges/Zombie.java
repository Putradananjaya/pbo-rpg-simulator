package XI_Challanges;

// Zombie juga mengimplementasikan antarmuka BisaLoot
public class Zombie extends Musuh implements BisaLoot {
    public Zombie() {
        super("Zombie Merangkak", 150);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menerkam dan menggigit! Pemain kehilangan 20 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Suara: *Groaaarrr... brainsss...*");
    }

    // JAWABAN TANTANGAN 1: Implementasi jatuhkanItem
    @Override
    public void jatuhkanItem() {
        System.out.println("Loot Drop: " + this.namaMusuh + " menjatuhkan 1x Daging Busuk!");
    }
}
