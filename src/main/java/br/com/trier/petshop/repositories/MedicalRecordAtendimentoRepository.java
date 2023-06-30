package br.com.trier.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.MedicalRecordAtendimento;
import br.com.trier.petshop.domain.Schedule;

@Repository
public interface MedicalRecordAtendimentoRepository extends JpaRepository<MedicalRecordAtendimento, Integer>{
	List<MedicalRecordAtendimento> findByAtendimento(Schedule atendimento);
	List<MedicalRecordAtendimento> findByProntuario(MedicalRecord prontuario);
}
