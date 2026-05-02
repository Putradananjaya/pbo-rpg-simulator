package xi_interface_object_casting;

// Naga mewarisi Musuh DAN menyetujui kontrak BisaTerbang
public class Naga extends Musuh implements BisaTerbang {

    public Naga() {
        super("Naga Api Hitam", 500);
    }

    // --- KEWAJIBAN DARI ABSTRACT CLASS (MUSUH) ---
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menggigit dengan rahang besarnya! Pemain kehilangan 30 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Suara: *ROAAAARRRR!!!*");
    }

    // --- KEWAJIBAN BARU DARI INTERFACE (BISA TERBANG) ---
    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuh + " mengepakkan sayap dan terbang tinggi! Sangat sulit diserang.");
    }

    @Override
    public void seranganUdara() {
        System.out.println(this.namaMusuh + " menukik dan menyemburkan badai api dari langit! Pemain -80 HP.");
    }
}
