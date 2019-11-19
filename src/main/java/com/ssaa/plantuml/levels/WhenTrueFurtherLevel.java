package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.ConditionStep;
import com.ssaa.plantuml.steps.ElseConditionStep;
import com.ssaa.plantuml.steps.EndStep;
import com.ssaa.plantuml.steps.WhenFalseStep;

public interface WhenTrueFurtherLevel<T extends PlantUMLSourceBase> extends
        PlantUMLSourceBase,
        EndStep<WhenTrueFurtherLevel<T>>,
        ActivityStep<WhenTrueFurtherLevel<T>>,
        ConditionStep<ConditionLevel<WhenTrueFurtherLevel<T>>>,
        WhenFalseStep<WhenFalseFirstLevel<T>>,
        ElseConditionStep<T> {
}
