package id.ac.polinema.uts.rental;

/**
 * Bagian 3: pelanggan rental.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 *   private ____ customerId;
 *   private ____ name;
 *   private int rentalCount;   // nilai awal 0
 */
public class Customer {

    private String customerId;
    private String name;
    private int rentalCount;
    private RentalCard card;
    /**
     * Membuat pelanggan yang belum punya sewa aktif.
     * customerId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Customer(String customerId, String name) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID tidak boleh kosong");
        }
        this.customerId = customerId;
        setName(name);
        this.rentalCount = 0;
        this.card = new RentalCard("RC-" + customerId); // new bagian 4
        // TODO Bantuan: validasi dulu sebelum mengisi field. Aturan nama sama dengan setName.
        // Bagian 4: kartu rental juga dibuat di sini (lihat diagram Bagian 4).
        //
        // Kerangka:
        //   if (customerId == null || ____) {
        //       throw new IllegalArgumentException("____");
        //   }
        //   this.customerId = customerId;
        //   setName(____);
    }

    public String getCustomerId() {
        return customerId;
        // TODO Bantuan: kembalikan data yang disimpan constructor.
    }

    public String getName() {
        return name;
        // TODO Bantuan: sama seperti getCustomerId.
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.name = name;
        // TODO Bantuan: periksa dulu, baru isi field.
        //
        // Kerangka:
        //   if (name == null || ____) {
        //       throw new IllegalArgumentException("____");
        //   }
        //   this.name = name;
    }

    public int getRentalCount() {
        return rentalCount;
        // TODO Bantuan: kembalikan jumlah sewa aktif saat ini.
    }

    public RentalCard getCard() {
        return card;
        //new method getter bagian 4
    }

    /** True jika pelanggan masih boleh menyewa (batasnya 2 sewa aktif). */
    public boolean canRent() {
        return rentalCount < 2;
        // TODO Bantuan: apakah perlu field baru, atau cukup dihitung dari data yang sudah ada?
        //
        // Kerangka:
        //   return rentalCount ____ 2;
    }

    /** Menambah jumlah sewa. Jika sudah di batas, tidak berubah dan hasilnya false. */
    public boolean addRental() {
        if (!canRent()) {
            return false;
        }
        rentalCount++;
        return true;
        // TODO Bantuan: periksa batas dulu. Adakah method lain di kelas ini yang sudah
        // menjawab pertanyaan "boleh atau tidak"?
        //
        // Kerangka:
        //   if (!____) {
        //       return false;
        //   }
        //   rentalCount++;
        //   return true;
    }

    /** Mengurangi jumlah sewa. Jika sudah tidak ada sewa, tidak berubah dan hasilnya false. */
    public boolean returnRental() {
        if (rentalCount == 0) {
            return false;
        }
        rentalCount--;
        return true;
        // TODO Bantuan: batas bawah jumlah sewa adalah berapa?
        //
        // Kerangka:
        //   if (rentalCount == ____) {
        //       return false;
        //   }
        //   rentalCount--;
        //   return true;
    }
}
