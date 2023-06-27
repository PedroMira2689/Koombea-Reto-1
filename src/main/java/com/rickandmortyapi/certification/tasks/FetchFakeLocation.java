package com.rickandmortyapi.certification.tasks;

import com.rickandmortyapi.certification.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchFakeLocation implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.FAKE_LOCATION_ENDPOINT)
        );
    }

    public static FetchFakeLocation inRickAndMortyApi() {
        return instrumented(FetchFakeLocation.class);
    }
}
