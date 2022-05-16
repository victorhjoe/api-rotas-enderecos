package com.geolocation.geolocation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geolocation.geolocation.view.controller.GeocodingController;
import com.geolocation.geolocation.view.model.EnderecoResponse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class GeolocationApplicationTests {

@Test
void deveRetornarLatitudeELongitudeCorretos(){
	GeocodingController controller = new GeocodingController();

	ResponseEntity<EnderecoResponse> result = controller.obterRelatorioEndereco("Av.Rio Branco, 1 Centro, Rio de Janeiro RJ, 20090003;Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200;Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030");

	//Endereco 1
	assertEquals(result.getBody().getEnderecosList().get(0).getLatitude(), -22.8973551);
	assertEquals(result.getBody().getEnderecosList().get(0).getLongitude(), -43.1802782);

	//Endereco 2
	assertEquals(result.getBody().getEnderecosList().get(1).getLatitude(), -22.9039608);
	assertEquals(result.getBody().getEnderecosList().get(1).getLongitude(), -43.1703536);

	//Endereco 3
	assertEquals(result.getBody().getEnderecosList().get(2).getLatitude(), -22.9507471);
	assertEquals(result.getBody().getEnderecosList().get(2).getLongitude(), -43.1876544);
}

}
