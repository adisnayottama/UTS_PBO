package id.ac.polinema.uts.rental;

import java.io.PrintStream;
import java.util.Scanner;

public class RentalApp {

    private RentalShop shop;
    private Scanner in;
    private PrintStream out;

    public RentalApp(RentalShop shop, Scanner in, PrintStream out) {
        this.shop = shop;
        this.in = in;
        this.out = out;
    }

    // Menu tampil lagi dan lagi sampai pengguna memilih 0 atau input habis.
    public void run() {
        while (true) {
            printMenu();
            if (!in.hasNextLine()) {
                return;
            }
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1": showVehicles(); break;
                case "2": addCar(); break;
                case "3": addMotorcycle(); break;
                case "4": addTruck(); break;
                case "5": registerCustomer(); break;
                case "6": rentVehicle(); break;
                case "7": returnVehicle(); break;
                case "8": searchVehicles(); break;
                case "9": showCustomers(); break;
                case "0":
                    out.println("Thank you");
                    return;
                default:
                    out.println("Unknown option");
            }
        }
    }

    // Mencetak prompt (tanpa pindah baris), lalu membaca satu baris tanpa spasi di ujung.
    private String readLine(String prompt) {
        out.print(prompt);
        if (!in.hasNextLine()) {
            return "";
        }
        return in.nextLine().trim();
    }

    // Bilangan bulat positif, atau -1 jika isinya bukan bilangan positif.
    private int readInt(String prompt) {
        String text = readLine(prompt);
        if (text.isEmpty() || text.length() > 9) {
            return -1;
        }
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return -1;
            }
        }
        int value = Integer.parseInt(text);
        return value > 0 ? value : -1;
    }

    // TODO: printMenu, line(Vehicle), showVehicles, addCar, addMotorcycle, addTruck,
    private void printMenu() {
        out.println("=== " + shop.getName() + " ===");
        out.println("1. List vehicles");
        out.println("2. Add car");
        out.println("3. Add motorcycle");
        out.println("4. Add truck");
        out.println("5. Register customer");
        out.println("6. Rent vehicle");
        out.println("7. Return vehicle");
        out.println("8. Search vehicles");
        out.println("9. List customers");
        out.println("0. Exit");
        out.print("Choose: ");
    }
    private void line(Vehicle v) {
        String status = v.isAvailable() ? "Available" : "Rented";
        out.println(v.describe() + " | " + status + " | Rp" + v.dailyRate() + "/day");
    }

    private void showVehicles() {
        Vehicle[] vehicles = shop.getVehicles();
        if (vehicles.length == 0) {
            out.println("No vehicles");
            return;
        }
        for (Vehicle v : vehicles) {
            line(v);
        }
    }

    private void addCar() {
        String plate = readLine("Plate: ");
        String model = readLine("Model: ");
        int year = readInt("Year: ");
        
        if (plate.isEmpty() || model.isEmpty()) {
            out.println("Invalid input");
            return;
        }
        if (year < 1990) {
            out.println("Invalid number");
            return;
        }

        String brandName = readLine("Brand name (blank for none): ");
        Brand brand = null;
        if (!brandName.isEmpty()) {
            String brandCountry = readLine("Brand country: ");
            if (!brandCountry.isEmpty()) {
                brand = new Brand(brandName, brandCountry);
            }
        }

        Car car = new Car(plate, model, year, brand);
        boolean success = shop.addVehicle(car);
        if (success) {
            out.println("Vehicle added");
        } else {
            out.println("Fleet is full");
        }
    }

    private void addMotorcycle() {
        String model = readLine("Model: ");
        int year = readInt("Year: ");
        int engine = readInt("Engine (cc): ");

        if (model.isEmpty()) {
            out.println("Invalid input");
            return;
        }
        if (year < 1990 || engine <= 0) {
            out.println("Invalid number");
            return;
        }

        Motorcycle moto = new Motorcycle(model, year, engine);
        boolean success = shop.addVehicle(moto);
        if (success) {
            out.println("Vehicle added");
        } else {
            out.println("Fleet is full");
        }
    }

    private void addTruck() {
        String model = readLine("Model: ");
        int year = readInt("Year: ");
        int load = readInt("Load (tons): ");

        if (model.isEmpty()) {
            out.println("Invalid input");
            return;
        }
        if (year < 1990 || load <= 0) {
            out.println("Invalid number");
            return;
        }

        Truck truck = new Truck(model, year, load);
        boolean success = shop.addVehicle(truck);
        if (success) {
            out.println("Vehicle added");
        } else {
            out.println("Fleet is full");
        }
    }

    private void registerCustomer() {
        String customerId = readLine("Customer ID: ");
        String name = readLine("Name: ");

        if (customerId.isEmpty() || name.isEmpty()) {
            out.println("Invalid input");
            return;
        }

        Customer customer = new Customer(customerId, name);
        boolean success = shop.addCustomer(customer);
        if (success) {
            out.println("Customer registered");
        } else {
            out.println("Customer ID already exists");
        }
    }

    private void rentVehicle() {
        String customerId = readLine("Customer ID: ");
        String model = readLine("Model: ");

        if (customerId.isEmpty() || model.isEmpty()) {
            out.println("Rental failed");
            return;
        }

        boolean success = shop.rent(customerId, model);
        if (success) {
            out.println("Rental successful");
        } else {
            out.println("Rental failed");
        }
    }

    private void returnVehicle() {
        String customerId = readLine("Customer ID: ");
        String model = readLine("Model: ");

        if (customerId.isEmpty() || model.isEmpty()) {
            out.println("Return failed");
            return;
        }

        boolean success = shop.giveBack(customerId, model);
        if (success) {
            out.println("Return successful");
        } else {
            out.println("Return failed");
        }
    }

    private void searchVehicles() {
        String keyword = readLine("Keyword: ");
        if (keyword.isEmpty()) {
            out.println("No vehicles found");
            return;
        }

        Vehicle[] results = shop.searchByKeyword(keyword);
        if (results.length == 0) {
            out.println("No vehicles found");
            return;
        }

        for (Vehicle v : results) {
            line(v);
        }
    }

    private void showCustomers() {
        Customer[] customers = shop.getCustomers();
        if (customers.length == 0) {
            out.println("No customers");
            return;
        }
        for (Customer c : customers) {
            out.println(c.getCustomerId() + " - " + c.getName() + " (" + c.getRentalCount() + " rentals)");
        }
    }

    // registerCustomer, rentVehicle, returnVehicle, searchVehicles, showCustomers
}