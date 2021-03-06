package com.schoppen.schoppenerp.control;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoppen.schoppenerp.dao.CATEG2Repository;
import com.schoppen.schoppenerp.model.CATEG2;

@Controller
@RequestMapping("/api/cervezas/categ2")
public class CATEG2Controller {

	@Autowired
	private CATEG2Repository repo;
	
	/*							U R L S
	 * "/api/cervezas/CATEG2" 						.GET 		=>		Todas los CATEG2
	 * "/api/cervezas/CATEG2/[id]" 					.GET 		=>		Proveedor [id]
	 * "/api/cervezas/CATEG2/[id]"					.DELETE		=>		Borra el proveedor
	 * "/api/cervezas/CATEG2/[id]"					.POST		=>		Nuevo proveedor
	 * "/api/cervezas/CATEG2/[id]"					.PUT		=>		Modificar nombre
	 */
	
	
	// Obtener todos los registros
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Set<CATEG2> getAll() {
		return repo.findAll();
	}	
	
	// Obtener registro
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CATEG2 getOne(@PathVariable("id") Long id) {
		return repo.findOne(id);
	}
	
	// Borrar registro
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody CATEG2 delete(@PathVariable("id") Long id) {
		CATEG2 cat = null;
		try {
			cat = repo.findOne(id);
		} catch (Exception ex) {
			return cat;
		}
		repo.delete(cat);
		return cat;
	}
	
	// Crear nuevo registro
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CATEG2 create(@RequestParam("name") String nombre){
		CATEG2 cat = new CATEG2();
		cat.setNombre(nombre);
		return repo.save(cat);
	}
	
	// Modificar registro
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public @ResponseBody CATEG2 update(@PathVariable("id") Long id, @RequestParam("name") String nombre){
		CATEG2 cat = null;
		try {
			cat = repo.findOne(id);
		} catch (Exception ex) {
			return cat;
		}
		cat.setNombre(nombre);
		return repo.save(cat);
	}
}
