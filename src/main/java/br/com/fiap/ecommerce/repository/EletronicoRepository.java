package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ecommerce.model.Eletronicos;

@Repository
public interface EletronicoRepository extends JpaRepository<Eletronicos, Long> {
	<T> T findByNome(String nome);
}
