package pro.lukasgorny.core;

import javax.annotation.Nonnull;

import pro.lukasgorny.dto.FilterCriteria;
import pro.lukasgorny.dto.Player;
import pro.lukasgorny.dto.Stat;
import pro.lukasgorny.enums.PUBGStat;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public interface JPubg {
    /**
     * Retrieves player specified by nickname data from the PUBGTracker API
     * and returns it in JSON String format. Use this method if you want to parse the
     * data by yourself.
     *
     * @param nickname nickname of the player
     * @return JSON String format with player data
     */
    String getByNickname(@Nonnull final String nickname);

    /**
     * Retrieves player specified by nickname data from the PUBGTracker API
     * and filters it by specified criteria.
     *
     * @param nickname nickname of the player
     * @param criteria filtering criteria
     * @return Object with player data
     */
    Player getByNickname(@Nonnull final String nickname, final FilterCriteria criteria);

    /**
     * Retrieves player specified by steamID data from the PUBGTracker API
     * and returns it in JSON String format. Use this method if you want to parse the
     * data by yourself.
     *
     * @param steamID steamID of the player
     * @return JSON String format with player data
     */
    String getBySteamID(@Nonnull final String steamID);

    /**
     * Retrieves player specified by nickname data from the PUBGTracker API
     * and filters it by specified criteria.
     *
     * @param steamID  steamID of the player
     * @param criteria filtering criteria
     * @return Object with player data
     */
    Player getBySteamID(@Nonnull final String steamID, final FilterCriteria criteria);

    /**
     * Filters stat by name from specified players matches from the latest season.
     *
     * @param player steamID of the player
     * @param stat   specifies what stat you want to be filtered
     * @return Object with stat data
     */
    Stat getPlayerMatchStatByStatName(@Nonnull Player player, @Nonnull final PUBGStat stat);
}