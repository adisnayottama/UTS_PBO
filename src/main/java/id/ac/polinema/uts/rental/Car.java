package id.ac.polinema.uts.rental;

/**
 * Bagian 2 dan 3: mobil rental.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setBrand, getBrand, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public String plate;
 *   public ____ model;
 *   public ____ year;
 *   public ____ available;
 */
public class Car extends  Vehicle{ //inheritance
    private String plate;
    private Brand brand;

    /**
     * Membuat mobil baru yang masih tersedia (belum disewa).
     * Bagian 3: plate tidak boleh kosong; model dan year divalidasi seperti setter-nya
     * (tahun minimal 1990).
     */
    public Car(String plate, String model, int year) {
        super(model, year); // memanggil constructor vehicle
        if (plate == null || plate.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate tidak boleh kosong");
        }
        this.plate = plate;
        // TODO Bantuan: isi semua field. Mobil baru: apakah sedang disewa atau tidak?
        // Bagian 3: aturan validasi model dan tahun sama dengan setter. Bisakah constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        //   this.plate = plate;
        //   this.model = ____;
        //   this.year = ____;
        //   this.available = ____;
        //
        // Kerangka (Bagian 3): ganti dua baris model dan year dengan pemanggilan setter.
        //   setModel(____);
        //   setYear(____);
    }
    //Constructor overloading (langsing isi merk)
    public Car(String plate, String model, int year, Brand brand){
        this(plate, model, year);
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
        // TODO Bantuan: kembalikan data yang disimpan constructor.
        //
        // Kerangka:
        //   return ____;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override 
    public int dailyRate() {
        return 350000;
    }

    @Override 
    public String describe() {
        String brandName = (brand != null) ? brand.getName() : "Unknown" ;
        return model + " (" + year + ") - " + brandName;
    }
}
