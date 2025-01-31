package exercise.models;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static exercise.helpers.JsonHandler.*;

public class CarsManager {
    private static final String jsonPath = "src/main/resources/cars.json";
    public static CarList cars;

    static {
        try {
            cars = deserializeCarsJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CarsManager() throws IOException {
    }

    public void addCar(String brand, String model, int prodYear) throws IOException {
        cars = deserializeCarsJson(jsonPath);
        cars.getCars().add(new Car(brand, model, prodYear));
        writeCarsToJson(cars);
    }

    public void countCarsAge(String brand, String model){
        List<Car> filteredCars = cars.getCars().stream().filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getModel().equals(model))
                .toList();

        for (Car car : filteredCars){
            int carsAge = (Year.now().getValue()) - car.getProdYear();
            System.out.println(car.getBrand() + " " + car.getModel() + ", is " + carsAge + " years old.");
        }
    }

    public void printCarsByAge(int prodYear){
        cars.getCars().stream().filter(car -> car.getProdYear() >= prodYear)
                .sorted(Comparator.comparingInt(Car::getProdYear))
                .forEach(System.out::println);
    }
}
