package br.com.trier.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordAtendimentoDTO {
	private Integer id;
	private Integer idAtendimento;
	private Integer idProntuario;
}
