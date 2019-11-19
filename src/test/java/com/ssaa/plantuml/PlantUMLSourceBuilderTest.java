package com.ssaa.plantuml;


import static com.ssaa.plantuml.PlantUMLSourceBuilder.activityGraph;
import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.junit.Test;

public class PlantUMLSourceBuilderTest {
    @Test
    public void shouldCreateBasicActivityGraphWithStartEndAndOneActivity() throws Exception {
        assertThat(
                activityGraph()
                        .start()
                        .activity("Some Activity")
                        .end()
                        .build()
        ).isEqualTo(read("/startEnd.plantuml"));

    }

    @Test
    public void shouldCreateActivityGraphWithJoin() throws Exception {
        assertThat(
                activityGraph()
                        .activity("Source 1")
                        .activity("Some activity")
                        .end()
                        .beginAnother()
                        .activity("Source 2")
                        .activity("Some other activity")
                        .end()
                        .build()
        ).isEqualTo(read("/join.plantuml"));

    }

    @Test
    public void shouldCreateActivityGraphWithCondition() throws Exception {
        assertThat(
                activityGraph()
                        .start()
                        .condition("A Condition")
                        .whenTrue()
                        .activity("When true action")
                        .whenFalse()
                        .activity("When false action")
                        .endIf()
                        .beginAnother()
                        .activity("When true action").end()
                        .beginAnother()
                        .activity("When false action").end()
                        .build()
        ).isEqualTo(read("/condition.plantuml"));

    }

    @Test
    public void shouldCreateActivityGraphWithMultiCondition() throws Exception {
        assertThat(
                activityGraph()
                        .start()
                        .condition("A Condition")
                        .whenTrue()
                        .activity("When true action")
                        .elseCondition("Another condition")
                        .activity("This was else if")
                        .whenFalse()
                        .activity("When false action")
                        .condition("Nested condition")
                        .whenTrue()
                        .activity("When nested condition true")
                        .whenFalse()
                        .activity("When nested condition false")
                        .endIf()
                        .endIf()
                        .beginAnother()
                        .activity("When true action").end()
                        .beginAnother()
                        .activity("When false action").end()
                        .build()
        ).isEqualTo(read("/conditions.plantuml"));

    }

    private String read(String path) throws IOException {
        return readFileToString(new File(getClass().getResource(path).getFile()), (String) null).replaceAll("\\r", "");
    }

    private String readFileToString(final File file, final String charEncoding) throws IOException {
        return Files.lines(file.toPath()).collect(Collectors.toList()).stream().collect(Collectors.joining("\n"));
    }

}