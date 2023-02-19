package com.kkotto.model;

public class Car {
    private final String name;
    private final CarModel carModel;
    private final int engineCapacity;

    public Car(String name, CarModel carModel, int engineCapacity) {
        this.name = name;
        this.carModel = carModel;
        this.engineCapacity = engineCapacity;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public String getName() {
        return name;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }
}