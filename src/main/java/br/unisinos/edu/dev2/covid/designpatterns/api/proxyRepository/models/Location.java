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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public Integer getCountry_population() {
        return country_population;
    }

    public void setCountry_population(Integer country_population) {
        this.country_population = country_population;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public InfectedData getLatest() {
        return latest;
    }

    public void setLatest(InfectedData latest) {
        this.latest = latest;
    }
}
