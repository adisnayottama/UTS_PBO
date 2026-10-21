package id.ac.polinema.uts.rental;

import java.util.Arrays;

public class RentalShop {
    //Enkapsulasi (private field)
    private String name;
    private Vehicle[] vehicles; // agregasi
    private int vehicleCount;
    private Customer[] customers;
    private int customerCount;

    // inisialisasi toko
    public RentalShop(String name) {
        this.name = name;
        this.vehicles = new Vehicle[20];
        this.vehicleCount = 0;
        this.customers = new Customer[10];
        this.customerCount = 0;
    }

    public String getName() {
        return name;
    }

    //proses agregasi => masuk array toko
    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicleCount >= 20) {
            return false;
        }
        vehicles[vehicleCount] = vehicle; // objek luar diagregasi
        vehicleCount++;
        return true;
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null || customerCount >= 10) {
            return false;
        }
        if (findCustomer(customer.getCustomerId()) != null) {
            return false;
        }
        customers[customerCount] = customer;
        customerCount++;
        return true;
    }

    public Vehicle[] getVehicles() {
        return Arrays.copyOf(vehicles, vehicleCount);
    }

    public Customer[] getCustomers() {
        return Arrays.copyOf(customers, customerCount);
    }

    public Vehicle findVehicleByModel(String model) {
        if (model == null) return null;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getModel().equalsIgnoreCase(model)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public Customer findCustomer(String customerId) {
        if (customerId == null) return null;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    public Vehicle[] searchByKeyword(String keyword) {
        if (keyword == null) {
            return new Vehicle[0];
        }
        Vehicle[] temp = new Vehicle[vehicleCount];
        int foundCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getModel().toLowerCase().contains(keyword.toLowerCase())) {
                temp[foundCount] = vehicles[i];
                foundCount++;
            }
        }
        return Arrays.copyOf(temp, foundCount);
    }

    //method transaksi ren dan giveBack
    public boolean rent(String customerId, String model) {
        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicleByModel(model);

        if (customer == null || vehicle == null) {
            return false;
        }

        if (customer.canRent() && vehicle.isAvailable()) {
            boolean rentSuccess = vehicle.rentOut();
            boolean addSuccess = customer.addRental();
            if (rentSuccess && addSuccess) {
                return true;
            }
        }
        return false; //logika sewa
    }

    public boolean giveBack(String customerId, String model) {
        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicleByModel(model);

        if (customer == null || vehicle == null) {
            return false;
        }

        // Pastikan kendaraan sedang disewa dan pelanggan punya sewa aktif
        if (!vehicle.isAvailable() && customer.getRentalCount() > 0) {
            vehicle.returnVehicle();
            return customer.returnRental();
        }
        return false; //logika pengembalian
    }
}