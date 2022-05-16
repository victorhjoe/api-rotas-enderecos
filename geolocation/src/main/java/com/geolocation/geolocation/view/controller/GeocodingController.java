package com.geolocation.geolocation.view.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.geolocation.geolocation.services.DistanceMatrixService;
import com.geolocation.geolocation.services.GeocodingService;
import com.geolocation.geolocation.shared.EnderecoDTO;
import com.geolocation.geolocation.view.model.Endereco;
import com.geolocation.geolocation.view.model.EnderecoResponse;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/geocoding")
public class GeocodingController {
    
    @GetMapping
    public ResponseEntity<EnderecoResponse> obterRelatorioEndereco(@RequestParam String enderecos){

        List<String> enderecosRequest = Arrays.asList(enderecos.split(";"));

        GeocodingService service = new GeocodingService();
        List<Endereco> enderecosList = service.getGeoCodings(enderecosRequest);

        ModelMapper mapper = new ModelMapper();

        List<EnderecoDTO> response = enderecosList.stream()
        .map(endereco -> mapper.map(endereco, EnderecoDTO.class))
        .collect(Collectors.toList());

        DistanceMatrixService distanceService = new DistanceMatrixService();

        
        response = distanceService.getDistances(response);
        
        EnderecoResponse relatorio = new EnderecoResponse(response);

        return new ResponseEntity<>(relatorio, HttpStatus.OK) ;
    }
}
