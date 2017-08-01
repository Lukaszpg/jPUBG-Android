package pro.lukasgorny.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-30.
 */
public class Player {

    private Long platformId;

    @SerializedName("AccountId")
    private String accountId;

    @SerializedName("Avatar")
    private String avatar;

    private String selectedRegion;

    private String defaultSeason;

    private String seasonDisplay;

    @SerializedName("LastUpdated")
    private String lastUpdated;

    @SerializedName("PlayerName")
    private String playerName;

    @SerializedName("PubgTrackerId")
    private Long pubgTrackerId;

    @SerializedName("Stats")
    private List<Match> matches;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(String selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    public String getDefaultSeason() {
        return defaultSeason;
    }

    public void setDefaultSeason(String defaultSeason) {
        this.defaultSeason = defaultSeason;
    }

    public String getSeasonDisplay() {
        return seasonDisplay;
    }

    public void setSeasonDisplay(String seasonDisplay) {
        this.seasonDisplay = seasonDisplay;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getPubgTrackerId() {
        return pubgTrackerId;
    }

    public void setPubgTrackerId(Long pubgTrackerId) {
        this.pubgTrackerId = pubgTrackerId;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
