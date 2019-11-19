package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;

public interface ConditionStep<T extends PlantUMLSourceBase> {
    T condition(String label);
}
