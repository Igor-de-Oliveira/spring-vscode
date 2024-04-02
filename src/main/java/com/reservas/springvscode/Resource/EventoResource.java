package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.EventoRepository;
import com.reservas.springvscode.model.Evento;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> Listr(){
        return eventoRepository.findAll();
    }
}
