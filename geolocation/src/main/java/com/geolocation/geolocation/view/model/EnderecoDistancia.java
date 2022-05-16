package com.geolocation.geolocation.view.model;

public class EnderecoDistancia {
    private String endereco;

    private String DistanciaRota;

    private String TempoDaRota;


    public String getTempoDaRota() {
        return TempoDaRota;
    }

    public String getDistanciaRota() {
        return DistanciaRota;
    }

    public void setDistanciaRota(String distanciaRota) {
        this.DistanciaRota = distanciaRota;
    }

    public void setTempoDaRota(String tempoDaRota) {
        this.TempoDaRota = tempoDaRota;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
