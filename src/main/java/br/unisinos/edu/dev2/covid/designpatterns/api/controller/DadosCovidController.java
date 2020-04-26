package br.unisinos.edu.dev2.covid.designpatterns.api.controller;

import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;
import br.unisinos.edu.dev2.covid.designpatterns.api.service.interfaces.CovidDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("dados-covid")
@AllArgsConstructor
@Validated
@Api(value = "API para consultar casos de COVID-19")
public class DadosCovidController {
    private CovidDataService covidDataService;

    @GetMapping("/global")
    @ApiOperation(value = "Consulta casos do mundo todo")
    public ResponseEntity<InfectedData> consultarCasosGlobal() throws IOException {
        return ok(covidDataService.getGlobalData());
    }

    @GetMapping("/por-localizacao/{codigoLocal}")
    @ApiOperation(value = "Consulta casos por localização")
    public ResponseEntity<Location> consultarCasoPorLocal(@ApiParam(required = true) @PathVariable Integer codigoLocal) throws IOException {
        return ok(covidDataService.getDataByLocation(codigoLocal));
    }
}
