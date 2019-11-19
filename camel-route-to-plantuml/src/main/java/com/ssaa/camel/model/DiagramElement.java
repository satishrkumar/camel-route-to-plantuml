package com.ssaa.camel.model;

import java.util.Set;

public interface DiagramElement {
    Set<DiagramElement> getOutputs();
}
