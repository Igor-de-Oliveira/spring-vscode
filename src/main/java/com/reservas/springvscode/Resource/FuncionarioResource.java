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

import com.reservas.springvscode.Repository.FuncionarioRepository;
import com.reservas.springvscode.model.Funcionario;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @GetMapping
    public List<Funcionario> Listar(){
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Funcionario> Criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
        Funcionario funcionarioSalva = funcionarioRepository.save(funcionario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idFuncionario}").buildAndExpand(funcionarioSalva.getIdEvento()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        
        return ResponseEntity.created(uri).body(funcionarioSalva);
    }

    @GetMapping("/{idFuncionario}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idFuncionario) {
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(idFuncionario);
        return funcionario.isPresent() ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
    }
    
    
}
