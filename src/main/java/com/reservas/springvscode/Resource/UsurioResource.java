package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.UsuarioRepository;
import com.reservas.springvscode.model.Usuario;

@RestController
@RequestMapping
public class UsurioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> Listar() {
        return usuarioRepository.findAll();
    }
}
