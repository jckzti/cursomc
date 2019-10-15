package com.jckuntz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jckuntz.cursomc.domain.Cliente;
import com.jckuntz.cursomc.repositories.ClienteRepository;
import com.jckuntz.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id  
						+ ", Tipo: " + Cliente.class.getName()));
	}

}
