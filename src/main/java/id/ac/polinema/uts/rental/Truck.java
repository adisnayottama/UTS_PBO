package id.ac.polinema.uts.rental;

public class Truck extends Vehicle {
    private int loadTons;

    public Truck(String model, int year, int loadTons) {
        super(model, year);
        this.loadTons = loadTons;
    }

    public int getLoadTons() {
        return loadTons;
    }
}
