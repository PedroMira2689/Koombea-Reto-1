package com.jokesparadeapi.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/scenarios.jokesparadeapi.feature",
        glue = "com/jokesparadeapi/certification/stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "")
public class ScenariosJokesParadeRunner {
}

