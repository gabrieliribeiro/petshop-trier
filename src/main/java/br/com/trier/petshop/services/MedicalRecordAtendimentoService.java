package br.com.trier.petshop.services;

import java.util.List;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.MedicalRecordAtendimento;
import br.com.trier.petshop.domain.Schedule;

public interface MedicalRecordAtendimentoService {
	MedicalRecordAtendimento save (MedicalRecordAtendimento medicalRecordAtendimento);
	MedicalRecordAtendimento update (MedicalRecordAtendimento medicalRecordAtendimento);
	MedicalRecordAtendimento findById(Integer id);
    List<MedicalRecordAtendimento> listAll();
    List<MedicalRecordAtendimento> findByAtendimento(Schedule atendimento);
	List<MedicalRecordAtendimento> findByProntuario(MedicalRecord prontuario);
	void delete(Integer id);
}
