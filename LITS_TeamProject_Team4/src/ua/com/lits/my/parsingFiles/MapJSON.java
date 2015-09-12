package ua.com.lits.my.parsingFiles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by olesia on 12.09.15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapJSON {
    private int id;
    private String team_name;
    private int founded;
    private String head_coach;
    private String city_based;

    @JsonCreator
    public MapJSON(@JsonProperty("id") int id, @JsonProperty("team_name") String team_name, @JsonProperty("founded") int founded,
                   @JsonProperty("head_coach") String head_coach, @JsonProperty("city_based") String city_based) {
        this.id = id;
        this.team_name = team_name;
        this.founded = founded;
        this.head_coach = head_coach;
        this.city_based = city_based;
    }

    public String getCity_based() {
        return city_based;
    }

    public void setCity_based(String city_based) {
        this.city_based = city_based;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getHead_coach() {
        return head_coach;
    }

    public void setHead_coach(String head_coach) {
        this.head_coach = head_coach;
    }

}
