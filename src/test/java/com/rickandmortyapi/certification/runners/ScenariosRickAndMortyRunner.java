package com.rickandmortyapi.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/scenarios.rickandmortyapi.feature",
        glue = "com.rickandmortyapi.certification.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "")
public class ScenariosRickAndMortyRunner {
}
