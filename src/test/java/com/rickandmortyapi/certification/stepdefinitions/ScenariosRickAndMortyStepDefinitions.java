package com.rickandmortyapi.certification.stepdefinitions;

import com.rickandmortyapi.certification.models.characters.Data;
import com.rickandmortyapi.certification.questions.GetThe;
import com.rickandmortyapi.certification.questions.ObtainThe;
import com.rickandmortyapi.certification.questions.RecieveThe;
import com.rickandmortyapi.certification.questions.RetrieveThe;
import com.rickandmortyapi.certification.tasks.*;
import com.rickandmortyapi.certification.utils.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

public class ScenariosRickAndMortyStepDefinitions {
    Actor usuario = Actor.named("user");


    @Given("^that the user knows the rick and morty api$")
    public void that_the_user_knows_the_rick_and_morty_api() {
        usuario.whoCan(CallAnApi.at(Constants.RICKANDMORTY_URL));
    }


    //Characters

    @When("^the user submits a request to fetch a real character with id$")
    public void theUserSubmitsARequestToFetchARealCharacterWithId(List<Data> idValue) {
        usuario.attemptsTo(FetchRealCharacters.inRickAndMortyApi(idValue.get(0).getIdValue()));
    }

    @Then("^the api response shows us the (.*) status code$")
    public void the_api_response_shows_us_the_status_code(int statusCode) {
        usuario.should(GivenWhenThen.seeThat(GetThe.statusCodeNumber(), Matchers.equalTo(statusCode)));
    }

    @And("^the api response includes a field named id with the value of$")
    public void the_api_response_includes_a_field_named_id_with_the_value_of(List<Data> idValue) {
        usuario.should(GivenWhenThen.seeThat(RetrieveThe.valueOfTheCharactersId(), Matchers.equalTo(String.valueOf(idValue.get(0).getIdValue()))));
    }


    @And("^the api response includes a header named X-Nf-Request-Id with the value of (.*)$")
    public void theApiResponseIncludesAHeaderNamedXNfRequestIdWithTheValueOfHW(String header) {
        usuario.should(GivenWhenThen.seeThat(actor -> actor.recall("header"), Matchers.containsString(header)));
    }

    @When("^the user submits a request to fetch a fake character$")
    public void the_user_submits_a_request_to_fetch_a_fake_character() {
        usuario.attemptsTo(FetchFakeCharacters.inRickAndMortyApi());
    }


    //Locations

    @When("^the user submits a request to fetch a real location with id$")
    public void theUserSubmitsARequestToFetchARealLocationWithId(List<Data> idValue) {
        usuario.attemptsTo(FetchRealLocation.inRickAndMortyApi(idValue.get(0).getIdValue()));
    }

    @When("^the user submits a request to fetch a fake location$")
    public void theUserSubmitsARequestToFetchAFakeLocation() {
        usuario.attemptsTo(FetchFakeLocation.inRickAndMortyApi());
    }

    @And("^the locations api response includes a field named id with the value of$")
    public void theLocationsApiResponseIncludesAFieldNamedIdWithTheValueOf(List<Data> idValue) {
        usuario.should(GivenWhenThen.seeThat(ObtainThe.valueOfTheLocationsId(), Matchers.equalTo(idValue.get(0).getIdValue())));
    }


    //Episodes

    @When("^the user submits a request to fetch a real episode with id$")
    public void theUserSubmitsARequestToFetchARealEpisodeWithId(List<Data> idValue) {
        usuario.attemptsTo(FetchRealEpisode.inRickAndMortyApi(idValue.get(0).getIdValue()));
    }

    @When("^the user submits a request to fetch a fake episode$")
    public void theUserSubmitsARequestToFetchAFakeEpisode() {
        usuario.attemptsTo(FetchFakeEpisode.inRickAndMortyApi());
    }

    @And("^the episodes api response includes a field named id with the value of$")
    public void theEpisodesApiResponseIncludesAFieldNamedIdWithTheValueOf(List<Data> idValue) {
        usuario.should(GivenWhenThen.seeThat(RecieveThe.valueOfTheEpisodesId(), Matchers.equalTo(idValue.get(0).getIdValue())));
    }

    @And("^The api response includes a header named X-Nf-Request-Id with the value of (.*)$")
    public void theApiResponseIncludesAHeaderNamedXNfRequestIdWithTheValueOfH(String header) {
        usuario.should(GivenWhenThen.seeThat(actor -> actor.recall("header"), Matchers.containsString(header)));
    }
}
