package xii_exeption_handling;

// Mewarisi class Exception bawaan Java
public class TargetMatiException extends Exception {

    // Constructor yang menerima pesan error
    public TargetMatiException(String pesan) {
        super(pesan); // Mengirim pesan ke superclass Exception
    }
}
