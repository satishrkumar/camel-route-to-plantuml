package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.EndStep;
import com.ssaa.plantuml.steps.ConditionStep;

public interface WhenFalseFirstLevel<T extends PlantUMLSourceBase> extends
        PlantUMLSourceBase,
        EndStep<WhenFalseFurtherLevel<T>>,
        ActivityStep<WhenFalseFurtherLevel<T>>,
        ConditionStep<ConditionLevel<WhenFalseFurtherLevel<T>>>
{}
