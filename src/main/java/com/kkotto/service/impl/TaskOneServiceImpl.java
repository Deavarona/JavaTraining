package com.kkotto.service.impl;

import com.kkotto.service.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class TaskOneServiceImpl implements TaskService {
    private static TaskOneServiceImpl instance;
    private final int NUMBERS_QUANTITY = 3;
    private static final Logger logger = LogManager.getLogger(TaskOneServiceImpl.class);

    private TaskOneServiceImpl() {
    }

    public static TaskOneServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskOneServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        Random random = new Random();
        int firstNumber = random.nextInt();
        int secondNumber = random.nextInt();
        int thirdNumber = random.nextInt();
        int resultValue = firstNumber > thirdNumber ? firstNumber + secondNumber : thirdNumber;
        int averageValue = (firstNumber + secondNumber + thirdNumber) / NUMBERS_QUANTITY;
        logger.debug("Result: " + resultValue);
        logger.info("Average: " + averageValue);
    }
}
