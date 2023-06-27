package com.rickandmortyapi.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class GetThe implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static GetThe statusCodeNumber() {
        return new GetThe();
    }
}
