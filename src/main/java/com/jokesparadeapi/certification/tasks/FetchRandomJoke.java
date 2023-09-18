package com.jokesparadeapi.certification.tasks;

import com.jokesparadeapi.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchRandomJoke implements Task {

    public FetchRandomJoke() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.RANDOME_JOKE).with(requestSpecification -> requestSpecification.log().all())
        );
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.lastResponse().prettyPrint();
    }

    public static FetchRandomJoke inJokesParadeApiResponseRandom() {
        return instrumented(FetchRandomJoke.class);
    }
}
