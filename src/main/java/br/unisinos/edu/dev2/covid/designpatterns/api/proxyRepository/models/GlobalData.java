package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models;

import lombok.Data;

@Data
public class GlobalData {
    private InfectedData latest;

    public InfectedData getLatest() {
        return latest;
    }

    public void setLatest(InfectedData latest) {
        this.latest = latest;
    }
}
