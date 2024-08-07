package com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.controller;

import com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.dao.EnvironmentalDataRepository;
import com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.entity.EnvironmentalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("api/environmental")
public class EnvironmentalDataController {
    @Autowired
    private EnvironmentalDataRepository repository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the file contains data in "dataPoint,value" format
                String[] data = line.split(",");
                EnvironmentalData environmentalData = new EnvironmentalData();
                environmentalData.setDataPoint(data[0]);
                environmentalData.setValue(data[1]);
                repository.save(environmentalData);
            }
            return ResponseEntity.ok("File uploaded and data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file: " + e.getMessage());
        }
    }

    @GetMapping("/data")
    public List<EnvironmentalData> getAllData() {
        return repository.findAll();
    }
}
