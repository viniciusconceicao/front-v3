package br.com.searchdevelopers.godev.iugu.service;


import br.com.searchdevelopers.godev.iugu.dto.request.pagamento.IuguPagamentoRequest;
import br.com.searchdevelopers.godev.iugu.dto.request.token.IuguTokenRequest;
import br.com.searchdevelopers.godev.iugu.dto.response.pagamento.IuguPagamentoResponse;
import br.com.searchdevelopers.godev.iugu.dto.response.token.IuguTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "criarToken", url = "https://api.iugu.com/v1/")
interface IuguService {

    @PostMapping(path = "/payment_token", consumes = "application/json", produces = "application/json")
    IuguTokenResponse getToken(@RequestBody IuguTokenRequest iuguTokenRequest);

    @PostMapping(path = "/charge?api_token=AFEC68916DC4274E923FAA3FCE2E55EF4B19F957D40C23F39049451947AD5E90",
            consumes = "application/json", produces = "application/json")
    IuguPagamentoResponse realizarPagamento(@RequestBody IuguPagamentoRequest iuguPagamentoRequest);
}
