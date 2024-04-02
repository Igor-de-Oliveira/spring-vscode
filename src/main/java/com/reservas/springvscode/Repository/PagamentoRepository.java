package com.reservas.springvscode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.springvscode.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
