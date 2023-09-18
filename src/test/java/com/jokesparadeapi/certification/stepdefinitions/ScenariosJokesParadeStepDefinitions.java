package com.jokesparadeapi.certification.stepdefinitions;

import com.jokesparadeapi.certification.questions.GetThe;
import com.jokesparadeapi.certification.questions.GetTheValue;
import com.jokesparadeapi.certification.questions.RetrieveThe;
import com.jokesparadeapi.certification.questions.RetrieveTheResponse;
import com.jokesparadeapi.certification.tasks.FetchJokes;
import com.jokesparadeapi.certification.tasks.FetchJokesNotFound;
import com.jokesparadeapi.certification.tasks.FetchRandomJoke;
import com.jokesparadeapi.certification.utils.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;


public class ScenariosJokesParadeStepDefinitions {
    Actor usuario = Actor.named("user");

//
    @Given("^that the user knows the jokes parade api$")
    public void that_the_user_knows_the_jokes_parade_api() {
        usuario.whoCan(CallAnApi.at(Constants.JOKES_API));
    }


    @When("^the user submits a request to look for a random programming jokes$")
    public void the_user_submits_a_request_to_look_for_a_random_programming_jokes() {
        usuario.attemptsTo(FetchJokes.inJokesParadeApi());

    }

    @Then("^the api response with (.*) status code$")
    public void the_api_response_with_status_code(int statusCode) {
        usuario.should(GivenWhenThen.seeThat(GetThe.statusCodeNumber(), Matchers.equalTo(statusCode)));
    }


    @Then("^the api response with an existing id$")
    public void the_api_response_with_an_existing_id() {
        usuario.should(GivenWhenThen.seeThat(RetrieveThe.ValueOfJokes(), Matchers.allOf(Matchers.notNullValue(), Matchers.not(Matchers.equalTo(0)))));

    }

    @Then("^the api response includes a header named Alt-Svc with the value of (.*)$")
    public void the_api_response_includes_a_header_named_Alt_Svc_with_the_value_of(String expectedValue) {
        usuario.should(GivenWhenThen.seeThat(RetrieveTheResponse.AltSvcHeaderValue("Alt-Svc"), Matchers.equalTo(expectedValue)));
    }

    @When("^the user submits an invalid request to look for a random programming jokes$")
    public void theUserSubmitsAnInvalidRequestToLookForARandomProgrammingJokes() {
        usuario.attemptsTo(FetchJokesNotFound.inJokesParadeApiResponse());
    }

    @When("^the user submits a request to look for a random joke$")
    public void theUserSubmitsARequestToLookForARandomJoke() {
        usuario.attemptsTo(FetchRandomJoke.inJokesParadeApiResponseRandom());

    }

    @And("^the api response with an existing type for a random joke$")
    public void theApiResponseWithAnExistingTypeForARandomJoke() {
        usuario.should(GivenWhenThen.seeThat(GetTheValue.ofRandomJoke(), Matchers.notNullValue()));

    }
}
