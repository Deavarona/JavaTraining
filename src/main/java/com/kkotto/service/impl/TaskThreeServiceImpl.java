package com.kkotto.service.impl;

import com.kkotto.model.Car;
import com.kkotto.model.CarModel;
import com.kkotto.service.FileUtils;
import com.kkotto.service.TaskService;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class TaskThreeServiceImpl implements TaskService {
    private static TaskThreeServiceImpl instance;
    private final FileUtils fileUtils;
    private final int CARS_QUANTITY = 10;
    private final int MIN_ENGINE_CAPACITY_VALUE = 1;
    private final int MAX_ENGINE_CAPACITY_VALUE = 3;
    private final String RESULT_FILE_PATH = "result_files\\result_file.txt";
    private final String RECORD_SEPARATOR = " - ";
    private final String LINE_SEPARATOR = "\n";
    private final String NO_INFO_VALUE = "No info.";

    private TaskThreeServiceImpl() {
        fileUtils = FileUtils.getInstance();
    }

    public static TaskThreeServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskThreeServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        List<Car> listOfCars = generateCars();
        Map<Integer, List<Car>> groupedCars = groupByCapacity(listOfCars);
        int randomCapacity = new Random().nextInt(MAX_ENGINE_CAPACITY_VALUE - MIN_ENGINE_CAPACITY_VALUE + 1) + MIN_ENGINE_CAPACITY_VALUE;
        String carLinesByCapacity = findCarsByCapacity(groupedCars, randomCapacity);
        File resultFIle = new File(RESULT_FILE_PATH);
        fileUtils.writeToFile(resultFIle, carLinesByCapacity);
    }

    private Map<Integer, List<Car>> groupByCapacity(List<Car> listOfCars) {
        return listOfCars.stream()
                .collect(Collectors.groupingBy(Car::getEngineCapacity));
    }

    private List<Car> generateCars() {
        List<Car> listOfCars = new ArrayList<>();
        for (int i = 0; i < CARS_QUANTITY; i++) {
            int engineCapacity = new Random().nextInt(MAX_ENGINE_CAPACITY_VALUE - MIN_ENGINE_CAPACITY_VALUE + 1) + MIN_ENGINE_CAPACITY_VALUE;
            int carModel = new Random().nextInt(CarModel.values().length);
            listOfCars.add(new Car("Car " + i, CarModel.getById(carModel), engineCapacity));
        }
        return listOfCars;
    }

    private String findCarsByCapacity(Map<Integer, List<Car>> groupedCars, int selectedCapacity) {
        Set<Integer> engineCapacity = groupedCars.keySet();
        for (Integer capacity : engineCapacity) {
            if (capacity.equals(selectedCapacity)) {
                return createLinesOfList(groupedCars.get(capacity));
            }
        }
        return NO_INFO_VALUE;
    }

    private String createLinesOfList(List<Car> listOfCars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car cars : listOfCars) {
            stringBuilder.append(cars.getName())
                    .append(RECORD_SEPARATOR)
                    .append(cars.getCarModel())
                    .append(RECORD_SEPARATOR)
                    .append(cars.getEngineCapacity())
                    .append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
