# Dicoding-Android-Beginner
Dicoding Android Beginner adalah aplikasi yang harus disubmit dalam menyelesaikan kelas [Belajar Membuat Aplikasi Android untuk Pemula](https://www.dicoding.com/academies/51)
Kelas ini ditujukan bagi pemula yang ingin memulai karirnya di bidang Android Developer dengan mengacu pada standar kompetensi internasional milik Google. Di akhir kelas, siswa dapat membuat aplikasi Android yang dapat menampilkan list dan detail data. 

## SCREENSHOT!
<img src="https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/fc4aef4a-2149-481e-9818-9b4ca667b3cc" alt="Screenshot_20231228_234319" width="250">   
<img src="https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/33993a52-ab55-468f-8f39-d03020e13f3e" alt="Screenshot_20231228_234336" width="250">   
<img src="https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/bed23fd0-efa9-4a68-837c-f74fec7e3d8d" alt="Screenshot_20231228_234319" width="250">

## Petunjuk Instalasi
1. Kloning Repositori::
   - Buka terminal atau command prompt di komputer lokal Anda.
   - Gunakan perintah **git clone** diikuti dengan URL yang telah Anda salin.
     ```
     git clone https://github.com/robbyyehezkiel/Dicoding-Android-Beginner.git
     ```
3. Buka Proyek di Android Studio:<br>
   Buka Android Studio dan buka proyek yang telah Anda kloning.
4. Bangun Proyek:<br>
   Setelah proyek dimuat, bangun proyek menggunakan opsi **build** di Android Studio.
5. Hubungkan Perangkat Anda:<br>
   Hubungkan perangkat Android Anda ke komputer menggunakan kabel USB dan pastikan debugging USB diaktifkan pada perangkat Anda.
7. Jalankan Aplikasi:
   - Pilih perangkat yang terhubung dari daftar perangkat yang tersedia di Android Studio.
   - Klik tombol **Run** untuk menginstal dan meluncurkan aplikasi di perangkat Anda.
8. Atau, Gunakan Emulator:<br>
   Jika Anda tidak memiliki perangkat fisik, Anda dapat menggunakan Emulator Android yang disediakan oleh Android Studio. Cukup buat perangkat virtual menggunakan AVD Manager dan jalankan aplikasi di emulator.

## KRITERIA SUBMISSION AKHIR APLIKASI

1. **Halaman Utama**<br>
   Syarat:
   - Menampilkan gambar dalam format List dengan jumlah minimal 10 item yang berbeda. Gunakanlah RecyclerView untuk menyusun listnya. Informasi yang ditampilkan mengandung :
     - Judul dari artikel
     - Memaparkan overview dari artikel (opsional)
   - Memunculkan halaman detail ketika salah satu item ditekan. Anda bisa menerapkan handler click pada setiap item RecyclerView

2. **Halaman Detail**<br>
   Syarat:
   - Menampilkan gambar dan informasi yang relevan pada halaman detail.
   - Informasi yang relevan mencakup kesamaan informasi yang ditampilkan pada halaman utama dengan halaman detail
       * Terdapat judul dan gambar yang sesuai dengan list
       - Terdapat kalimat deskripsi yang lebih panjang atau informasi tambahan lainnya
   - Gunakan ScrollView supaya konten tetap dapat dilihat ketika aplikasi dirotasi.

3. **Halaman About**<br>
   Syarat:
   - Menampilkan foto diri, nama, dan email yang terdaftar di Dicoding.
   - Dalam mengakses halaman about, pastikan terdapat tombol yang bisa digunakan untuk mengakses halamannya. Untuk cara mengaksesnya, kamu bisa mengimplementasikan :
     - Dengan menambahkan elemen View khusus (bisa option menu, tombol, atau tab) yang mengandung ID “about_page”

## PENILAIAN
Submission Anda akan dinilai oleh reviewer dengan skala 1-5 berdasarkan dari parameter yang ada.<br>

| Penilaian | Deskripsi |
| --- | --- |
| ![rating-default-1](https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/a44691b2-f5ae-4d65-8cf1-35e883080b58) | Semua ketentuan terpenuhi, namun terdapat indikasi plagiat yaitu dengan menggunakan project orang lain dan hanya merubah kontennya saja. |
| ![rating-default-2](https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/2eb100d9-6af2-4612-9a3e-335b2afa400f) | Semua ketentuan terpenuhi, namun terdapat kekurangan pada tampilan aplikasi. |
| ![rating-default-3](https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/5b91432e-4b00-44cf-abb4-f1440904c94a) | Semua ketentuan wajib terpenuhi, namun tidak terdapat improvisasi atau persyaratan opsional yang dipenuhi. |
| ![rating-default-4](https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/66b77800-871a-4a5a-8a0f-ffeb86fdffa5) | Semua ketentuan terpenuhi dan menerapkan tiga saran di atas. |
| ![rating-default-5](https://github.com/robbyyehezkiel/Dicoding-Android-Beginner/assets/107051384/acbff36b-016d-4962-8aaa-20f36ec55b8b) | Semua ketentuan terpenuhi dan menerapkan semua saran di atas. |

Anda dapat menerapkan beberapa saran di bawah ini untuk mendapatkan nilai tinggi, berikut sarannya:

1. Menerapkan tampilan aplikasi yang sesuai standar. Di mana kriterianya adalah :
   - Memiliki width, height, margin, dan padding yang sesuai.
   - Komponen tidak saling bertumpuk
   - Penggunaan komponen sesuai dengan fungsinya
   - Penggunaan warna yang sesuai
   - Semua data dapat terlihat baik ketika landscape maupun potrait (gunakan ScrollView)
2. Informasi yang ditampilkan pada halaman detail lebih lengkap.
   - Jenis data yang ditampilkan bervariasi
3. Membuat custom splash screen yang menarik.
   - Pastikan nama Activity yang digunakan mengandung kata “Splash”
   - Gunakan referensi berikut untuk menerapkan splash screen pada project sesuai dengan yang disarankan.
4. Menggunakan CardView yang sesuai untuk menampilkan konten List.
   - Gunakan referensi CardView Guideline untuk menerapkan CardView yang baik dan benar.
5. Mengimplementasikan fungsi Share pada halaman detail.
   - Pastikan pada tombol Share menggunakan id “action_share”
> **Catatan:**
> Jika submission Anda ditolak maka tidak ada penilaian. Kriteria penilaian bintang di atas hanya berlaku jika submission Anda lulus.
