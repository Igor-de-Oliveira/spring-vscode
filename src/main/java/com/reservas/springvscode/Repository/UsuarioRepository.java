package com.reservas.springvscode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.springvscode.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
