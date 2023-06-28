package br.com.trier.petshop.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {
	private ZonedDateTime time;
	private Integer status;
	private String erro;
	private String url;
}
