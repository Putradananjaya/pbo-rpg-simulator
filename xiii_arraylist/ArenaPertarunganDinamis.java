package xiii_arraylist;

import java.util.Scanner;
import java.util.ArrayList;

public class ArenaPertarunganDinamis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Musuh> gelombangMonster = new ArrayList<>();

        // Menambahkan objek ke dalam daftar secara dinamis
        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Naga());
        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Zombie());

        System.out.println("=====================================");
        System.out.println("   ARENA RPG: GELOMBANG MONSTER      ");
        System.out.println("=====================================\n");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        // Loop berjalan selama ArrayList tidak kosong
        while (isBermain && !gelombangMonster.isEmpty()) {

            System.out.println("\n--- STATUS MONSTER ---");
            
            for (int i = 0; i < gelombangMonster.size(); i++) {
                
                Musuh m = gelombangMonster.get(i);
                System.out.println((i + 1) + ". " + m.namaMusuh + " (HP: " + m.healthPoint + ")");
            }

            System.out.println("0. Kabur dari pertarungan");
            System.out.print("\nPilih target monster: ");

            try {
                int pilihanTarget = input.nextInt();

                if (pilihanTarget == 0) {
                    System.out.println("Anda lari terbirit-birit...");
                    isBermain = false;
                    continue;
                }

                // Validasi rentang pilihan dinamis sesuai jumlah monster yang tersisa
                if (pilihanTarget < 1 || pilihanTarget > gelombangMonster.size()) {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }

                int indeksMonster = pilihanTarget - 1;
                Musuh target = gelombangMonster.get(indeksMonster);

                System.out.print("Masukkan kekuatan serangan Anda (10-100): ");
                int power = input.nextInt();
                if (power < 10 || power > 100) {
                    // Lemparkan Custom Exception Anda secara sengaja di sini beserta pesannya!
                    throw new SeranganTidakValidException("Kekuatan serangan harus di antara 10 sampai 100!");
                }
                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                target.terimaDamage(power);

                // --- LOGIKA PENGHAPUSAN DINAMIS 1---
                if (target.healthPoint <= 0) {
                    System.out.println(target.namaMusuh + " hancur menjadi debu!");

                    if (target instanceof BisaLoot) {
                        BisaLoot loot = (BisaLoot) target;
                        loot.jatuhkanItem();
                    }

                    // MENGHAPUS OBJEK DARI ARRAYLIST SECARA PERMANEN
                    gelombangMonster.remove(indeksMonster);
                }

            } catch (Exception e) {
                System.out.println
                ("Terjadi kesalahan input, silakan coba lagi.");
                input.nextLine();
                continue;
            }

            // Jika semua monster mati setelah serangan pemain, langsung keluar dari loop
            if (gelombangMonster.isEmpty()) {
                System.out.println
                ("\nSELAMAT! Semua monster telah dibersihkan dari arena!");
                break;
            }

            // --- GILIRAN MONSTER MEMBALAS ---
            System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");
            for (int i = 0; i < gelombangMonster.size(); i++) {
                Musuh monsterAktif = gelombangMonster.get(i);

                // Tidak perlu lagi if (hp > 0), karena jika mati sudah di-remove!
                monsterAktif.suaraKhas();

                if (monsterAktif instanceof BisaTerbang) {
                    System.out.println("[PERINGATAN! SERANGAN UDARA TERDETEKSI]");
                    BisaTerbang monsterTerbang = (BisaTerbang) monsterAktif;

                    // Panggil langsung tanpa try-catch ManaHabisException
                    monsterTerbang.lepasLandas();
                    monsterTerbang.seranganUdara();
                } else {
                    monsterAktif.serangPemain();
                }
                System.out.println("-------------------------------------");
            }

            // Logika untuk memeriksa apakah semua monster sudah mati (opsional, untuk
            // mempermanis game)
            // Logika untuk memeriksa apakah semua monster sudah mati
            boolean semuaMati = true;
            for (int i = 0; i < gelombangMonster.size(); i++) { // Gunakan .size() bukan .length
                if (gelombangMonster.get(i).healthPoint > 0) { // Gunakan .get(i) bukan [i]
                    semuaMati = false;
                    break;
                }
            }

            if (semuaMati) {
                System.out.println
                ("\nSELAMAT! Anda telah menyapu bersih gelombang monster ini!");
                isBermain = false;
            }
        }

        input.close();
        System.out.println("Permainan Berakhir.");
    }
}
