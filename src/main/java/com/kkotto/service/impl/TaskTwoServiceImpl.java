package com.kkotto.service.impl;

import com.kkotto.service.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskTwoServiceImpl implements TaskService {
    private static TaskTwoServiceImpl instance;
    private final int MIN_NUMBER_VALUE = -300;
    private final int MAX_NUMBER_VALUE = 300;
    private final int NUMBERS_QUANTITY = 10;
    private static final Logger logger = LogManager.getLogger(TaskTwoServiceImpl.class);

    private TaskTwoServiceImpl() {
    }

    public static TaskTwoServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskTwoServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        List<Integer> listOfNumbers = generateListOfNumbers();
        int minValue = findMinValue(listOfNumbers);
        int maxValue = findMaxValue(listOfNumbers);
        logger.info("Min is " + minValue + "; Max is " + maxValue);
        changeElement(listOfNumbers, maxValue, minValue);
        printList(listOfNumbers);
    }

    private List<Integer> generateListOfNumbers() {
        int excludeMinBound = 1;
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBERS_QUANTITY; i++) {
            listOfNumbers.add(new Random().nextInt(MAX_NUMBER_VALUE - MIN_NUMBER_VALUE) + (MIN_NUMBER_VALUE + excludeMinBound));
        }
        return listOfNumbers;
    }

    private int findMinValue(List<Integer> listOfNumbers) {
        int minValue = listOfNumbers.get(0);
        for (Integer value : listOfNumbers) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    private int findMaxValue(List<Integer> listOfNumbers) {
        int maxValue = listOfNumbers.get(0);
        for (Integer value : listOfNumbers) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private void changeElement(List<Integer> listOfNumbers, int firstValue, int secondValue) {
        listOfNumbers.set(listOfNumbers.indexOf(firstValue), firstValue * secondValue);
    }

    private void printList(List<Integer> listOfNumbers) {
        for (Integer number : listOfNumbers) {
            logger.error(number);
        }
    }
}
