package com.ssaa.plantuml.steps;

import com.ssaa.plantuml.PlantUMLSourceBase;

public interface StartStep<T extends PlantUMLSourceBase> {
    T start();
}
