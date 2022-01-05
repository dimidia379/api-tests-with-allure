package guru.qa.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
    private List<String> films;
    private List<String> residents;
    private String edited;
    private String created;
    private String climate;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    private String url;
    private String population;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String diameter;
    private String gravity;
    private String name;
    private String terrain;
}
