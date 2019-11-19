package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.levels.GeneralLevel;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.FirstNodeLevel;

public class GeneralLevelBuilder implements GeneralLevel {
    private final PlantUMLSourceBuilder plantUMLSourceBuilder;

    public GeneralLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
    }

    @Override
    public GeneralLevel activity(String label) {
        plantUMLSourceBuilder.generalLevelActivity(label);
        return this;
    }

    @Override
    public FirstNodeLevel beginAnother() {
        plantUMLSourceBuilder.generalLevelBeginAnother();
        return firstNodeLevel();
    }

    @Override
    public String build() {
        return plantUMLSourceBuilder.build();
    }

    @Override
    public ConditionLevel condition(String label) {
        plantUMLSourceBuilder.generalLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public GeneralLevel end() {
        plantUMLSourceBuilder.generalLevelEnd();
        return this;
    }

    private ConditionLevelBuilder<GeneralLevel> conditionLevel() {
        return new ConditionLevelBuilder<>(plantUMLSourceBuilder, this);
    }

    private FirstNodeLevelBuilder firstNodeLevel() {
        return new FirstNodeLevelBuilder(plantUMLSourceBuilder);
    }
}
