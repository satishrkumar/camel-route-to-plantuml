package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.levels.GeneralLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.SecondNodeLevel;

public class SecondNodeLevelBuilder implements SecondNodeLevel {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;

    public SecondNodeLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
    }

    @Override
    public GeneralLevel activity(String label) {
        plantUMLSourceBuilder.secondNodeActivity(label);
        return generalLevel();
    }

    @Override
    public ConditionLevel<GeneralLevel> condition(String label) {
        plantUMLSourceBuilder.secondNodeCondition(label);
        return conditionLevel();
    }

    @Override
    public GeneralLevel end() {
        plantUMLSourceBuilder.secondNodeEnd();
        return generalLevel();
    }

    private ConditionLevelBuilder<GeneralLevel> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, generalLevel());
    }

    private GeneralLevelBuilder generalLevel() {
        return new GeneralLevelBuilder(plantUMLSourceBuilder);
    }
}
