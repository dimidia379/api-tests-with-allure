package guru.qa;

import guru.qa.lombok.Planet;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsingLombokAndGroovyApiTests {
    @Test
    void planetInfoWithLombok() {
        Planet planet =
                given()
                        .get("https://swapi.dev/api/planets/4")
                        .then()
                        .log().body()
                        .extract().as(Planet.class);
        assertEquals("Hoth", planet.getName());
    }

    @Test
    void hothAmongFrozenPlanetsWithGroovy() {
        given()
                .get("https://swapi.dev/api/planets")
                .then()
                .log().body()
                .body("results.findAll{it.climate='frozen'}.name.flatten()",
                        hasItem("Hoth"));

    }
}
