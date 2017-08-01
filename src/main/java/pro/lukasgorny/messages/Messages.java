package pro.lukasgorny.messages;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public class Messages {
    public static final String BAD_RESPONSE_CODE_ERROR = "FATAL ERROR! Server has returned %s response code. It should be 200 OK.";
    public static final String FATAL_ERROR_EMPTY_RESPONSE = "FATAL ERROR! Empty response returned!";
    public static final String NICKNAME_MUST_NOT_BE_NULL_OR_EMPTY = "Nickname argument must not be null or empty!";
    public static final String STEAMID_MUST_NOT_BE_NULL_OR_EMPTY = "SteamID argument must not be null or empty!";
    public static final String CANNOT_FILTER_PLAYER_NULL = "Cannot filter player data, because player object returned is null! Is your API Key valid?";
    public static final String BAD_NUMBER_OF_STATS_RETURNED = "More than one stat or no stats with given name was returned while filtering matches.";
    public static final String PLAYER_HAS_NO_MATCHES_PLAYED = "Specified player has no matches played in specified season, no stats can be filtered.";
    public static final String CANNOT_GET_MATCH_NULL = "Cannot get match from season, because list of matches is null.";
    public static final String CANNOT_GET_MATCH_EMPTY = "Cannot get match from season, because list of matches is empty.";
    public static final String CANNOT_GET_MATCH_FROM_SEASON_MATCH_IS_NULL = "Cannot get match from season, because returned match object is null.";
    public static final String CANNOT_GET_MATCH_SIZE_TOO_HIGH = "Cannot get match from season, because specified match list has more than one season data.";
    public static final String API_KEY_EMPTY_OR_NULL = "Specified API Key is null or empty. Cannot proceed.";


}