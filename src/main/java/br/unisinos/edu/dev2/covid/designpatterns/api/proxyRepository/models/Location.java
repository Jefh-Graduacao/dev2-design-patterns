package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String country;
    private String country_code;
    private Integer country_population;
    private String province;
    private String county;
    private String last_updated;
    private InfectedData latest;
}
