package com.jckuntz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jckuntz.cursomc.domain.Categoria;
import com.jckuntz.cursomc.repositories.CategoriaRepository;
import com.jckuntz.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id  
						+ ", Tipo: " + Categoria.class.getName()));
	}

}
