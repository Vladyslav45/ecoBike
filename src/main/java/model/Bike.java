package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Bike implements Serializable{
    private String brand;
    private long weightOfTheBike;
    private boolean availabilityOfLight;
    private String color;
    private int price;
    private int maxSpeed;
    private long batteryCapacity;
    private int sizeOfTheWheels;
    private int numberOfGears;

    public Bike(String brand,int sizeOfTheWheels, int numberOfGears, long weightOfTheBike, boolean availabilityOfLight, String color, int price) {
        this.brand = brand;
        this.weightOfTheBike = weightOfTheBike;
        this.availabilityOfLight = availabilityOfLight;
        this.color = color;
        this.price = price;
        this.sizeOfTheWheels = sizeOfTheWheels;
        this.numberOfGears = numberOfGears;
    }

    public Bike(String brand, int maxSpeed, long weightOfTheBike, boolean availabilityOfLight, long batteryCapacity, String color, int price) {
        this.brand = brand;
        this.weightOfTheBike = weightOfTheBike;
        this.availabilityOfLight = availabilityOfLight;
        this.color = color;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return brand + ((brand.startsWith("FOLDING BIKE") ? " number of gears: " + numberOfGears + "; size of the wheels: " + sizeOfTheWheels : "; maximum speed: " + maxSpeed + "; battery capacity: " + batteryCapacity) +
                "; weight of the bike: " + weightOfTheBike + "; availability of lights at front and back: " + ((availabilityOfLight) ? "head/tail light" : "no head/tail light") +
                "; color: " + color + "; price: " + price);
    }
}
