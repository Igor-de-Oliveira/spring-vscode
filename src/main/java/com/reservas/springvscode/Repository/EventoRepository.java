package com.reservas.springvscode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.springvscode.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
