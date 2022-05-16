package com.geolocation.geolocation.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.geolocation.geolocation.shared.EnderecoDTO;
import com.geolocation.geolocation.view.model.EnderecoDistancia;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;

public class DistanceMatrixService {

    String enderecosString = "";
    Integer enderecoIndex = 0;
    
    /**
     * Método para inforrmar a distância das rotas entre os endereços informados e o tempo de locomoção
     * @param enderecosDTOListReq
     * @return A lista completa de enderecos com distância em Km e o tempo de locomoção
     */
    public List<EnderecoDTO> getDistances(List<EnderecoDTO> enderecosDTOListReq){

        List<EnderecoDTO> enderecosDTOList = new ArrayList<>();

        
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAxV0a3zNL1qv_eq5b7ENresE_32s8E24w").build();

        int qtd = enderecosDTOListReq.size();

        
        String[] listString = new String[qtd];


        for(int j=0;j<enderecosDTOListReq.size();j++){
            listString[j] = enderecosDTOListReq.get(j).getEndereco();
        }


        try {
            DistanceMatrix result = DistanceMatrixApi.getDistanceMatrix(context, listString, listString).await();
            DistanceMatrixRow rows[] = result.rows;

            for(int i=0; i < enderecosDTOListReq.size(); i++){   

                DistanceMatrixElement[] elements = rows[i].elements;
                List<DistanceMatrixElement> elementsList = Arrays.asList(elements);
                
                EnderecoDTO endereco = enderecosDTOListReq.get(i);
                List<EnderecoDistancia> distances = new ArrayList<>();
                
                elementsList.stream().forEach(element -> {

                    if(endereco.getEndereco() != enderecosDTOListReq.get(enderecoIndex).getEndereco()){
                        EnderecoDistancia distance = new EnderecoDistancia();
                        distance.setEndereco(enderecosDTOListReq.get(enderecoIndex).getEndereco());
                        distance.setDistanciaRota(element.distance.toString());
                        distance.setTempoDaRota(element.duration.toString());
                        distances.add(distance);
                    }

                    enderecoIndex++;
                });
                this.enderecoIndex =  0;


                endereco.setDistanciasList(distances);
                enderecosDTOList.add(endereco);
            }   

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return enderecosDTOList;
    }
}
