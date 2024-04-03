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

import com.reservas.springvscode.Repository.EventoRepository;
import com.reservas.springvscode.model.Evento;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/eventos")
public class EventoResource {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> Listr(){
        return eventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Evento> Criar(@RequestBody Evento evento, HttpServletResponse response) {
        Evento eventoSalva = eventoRepository.save(evento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idEvento}").buildAndExpand(eventoSalva.getIdEvento()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(eventoSalva);
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idEvento) {
        Optional<Evento> evento = this.eventoRepository.findById(idEvento);
        return evento.isPresent() ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
    }
    
}
