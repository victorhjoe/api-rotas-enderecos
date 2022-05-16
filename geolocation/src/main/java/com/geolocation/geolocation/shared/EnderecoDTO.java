package com.geolocation.geolocation.shared;

import java.util.List;

import com.geolocation.geolocation.view.model.EnderecoDistancia;

public class EnderecoDTO {
    private String endereco;

    private Double latitude;

    private Double longitude;

    private List<EnderecoDistancia> distanciasList;


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<EnderecoDistancia> getDistanciasList() {
        return distanciasList;
    }

    public void setDistanciasList(List<EnderecoDistancia> distanciasList) {
        this.distanciasList = distanciasList;
    }
}
