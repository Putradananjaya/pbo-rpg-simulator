package xii_exeption_handling;

// JAWABAN TANTANGAN 2: Naga menandatangani DUA kontrak sekaligus (BisaTerbang & BisaLoot)
public class Naga extends Musuh implements BisaTerbang, BisaLoot {
    public Naga() {
        super("Naga Api Hitam", 500);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menggigit dengan rahang besarnya! Pemain kehilangan 30 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Suara: *ROAAAARRRR!!!*");
    }

    // Kewajiban dari BisaTerbang
    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuh + " mengepakkan sayap dan terbang tinggi! Sangat sulit diserang.");
    }

    @Override
    public void seranganUdara() {
        System.out.println(this.namaMusuh + " menukik dan menyemburkan badai api dari langit! Pemain -80 HP.");
    }

    // JAWABAN TANTANGAN 2: Kewajiban dari BisaLoot
    @Override
    public void jatuhkanItem() {
        System.out.println("Loot Drop: " + this.namaMusuh + " menjatuhkan 1x Sisik Naga Api (Legendary)!");
    }
}
