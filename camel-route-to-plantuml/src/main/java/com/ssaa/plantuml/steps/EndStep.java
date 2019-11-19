package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;

public interface EndStep<T extends PlantUMLSourceBase> {
    T end();
}
