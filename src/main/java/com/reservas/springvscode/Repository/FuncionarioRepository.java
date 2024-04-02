package com.reservas.springvscode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.springvscode.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
