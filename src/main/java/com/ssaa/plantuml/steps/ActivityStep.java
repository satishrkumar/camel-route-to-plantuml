package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;

public interface ActivityStep<T extends PlantUMLSourceBase> {
    T activity(String label);
}
