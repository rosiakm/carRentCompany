package exercise.runner;

import exercise.models.CarsManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarsManager carsManager = new CarsManager();

        //cars.countCarsAge("Renault", "Captur");
        //cars.printCarsByAge(2020);
        //carsManager.addCar("Kia","Sportage",2023);
        carsManager.printCarsByAge(2018);
    }
}
