package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.WhenTrueFirstLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.WhenTrueFurtherLevel;

public class WhenTrueFirstLevelBuilder<T extends PlantUMLSourceBase> implements WhenTrueFirstLevel<T> {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;
    private final T previousLevel;

    public WhenTrueFirstLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder, T previousLevel) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenTrueFurtherLevel<T> activity(String label) {
        plantUMLSourceBuilder.whenTrueFirstLevelActivity(label);
        return whenTrueFurtherLevel();
    }

    @Override
    public ConditionLevel<WhenTrueFurtherLevel<T>> condition(String label) {
        plantUMLSourceBuilder.whenTrueFirstLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public WhenTrueFurtherLevel<T> end() {
        plantUMLSourceBuilder.whenTrueFirstLevelEnd();
        return whenTrueFurtherLevel();
    }

    private ConditionLevelBuilder<WhenTrueFurtherLevel<T>> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, whenTrueFurtherLevel());
    }

    private WhenTrueFurtherLevelBuilder<T> whenTrueFurtherLevel() {
        return new WhenTrueFurtherLevelBuilder<T>(plantUMLSourceBuilder, previousLevel);
    }
}
