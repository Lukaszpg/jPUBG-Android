package pro.lukasgorny.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Łukasz "Husar" Górny on 2017-07-11.
 */
public enum PUBGSeason {
    PRE1_2017("2017-pre1"),
    PRE2_2017("2017-pre2"),
    PRE3_2017("2017-pre3"),
    PRE4_2017("2017-pre4"),
    PRE5_2017("2017-pre5");

    PUBGSeason(String seasonName) {
        this.seasonName = seasonName;
    }

    private String seasonName;
    private static final Map<String, PUBGSeason> map;

    public String getSeasonName() {
        return seasonName;
    }

    static {
        map = new HashMap<>();
        for (PUBGSeason season : PUBGSeason.values()) {
            map.put(season.getSeasonName(), season);
        }
    }

    public static PUBGSeason findByKey(String toFind) {
        return map.get(toFind);
    }
}
