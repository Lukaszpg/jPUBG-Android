package pro.lukasgorny;

import org.junit.Before;
import org.junit.Test;

import pro.lukasgorny.core.JPubg;
import pro.lukasgorny.dto.FilterCriteria;
import pro.lukasgorny.dto.Player;
import pro.lukasgorny.dto.Stat;
import pro.lukasgorny.enums.PUBGMode;
import pro.lukasgorny.enums.PUBGRegion;
import pro.lukasgorny.enums.PUBGSeason;
import pro.lukasgorny.enums.PUBGStat;
import pro.lukasgorny.factory.JPubgFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Łukasz "Husar" Górny on 2017-07-24.
 */
public class Tests {

    private JPubg jPubg;
    private FilterCriteria criteria;

    @Before
    public void initialize() {
        jPubg = JPubgFactory.getWrapper("0d433ff7-2ed9-459a-9760-31a4247d612c");
        criteria = new FilterCriteria(PUBGMode.solo, PUBGRegion.eu, PUBGSeason.PRE2_2017);
    }

    @Test
    public void testGetPlayerStringDataByNickname() {
        String playerData = jPubg.getByNickname("TheHusar");
        assertNotNull("Returned player string data is null!", playerData);
    }

    @Test
    public void testGetPlayerObjectByNickname() {
        Player player = jPubg.getByNickname("TheHusar", null);
        assertNotNull("Returned player object is null!", player);
        assertNotNull("Returned player has null account id, hence it's invalid!", player.getAccountId());
    }

    @Test
    public void testGetPlayerStat() {
        Player player = jPubg.getByNickname("TheHusar", criteria);
        Stat stat = jPubg.getPlayerMatchStatByStatName(player, PUBGStat.BEST_RATING);
        assertNotNull("Returned player stat is null!", stat);
        assertNotNull("Returned player stat string value is null!", stat.getStringValue());
    }

    @Test
    public void testGetPlayerStringDataBySteamId() {
        String playerData = jPubg.getBySteamID("STEAM_0:0:56407384");
        assertNotNull("Returned player string data is null!", playerData);
    }
}
