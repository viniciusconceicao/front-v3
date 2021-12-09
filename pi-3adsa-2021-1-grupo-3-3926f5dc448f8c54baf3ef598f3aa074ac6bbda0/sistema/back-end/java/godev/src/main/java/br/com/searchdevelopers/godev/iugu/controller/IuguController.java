package br.com.searchdevelopers.godev.iugu.controller;


import br.com.searchdevelopers.godev.domain.Users;
import br.com.searchdevelopers.godev.iugu.dto.request.pagamento.IuguPagamentoRequest;
import br.com.searchdevelopers.godev.iugu.dto.response.pagamento.IuguPagamentoResponse;
import br.com.searchdevelopers.godev.iugu.service.PagamentoService;
import br.com.searchdevelopers.godev.repository.UserRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class IuguController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private UserRepository userRepository;
    /*
    Rota pata gerarar o pagamento
    */
    @PostMapping("/gerar-pagamento/{id}")
    public ResponseEntity<?> gerarPagamento(@Valid @RequestBody IuguPagamentoRequest iuguPagamentoRequest,
                                            @PathVariable Integer id) {
        Users users = userRepository.findUserByIdUser(id);

        try {
            IuguPagamentoResponse pagamento = this.pagamentoService.gerarPagamento(iuguPagamentoRequest, id);
            users.setPremium(true);
            return ResponseEntity.ok(pagamento);
        } catch (FeignException e) {
            users.setPremium(false);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
