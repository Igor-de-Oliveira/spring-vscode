package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.LocalRepository;
import com.reservas.springvscode.model.Local;

@RestController
@RequestMapping("/locais")
public class LocalResource {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public List<Local> Listar() {
        return localRepository.findAll();
    }
}
