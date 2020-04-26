package br.unisinos.edu.dev2.covid.designpatterns.api.service.interfaces;

import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;

import java.io.IOException;

public interface CovidDataService {
    Location getDataByLocation(Integer locationCode) throws IOException;
    InfectedData getGlobalData() throws IOException;
}
