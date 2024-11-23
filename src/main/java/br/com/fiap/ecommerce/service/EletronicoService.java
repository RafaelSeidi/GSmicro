package br.com.fiap.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.model.Eletronicos;
import br.com.fiap.ecommerce.repository.EletronicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EletronicoService {

	private final EletronicoRepository eletronicoRepository;
	
	public List<Eletronicos> list() {
		return eletronicoRepository.findAll();
	}
	
	public Optional<Eletronicos> findById(Long id) {
		return eletronicoRepository.findById(id);
	}
	
	public List<Eletronicos> findByNome(String nome) {
		return eletronicoRepository.findByNome(nome);
	}
	
	public Eletronicos save(Eletronicos eletronico) {
		return eletronicoRepository.save(eletronico);
	}
	
	public boolean existsById(Long id) {
		return eletronicoRepository.existsById(id);
	}
	
	public void delete(Long id) {
		eletronicoRepository.deleteById(id);
	}
	
}
