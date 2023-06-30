package br.com.trier.petshop.domain;


import br.com.trier.petshop.domain.dto.MedicalRecordAtendimentoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "prontuario_atendimento")
public class MedicalRecordAtendimento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prontuario_atendimento")
	@Setter
	private Integer id;
	
	@ManyToOne
	private Schedule atendimento;
	
	
	@ManyToOne
	private MedicalRecord prontuario;

	public MedicalRecordAtendimentoDTO toDTO() {
		return new MedicalRecordAtendimentoDTO(id,atendimento.getId(), prontuario.getId());
	}
	
	public MedicalRecordAtendimento(MedicalRecordAtendimentoDTO dto, Schedule atendimento, MedicalRecord prontuario) {
		this(dto.getId(), atendimento, prontuario);
	}
	
}
