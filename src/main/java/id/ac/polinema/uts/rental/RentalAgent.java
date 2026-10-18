package id.ac.polinema.uts.rental;

public class RentalAgent {
    
    public boolean rent(Customer customer, Car car) {
        if (customer == null || car == null) {
            return false;
        }
        if (customer.canRent() && car.isAvailable()) {
            boolean rentSuccess = car.rentOut();
            boolean addSuccess = customer.addRental();
            if (rentSuccess && addSuccess) {
                return true;
            }
        }
        return false;
    }

    public boolean giveBack(Customer customer, Car car) {
        if (customer == null || car == null) {
            return false;
        }
        car.returnVehicle();
        boolean returnSuccess = customer.returnRental();
        return returnSuccess;
    }
}
