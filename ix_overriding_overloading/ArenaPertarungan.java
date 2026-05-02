package ix_overriding_overloading;

import java.util.Scanner;

public class ArenaPertarungan {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menangkap input dari keyboard
        Scanner input = new Scanner(System.in);

        // UPCASTING: Menyiapkan referensi tipe induk untuk objek spesifik
        Musuh monster1 = new Slime();
        Musuh monster2 = new Naga();

        System.out.println("=====================================");
        System.out.println("   SELAMAT DATANG DI ARENA RPG 2D    ");
        System.out.println("=====================================\n");

        boolean isBermain = true;

        // Game Loop agar pertarungan bisa dilakukan berulang kali
        while (isBermain) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Serang Slime");
            System.out.println("2. Serang Naga");
            System.out.println("3. Kabur (Keluar)");
            System.out.print("Pilih target serangan (1/2/3): ");
            int pilihanTarget = input.nextInt();

            // Logika untuk keluar dari permainan
            if (pilihanTarget == 3) {
                System.out.println("\nAnda melarikan diri dari pertarungan...");
                isBermain = false;
                continue;
            }

            // Input besaran kekuatan serangan pemain
            System.out.print("Masukkan kekuatan serangan Anda (10 - 100): ");
            int power = input.nextInt();

            // INPUT TAMBAHAN: Memilih tipe balasan monster (Demo Overloading)
            System.out.println("\nPilih tipe balasan monster:");
            System.out.println("1. Serangan Fisik (Default)");
            System.out.println("2. Serangan Sihir");
            System.out.print("Pilihan (1/2): ");
            int tipeBalasan = input.nextInt();

            System.out.println("\n>>> HASIL PERTARUNGAN <<<");

            if (pilihanTarget == 1) {
                // Eksekusi OVERRIDING: Java memanggil terimaDamage milik Slime
                monster1.terimaDamage(power);

                System.out.println("\n<<< BALASAN MONSTER >>>");
                if (tipeBalasan == 2) {
                    // Eksekusi OVERLOADING: Memanggil metode dengan parameter String
                    monster1.serang("Semburan Asam");
                } else {
                    // Eksekusi OVERLOADING: Memanggil metode tanpa parameter
                    monster1.serang();
                }

            } else if (pilihanTarget == 2) {
                // Eksekusi OVERRIDING: Java memanggil terimaDamage milik Naga
                monster2.terimaDamage(power);

                System.out.println("\n<<< BALASAN MONSTER >>>");
                if (tipeBalasan == 2) {
                    // Eksekusi OVERLOADING: Memanggil metode dengan parameter String
                    monster2.serang("Api Hitam");
                } else {
                    // Eksekusi OVERLOADING: Memanggil metode tanpa parameter
                    monster2.serang();
                }

            } else {
                System.out.println("Target tidak valid! Serangan Anda meleset.");
            }

            System.out.println("\n-------------------------------------");
        }

        // Menutup scanner untuk menjaga performa memori
        input.close();
        System.out.println("Permainan Berakhir. Sampai jumpa di petualangan berikutnya!");
    }
}