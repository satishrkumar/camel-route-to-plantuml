package com.ssaa.plantuml.levels;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.StartStep;

public interface FirstNodeLevel extends
        PlantUMLSourceBase,
        StartStep<SecondNodeLevel>,
        ActivityStep<SecondNodeLevel>
{}
