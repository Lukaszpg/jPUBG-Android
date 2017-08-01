package pro.lukasgorny.utils;

import pro.lukasgorny.messages.Messages;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public class MessageUtils {

    public static String prepareBadCodeErrorMessage(final int responseCode) {
        return String.format(Messages.BAD_RESPONSE_CODE_ERROR, String.valueOf(responseCode));
    }
}