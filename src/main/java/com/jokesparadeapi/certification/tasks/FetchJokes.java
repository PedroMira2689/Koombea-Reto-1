package com.jokesparadeapi.certification.tasks;

import com.jokesparadeapi.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchJokes implements Task {


    public FetchJokes() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.JOKES_PROGRAMMING_TEN).with(requestSpecification -> requestSpecification.log().all())
        );
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.lastResponse().prettyPrint();
    }

    public static FetchJokes inJokesParadeApi() {
        return instrumented(FetchJokes.class);
    }
}
