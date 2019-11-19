package com.ssaa.camel;

import java.util.List;

import com.ssaa.plantuml.PlantUMLSourceBase;
import com.ssaa.plantuml.PlantUMLSourceBuilder;
import com.ssaa.plantuml.levels.ConditionLevel;
import com.ssaa.plantuml.levels.FirstNodeLevel;
import com.ssaa.plantuml.levels.GeneralLevel;
import com.ssaa.plantuml.levels.SecondNodeLevel;
import com.ssaa.plantuml.levels.WhenFalseFirstLevel;
import com.ssaa.plantuml.levels.WhenFalseFurtherLevel;
import com.ssaa.plantuml.levels.WhenTrueFirstLevel;
import com.ssaa.plantuml.levels.WhenTrueFurtherLevel;
import com.ssaa.plantuml.steps.ActivityStep;
import com.ssaa.plantuml.steps.ConditionStep;
import com.ssaa.camel.model.Activity;
import com.ssaa.camel.model.Condition;
import com.ssaa.camel.model.DiagramElement;

public class PlantUMLComposer {
    public String toPlantUML(List<List<DiagramElement>> tree) {
        FirstNodeLevel firstNodeLevel = null;
        GeneralLevel builder = null;
        for (List<DiagramElement> elements : tree) {
            firstNodeLevel = next(firstNodeLevel, builder);
            SecondNodeLevel secondNodeLevel = firstNodeLevel.activity(getActivityLabel(elements.get(0)));
            builder = buildNode(GeneralLevel.class, secondNodeLevel, elements.get(1));
            for (int i = 2; i < elements.size(); i++) {
                DiagramElement diagramElement = elements.get(i);
                builder = buildNode(GeneralLevel.class, builder, diagramElement);
            }
        }
        return builder.build();
    }

    private FirstNodeLevel next(FirstNodeLevel firstNodeLevel, GeneralLevel builder) {
        if (firstNodeLevel == null) {
            firstNodeLevel = PlantUMLSourceBuilder.activityGraph();
        } else {
            firstNodeLevel = builder.beginAnother();
        }
        return firstNodeLevel;
    }

    private <R extends PlantUMLSourceBase, T extends PlantUMLSourceBase> R buildNode(Class<R> clazz, T builder, DiagramElement diagramElement) {
        if (diagramElement instanceof Activity) {
            return toActivityBuilder(clazz, builder).activity(getActivityLabel(diagramElement));
        } else {
            Condition condition = (Condition) diagramElement;
            WhenTrueFirstLevel<R> generalLevelWhenTrueFirstLevel = toConditionBuilder(clazz, builder)
                    .condition(condition.getExpression())
                    .whenTrue();

            WhenTrueFurtherLevel<R> whenTrue = buildNode(WhenTrueFurtherLevel.class, generalLevelWhenTrueFirstLevel, condition.getWhenTrue());
            WhenFalseFirstLevel<R> whenFalseFirstLevel = whenTrue.whenFalse();
            WhenFalseFurtherLevel<R> whenFalse = buildNode(WhenFalseFurtherLevel.class, whenFalseFirstLevel, condition.getWhenFalse());
            return whenFalse
                    .endIf();
        }
    }

    private <R extends PlantUMLSourceBase> ActivityStep<R> toActivityBuilder(Class<R> clazz, PlantUMLSourceBase builder) {
        return (ActivityStep<R>) builder;
    }

    private <R extends PlantUMLSourceBase> ConditionStep<ConditionLevel<R>> toConditionBuilder(Class<R> clazz, PlantUMLSourceBase builder) {
        return (ConditionStep<ConditionLevel<R>>) builder;
    }

    private String getActivityLabel(DiagramElement activity) {
        return ((Activity) activity).getLabel();
    }
}
