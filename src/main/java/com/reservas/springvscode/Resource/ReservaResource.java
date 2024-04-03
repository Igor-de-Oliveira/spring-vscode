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

import com.reservas.springvscode.Repository.ReservaRepository;
import com.reservas.springvscode.model.Reserva;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reservas")
public class ReservaResource {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> Listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> Criar(@RequestBody Reserva reserva, HttpServletResponse response) {
        Reserva reservaSalva = reservaRepository.save(reserva);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idReserva}").buildAndExpand(reservaSalva.getIdReserva()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        
        return ResponseEntity.created(uri).body(reservaSalva);
    }
    
    @GetMapping("/{idReserva}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long idReserva) {
        Optional<Reserva> reserva = this.reservaRepository.findById(idReserva);
        return reserva.isPresent() ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }
    
}
