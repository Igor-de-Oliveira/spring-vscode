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

import com.reservas.springvscode.Repository.UsuarioRepository;
import com.reservas.springvscode.model.Usuario;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuarios")
public class UsurioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> Listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalva = usuarioRepository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idUsuario}").buildAndExpand(usuarioSalva.getIdUsuario()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        
        return ResponseEntity.created(uri).body(usuarioSalva);
    }
    
    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idUsuario) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
        return usuario.isPresent() ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
    
}
