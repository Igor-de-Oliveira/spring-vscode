package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.avaliacaoRepository;
import com.reservas.springvscode.model.avaliacao;

@RestController
@RequestMapping("/avaliacao")
public class avaliacaoResource {

    @Autowired
    private avaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<avaliacao> Listar() {
        return avaliacaoRepository.findAll();
    }
}
