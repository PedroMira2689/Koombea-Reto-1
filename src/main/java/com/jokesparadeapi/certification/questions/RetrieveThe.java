package com.jokesparadeapi.certification.questions;

import com.jokesparadeapi.certification.models.characters.ResponseProgrammingJokes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class RetrieveThe implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        List<Map<String, Object>> jsonResponse = SerenityRest.lastResponse().jsonPath().getList("$");
        // Suponiendo que la respuesta es una lista de objetos JSON, cada uno con un campo "id".
        // Puedes adaptar esto según la estructura real de tu respuesta.

        // Verifica que la respuesta no esté vacía y obtén el ID del primer elemento si existe.
        if (!jsonResponse.isEmpty()) {
            Map<String, Object> firstItem = jsonResponse.get(0);
            if (firstItem.containsKey("id")) {
                return (Integer) firstItem.get("id");
            }
        }
        return -1;
    }

        public static RetrieveThe ValueOfJokes () {
            return new RetrieveThe();
        }
    }


