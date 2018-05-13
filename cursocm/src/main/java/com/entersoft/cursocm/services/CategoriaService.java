package com.entersoft.cursocm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.entersoft.cursocm.domain.Categoria;
import com.entersoft.cursocm.dto.CategoriaDTO;
import com.entersoft.cursocm.repositories.CategoriaRepository;
import com.entersoft.cursocm.services.exceptions.DataIntegrityException;
import com.entersoft.cursocm.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {	
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<CategoriaDTO> findAll() {		
		List<Categoria> lista = repo.findAll();
		List<CategoriaDTO> listDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui um ou mais produtos");
		}	
	}
	
}
