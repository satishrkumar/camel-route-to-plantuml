package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.EndStep;
import com.ssaa.plantuml.steps.ConditionStep;

public interface SecondNodeLevel extends
        PlantUMLSourceBase,
        EndStep<GeneralLevel>,
        ActivityStep<GeneralLevel>,
        ConditionStep<ConditionLevel<GeneralLevel>>
{}
