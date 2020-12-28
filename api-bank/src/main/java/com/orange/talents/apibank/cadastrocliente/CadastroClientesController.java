package com.orange.talents.apibank.cadastrocliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.apibank.validator.CpfUnicoValidator;
import com.orange.talents.apibank.validator.EmailUnicoValidator;

@RestController
@RequestMapping("/clientes")
public class CadastroClientesController {

	@Autowired
	private EntityManager manager;

	@Autowired
	private EmailUnicoValidator emailUnicoValidator;

	@Autowired
	private CpfUnicoValidator cpfUnicoValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailUnicoValidator, cpfUnicoValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Cliente> create(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel();
		manager.persist(cliente);
		return ResponseEntity.ok(cliente);
	}

}
