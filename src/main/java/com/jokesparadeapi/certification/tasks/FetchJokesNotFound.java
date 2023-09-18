package com.jokesparadeapi.certification.tasks;

import com.jokesparadeapi.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchJokesNotFound implements Task {


    public FetchJokesNotFound() {

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.JOKES_PROGRAMMING_TEN_NOT_FOUND).with(requestSpecification -> requestSpecification.log().all())
        );
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.lastResponse().prettyPrint();
    }

    public static Performable inJokesParadeApiResponse() {
        return instrumented(FetchJokesNotFound.class);
    }
    }





