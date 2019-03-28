package it.dstech.tornei.service.generic;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class GenericService<Entita, Repository extends CrudRepository> {

	@Autowired
	protected Repository repository;

	
	public Optional<Entita> findOne(Long id) {
		return repository.findById(id);
	}

	public List<Entita> findAll() {
		return (List<Entita>) repository.findAll();
	}

	public Entita save(Entita entity) {
		return (Entita) repository.save(entity);
	}

	public void save(List<Entita> entities) {
		repository.save(entities);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Entita entity) {
		repository.delete(entity);
	}

}
