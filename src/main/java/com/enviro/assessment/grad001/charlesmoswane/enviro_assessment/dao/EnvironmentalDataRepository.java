package com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.dao;

import com.enviro.assessment.grad001.charlesmoswane.enviro_assessment.entity.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentalDataRepository extends JpaRepository<EnvironmentalData, Long> {
}