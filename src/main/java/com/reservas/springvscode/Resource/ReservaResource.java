package com.reservas.springvscode.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.springvscode.Repository.ReservaRepository;
import com.reservas.springvscode.model.Reserva;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> Listar() {
        return reservaRepository.findAll();
    }
}
