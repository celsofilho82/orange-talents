package com.orange.talents.apibank.validator;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.talents.apibank.cadastrocliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByCpf(String cpf);

	Optional<Cliente> findByEmail(String email);
}
