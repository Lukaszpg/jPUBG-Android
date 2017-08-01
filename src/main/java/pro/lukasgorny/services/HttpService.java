package pro.lukasgorny.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.common.base.Preconditions;

import pro.lukasgorny.exceptions.BadResponseCodeException;
import pro.lukasgorny.messages.Messages;
import pro.lukasgorny.settings.Settings;
import pro.lukasgorny.utils.MessageUtils;
import pro.lukasgorny.utils.UrlUtils;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public class HttpService {

    private URL url;
    private String apiKey;
    private HttpURLConnection connection;

    private int connectionTimeout = Settings.CONNECTION_TIMEOUT;

    public HttpService(final String apiKey) {
        this.apiKey = apiKey;
    }

    public HttpService(final String apiKey, final int connectionTimeout) {
        this.apiKey = apiKey;
        this.connectionTimeout = connectionTimeout;
    }

    public String executeGetByNicknameAction(final String nickname) {
        Preconditions.checkArgument(nickname != null || !nickname.isEmpty(), Messages.NICKNAME_MUST_NOT_BE_NULL_OR_EMPTY);
        String response = null;

        try {
            response = sendGetByNicknameRequest(nickname);
        } catch (IOException | BadResponseCodeException e) {
            e.printStackTrace();
        }

        Preconditions.checkState(!response.isEmpty(), Messages.FATAL_ERROR_EMPTY_RESPONSE);

        return response;
    }

    public String executeGetBySteamIDAction(final String steamID) {
        Preconditions.checkArgument(steamID != null || !steamID.isEmpty(), Messages.STEAMID_MUST_NOT_BE_NULL_OR_EMPTY);
        String response = null;

        try {
            response = sendGetBySteamIDRequest(steamID);
        } catch (IOException | BadResponseCodeException e) {
            e.printStackTrace();
        }

        Preconditions.checkState(!response.isEmpty(), Messages.FATAL_ERROR_EMPTY_RESPONSE);

        return response;
    }


    private String sendGetByNicknameRequest(final String nickname) throws IOException, BadResponseCodeException {
        return sendGetRequest(UrlUtils.prepareNicknameRequestURL(nickname));
    }

    private String sendGetBySteamIDRequest(final String steamID) throws IOException, BadResponseCodeException {
        return sendGetRequest(UrlUtils.prepareSteamIDRequestURL(steamID));
    }

    private String sendGetRequest(final String urlString) throws IOException, BadResponseCodeException {
        prepareURL(urlString);
        prepareAndOpenConnection();
        setRequestProperties();

        return processResponse();
    }

    private void prepareURL(final String urlString) throws MalformedURLException {
        url = new URL(urlString);
    }

    private void prepareAndOpenConnection() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
    }

    private void setRequestProperties() throws ProtocolException {
        connection.setConnectTimeout(connectionTimeout);
        connection.setRequestMethod(Settings.REQUEST_TYPE);
        connection.setRequestProperty(Settings.REQUEST_HEADER_USER_AGENT, Settings.USER_AGENT);
        connection.setRequestProperty(Settings.REQUEST_HEADER_TRN_API_KEY, apiKey);
    }

    private String processResponse() throws IOException, BadResponseCodeException {
        int responseCode = connection.getResponseCode();

        if(responseCode != HttpURLConnection.HTTP_OK) {
            throw new BadResponseCodeException(MessageUtils.prepareBadCodeErrorMessage(responseCode));
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = bufferedReader.readLine()) != null) {
            response.append(output);
        }

        bufferedReader.close();

        return response.toString();
    }
}