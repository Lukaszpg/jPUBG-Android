package pro.lukasgorny.services;

import java.util.List;
import com.google.common.base.Optional;

import pro.lukasgorny.dto.Match;
import pro.lukasgorny.dto.Stat;
import pro.lukasgorny.enums.PUBGStat;

/**
 * Created by Łukasz "Husar" Górny on 2017-07-10.
 */
public class MatchStatFilterService {

    private MatchValidationService matchValidationService;

    public MatchStatFilterService() {
        this.matchValidationService = new MatchValidationService();
    }

    public Stat getStatFromSeasonMatches(final List<Match> matches, final PUBGStat statName) {
        Match match = getMatchFromSeason(matches);

        for (Stat stat : match.getStats()) {
            if(statName.getLabelName().equals(stat.getField())) {
                return stat;
            }
        }

        return null;
    }

    private Match getMatchFromSeason(List<Match> matches) {
        matchValidationService.validateWithSizeValidation(matches);

        Optional<List<Match>> optionalMatches = Optional.fromNullable(matches);
        Match match = optionalMatches.get().get(0);
        matchValidationService.validateSingleMatch(match);

        return match;
    }
}
