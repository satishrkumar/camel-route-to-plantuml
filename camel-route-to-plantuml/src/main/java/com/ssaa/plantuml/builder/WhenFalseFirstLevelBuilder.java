package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.levels.WhenFalseFurtherLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.WhenFalseFirstLevel;

public class WhenFalseFirstLevelBuilder<T extends PlantUMLSourceBase> implements WhenFalseFirstLevel<T> {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;
    private final T previousLevel;

    public WhenFalseFirstLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder, T previousLevel) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenFalseFurtherLevel<T> activity(String label) {
        plantUMLSourceBuilder.whenFalseFirstLevelActivity(label);
        return whenFalseFurtherLevel();
    }

    @Override
    public ConditionLevel<WhenFalseFurtherLevel<T>> condition(String label) {
        plantUMLSourceBuilder.whenFalseFirstLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public WhenFalseFurtherLevel<T> end() {
        plantUMLSourceBuilder.whenFalseFirstLevelEnd();
        return whenFalseFurtherLevel();
    }

    private ConditionLevelBuilder<WhenFalseFurtherLevel<T>> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, whenFalseFurtherLevel());
    }

    private WhenFalseFurtherLevelBuilder<T> whenFalseFurtherLevel() {
        return new WhenFalseFurtherLevelBuilder<T>(plantUMLSourceBuilder, previousLevel);
    }
}
