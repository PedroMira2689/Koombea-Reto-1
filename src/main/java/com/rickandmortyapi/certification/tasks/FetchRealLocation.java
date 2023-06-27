package com.rickandmortyapi.certification.tasks;

import com.rickandmortyapi.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchRealLocation implements Task {
    private int id;

    public FetchRealLocation(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.REAL_LOCATION_ENDPOINT).with(requestSpecification -> requestSpecification.pathParam("id", id).log().all())
        );
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.lastResponse().prettyPrint();
        System.out.println("actor = " + actor);
    }

    public static FetchRealLocation inRickAndMortyApi(int idValue) {
        return instrumented(FetchRealLocation.class, idValue);
    }
}
