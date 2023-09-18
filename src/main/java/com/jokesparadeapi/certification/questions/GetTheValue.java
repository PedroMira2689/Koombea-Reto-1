package com.jokesparadeapi.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class GetTheValue implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        Map<String, Object> jsonResponse = SerenityRest.lastResponse().jsonPath().getMap("$");

        if (jsonResponse.containsKey("id")) {
            return (Integer) jsonResponse.get("id");
        } else {
            return -1;
        }
    }

    public static GetTheValue ofRandomJoke() {
        return new GetTheValue();
    }
}
