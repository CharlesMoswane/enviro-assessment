package com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.dao;

import com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.entity.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/environmental")
public interface EnvironmentalDataRepository extends JpaRepository<EnvironmentalData, Long> {
}