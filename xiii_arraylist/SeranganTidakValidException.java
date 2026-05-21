package xiii_arraylist;

// 1. Warisi class Exception bawaan Java agar menjadi Checked Exception
public class SeranganTidakValidException extends Exception {

    // 2. Buat constructor untuk menerima pesan teks error
    public SeranganTidakValidException(String pesan) {
        // 3. Teruskan pesan teks ke superclass Exception Java
        super(pesan);
    }
}
