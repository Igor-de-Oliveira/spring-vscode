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

import com.reservas.springvscode.Repository.LocalRepository;
import com.reservas.springvscode.model.Local;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/locais")
public class LocalResource {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public List<Local> Listar() {
        return localRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Local> Criar(@RequestBody Local local, HttpServletResponse response) {
        Local localSalva = localRepository.save(local);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idLocal}").buildAndExpand(localSalva.getIdLocal()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(localSalva);
    }

    @GetMapping("/{idLocal}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idLocal){
        Optional<Local> local = this.localRepository.findById(idLocal);
        return local.isPresent() ? ResponseEntity.ok(local) : ResponseEntity.notFound().build();
    }
}
