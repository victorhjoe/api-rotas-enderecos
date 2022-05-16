# api-rotas-enderecos 📍

- Api utiliza serviço do Google Maps para informar a latitude e Longitude dos endereços informados
- Tecnologia utilizada Spring boot   <img align="center" alt="spring" height="40"  src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
# Instruções
- Ao levantar o sistema informar  como query param os endereços separados por ";" : 
- Exemplo - http://localhost:8080/api/geocoding?enderecos=Av.RioBranco,1Centro,RiodeJaneiroRJ,20090003;PraçaMal.Âncora,122Centro,RiodeJaneiroRJ,20021200;Rua19deFevereiro,34BotafogoRiodeJaneiroRJ,22280030

#Resultado Esperado:
- ![result1](https://user-images.githubusercontent.com/43349527/168657657-e123d647-17d7-448e-a23a-4bfb82471561.png)


- ![result2](https://user-images.githubusercontent.com/43349527/168657733-bd80d50d-a629-47d6-a398-aefa1fad2762.png)
