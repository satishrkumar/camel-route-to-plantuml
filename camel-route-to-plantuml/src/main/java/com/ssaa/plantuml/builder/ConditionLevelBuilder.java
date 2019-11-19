package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.WhenTrueFirstLevel;

public class ConditionLevelBuilder<T extends PlantUMLSourceBase> implements ConditionLevel<T> {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;
    private final T previousLevel;

    public ConditionLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder, T previousLevel) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenTrueFirstLevel<T> whenTrue() {
        plantUMLSourceBuilder.conditionLevelWhenTrue();
        return new WhenTrueFirstLevelBuilder<>(plantUMLSourceBuilder, previousLevel);
    }
}
