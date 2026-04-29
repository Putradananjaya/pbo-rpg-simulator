package IX;

public class Slime extends Musuh {

    public Slime() {
        this.namaMusuh = "Slime Berlendir";
        this.healthPoint = 50;
    }

    // Menerapkan Overriding untuk memodifikasi cara kerja method dari superclass
    @Override
    public void terimaDamage(int damage) {
        super.terimaDamage(damage); // Memanggil logika pengurangan HP dari kelas induk
        System.out.println("Efek Pasif: " + this.namaMusuh + " membelah diri menjadi dua karena diserang!");
    }
}
