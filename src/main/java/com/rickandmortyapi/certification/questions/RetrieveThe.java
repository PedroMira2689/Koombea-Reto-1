package com.rickandmortyapi.certification.questions;

import com.rickandmortyapi.certification.models.characters.ResponseCharacters;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RetrieveThe implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        ResponseCharacters response = SerenityRest.lastResponse().jsonPath().getObject("", ResponseCharacters.class);
        actor.remember("header", SerenityRest.lastResponse().header("X-Nf-Request-Id"));
        System.out.println("LA DIMENSION ES " + response.getDimensions());
        return response.getId();
    }

    public static RetrieveThe valueOfTheCharactersId() {
        return new RetrieveThe();
    }
}
