package pro.lukasgorny.exceptions;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public class BadResponseCodeException extends Exception {

    public BadResponseCodeException(String message) {
        super(message);
    }
}