package com.rickandmortyapi.certification.tasks;

import com.rickandmortyapi.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchFakeCharacters implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.FAKE_CHARACTER_ENDPOINT)
        );
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.lastResponse().prettyPrint();
    }

    public static FetchFakeCharacters inRickAndMortyApi() {
        return instrumented(FetchFakeCharacters.class);
    }
}
