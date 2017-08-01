package pro.lukasgorny.factory;

import javax.annotation.Nonnull;
import com.google.common.base.Preconditions;

import pro.lukasgorny.core.JPubg;
import pro.lukasgorny.core.JPubgImpl;
import pro.lukasgorny.messages.Messages;

/**
 * Created by Łukasz "Husar" Górny on 29.06.2017.
 */
public final class JPubgFactory {

    /**
     * Returns fully initialized, ready to use API object with
     * default connection timeout (5000 miliseconds - 5 seconds).
     *
     * @param apiKey your http://pubgtracker.com API-KEY
     * @return Fully initialized API object
     */
    public static JPubg getWrapper(@Nonnull String apiKey) {
        validateApiKey(apiKey);
        return new JPubgImpl(apiKey);
    }

    /**
     * Returns fully initialized, ready to use API object with specified connection timeout.
     *
     * @param apiKey your http://pubgtracker.com API-KEY
     * @param connectionTimeout connection timeout in miliseconds (default 5000 miliseconds - 5 seconds)
     * @return Fully initialized API object
     */
    public static JPubg getWrapper(@Nonnull String apiKey, int connectionTimeout) {
        validateApiKey(apiKey);
        return new JPubgImpl(apiKey, connectionTimeout);
    }

    private static void validateApiKey(String apiKey) {
        Preconditions.checkArgument(apiKey != null || !apiKey.trim().isEmpty(), Messages.API_KEY_EMPTY_OR_NULL);
    }
}