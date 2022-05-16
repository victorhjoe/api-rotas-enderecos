package com.geolocation.geolocation.view.model;

import java.util.List;

import com.geolocation.geolocation.shared.EnderecoDTO;

public class EnderecoResponse {

    private List<EnderecoDTO> enderecosList;

    private String enderecosMaisProximosOrigem;

    private String enderecosMaisProximosDestino;

    private String enderecosMaisDistantesOrigem;
    
    private String enderecosMaisDistantesDestino;

    private Double maiorRota = 0.0;

    private Double menorRota = 0.0;

    public EnderecoResponse(List<EnderecoDTO> enderecosList) {

        this.enderecosList = enderecosList;

        enderecosList.stream().forEach(endereco -> {
            endereco.getDistanciasList().stream().forEach(distancia -> {
                Double rota;

                if(distancia.getDistanciaRota().contains(" km")){
                    rota = Double.parseDouble(distancia.getDistanciaRota().replace(" km", ""));
                } else{
                    rota = Double.parseDouble(distancia.getDistanciaRota().replace(" m", ""));
                }


                if(rota > maiorRota){
                    this.maiorRota = rota;
                    this.enderecosMaisDistantesOrigem = endereco.getEndereco();
                    this.enderecosMaisDistantesDestino = distancia.getEndereco();
                }
                if(rota < menorRota || menorRota == 0.00) {
                    this.menorRota = rota;
                    this.enderecosMaisProximosOrigem = endereco.getEndereco();
                    this.enderecosMaisProximosDestino = distancia.getEndereco();
                }
            });
        });
    }

    public List<EnderecoDTO> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<EnderecoDTO> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public String getEnderecosMaisProximosOrigem() {
        return enderecosMaisProximosOrigem;
    }

    public void setEnderecosMaisProximosOrigem(String enderecosMaisProximosOrigem) {
        this.enderecosMaisProximosOrigem = enderecosMaisProximosOrigem;
    }

    public String getEnderecosMaisProximosDestino() {
        return enderecosMaisProximosDestino;
    }

    public void setEnderecosMaisProximosDestino(String enderecosMaisProximosDestino) {
        this.enderecosMaisProximosDestino = enderecosMaisProximosDestino;
    }

    public String getEnderecosMaisDistantesOrigem() {
        return enderecosMaisDistantesOrigem;
    }

    public void setEnderecosMaisDistantesOrigem(String enderecosMaisDistantesOrigem) {
        this.enderecosMaisDistantesOrigem = enderecosMaisDistantesOrigem;
    }

    public String getEnderecosMaisDistantesDestino() {
        return enderecosMaisDistantesDestino;
    }

    public void setEnderecosMaisDistantesDestino(String enderecosMaisDistantesDestino) {
        this.enderecosMaisDistantesDestino = enderecosMaisDistantesDestino;
    }

}
