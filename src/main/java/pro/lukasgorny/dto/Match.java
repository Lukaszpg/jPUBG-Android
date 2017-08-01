package pro.lukasgorny.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import pro.lukasgorny.enums.PUBGMode;
import pro.lukasgorny.enums.PUBGRegion;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-30.
 */
public class Match {

    @SerializedName("Region")
    private PUBGRegion region;

    @SerializedName("Season")
    private String season;

    @SerializedName("Match")
    private PUBGMode matchType;

    @SerializedName("Stats")
    private List<Stat> stats;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public PUBGMode getMatchType() {
        return matchType;
    }

    public void setMatchType(PUBGMode matchType) {
        this.matchType = matchType;
    }

    public PUBGRegion getRegion() {
        return region;
    }

    public void setRegion(PUBGRegion region) {
        this.region = region;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
