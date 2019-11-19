package com.ssaa.plantuml;

import com.ssaa.plantuml.levels.FirstNodeLevel;
import com.ssaa.plantuml.builder.FirstNodeLevelBuilder;

import java.util.LinkedList;
import java.util.List;

public class PlantUMLSourceBuilder {

    private final List<Line> lines = new LinkedList<Line>();

    private PlantUMLSourceBuilder(){}

    public static FirstNodeLevel activityGraph() {
        PlantUMLSourceBuilder plantUMLSourceBuilder = new PlantUMLSourceBuilder();
        return new FirstNodeLevelBuilder(plantUMLSourceBuilder);
    }

    public void firstNodeActivity(final String label) {
        lines.add(() -> "\""+label+"\" ");
    }

    public void firstNodeStart() {
        lines.add(() -> "(*) ");
    }

    public void secondNodeActivity(final String label) {
        lines.add(() -> "--> \""+label+"\"\n");
    }

    public void secondNodeCondition(final String label) {
        lines.add(() -> "--> if \""+label+"\" then\n");
    }

    public void secondNodeEnd() {
        lines.add(() -> "--> (*)\n");
    }

    public void generalLevelActivity(final String label) {
        lines.add(() -> "--> \""+label+"\"\n");
    }

    public void generalLevelBeginAnother() {
        lines.add(() -> "\n");
    }

    public void generalLevelCondition(final String label) {
        lines.add(() -> "--> if \""+label+"\" then\n");
    }

    public void generalLevelEnd() {
        lines.add(() -> "--> (*)\n");
    }

    public void conditionLevelWhenTrue() {
        lines.add(() -> "  -->[true] ");
    }

    public void whenTrueFirstLevelActivity(final String label) {
        lines.add(() -> "\""+label+"\"\n");
    }

    public void whenTrueFirstLevelCondition(final String label) {
        lines.add(() -> "if \""+label+"\" then\n");
    }

    public void whenTrueFirstLevelEnd() {
        lines.add(() -> "(*)\n");
    }

    public void whenTrueFurtherLevelActivity(final String label) {
        lines.add(() -> "  --> \""+label+"\"\n");
    }

    public void whenTrueFurtherLevelCondition(final String label) {
        lines.add(() -> "  --> if \""+label+"\" then\n");
    }

    public void whenTrueFurtherLevelEnd() {
        lines.add(() -> "  --> (*)");
    }

    public void whenTrueFurtherLevelWhenFalse() {
        lines.add(() -> "else\n" +
               "  -->[false] ");
    }

    public void whenTrueFurtherLevelElseCondition(final String label) {
        lines.add(() -> "else\n" +
               "  -->[false] if \""+label+"\" then\n" +
               "  -->[true] ");

    }

    public void whenFalseFirstLevelActivity(String label) {
        whenTrueFirstLevelActivity(label);
    }

    public void whenFalseFirstLevelCondition(String label) {
        whenTrueFirstLevelCondition(label);
    }

    public void whenFalseFirstLevelEnd() {
        whenTrueFirstLevelEnd();
    }

    public void whenFalseFurtherLevelActivity(String label) {
        whenTrueFirstLevelActivity(label);
    }

    public void whenFalseFurtherLevelCondition(String label) {
        whenTrueFirstLevelCondition(label);
    }

    public void whenFalseFurtherLevelEnd() {
        whenTrueFirstLevelEnd();
    }

    public void whenFalseFurtherLevelEndIf() {
        lines.add(() -> "endif\n");
    }

    public String build() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("@startuml\n")
                .append("scale 750 width\n" +
                        "skinparam backgroundColor #AAFFFF\n" +
                        "skinparam activity {\n" +
                        "  StartColor red\n" +
                        "  BarColor SaddleBrown\n" +
                        "  EndColor Silver\n" +
                        "  BackgroundColor Peru\n" +
                        "  BackgroundColor<< Begin >> Olive\n" +
                        "  BorderColor Peru\n" +
                        "\n" +
                        "}\n\n");
        for (Line line : lines) {
            stringBuilder.append(line.toPlantUML());
        }

        return stringBuilder.append('\n')
                .append("@enduml")
                .toString();
    }
}
