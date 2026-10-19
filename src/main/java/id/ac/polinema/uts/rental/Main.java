package id.ac.polinema.uts.rental;

import java.util.Scanner;

/**
 * Titik awal program (satu-satunya method main di proyek ini).
 *
 * Bagian 1: baris PERTAMA output harus persis "Welcome to Polinema Rental".
 * Setelah itu kamu bebas menambah baris lain untuk bereksperimen.
 *
 * Bagian 7: di bawah baris sapaan, kamu akan membuat RentalShop, mengisi data
 * contoh, lalu menjalankan RentalApp. Kerangkanya ada di README.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Rental");

        RentalShop shop = new RentalShop("Polinema Rental");

        Car car = new Car("N 1234 AB", "Avanza", 2021, new Brand("Toyota", "Japan"));
        Motorcycle moto = new Motorcycle("Vario", 2022, 125);
        Truck truck = new Truck("Canter", 2020, 4);
        Customer customer = new Customer("C001", "Dewi");

        shop.addVehicle(car);
        shop.addVehicle(moto);
        shop.addVehicle(truck);
        shop.addCustomer(customer);

        RentalApp app = new RentalApp(shop, new Scanner(System.in), System.out);
        app.run();
        // TODO: Tampilkan sebuah teks ke layar.
        // Di Java, perintahnya berbentuk: System.out.println("teks kamu");
        // Ganti teks di dalam tanda kutip dengan teks dari soal. Huruf besar-kecil dan
        // spasi harus persis sama. Tulis perintahnya di dalam kurung kurawal main ini,
        // lalu jalankan programnya.
        //
        // Kerangka:
        //   System.out.println("____");

        // Bagian 7: lanjutkan di sini (buat RentalShop, isi data contoh, jalankan RentalApp).
    }
}
