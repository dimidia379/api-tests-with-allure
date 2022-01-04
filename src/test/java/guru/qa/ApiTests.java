package guru.qa;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiTests {
        @Test
        void planetInfoWithLog() {
            given()
                    .filter(new AllureRestAssured())
                    .log().all()
                    .get("https://swapi.dev/api/planets/4")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", is("Hoth"))
                    .body("terrain", is("tundra, ice caves, mountain ranges"));
        }

    @Test
    void planetInfoWithCustomTemplateLog() {
        given()
                .filter(customLogFilter().withCustomTemplates())
                .log().all()
                .get("https://swapi.dev/api/planets/4")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Hoth"))
                .body("terrain", is("tundra, ice caves, mountain ranges"));
    }
    }

