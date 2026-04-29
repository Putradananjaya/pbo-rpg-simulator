package X;

public class Naga extends Musuh {

    public Naga() {
        super("Naga Api Hitam", 500);
    }

    // WAJIB ADA: Naga dipaksa oleh Java untuk meng-override metode ini
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menyemburkan nafas api dari udara! Player -50 HP");
    }
}
