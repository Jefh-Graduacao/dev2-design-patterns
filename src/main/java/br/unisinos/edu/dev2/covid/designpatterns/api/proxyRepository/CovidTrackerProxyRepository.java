package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository;

import br.unisinos.edu.dev2.covid.designpatterns.api.config.ObjectMapperSingleton;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.GlobalData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.LocationResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Classe Proxy para consultar informações sobre os casos de COVID-19
 * Esta classe implementa o padrão Proxy
 */
public class CovidTrackerProxyRepository {
    private final String source;
    private final boolean includeTimelines;
    private final CovidTrackerApiUrlBuilder urlBuilder;

    public CovidTrackerProxyRepository(String source, boolean includeTimelines) {
        this.source = source;
        this.includeTimelines = includeTimelines;
        this.urlBuilder = CovidTrackerApiUrlBuilder.createDefaultBuilder().withApiVersion(2);
    }

    /**
     * Ultilizando aqui padrão build para realizar montagem de URL.
     * @param locationCode
     * @return
     * @throws IOException
     */
    public Location findByLocation(Integer locationCode) throws IOException {
        var url = this.urlBuilder
                .withResource("locations")
                .withPathParam(locationCode)
                .withQueryString("source", this.source)
                .withQueryString("timelines", this.includeTimelines)
                .build();

        var responseString = sendRequest(url);
        var objMapper = ObjectMapperSingleton.getInstance();

        return objMapper.readValue(responseString, LocationResponse.class).getLocation();
    }

    public InfectedData getGlobalData() throws IOException {
        var url = this.urlBuilder
                .withResource("latest")
                .withQueryString("source", this.source)
                .build();

        var responseString = sendRequest(url);
        var objMapper = ObjectMapperSingleton.getInstance();

        return objMapper.readValue(responseString, GlobalData.class).getLatest();
    }

    private String sendRequest(URL url) throws IOException {
        System.out.println("Buscando dados -> "+url);
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            var in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();
        } finally {
            if(connection != null)
                connection.disconnect();
        }
    }
}
