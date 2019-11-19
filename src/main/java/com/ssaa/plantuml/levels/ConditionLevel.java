package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.WhenTrueStep;

public interface ConditionLevel<T extends PlantUMLSourceBase> extends
        PlantUMLSourceBase,
        WhenTrueStep<WhenTrueFirstLevel<T>>
{}
