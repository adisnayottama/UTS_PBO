package id.ac.polinema.uts.rental;

public class Truck extends Vehicle {
    private int loadTons;

    public Truck(String model, int year, int loadTons) {
        super(model, year);
        this.loadTons = loadTons;
    }
    //Contructor overloading (2 parameter)
    public Truck(String model, int year) {
        super(model, year);
        this.loadTons = 5;
    }

    public int getLoadTons() {
        return loadTons;
    }
}
