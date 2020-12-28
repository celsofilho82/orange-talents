package com.orange.talents.apibank.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orange.talents.apibank.cadastrocliente.Cliente;
import com.orange.talents.apibank.cadastrocliente.NovoClienteRequest;

@Component
public class CpfUnicoValidator implements Validator {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean supports(Class<?> clazz) {

		return NovoClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoClienteRequest request = (NovoClienteRequest) target;
		Optional<Cliente> possivelClienteCpfDuplicado = clienteRepository.findByCpf(request.getCpf());

		if (possivelClienteCpfDuplicado.isPresent()) {
			errors.reject("cpf", "Esse CPF já está cadastrado " + request.getCpf());
		}

	}

}
