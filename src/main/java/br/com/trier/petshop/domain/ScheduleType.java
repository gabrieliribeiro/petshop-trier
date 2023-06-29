package br.com.trier.petshop.domain;

import br.com.trier.petshop.domain.dto.ScheduleTypeDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "tipo_agendamento")
public class ScheduleType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	@Setter
	private Integer id;
	
	@Column(name = "descricao")
    private String description;
    
	@Column(name = "requer_prontuario")
    private boolean requerMedicalRecord;

    public ScheduleType(ScheduleTypeDTO dto) {
    	this(dto.getId(), dto.getDescription(), dto.isRequerMedicalRecord());
    }

    public ScheduleTypeDTO toDto() {
        return new ScheduleTypeDTO(this.id, this.description, this.requerMedicalRecord);
    }
    
}
