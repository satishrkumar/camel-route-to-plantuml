package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.BeginAnotherStep;
import com.ssaa.plantuml.steps.BuildStep;
import com.ssaa.plantuml.steps.ConditionStep;
import com.ssaa.plantuml.steps.EndStep;

public interface GeneralLevel extends
        PlantUMLSourceBase,
        EndStep<GeneralLevel>,
        ActivityStep<GeneralLevel>,
        ConditionStep<ConditionLevel<GeneralLevel>>,
        BeginAnotherStep<FirstNodeLevel>,
        BuildStep {
}
