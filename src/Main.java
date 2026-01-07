import br.com.alura.api.ChaveAPI;
import br.com.alura.api.InformacoesClima;
import br.com.alura.api.InformacoesClimaJson;
import com.google.gson.Gson;

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
        //criei uma classe que guarda a chave api
        ChaveAPI chaveAPI = new ChaveAPI();

        String urlRequisicao = "https://api.weatherapi.com/v1/current.json?key=" + chaveAPI.getWeaterChaveAPI() + "&q=" + cidadeInformada ;

          
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                //aqui foi passado a url dinamica da api
                .uri(URI.create(urlRequisicao))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //validando a saída do response; se retorna cod 200 = OK
        //System.out.println(response);

        //validando json
        //System.out.println(response.body());

        System.out.println();

        //atribuindo o json a uma var do tipo string
        String json = response.body();
        Gson gson = new Gson();
        InformacoesClimaJson climaJson = gson.fromJson(json, InformacoesClimaJson.class);
        //System.out.println(climaJson);
        InformacoesClima informacoesClima = new InformacoesClima(climaJson);

        System.out.println(informacoesClima);

    }
}
