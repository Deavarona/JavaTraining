package com.kkotto;

import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskThreeServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService taskOne = TaskOneServiceImpl.getInstance();
        TaskService taskTwo = TaskTwoServiceImpl.getInstance();
        TaskService taskThree = TaskThreeServiceImpl.getInstance();
        List<TaskService> taskServiceList = List.of(taskOne, taskTwo, taskThree);
        for (TaskService taskService : taskServiceList) {
            taskService.runTask();
        }
    }
}