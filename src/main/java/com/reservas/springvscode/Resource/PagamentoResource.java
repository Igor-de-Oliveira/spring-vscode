package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.PagamentoRepository;
import com.reservas.springvscode.model.Pagamento;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> Listar() {
        return pagamentoRepository.findAll();
    }
}
