package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("prodYear")
    private int prodYear;

    public Car(){}

    public Car (String brand, String model, int prodYear){
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getProdYear(){
        return prodYear;
    }

    public String toString(){
        return "Car brand: " + brand + ", model: " + model + ", production year: " + prodYear;
    }
}
