package com.cristi.tdd;

/**
 * Created by criss on 3/5/16.
 */
public class TestTemplate {
    private Template template; @Before public void setUp() throws Exception { template = new Template("${one}, ${two}, ${three}"); template.set("one", "1"); template.set("two", "2"); template.set("three", "3"); } @Test public void multipleVariables() throws Exception { assertTemplateEvaluatesTo("1, 2, 3"); }
