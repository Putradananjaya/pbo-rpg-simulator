# PBO RPG Simulator

Repositori ini berisi simulasi game RPG sederhana yang dibangun menggunakan bahasa pemrograman Java sebagai bagian dari pembelajaran Pemrograman Berorientasi Objek (PBO). Simulator ini menunjukkan perkembangan implementasi konsep-konsep PBO dari tahap dasar hingga lanjutan.

## Struktur Folder

Folder dalam repositori ini diatur berdasarkan tahapan pembelajaran (milestone) dan tantangan (challenges):

- **IX**: Implementasi dasar sistem pertarungan dengan kelas dasar Musuh dan Slime/Naga.
- **X**: Pengembangan lebih lanjut pada struktur kelas dan logika pertarungan.
- **XI**: Penambahan kelas `Zombie` dan implementasi Interface `BisaTerbang`.
- **XII**: Implementasi fitur tingkat lanjut termasuk Interface `BisaLoot` dan penanganan eksepsi khusus (`TargetMatiException`).
- **X_Challanges & XI_Challanges**: Folder khusus berisi solusi untuk tantangan pemrograman tambahan yang memperdalam pemahaman konsep PBO.

## Konsep PBO yang Diimplementasikan

1. **Encapsulation**: Menyembunyikan status internal objek dan hanya mengizinkan akses melalui metode publik.
2. **Inheritance**: Menggunakan kelas induk `Musuh` untuk mewariskan sifat umum ke berbagai jenis monster.
3. **Polymorphism**: Memungkinkan objek monster yang berbeda untuk merespons metode yang sama (seperti `serang()`) dengan cara yang unik.
4. **Abstraction & Interfaces**: Menggunakan Interface seperti `BisaTerbang` dan `BisaLoot` untuk mendefinisikan kemampuan tambahan yang fleksibel.
5. **Exception Handling**: Mengelola kesalahan input atau logika permainan menggunakan blok `try-catch` dan custom exception.

## Cara Menjalankan

Untuk menjalankan simulasi di folder tertentu (misalnya `XII`):

1. Masuk ke direktori folder tersebut.
2. Kompilasi semua file `.java`:
   ```bash
   javac *.java
   ```
3. Jalankan kelas utama `ArenaPertarungan`:
   ```bash
   java ArenaPertarungan
   ```

## Tujuan
Proyek ini bertujuan sebagai sarana praktik untuk memahami bagaimana konsep-konsep teoritis PBO diterapkan dalam pengembangan perangkat lunak nyata, khususnya dalam konteks logika permainan.
