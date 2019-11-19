package com.ssaa.camel.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Link {
    private final Activity source;
    private final DiagramElement target;

    public Link(Activity source, DiagramElement target) {
        this.source = source;
        this.target = target;
    }

    public Activity getSource() {
        return source;
    }

    public DiagramElement getTarget() {
        return target;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Link that = (Link) o;

        return Objects.equals(this.source, that.source) &&
                Objects.equals(this.target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner("");
        sj.add(Objects.toString(this))
                .add("source").add(String.valueOf(source))
                .add("target").add(String.valueOf(target));
        return sj.toString();
    }

    public static interface SourceStep {
        TargetStep withSource(Activity source);
    }

    public static interface TargetStep {
        BuildStep withTarget(DiagramElement target);
    }

    public static interface BuildStep {
        Link build();
    }


    public static class Builder implements SourceStep, TargetStep, BuildStep {
        private Activity source;
        private DiagramElement target;

        private Builder() {
        }

        public static SourceStep link() {
            return new Builder();
        }

        @Override
        public TargetStep withSource(Activity source) {
            this.source = source;
            return this;
        }

        @Override
        public BuildStep withTarget(DiagramElement target) {
            this.target = target;
            return this;
        }

        @Override
        public Link build() {
            return new Link(
                    this.source,
                    this.target
            );
        }
    }
}
