package com.kkotto.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    private static FileUtils instance;
    static final Logger logger = LogManager.getLogger(FileUtils.class);

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    public void writeToFile(File file, String lines) {
        if (!file.exists()) {
            file = createFile(file.getPath());
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(lines);
        } catch (IOException e) {
            logger.error("Impossible to write to file " + file.getName());
        }
    }

    public File createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                logger.info(file.getName() + " was successfully created.");
            } else {
                logger.info(file.getName() + " already exists.");
            }
        } catch (IOException e) {
            logger.error("Impossible to create file " + file.getName());
        }
        return file;
    }
}
