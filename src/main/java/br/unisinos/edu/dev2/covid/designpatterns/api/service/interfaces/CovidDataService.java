package br.unisinos.edu.dev2.covid.designpatterns.api.service.interfaces;

import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;

import java.io.IOException;

/**
 * Interface de serviço
 * Implementa o padrão Bridge no projeto setando esta interface como abstração para uso com possibilidade de implementações diferentes.
 */
public interface CovidDataService {
    Location getDataByLocation(Integer locationCode) throws IOException;
    InfectedData getGlobalData() throws IOException;
}
