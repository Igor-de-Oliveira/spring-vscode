package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.FuncionarioRepository;
import com.reservas.springvscode.model.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @GetMapping
    public List<Funcionario> Listar(){
        return funcionarioRepository.findAll();
    }
}
