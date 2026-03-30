package controller;

import com.google.gson.*;
import model.Libro;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class APIController {
    Gson gson= new Gson();
    // Gestiona la petición al Api externa y la obtención de todos los libros.
    //PASOS--> 1 Abrir cliente, 2 Crear peticion, 3 Esperar respuesta
    public List<Libro> getAllBooks(){
        String url="https://stephen-king-api.onrender.com/api/books";
        List<Libro> libros = new ArrayList<>();
        HttpClient client = null;

        try {
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String books = response.body();
            JsonObject jsonBook = JsonParser.parseString(books).getAsJsonObject(); //Es necesario parsearlo con gson
            JsonArray booksArray = jsonBook.getAsJsonArray("data");

            for (JsonElement bookElement : booksArray){
                Libro libro = gson.fromJson(bookElement, Libro.class);
                libros.add(libro);
            }

        }catch (Exception e){
            System.out.println("Error en la petición.");
        }
        return libros;

    }
    public void getBookId(int id){
        String url="https://stephen-king-api.onrender.com/api/book"+"/"+id;
        HttpClient client = null;

        try {
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String bookDetail = response.body();
            JsonObject jsonBody = JsonParser.parseString(bookDetail).getAsJsonObject();
            JsonObject dataObject = jsonBody.getAsJsonObject("data");

            Libro libro = gson.fromJson(dataObject, Libro.class);
            System.out.println(libro);

        }catch (Exception e){
            System.out.println("Error"+ e.getMessage());
            e.printStackTrace();
            System.out.println("Algo salio mal al buscar tu libro, lo sentimos.");
        }


    }


}
