package id.ac.polinema.uts.rental;

public class Motorcycle extends Vehicle {
    private int engineCc;

    public Motorcycle(String model, int year, int engineCc) {
        super(model, year);
        this.engineCc = engineCc;
    }

    public int getEngineCc() {
        return engineCc;
    }

    @Override 
    public int dailyRate() {
        return 100000;
    }

    @Override 
    public String describe() {
        return model + " (" + year + ") [" + engineCc + " cc]";
    }
}
