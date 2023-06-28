package br.com.trier.petshop.services.exceptions;

public class ObjectNotFound extends RuntimeException{

	public ObjectNotFound(String mensagem) {
		super(mensagem);
	}
	
}
