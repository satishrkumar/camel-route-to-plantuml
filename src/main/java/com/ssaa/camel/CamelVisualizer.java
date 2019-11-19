package com.ssaa.camel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssaa.camel.model.Link;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.model.RouteDefinition;

public class CamelVisualizer {
    private final ModelCamelContext camelContext;
    private final CamelModelMapper camelModelMapper = new CamelModelMapper();
    private final LinksReducer linksReducer = new LinksReducer();
    private final LinksToNodesTransformer transformer = new LinksToNodesTransformer();
    private final PlantUMLComposer composer = new PlantUMLComposer();

    public CamelVisualizer(ModelCamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public String toPlantUML() {
        return composer.toPlantUML(
                transformer.transformToElements(
                        linksReducer.groupLinks(
                                mapRoutes(
                                        camelContext.getRouteDefinitions()
                                )
                        )
                )
        );
    }

    private Set<Link> mapRoutes(List<RouteDefinition> routeDefinitions) {
        Set<Link> links = new HashSet<Link>();
        for (RouteDefinition routeDefinition : routeDefinitions) {
            links.addAll(camelModelMapper.map(routeDefinition));
        }
        return links;
    }


}
