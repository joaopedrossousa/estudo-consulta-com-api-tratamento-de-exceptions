package br.com.alura.api;

import br.com.alura.api.models.Current;
import br.com.alura.api.models.Location;

public record InformacoesClimaJson(Location location, Current current) {

}
