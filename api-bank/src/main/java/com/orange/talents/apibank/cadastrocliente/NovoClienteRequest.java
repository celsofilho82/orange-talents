package com.orange.talents.apibank.cadastrocliente;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

public class NovoClienteRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@CPF
	private String cpf;

	@NotNull
	@Past
	private LocalDate dataNascimento;

	public NovoClienteRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @CPF String cpf,
			@NotNull @Past LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Cliente toModel() {
		return new Cliente(this.nome, this.getEmail(), this.getCpf(), this.dataNascimento);
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

}
