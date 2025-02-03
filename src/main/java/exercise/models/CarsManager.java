package exercise.models;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static exercise.helpers.FileManager.jsonPath;
import static exercise.helpers.JsonHandler.*;

public class CarsManager {

    public static CarList cars;

    static {
        try {
            cars = deserializeCarsJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CarsManager(){}

    public void addCar(String brand, String model, int prodYear) throws IOException {
        cars = deserializeCarsJson(jsonPath);
        if(cars.getCars() == null){
            cars.setCars(new ArrayList<>());
        }
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

    public void rentCar(int id) throws IOException {
        cars = deserializeCarsJson(jsonPath);

        Car car = filterCarById(id).get();

        if(car.getIsAvailable()){
            car.setIsAvailable(false);
            System.out.println("You have rented " + car.getBrand() + " " + car.getModel() + " with id " + car.getId() );
        } else {
            System.out.println(car.getBrand() + " " + car.getModel() + " with id " + car.getId() + " is already rented");
        }

        writeCarsToJson(cars);
    }

    public void returnCar(int id) throws IOException {
        cars = deserializeCarsJson(jsonPath);

        Car car = filterCarById(id).get();

        if(car.getIsAvailable()){
            System.out.println(car.getBrand() + " " + car.getModel() + " with id " + car.getId() + " is available");
            System.out.println("You can't return it back!");
        } else {
            car.setIsAvailable(true);
            System.out.println("Thanks for returning " + car.getBrand() + " " + car.getModel() + " with id " + car.getId());
        }

        writeCarsToJson(cars);
    }

    private Optional<Car> filterCarById(int id){
        return cars.getCars().stream().filter(car -> car.getId() == id)
                .findFirst();
    }
}
