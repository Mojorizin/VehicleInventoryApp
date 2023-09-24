public class Car {
    private String make, model, color;
    private int year, mileage;
    public void setCar(String carMake, String carModel, String carColor, int carYear, int carMileage) {
        make = carMake;
        model = carModel;
        color = carColor;
        year = carYear;
        mileage = carMileage;
    }
    public void printCar() {
        System.out.println("Vehicle: " + year + " " + color + " " + make + " " + model + " with " + mileage + " miles." );
    }
}
