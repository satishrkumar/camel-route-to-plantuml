package com.ssaa.camel;

import static com.google.common.collect.Iterables.getLast;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.ssaa.camel.model.DiagramElement;
import com.ssaa.camel.model.Link;

public class LinksToNodesTransformer {
    List<List<DiagramElement>> transformToElements(List<List<Link>> links) {
        return transform(links, input -> ImmutableList.<DiagramElement>builder().addAll(transform(input, new Function<Link, DiagramElement>() {
            @Override
            public DiagramElement apply(Link input) {
                return input.getSource();
            }
        })).add(getLast(input).getTarget()).build());
    }
}
