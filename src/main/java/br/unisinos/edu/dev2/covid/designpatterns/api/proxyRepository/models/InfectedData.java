package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models;

import lombok.Data;

@Data
public class InfectedData {
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
}
