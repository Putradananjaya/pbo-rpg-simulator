package X;

import java.util.Scanner;

public class ArenaPertarungan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Memasukkan musuh ke dalam Array (Upcasting ke Abstract Class)
        Musuh[] gelombangMonster = new Musuh[3];
        gelombangMonster[0] = new Slime();
        gelombangMonster[1] = new Naga();
        gelombangMonster[2] = new Slime();

        System.out.println("=====================================");
        System.out.println("   ARENA RPG: GELOMBANG MONSTER      ");
        System.out.println("=====================================\n");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        // Game Loop
        while (isBermain) {
            System.out.println("\n--- STATUS MONSTER ---");
            // Menampilkan daftar monster yang ada di dalam Array
            for (int i = 0; i < gelombangMonster.length; i++) {
                System.out.println((i + 1) + ". " + gelombangMonster[i].namaMusuh + " (HP: "
                        + gelombangMonster[i].healthPoint + ")");
            }

            System.out.println("4. Kabur dari pertarungan");
            System.out.print("\nPilih target monster yang ingin diserang (1/2/3) atau 4 untuk kabur: ");
            int pilihanTarget = input.nextInt();

            if (pilihanTarget == 4) {
                System.out.println("Anda lari terbirit-birit dari arena...");
                isBermain = false;
                continue;
            }

            // Validasi input agar tidak error keluar batas Array
            if (pilihanTarget < 1 || pilihanTarget > 3) {
                System.out.println("Pilihan tidak valid! Anda membuang giliran.");
            } else {
                System.out.print("Masukkan kekuatan serangan Anda (10 - 100): ");
                int power = input.nextInt();

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                // Menyerang monster spesifik sesuai pilihan (Indeks Array dimulai dari 0, jadi
                // pilihanTarget - 1)
                int indeksMonster = pilihanTarget - 1;
                gelombangMonster[indeksMonster].terimaDamage(power);
            }

            System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");
            // Semua monster di dalam Array akan menyerang balik secara bergiliran
            for (int i = 0; i < gelombangMonster.length; i++) {
                // Logika tambahan: Monster hanya bisa menyerang balik jika HP-nya masih di atas
                // 0
                if (gelombangMonster[i].healthPoint > 0) {
                    gelombangMonster[i].serangPemain();
                } else {
                    System.out.println(gelombangMonster[i].namaMusuh + " sudah mati dan tidak bisa menyerang.");
                }
            }
            System.out.println("-------------------------------------");
        }

        input.close();
        System.out.println("Permainan Berakhir.");
    }
}