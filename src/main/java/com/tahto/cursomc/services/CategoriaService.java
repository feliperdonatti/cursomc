package com.tahto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tahto.cursomc.domain.Categoria;
import com.tahto.cursomc.repositories.CategoriaRepository;
import com.tahto.cursomc.services.exceptions.ObjectNotFoundException;




@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);// Seta null para que o repositori entenda que é uma inserçao e nao uma alteracao
		return repository.save(obj);
	}

}
