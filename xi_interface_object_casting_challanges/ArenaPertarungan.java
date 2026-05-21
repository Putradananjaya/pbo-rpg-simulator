package xi_interface_object_casting_challanges;

import java.util.Scanner;

public class ArenaPertarungan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array monster tetap sama seperti hasil pertemuan 10
        Musuh[] gelombangMonster = new Musuh[4];
        gelombangMonster[0] = new Slime();
        gelombangMonster[1] = new Naga();
        gelombangMonster[2] = new Slime();
        gelombangMonster[3] = new Zombie();

        System.out.println("=====================================");
        System.out.println("   ARENA RPG: GELOMBANG MONSTER      ");
        System.out.println("=====================================\n");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        while (isBermain) {
            System.out.println("\n--- STATUS MONSTER ---");
            for (int i = 0; i < gelombangMonster.length; i++) {
                // Menambahkan pengecekan agar monster yang mati statusnya [Tewas]
                if (gelombangMonster[i].healthPoint > 0) {
                    System.out.println((i + 1) + ". " + gelombangMonster[i].namaMusuh + " (HP: "
                            + gelombangMonster[i].healthPoint + ")");
                } else {
                    System.out.println((i + 1) + ". " + gelombangMonster[i].namaMusuh + " [TEWAS]");
                }
            }

            System.out.println("5. Kabur dari pertarungan");
            System.out.print("\nPilih target monster yang ingin diserang (1-4) atau 5 untuk kabur: ");
            
            int pilihanTarget = input.nextInt();

            if (pilihanTarget == 5) {
                System.out.println("Anda lari terbirit-birit dari arena...");
                isBermain = false;
                continue;
            }

            if (pilihanTarget < 1 || pilihanTarget > 4) {
                System.out.println("Pilihan tidak valid! Anda membuang giliran.");
            } else {
                int indeksMonster = pilihanTarget - 1;

                // Mencegah pemain menyerang mayat monster
                if (gelombangMonster[indeksMonster].healthPoint <= 0) {
                    System.out.println("Monster tersebut sudah mati! Serangan dibatalkan.");
                } else {
                    System.out.print("Masukkan kekuatan serangan Anda (10 - 100): ");
                    int power = input.nextInt();

                    System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                    gelombangMonster[indeksMonster].terimaDamage(power);

                    // --- JAWABAN TANTANGAN 1 & 2: LOGIKA LOOT DROP ---
                    // Cek apakah monster terbunuh oleh serangan barusan
                    if (gelombangMonster[indeksMonster].healthPoint <= 0) {
                        System.out.println(gelombangMonster[indeksMonster].namaMusuh + " berhasil dikalahkan!");

                        // Implementasi Downcasting untuk Interface BisaLoot
                        if (gelombangMonster[indeksMonster] instanceof BisaLoot) {
                            BisaLoot monsterLoot = (BisaLoot) gelombangMonster[indeksMonster];
                            monsterLoot.jatuhkanItem();
                        }
                    }
                }
            }

            System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");
            for (int i = 0; i < gelombangMonster.length; i++) {
                if (gelombangMonster[i].healthPoint > 0) {

                    Musuh monsterAktif = gelombangMonster[i];
                    monsterAktif.suaraKhas();

                    // Blok Casting dari Sesi Live Coding (Serangan Udara Naga)
                    if (monsterAktif instanceof BisaTerbang) {
                        System.out.println("[PERINGATAN! SERANGAN UDARA TERDETEKSI]");
                        BisaTerbang monsterTerbang = (BisaTerbang) monsterAktif;
                        monsterTerbang.lepasLandas();
                        monsterTerbang.seranganUdara();
                    } else {
                        monsterAktif.serangPemain();
                    }

                    System.out.println("-------------------------------------");
                }
            }

            // Logika untuk memeriksa apakah semua monster sudah mati (opsional, untuk
            // mempermanis game)
            boolean semuaMati = true;
            for (int i = 0; i < gelombangMonster.length; i++) {
                if (gelombangMonster[i].healthPoint > 0) {
                    semuaMati = false;
                    break;
                }
            }

            if (semuaMati) {
                System.out.println("\nSELAMAT! Anda telah menyapu bersih gelombang monster ini!");
                isBermain = false;
            }
        }

        input.close();
        System.out.println("Permainan Berakhir.");
    }
}
