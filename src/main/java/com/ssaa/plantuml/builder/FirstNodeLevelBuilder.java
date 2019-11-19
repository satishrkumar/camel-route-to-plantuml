package com.ssaa.plantuml.builder;

import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.FirstNodeLevel;
import com.ssaa.plantuml.levels.SecondNodeLevel;

public class FirstNodeLevelBuilder implements FirstNodeLevel {

    private final PlantUMLSourceBuilder plantUMLSourceBuilder;

    public FirstNodeLevelBuilder(PlantUMLSourceBuilder plantUMLSourceBuilder) {
        this.plantUMLSourceBuilder = plantUMLSourceBuilder;
    }

    @Override
    public SecondNodeLevel activity(String label) {
        plantUMLSourceBuilder.firstNodeActivity(label);
        return next();
    }

    @Override
    public SecondNodeLevel start() {
        plantUMLSourceBuilder.firstNodeStart();
        return next();
    }

    private SecondNodeLevelBuilder next() {
        return new SecondNodeLevelBuilder(plantUMLSourceBuilder);
    }
}
