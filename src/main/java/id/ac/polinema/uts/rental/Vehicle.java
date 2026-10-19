package id.ac.polinema.uts.rental;

public class Vehicle {
    protected String model;
    protected int year;
    private boolean available;
    private int extraDays;

    public Vehicle(String model, int year) {
        setModel(model);
        setYear(year);
        this.available = true;
        this.extraDays = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model tidak boleh kosong");
        }
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1990) {
            throw new IllegalArgumentException("Tahun minimal 1990");
        }
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean rentOut() {
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    public void returnVehicle() {
        available = true;
    }
    //Method bagian 6
    public int dailyRate() {
        return 250000;
    }

    public String describe() {
        return model + " (" + year + ")";
    }

    @Override 
    public String toString() {
        return describe();
    }

    public void extendRental() {
        this.extraDays += 2;
    }

    public void extendRental(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Hari harus lebih dari 0");
        }
        this.extraDays += days;
    }

    public int getTotalRentalDays() {
        return 1 + extraDays;
    }
}
