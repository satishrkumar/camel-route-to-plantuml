package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.EndStep;
import com.ssaa.plantuml.steps.ConditionStep;

public interface WhenTrueFirstLevel<T extends PlantUMLSourceBase> extends
        PlantUMLSourceBase,
        EndStep<WhenTrueFurtherLevel<T>>,
        ActivityStep<WhenTrueFurtherLevel<T>>,
        ConditionStep<ConditionLevel<WhenTrueFurtherLevel<T>>>
{}
