package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.levels.WhenTrueFirstLevel;

public interface ElseConditionStep<T extends PlantUMLSourceBase> {
    WhenTrueFirstLevel<T> elseCondition(String label);
}
