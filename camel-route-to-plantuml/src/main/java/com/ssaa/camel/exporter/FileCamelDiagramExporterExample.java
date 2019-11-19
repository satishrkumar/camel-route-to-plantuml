package com.ssaa.camel.exporter;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.model.ModelCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by satishkumar on 19/11/2019.
 */
public class FileCamelDiagramExporterExample extends RouteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(FileCamelDiagramExporterExample.class);

    @Override
    public void configure() throws Exception {


        from("direct:startA")
                .process(exchange -> {
                    System.out.println("Satish");
                })
                .process("dddddddddddd")
                .transform(new Expression() {
                    @Override
                    public <T> T evaluate(final Exchange exchange, final Class<T> type) {
                        return null;
                    }
                })
                .to("direct:middle")
                .to("direct:middle1")
                .to("direct:middle8")
                .to("direct:middle9")
                .to("direct:middle10");


        from("direct:startB")
                .to("direct:middle");



        from("direct:middle")
                .choice()
                .when(header("propertyA").isEqualTo("firstValue"))
                .to("direct:endA")
                .when(header("propertyA").isEqualTo("secondValue"))
                .to("direct:endB")
                .otherwise()
                .to("direct:endC");
        from("direct:endB")
                .filter(header("propertyB").isGreaterThan(3))
                .to("direct:middle2")
                .to("direct:endC");
    }
    class DummyProcessor implements Processor {

        @Override
        public void process(final Exchange exchange) throws Exception {

        }
    }
    public ModelCamelContext buildContext() throws Exception {
        DummyProcessor dddddddddddd = new DummyProcessor();
        SimpleRegistry registry = new SimpleRegistry();
        registry.put("dddddddddddd", dddddddddddd);
        ModelCamelContext camelContext = new DefaultCamelContext(registry);
        camelContext.addRoutes(this);
        camelContext.start();
        return camelContext;
    }

    public static void main(String[] args) throws Exception {
        ModelCamelContext camelContext = new FileCamelDiagramExporterExample().buildContext();
        camelContext.getRouteDefinitions().forEach(route -> {
            LOG.info(route.toString());
            route.getInputs().forEach(in -> System.out.println("Input: "+in.getUri()));
            route.getOutputs().forEach(out -> System.out.println("Out: "+out.getClass()));
        });
        FileCamelDiagramExporter.fileExporter(camelContext, "example.plantuml", "example.png").export();
    }
}
