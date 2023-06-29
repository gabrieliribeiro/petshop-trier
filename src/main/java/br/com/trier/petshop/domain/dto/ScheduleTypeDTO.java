package br.com.trier.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTypeDTO {
	private Integer id;
    private String description;
    private boolean requerMedicalRecord;
    
    public boolean isRequerMedicalRecord() {
        return requerMedicalRecord;
    }
}
