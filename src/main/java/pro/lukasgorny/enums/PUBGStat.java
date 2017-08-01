package pro.lukasgorny.enums;

/**
 * Created by Łukasz "Husar" Górny on 2017-07-10.
 */
public enum PUBGStat {
    RATING("Rating"),
    KILL_DEATH_RATIO("KillDeathRatio"),
    WIN_RATIO("WinRatio"),
    TIME_SURVIVED("TimeSurvived"),
    ROUNDS_PLAYED("RoundsPlayed"),
    WINS("Wins"),
    WIN_TOP_10_RATIO("WinTop10Ratio"),
    TOP_10("Top10s"),
    TOP_10_RATIO("Top10Ratio"),
    LOSSES("Losses"),
    BEST_RATING("BestRating"),
    DAMAGE_PER_GAME("DamagePg"),
    HEADSHOT_KILLS_PER_GAME("HeadShotKillsPg"),
    HEALS_PER_GAME("HealsPg"),
    KILLS_PER_GAME("KillsPg"),
    MOVE_DISTANCE_PER_GAME("MoveDistancePg"),
    REVIVES_PER_GAME("RevivesPg"),
    ROAD_KILLS_PER_GAME("RoadKillsPg"),
    TEAM_KILLS_PER_GAME("TeamKillsPg"),
    TIME_SURVIVED_PER_GAME("TimeSurvivedPg"),
    TOP_10_PER_GAME("Top10sPg"),
    KILLS("Kills"),
    ASSISTS("Assists"),
    SUICIDES("Suicides"),
    TEAM_KILLS("TeamKills"),
    HEADSHOT_KILLS("HeadshotKills"),
    HEADSHOT_KILL_RATIO("HeadshotKillRatio"),
    VEHICLE_DESTROYED("VehicleDestroys"),
    ROAD_KILLS("RoadKills"),
    DAILY_KILLS("DailyKills"),
    WEEKLY_KILLS("WeeklyKills"),
    ROUND_MOST_KILLS("RoundMostKills"),
    MAX_KILL_STREAKS("MaxKillStreaks"),
    WEAPON_ACQUIRED("WeaponAcquired"),
    SURVIVED_DAYS("Days"),
    LONGEST_TIME_SURVIVED("LongestTimeSurvived"),
    MOST_SURVIVAL_TIME("MostSurvivalTime"),
    AVERAGE_SURVIVAL_TIME("AvgSurvivalTime"),
    WIN_POINTS("WinPoints"),
    WALK_DISTANCE("WalkDistance"),
    RIDE_DISTANCE("RideDistance"),
    MOVE_DISTANCE("MoveDistance"),
    AVERAGE_WALK_DISTANCE("AvgWalkDistance"),
    AVERAGE_RIDE_DISTANCE("AvgRideDistance"),
    LONGEST_KILL("LongestKill"),
    HEALS("Heals"),
    REVIVES("Revives"),
    BOOSTS("Boosts"),
    DAMAGE_DEALT("DamageDealt"),
    KNOCK_OUTS("DBNOs");

    private String labelName;

    PUBGStat(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelName() {
        return labelName;
    }
}
