package com.geolocation.geolocation.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.geolocation.geolocation.view.model.Endereco;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import org.springframework.stereotype.Service;

@Service
public class GeocodingService {
    
    /**
     * Método para retornas as latitudes e longitudes dos endereços informados
     * @param enderecosListReq
     * @return Os enderecos por extenso e suas respectivas localizações no mapa
     */
    public List<Endereco> getGeoCodings(List<String> enderecosListReq) {
        
        List<Endereco> enderecosList = new ArrayList<>();

        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAxV0a3zNL1qv_eq5b7ENresE_32s8E24w").build();

        enderecosListReq.forEach(endereco -> {
            Endereco enderecoObj = new Endereco();

            try {
                GeocodingResult[] results =  GeocodingApi.geocode(context,
                endereco).await();
                
                enderecoObj.setEndereco(results[0].formattedAddress);
                enderecoObj.setLatitude(results[0].geometry.location.lat);
                enderecoObj.setLongitude(results[0].geometry.location.lng);

                enderecosList.add(enderecoObj);
                
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return enderecosList;
    }
}
