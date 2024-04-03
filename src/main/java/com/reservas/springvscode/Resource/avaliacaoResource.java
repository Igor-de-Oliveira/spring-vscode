package com.reservas.springvscode.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reservas.springvscode.Repository.avaliacaoRepository;
import com.reservas.springvscode.model.avaliacao;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/avaliacao")
public class avaliacaoResource {

    @Autowired
    private avaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<avaliacao> Listar() {
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<avaliacao> Criar(@RequestBody avaliacao avaliacao, HttpServletResponse response) {
        avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idavaliacao}").buildAndExpand(avaliacaoSalva.getIdUsuario()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(avaliacaoSalva);
    }

    @GetMapping("/{idavaliacao}")
    public ResponseEntity<?> buescaCodigo(@PathVariable Long idavaliacao){
        Optional<avaliacao> avaliacao = this.avaliacaoRepository.findById(idavaliacao);
        return avaliacao.isPresent() ? ResponseEntity.ok(avaliacao) : ResponseEntity.notFound().build();
    }
}
