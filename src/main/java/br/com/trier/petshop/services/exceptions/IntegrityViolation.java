package br.com.trier.petshop.services.exceptions;

public class IntegrityViolation extends RuntimeException{
	
	public IntegrityViolation(String mensagem) {
		super(mensagem);
	}
	
}
