package IX;

public class Naga extends Musuh {
    
    public Naga() {
        this.namaMusuh = "Naga Hitam";
        this.healthPoint = 500;
    }

    // Menerapkan Overriding dengan logika yang sepenuhnya berbeda
    @Override
    public void terimaDamage(int damage) {
        // Logika khusus: Naga memiliki sisik keras, damage selalu berkurang 15
        int damageMasuk = damage - 15;
        if (damageMasuk < 0) {
            damageMasuk = 0;
        }
        
        this.healthPoint -= damageMasuk;
        System.out.println("Armor Sisik: " + this.namaMusuh + " menangkis serangan! Hanya menerima " + damageMasuk + " damage. Sisa HP: " + this.healthPoint);
    }
}
