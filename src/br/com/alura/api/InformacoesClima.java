package br.com.alura.api;

public class InformacoesClima {
    private String nomeCidade;
    private  String nomeEstado;
    private  String nomePais;
    private  String tempCelcius;

    public InformacoesClima (InformacoesClimaJson informacoesClimaJson){
        this.nomeCidade = informacoesClimaJson.location().name();
        this.nomeEstado = informacoesClimaJson.location().region();
        this.nomePais = informacoesClimaJson.location().country();
        this.tempCelcius = informacoesClimaJson.current().temp_c();

    }

    @Override
    public String toString() {
        return "Cidade: " + nomeCidade + "\n" +
                "Estado: " + nomeEstado + "\n" +
                "País: " + nomePais + "\n" +
                "Temperatura: " + tempCelcius+"°C";
    }
}
