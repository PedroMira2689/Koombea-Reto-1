package com.rickandmortyapi.certification.questions;

import com.rickandmortyapi.certification.models.episodes.ResponseEpisodes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RecieveThe implements Question {


    @Override
    public Object answeredBy(Actor actor) {
        ResponseEpisodes response = SerenityRest.lastResponse().jsonPath().getObject("", ResponseEpisodes.class);
        actor.remember("header", SerenityRest.lastResponse().header("X-Nf-Request-Id"));
        return response.getId();
    }

    public static RecieveThe valueOfTheEpisodesId() {
        return new RecieveThe();
    }
}
