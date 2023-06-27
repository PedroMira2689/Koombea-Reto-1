package com.rickandmortyapi.certification.questions;

import com.rickandmortyapi.certification.models.locations.ResponseLocations;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtainThe implements Question {


    @Override
    public Object answeredBy(Actor actor) {
        ResponseLocations response = SerenityRest.lastResponse().jsonPath().getObject("", ResponseLocations.class);
        actor.remember("header", SerenityRest.lastResponse().header("X-Nf-Request-Id"));
        return response.getId();
    }

    public static ObtainThe valueOfTheLocationsId() {
        return new ObtainThe();
    }
}
