package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.WhenFalseFirstLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.WhenTrueFirstLevel;
import com.ssaa.plantuml.levels.WhenTrueFurtherLevel;

public class WhenTrueFurtherLevelBuilder<T extends PlantUMLSourceBase> implements WhenTrueFurtherLevel<T> {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;
    private final T previousLevel;

    public WhenTrueFurtherLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder, T previousLevel) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenTrueFurtherLevel<T> activity(String label) {
        plantUMLSourceBuilder.whenTrueFurtherLevelActivity(label);
        return this;
    }

    @Override
    public ConditionLevel<WhenTrueFurtherLevel<T>> condition(String label) {
        plantUMLSourceBuilder.whenTrueFurtherLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public WhenTrueFurtherLevel<T> end() {
        plantUMLSourceBuilder.whenTrueFurtherLevelEnd();
        return this;
    }

    @Override
    public WhenFalseFirstLevel<T> whenFalse() {
        plantUMLSourceBuilder.whenTrueFurtherLevelWhenFalse();
        return whenFalseFirstLevel();
    }

    @Override
    public WhenTrueFirstLevel<T> elseCondition(String label) {
        plantUMLSourceBuilder.whenTrueFurtherLevelElseCondition(label);
        return new WhenTrueFirstLevelBuilder<T>(plantUMLSourceBuilder, previousLevel);
    }

    private WhenFalseFirstLevelBuilder<T> whenFalseFirstLevel() {
        return new WhenFalseFirstLevelBuilder<T>(plantUMLSourceBuilder, previousLevel);
    }

    private ConditionLevelBuilder<WhenTrueFurtherLevel<T>> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, this);
    }
}
