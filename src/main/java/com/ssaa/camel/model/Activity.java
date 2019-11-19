package com.ssaa.camel.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


public class Activity implements DiagramElement {
    private final String label;

    public Activity(String label) {
        this.label = label;
    }

    public static Activity activity(String label) {
        return new Activity(label);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Activity that = (Activity) o;

        return Objects.equals(this.label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(label);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner("");
        sj.add(Objects.toString(this))
                .add("label").add(String.valueOf(label));
        return sj.toString();
    }

    @Override
    public Set<DiagramElement> getOutputs() {
        return Collections.<DiagramElement>singleton(this);
    }
}
