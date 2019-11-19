package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;

public interface BeginAnotherStep<T extends PlantUMLSourceBase> {
    T beginAnother();
}
