package com.ssaa.camel.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


public class Condition implements DiagramElement {

    private final DiagramElement whenTrue;
    private final DiagramElement whenFalse;
    private final String expression;

    public Condition(
            DiagramElement whenTrue,
            DiagramElement whenFalse,
            String expression
    ) {

        this.whenTrue = whenTrue;
        this.whenFalse = whenFalse;
        this.expression = expression;
    }


    @Override
    public Set<DiagramElement> getOutputs() {
        Set<DiagramElement> diagramElements = Collections.emptySet();
        diagramElements.add(whenTrue);
        diagramElements.add(whenFalse);
        return Collections.unmodifiableSet(diagramElements);
    }

    public DiagramElement getWhenTrue() {
        return whenTrue;
    }

    public DiagramElement getWhenFalse() {
        return whenFalse;
    }

    public String getExpression() {
        return expression;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Condition that = (Condition) o;

        return Objects.equals(this.whenTrue, that.whenTrue) &&
                Objects.equals(this.whenFalse, that.whenFalse) &&
                Objects.equals(this.expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whenTrue, whenFalse, expression);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner("");
        sj.add(Objects.toString(this))
                .add("whenTrue").add(String.valueOf(whenTrue))
                .add("whenFalse").add(String.valueOf(whenFalse))
                .add("expression").add(String.valueOf(expression));
        return sj.toString();
    }

    public static interface WhenTrueStep {
        WhenFalseStep withWhenTrue(DiagramElement whenTrue);
    }

    public static interface WhenFalseStep {
        ExpressionStep withWhenFalse(DiagramElement whenFalse);
    }

    public static interface ExpressionStep {
        BuildStep withExpression(String expression);
    }

    public static interface BuildStep {
        Condition build();
    }


    public static class Builder implements WhenTrueStep, WhenFalseStep, ExpressionStep, BuildStep {
        private DiagramElement whenTrue;
        private DiagramElement whenFalse;
        private String expression;

        private Builder() {
        }

        public static WhenTrueStep condition() {
            return new Builder();
        }

        @Override
        public WhenFalseStep withWhenTrue(DiagramElement whenTrue) {
            this.whenTrue = whenTrue;
            return this;
        }

        @Override
        public ExpressionStep withWhenFalse(DiagramElement whenFalse) {
            this.whenFalse = whenFalse;
            return this;
        }

        @Override
        public BuildStep withExpression(String expression) {
            this.expression = expression;
            return this;
        }

        @Override
        public Condition build() {
            return new Condition(
                    this.whenTrue,
                    this.whenFalse,
                    this.expression
            );
        }
    }
}
