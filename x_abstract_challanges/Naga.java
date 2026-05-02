package x_abstract_challanges;

public class Naga extends Musuh {

    public Naga() {
        super("Naga Api Hitam", 500);
    }

    // WAJIB ADA: Naga dipaksa oleh Java untuk meng-override metode ini
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menyemburkan nafas api dari udara! Player -50 HP");
    }

    // JAWABAN TANTANGAN 2: Implementasi Wajib suaraKhas()
    @Override
    public void suaraKhas() {
        System.out.println("Suara: *ROAAAARRRR!!!*");
    }
}
