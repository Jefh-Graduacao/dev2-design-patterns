package br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models;

import lombok.Data;

@Data
public class LocationResponse {
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
