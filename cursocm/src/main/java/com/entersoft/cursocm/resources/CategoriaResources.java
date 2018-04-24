package com.entersoft.cursocm.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entersoft.cursocm.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar()
	{
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(1, "Escritório");
		
		List<Categoria> catList = new ArrayList<>();
		catList.add(cat1);
		catList.add(cat2);
		

		return catList;
	}	
}
