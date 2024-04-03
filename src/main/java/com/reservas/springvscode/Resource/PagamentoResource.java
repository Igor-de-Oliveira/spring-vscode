package com.reservas.springvscode.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reservas.springvscode.Repository.PagamentoRepository;
import com.reservas.springvscode.model.Pagamento;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> Listar() {
        return pagamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pagamento> Criar(@RequestBody Pagamento pagamento, HttpServletResponse response){
        Pagamento pagamentoSalva = pagamentoRepository.save(pagamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/idPagamento").buildAndExpand(pagamentoSalva.getIdPagamento()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        
        return ResponseEntity.created(uri).body(pagamentoSalva);
    }
    
    @GetMapping("/idPagamento")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idPagamento) {
        Optional<Pagamento> pagamento = this.pagamentoRepository.findById(idPagamento);
        return pagamento.isPresent() ? ResponseEntity.ok(pagamento) : ResponseEntity.notFound().build();

    }
    
}
