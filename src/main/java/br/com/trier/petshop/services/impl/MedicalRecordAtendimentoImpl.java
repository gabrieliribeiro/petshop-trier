package br.com.trier.petshop.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.MedicalRecordAtendimento;
import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.repositories.MedicalRecordAtendimentoRepository;
import br.com.trier.petshop.services.MedicalRecordAtendimentoService;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

@Service
public class MedicalRecordAtendimentoImpl implements MedicalRecordAtendimentoService{
	
	@Autowired
	MedicalRecordAtendimentoRepository repository;

	@Override
	public MedicalRecordAtendimento save(MedicalRecordAtendimento medicalRecordAtendimento) {
		return repository.save(medicalRecordAtendimento);
	}

	@Override
	public MedicalRecordAtendimento update(MedicalRecordAtendimento medicalRecordAtendimento) {
		return repository.save(medicalRecordAtendimento);
	}

	@Override
	public MedicalRecordAtendimento findById(Integer id) {
		Optional<MedicalRecordAtendimento> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFound("Nenhum prontuário encontrado com id %s".formatted(id)));
	}

	@Override
	public List<MedicalRecordAtendimento> listAll() {
		return repository.findAll();
	}

	@Override
	public List<MedicalRecordAtendimento> findByAtendimento(Schedule atendimento) {
		return repository.findByAtendimento(atendimento);
	}

	@Override
	public List<MedicalRecordAtendimento> findByProntuario(MedicalRecord prontuario) {
		return repository.findByProntuario(prontuario);
	}

	@Override
	public void delete(Integer id) {
		MedicalRecordAtendimento medicalRecordAtendimento =findById(id);
		repository.delete(medicalRecordAtendimento);
	}
	
	
}
