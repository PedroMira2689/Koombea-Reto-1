package com.jokesparadeapi.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RetrieveTheResponse implements Question<String> {
    private final String headerName;

    public RetrieveTheResponse(String headerName) {
        this.headerName = headerName;
    }

    public static void AltSvcHeaderValue() {
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().header(headerName);
    }

    public static RetrieveTheResponse AltSvcHeaderValue(String headerName) {
        return new RetrieveTheResponse(headerName);
    }
}
