package com.gestorfinancas.repositories;

import com.gestorfinancas.models.Conta;
import com.gestorfinancas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findContaByPessoa(Pessoa pessoa);
}
