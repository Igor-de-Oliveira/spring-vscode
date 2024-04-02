package com.reservas.springvscode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.springvscode.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
