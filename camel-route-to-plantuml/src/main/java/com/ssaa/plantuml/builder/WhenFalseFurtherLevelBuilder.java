package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.WhenFalseFurtherLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;

public class WhenFalseFurtherLevelBuilder<T extends PlantUMLSourceBase> implements WhenFalseFurtherLevel<T> {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;
    private final T previousLevel;

    public WhenFalseFurtherLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder, T previousLevel) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenFalseFurtherLevel<T> activity(String label) {
        plantUMLSourceBuilder.whenFalseFurtherLevelActivity(label);
        return this;
    }

    @Override
    public ConditionLevel<WhenFalseFurtherLevel<T>> condition(String label) {
        plantUMLSourceBuilder.whenFalseFurtherLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public WhenFalseFurtherLevel<T> end() {
        plantUMLSourceBuilder.whenFalseFurtherLevelEnd();
        return this;
    }

    @Override
    public T endIf() {
        plantUMLSourceBuilder.whenFalseFurtherLevelEndIf();
        return previousLevel;
    }

    private ConditionLevelBuilder<WhenFalseFurtherLevel<T>> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, this);
    }
}
