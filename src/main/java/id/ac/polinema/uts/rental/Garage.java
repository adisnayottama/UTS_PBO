package id.ac.polinema.uts.rental;

public class Garage {
    private String code;
    private Car[] cars;
    private int count;

    public Garage(String code) {
        this.code = code;
        this.cars = new Car[5];
        this.count = 0;
    }

    public String getCode() {
        return code;
    }

    public int getCarCount() {
        return count;
    }

    public boolean addCar(Car car) {
        if (car == null || count >= 5) {
            return false;
        }
        cars[count] = car;
        count++;
        return true;
    }
    
    public Car findByPlate(String plate) {
        for (int i = 0; i < count; i++) {
            if (cars[i].getPlate().equalsIgnoreCase(plate)) {
                return cars[i];
            }
        }
        return null;
    }

    public int countAvailable() {
        int availableCount = 0;
        for (int i = 0; i < count; i++) {
            if (cars[i].isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }
}
