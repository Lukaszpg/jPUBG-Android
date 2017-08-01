package pro.lukasgorny.services;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Optional;
import com.google.gson.Gson;

import pro.lukasgorny.dto.FilterCriteria;
import pro.lukasgorny.dto.Match;
import pro.lukasgorny.dto.Player;
import pro.lukasgorny.enums.PUBGMode;
import pro.lukasgorny.enums.PUBGRegion;
import pro.lukasgorny.enums.PUBGSeason;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-30.
 */
public class PlayerDataFilterService {

    private PlayerValidationService playerValidationService;
    private DataAppendService dataAppendService;

    public PlayerDataFilterService() {
        this.playerValidationService = new PlayerValidationService();
        this.dataAppendService = new DataAppendService();
    }

    public Player getPlayerByCriteria(final String data, final FilterCriteria criteria) {
        Player player = jsonToObject(data);
        Optional<FilterCriteria> criteriaOptional = Optional.fromNullable(criteria);

        if(criteriaOptional.isPresent()) {
            Optional<PUBGMode> modeOptional = Optional.fromNullable(criteriaOptional.get().getMode());
            Optional<PUBGRegion> regionOptional = Optional.fromNullable(criteriaOptional.get().getRegion());
            Optional<PUBGSeason> seasonOptional = Optional.fromNullable(criteriaOptional.get().getSeason());

            if (modeOptional.isPresent() && !regionOptional.isPresent() && !seasonOptional.isPresent()) {
                filterByMode(player, criteria);
            } else if (!modeOptional.isPresent() && regionOptional.isPresent() && !seasonOptional.isPresent()) {
                filterByRegion(player, criteria);
            } else if (!modeOptional.isPresent() && !regionOptional.isPresent() && seasonOptional.isPresent()) {
                filterBySeason(player, criteria);
            } else if (modeOptional.isPresent() && regionOptional.isPresent() && !seasonOptional.isPresent()) {
                filterByModeAndRegion(player, criteria);
            } else if (modeOptional.isPresent() && !regionOptional.isPresent() && seasonOptional.isPresent()) {
                filterByModeAndSeason(player, criteria);
            } else if (!modeOptional.isPresent() && regionOptional.isPresent() && seasonOptional.isPresent()) {
                filterByRegionAndSeason(player, criteria);
            } else if (modeOptional.isPresent() && regionOptional.isPresent() && seasonOptional.isPresent()) {
                filterByRegionAndModeAndSeason(player, criteria);
            }
        }

        return player;
    }

    private Player filterByMode(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getMatchType().equals(criteria.getMode())) {
                results.add(match);
            }
        }

        player.setMatches(results);
        return player;
    }

    private Player filterByRegion(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getRegion().equals(criteria.getRegion())) {
                results.add(match);
            }
        }

        player.setMatches(results);
        return player;
    }

    private Player filterBySeason(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getSeason().equals(criteria.getSeason().getSeasonName())) {
                results.add(match);
            }
        }

        player.setMatches(results);

        return player;
    }

    private Player filterByModeAndRegion(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getMatchType().equals(criteria.getMode()) && match.getRegion().equals(criteria.getRegion())) {
                results.add(match);
            }
        }

        player.setMatches(results);

        return player;
    }

    private Player filterByModeAndSeason(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getMatchType().equals(criteria.getMode()) && match.getSeason().equals(criteria.getSeason().getSeasonName())) {
                results.add(match);
            }
        }

        player.setMatches(results);

        return player;
    }

    private Player filterByRegionAndSeason(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getRegion().equals(criteria.getRegion()) && match.getSeason().equals(criteria.getSeason().getSeasonName())) {
                results.add(match);
            }
        }

        player.setMatches(results);

        return player;
    }

    private Player filterByRegionAndModeAndSeason(Player player, FilterCriteria criteria) {
        List<Match> results = new ArrayList<>();
        for (Match match : player.getMatches()) {
            if(match.getRegion().equals(criteria.getRegion()) && match.getMatchType().equals(criteria.getMode())
                    && match.getSeason().equals(criteria.getSeason().getSeasonName())) {
                results.add(match);
            }
        }

        player.setMatches(results);

        return player;
    }

    private Player jsonToObject(final String data) {
        Gson gson = new Gson();
        Player player = gson.fromJson(data, Player.class);
        playerValidationService.validate(player);
        dataAppendService.appendSeasonToStats(player);
        return player;
    }
}
