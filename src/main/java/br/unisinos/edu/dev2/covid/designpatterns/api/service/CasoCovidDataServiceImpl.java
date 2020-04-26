package br.unisinos.edu.dev2.covid.designpatterns.api.service;

import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.CovidTrackerProxyRepository;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;
import br.unisinos.edu.dev2.covid.designpatterns.api.service.interfaces.CovidDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Serviço para consulta dos dados sobre a COVID-19
 * Esta classe (juntamente com sua interface) implementa o padrão Bridge. A interface
 * define a API pública independentemente da implementação aqui feita. Desta forma,
 * podemos alterar a lógica de implementação sem quebrar a compatibilidade.
 */
@Service
@AllArgsConstructor
public class CasoCovidDataServiceImpl implements CovidDataService {
    private CovidTrackerProxyRepository covidRepository;
    public CasoCovidDataServiceImpl() {
        covidRepository = new CovidTrackerProxyRepository("jhu", false);
    }

    @Override
    public Location getDataByLocation(Integer locationCode) throws IOException {
        return covidRepository.findByLocation(locationCode);
    }

    @Override
    public InfectedData getGlobalData() throws IOException {
        return covidRepository.getGlobalData();
    }
}
