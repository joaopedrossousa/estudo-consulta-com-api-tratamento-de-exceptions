import br.com.alura.api.ChaveAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);
        //entrada que recebe o parametro para consulta
        System.out.println("Qual cidade deseja consultar o clima? ");
        String cidadeInformada = entrada.nextLine();

        ChaveAPI chaveAPI = new ChaveAPI();

        String urlRequisicao = "https://api.weatherapi.com/v1/current.json?key=" + chaveAPI.getWeaterChaveAPI() + "&q=" + cidadeInformada ;


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequisicao))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //validando a saída do response
        System.out.println(response);

    }
}
