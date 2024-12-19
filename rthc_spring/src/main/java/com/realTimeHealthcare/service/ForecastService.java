package com.realTimeHealthcare.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Service to run forecast.py and provide path to forecast.json
 */
@Service
public class ForecastService {

    // Path to Python and script
    // If 'python3' is not on PATH, you may need the full path to Python interpreter

    String currentDirectory = System.getProperty("user.dir");
    
    String PYTHON_COMMAND = "python3"; 
    String SCRIPT_PATH =  currentDirectory + "/src/main/scripts/forecast.py";
    String FORECAST_JSON_PATH = currentDirectory + "/src/main/resources/static/data/forecast.json";

    /**
     * Runs the Python forecast script and waits for it to complete.
     * Throws RuntimeException if the script does not exit cleanly.
     */
    public void runForecastScript() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(PYTHON_COMMAND, SCRIPT_PATH);
        
        // Set the working directory to the scripts folder so relative paths inside the script work
        pb.directory(new File("src/main/scripts"));

        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Read the script output (optional, for debugging)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println("Python script output: " + line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Python script exited with code " + exitCode);
        }
    }

    /**
     * Returns the path to the forecast.json file.
     */
    public String getForecastJsonPath() {
        return FORECAST_JSON_PATH;
    }
}
