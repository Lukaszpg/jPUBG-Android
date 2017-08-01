package pro.lukasgorny.services;

import java.util.List;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import pro.lukasgorny.dto.Match;
import pro.lukasgorny.messages.Messages;

/**
 * Created by Łukasz "Husar" Górny on 2017-07-24.
 */
public class MatchValidationService {

    public void validate(final List<Match> matches) {
        Optional<List<Match>> optionalMatches = Optional.fromNullable(matches);
        Preconditions.checkArgument(optionalMatches.isPresent(), Messages.CANNOT_GET_MATCH_NULL);
        Preconditions.checkArgument(!optionalMatches.get().isEmpty(), Messages.CANNOT_GET_MATCH_EMPTY);
    }

    public void validateWithSizeValidation(final List<Match> matches) {
        validate(matches);
        Preconditions.checkArgument(matches.size() == 1, Messages.CANNOT_GET_MATCH_SIZE_TOO_HIGH);
    }

    public void validateSingleMatch(final Match match) {
        Optional<Match> matchOptional = Optional.fromNullable(match);
        Preconditions.checkState(matchOptional.isPresent(), Messages.CANNOT_GET_MATCH_FROM_SEASON_MATCH_IS_NULL);
    }
}
