package com.alura.convertidor_moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsumoApi {
    private static String API_KEY = "";
    private static String URL_BASE = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/";

    public Conversor obtenerDatos(String baseCode, String targetCode) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE+baseCode+"/"+targetCode))
                .build();

        HttpResponse<String> response =  null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch(IOException | InterruptedException e ){
            throw new RuntimeException(e);
        }



        return new Gson().fromJson(response.body(), Conversor.class);
    }
}

