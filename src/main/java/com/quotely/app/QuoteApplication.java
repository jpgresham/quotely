package com.quotely.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotely.enums.Language;
import com.quotely.exceptions.MissingLanguageException;
import com.quotely.model.Quote;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuoteApplication {

    private static String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=%s";
    private HttpClient client;
    private String language = "";

    public QuoteApplication() {
        this.client = HttpClient.newHttpClient();
    }

    public Quote fetch() throws Exception {
        if (this.language.isEmpty()) {
            throw new MissingLanguageException();
        }
        var request = HttpRequest.newBuilder().uri(URI.create(String.format(url, this.language))).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception();
        }

        var mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Quote.class);
    }

    public void setLanguage(Language language) throws Exception {
        if (!language.toString().equalsIgnoreCase(Language.EN.toString())
                && !language.toString().equalsIgnoreCase(Language.RU.toString())) {
            throw new Exception(String.format("expected language to be en or ru; got %s", language));
        }
        this.language = language.toString();
    }

}
