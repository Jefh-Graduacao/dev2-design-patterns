package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Classe responsável por montar as URL's de requisições para a API do Corona Vírus
 * Esta classe implementa o padrão Builder e seu método de construção implementa o
 * padrão Factory Method
 */
public class CovidTrackerApiUrlBuilder {
    private static final String HOST = "https://coronavirus-tracker-api.herokuapp.com/";
    private String url;

    private CovidTrackerApiUrlBuilder() {
        url = HOST;
    }

    public static CovidTrackerApiUrlBuilder createDefaultBuilder() {
        return new CovidTrackerApiUrlBuilder();
    }

    public CovidTrackerApiUrlBuilder withApiVersion(int apiVersion) {
        url += String.format("v%d/", apiVersion);
        return this;
    }

    public CovidTrackerApiUrlBuilder withResource(String resource) {
        url += resource + "/";
        return this;
    }

    public CovidTrackerApiUrlBuilder withPathParam(Object param) {
        url += param + "/";
        return this;
    }

    public CovidTrackerApiUrlBuilder withQueryString(String key, Object value) {
        var prefixo = url.indexOf('?') == -1 ? "?" : "&";
        url += String.format(prefixo + "%s=%s", key, value);
        return this;
    }

    public URL build() throws MalformedURLException {
        return new URL(this.url);
    }
}
