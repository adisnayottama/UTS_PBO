package id.ac.polinema.uts.rental;

/**
 * Bagian 2: merek kendaraan (contoh: Toyota dari Japan).
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Di Bagian 2 field boleh public. Di Bagian 3 kamu akan menutupnya.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public ____ name;
 *   public ____ country;
 */
public class Brand {
    private String name;
    private String country;

    /** Membuat merek dengan nama dan negara asal. */
    public Brand(String name, String country) {
        this.name = name;
        this.country = country;
        // TODO Bantuan: nama parameter sama dengan nama field. Kata kunci apa yang
        // menunjuk ke objek yang sedang dibuat?
        //
        // Kerangka:
        //   this.name = ____;
        //   this.country = ____;
    }

    public String getName() {
        return name;
        // TODO Bantuan: kembalikan data yang disimpan constructor.
        //
        // Kerangka:
        //   return ____;
    }

    public String getCountry() {
        return country;
        // TODO Bantuan: sama seperti getName.
    }

    /** Teks berbentuk "nama (negara)". Contoh: Wuling (China). */
    public String getInfo() {
        return name + " (" + country + ")";
        // TODO Bantuan: gabungkan dua data dengan operator + dan tanda kurung dalam String.
        //
        // Kerangka:
        //   return name + " (" + ____ + ")";
    }
}
