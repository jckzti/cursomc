package com.jckuntz.cursomc.resources;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public HashMap<String, String> listar() {
		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("Valor", "valorX");
		//return "REST está funcionando";
		return mapa;
	}
}
